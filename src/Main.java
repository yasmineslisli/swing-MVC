import Contoller.StudentController;
import DAO.StudentDAO;
import Service.StudentService;
import View.StudentView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();

        // create service object
        StudentService studentService = new StudentService(studentDAO);

        // create controller object
        StudentController studentController = new StudentController(studentService);
        // create view object
        StudentView studentView = new StudentView(studentController);
        studentView.start();
    }


}