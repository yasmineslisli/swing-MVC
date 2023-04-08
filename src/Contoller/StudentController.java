package Contoller;

import Entity.Student;
import Service.StudentService;
import DAO.StudentDAO;
import View.StudentView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//The controller package contains classes that handle user
// input and interact with the model and view components.
// The controller's primary responsibility is to control the
// flow of the application by receiving user input and
// invoking appropriate actions on the model or view
// components.
public class StudentController {
    private StudentService studentService;
    private StudentView studentView;
    private List<Student> students;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        students = new ArrayList<>();
    }


    public void addStudent(String name, String email, String phone) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);

        studentService.addStudent(student);
        students.add(student);
    }

    public void updateStudent(int id, String name, String email, String phone) {
        Student student = studentService.getStudentById(id);
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);

        studentService.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            students = StudentService.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
