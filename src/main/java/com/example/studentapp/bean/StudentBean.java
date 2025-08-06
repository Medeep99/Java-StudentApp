package com.example.studentapp.bean;

import com.example.studentapp.dao.StudentDAO;
import com.example.studentapp.entity.Student;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentDAO studentDAO;

    private Student student;
    private List<Student> students;
    private List<String> studentClasses;
    private Map<String, List<String>> subjectsByClass;
    private List<String> availableSubjects;
    private Student selectedStudent;

    @PostConstruct
    public void init() {
        student = new Student();
        loadStudents();
        initDropdowns();
    }

    private void loadStudents() {
        students = studentDAO.findAll();
    }

    private void initDropdowns() {
        studentClasses = Arrays.asList("Class 10", "Class 11", "Class 12");
        subjectsByClass = new HashMap<>();
        subjectsByClass.put("Class 10", Arrays.asList("Math", "Science", "Social Studies"));
        subjectsByClass.put("Class 11", Arrays.asList("Physics", "Chemistry", "Biology", "Computer Science"));
        subjectsByClass.put("Class 12", Arrays.asList("Advanced Physics", "Advanced Chemistry", "Calculus", "Literature"));
        availableSubjects = Collections.emptyList();
    }

    public void onClassChange() {
        availableSubjects = subjectsByClass.getOrDefault(
            student.getStudentClass(),
            Collections.emptyList()
        );
        student.setSubjects(new ArrayList<>());
    }

    public void saveStudent() {
        studentDAO.save(student);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Student saved"));
        student = new Student();
        availableSubjects = Collections.emptyList();
        loadStudents();
        PrimeFaces.current().ajax()
            .update("studentForm:messages", "studentForm:studentTable");
    }

    public void deleteStudent(Student s) {
        studentDAO.delete(s.getId());
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Student deleted"));
        loadStudents();
        PrimeFaces.current().ajax()
            .update("studentForm:messages", "studentForm:studentTable");
    }


    public void openEditDialog(Student s) {
        selectedStudent = s;
        
        availableSubjects = subjectsByClass.getOrDefault(
            selectedStudent.getStudentClass(),
            Collections.emptyList()
        );
        PrimeFaces.current().ajax().update("editForm");
        PrimeFaces.current().executeScript("PF('editDlg').show()");
    }

    public void updateStudent() {
        studentDAO.save(selectedStudent);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Student updated"));
        loadStudents();
        PrimeFaces.current().ajax()
            .update("studentForm:messages", "studentForm:studentTable");
        PrimeFaces.current().executeScript("PF('editDlg').hide()");
    }
    public void onEditClassChange() {
    availableSubjects = subjectsByClass.getOrDefault(
        selectedStudent.getStudentClass(),
        Collections.emptyList()
    );
    selectedStudent.setSubjects(new ArrayList<>());
}

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public List<String> getStudentClasses() { return studentClasses; }
    public List<String> getAvailableSubjects() { return availableSubjects; }

    public Student getSelectedStudent() { return selectedStudent; }
}
