package DAO;

import Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//The DAO package contains classes that are responsible for data storage
// and retrieval. The DAO provides a layer of abstraction
// between the application and the database, allowing the
// application to access data without being tied to a
// specific database implementation.
public class StudentDAO {
//DAO for database
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public void addStudent(Student student) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/swing", DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO student (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/swing", DB_USER, DB_PASSWORD)) {
            String query = "UPDATE student SET name=?, email=?, phone=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/swing", DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM student WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/swing", DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Student student = new Student(id, name, email, phone);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById(int id) {
        Student student = new Student();

        try {Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/swing", DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

}
