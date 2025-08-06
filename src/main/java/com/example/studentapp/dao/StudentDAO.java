package com.example.studentapp.dao;

import com.example.studentapp.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentDAO {
    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    public void save(Student s) {
        if (s.getId() == null) em.persist(s);
        else                  em.merge(s);
    }

    public void delete(Long id) {
        Student s = em.find(Student.class, id);
        if (s != null) em.remove(s);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                 .getResultList();
    }
}
