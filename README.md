# JSF Student Management CRUD Application

A Java web application demonstrating CRUD operations using the JSF framework, PrimeFaces, and JPA (Hibernate), deployed on GlassFish 4 with MySQL as the backend database.
This project implements a dynamic student form, interactive UI elements, and a modal dialog (PrimeFaces <p:dialog>) for editing.

# Features
Student Form
Student Name
Student Address
Student Class (dropdown)
Subjects (dropdown — values change based on selected class)
Save button to insert data into the database

# Dynamic Dropdowns
Selecting a Student Class updates the Subjects dropdown automatically.

# Data Table
Displays all saved records immediately after insertion

# Includes an Actions column with:
Edit — opens PrimeFaces dialog with editable form
Delete — removes the record from MySQL

# PrimeFaces Dialog
Pre-populated form for editing
Update button to save changes back to the database

# Backend
Uses JPA for database CRUD operations
Uses @ViewScoped Managed Beans (javax.faces.bean.ViewScoped)
MySQL database integration

# Technologies Used
Layer	Technology
Frontend = JSF, PrimeFaces
Backend =	Java, JPA (Hibernate provider)
Server =	GlassFish 4.0
Database =	MySQL
Java Version =	JDK 8
View Scope =	javax.faces.bean.ViewScoped



#GlassFish -> Applications
<img width="1512" height="658" alt="image" src="https://github.com/user-attachments/assets/3e3d4574-0141-41bb-9c41-f1fc1fb617e0" />

#Landing Page of StudentApp
<img width="1512" height="660" alt="image" src="https://github.com/user-attachments/assets/2a91fb71-d265-4ad6-aa77-af4b52a456bd" />

#Add new student with dynamic subject listing
<img width="1512" height="637" alt="image" src="https://github.com/user-attachments/assets/2d67dc9b-18b8-4bb0-924d-23f38c69398f" />
<img width="1512" height="511" alt="image" src="https://github.com/user-attachments/assets/b8217cc8-e3c8-44e1-8756-be04c96ab12a" />
<img width="1512" height="569" alt="image" src="https://github.com/user-attachments/assets/8b66b4b9-0522-4823-bd37-d5fd5e010afd" />

##saving
<img width="1511" height="589" alt="image" src="https://github.com/user-attachments/assets/43985f8d-4481-4f34-ba42-c00757e37a59" />

#editing student
<img width="1512" height="713" alt="image" src="https://github.com/user-attachments/assets/b644e319-bd3d-451a-bf63-385bee51c9d1" />
<img width="1512" height="262" alt="image" src="https://github.com/user-attachments/assets/bc85915c-6c34-42ce-b80e-9100b445893e" />

#deleting
<img width="1512" height="502" alt="image" src="https://github.com/user-attachments/assets/a6be76be-668a-4214-94e9-a24a15046369" />
