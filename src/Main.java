import Contoller.StudentController;
import View.StudentView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentController studentController = new StudentController();
        StudentView studentView = new StudentView(studentController);
        studentView.start();
    }


}