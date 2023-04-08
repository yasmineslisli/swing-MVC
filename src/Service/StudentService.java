package Service;

import DAO.StudentDAO;
import Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// The service package contains classes that provide business logic and act as a bridge between the controller
// and DAO layers. The service layer is responsible for processing data and performing business operations
// on the data before it's stored in the database or
// presented to the user.
public class StudentService {
    private Connection connection;
    private static StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public static List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public static Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public void addStudent(Student student) {
        if (student.getName().isEmpty() || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Name and email cannot be empty.");
        }
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
        if (student.getName().isEmpty() || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Name and email cannot be empty.");
        }
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);

    }
}
