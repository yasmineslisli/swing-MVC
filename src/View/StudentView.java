package View;

import Contoller.StudentController;
import DAO.StudentDAO;
import Entity.Student;
import Service.StudentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

//The view package contains classes that handle the presentation logic
// of the application. Views are responsible for rendering user interface
// components and receiving user input.
public class StudentView extends JFrame {
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JTable tblStudents;
    private DefaultTableModel tblModel;
    private StudentController studentController;

    public StudentView(StudentController studentController) throws SQLException {
        setTitle("Student Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);

        txtId = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPhone = new JTextField();

        JLabel lblId = new JLabel("ID");
        JLabel lblName = new JLabel("Name");
        JLabel lblEmail = new JLabel("Email");
        JLabel lblPhone = new JLabel("Phone");

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        tblModel = new DefaultTableModel();
        tblModel.addColumn("ID");
        tblModel.addColumn("Name");
        tblModel.addColumn("Email");
        tblModel.addColumn("Phone");

        tblStudents = new JTable(tblModel);
        JScrollPane scrollPane = new JScrollPane(tblStudents);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(lblId);
        formPanel.add(txtId);
        formPanel.add(lblName);
        formPanel.add(txtName);
        formPanel.add(lblEmail);
        formPanel.add(txtEmail);
        formPanel.add(lblPhone);
        formPanel.add(txtPhone);
        formPanel.add(btnAdd);
        formPanel.add(btnUpdate);
        formPanel.add(btnDelete);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(formPanel, BorderLayout.SOUTH);

        StudentService studentService = new StudentService(new StudentDAO());
        this.studentController = new StudentController(studentService);
        populateTable();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();

                StudentView.this.studentController.addStudent(name, email, phone);
                populateTable();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();

                StudentView.this.studentController.updateStudent(id, name, email, phone);
                populateTable();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                StudentView.this.studentController.deleteStudent(id);
                populateTable();
            }
        });

        tblStudents.getSelectionModel().addListSelectionListener(event -> {
            if (tblStudents.getSelectedRow() >= 0) {
                int id = Integer.parseInt(tblStudents.getValueAt(tblStudents.getSelectedRow(), 0).toString());
                String name = tblStudents.getValueAt(tblStudents.getSelectedRow(), 1).toString();
                String email = tblStudents.getValueAt(tblStudents.getSelectedRow(), 2).toString();
                String phone = tblStudents.getValueAt(tblStudents.getSelectedRow(), 3).toString();

                txtId.setText(Integer.toString(id));
                txtName.setText(name);
                txtEmail.setText(email);
                txtPhone.setText(phone);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateTable() {
        tblModel.setRowCount(0);

        List<Student> students = studentController.getAllStudents();

        for (Student student : students) {
            Object[] row = new Object[4];
            row[0] = student.getId();
            row[1] = student.getName();
            row[2] = student.getEmail();
            row[3] = student.getPhone();
            tblModel.addRow(row);
        }

    }
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentView.this.setVisible(true);
            }
        });
    }


}
