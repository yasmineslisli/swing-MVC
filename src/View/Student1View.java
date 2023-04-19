package View;

import javax.swing.*;
import java.awt.*;

public class Student1View extends JFrame{

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JTable tblStudents;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public Student1View()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")

    public void initComponents()
    {
        JLabel lblId = new JLabel("ID");
        JLabel lblName = new JLabel("Name");
        JLabel lblEmail = new JLabel("Email");
        JLabel lblPhone = new JLabel("Phone");

        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtEmail= new JTextField();
        JTextField txtPhone = new JTextField();

        JButton btnAdd = new JButton();
        JButton bnUpdate = new JButton();
        JButton btnDelete = new JButton();

        JPanel jPanel1 = new JPanel();

        txtId.setBackground(new Color(250,240,230))	;
        txtName.setBackground(new Color(250,240,230))	;
        txtEmail.setBackground(new Color(250,240,230))	;
        txtPhone.setBackground(new Color(250,240,230))	;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt){
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblId.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        lblId.setForeground(new Color(25, 118, 211));
        lblId.setBounds();
        lblId.setText("ID");



    }
    private void formWindowOpened(java.awt.event.WindowEvent evt){

    }

        public void start() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Student1View.this.setVisible(false);
                }
            });
        }
}
