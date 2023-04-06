package Contoller;

import Entity.Student;
import Service.StudentService;
import DAO.StudentDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentService studentService;
    private List<Student> students;

    public StudentController() throws SQLException {
        studentService = new StudentService();
        students = studentService.getAllStudents();
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
            students = StudentDAO.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
