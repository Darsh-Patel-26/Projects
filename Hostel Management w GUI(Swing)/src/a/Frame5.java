package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Frame5 extends JFrame implements ActionListener {

    private Container c;
    private JButton b1;
    private JLabel l1, l2, l3, l4;
    private JTextField t1;
    private JPasswordField p1;
    private final Font f = new Font("Consolas", Font.PLAIN, 20);
    private ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\studnets.jpg");
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");

    Frame5() {

        setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(logo.getImage());
        setTitle("Login");
        Image bg = i.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(bg);
        l1 = new JLabel("Email");
        l2 = new JLabel("Password");
        l3 = new JLabel("Student Login Page");
        l4 = new JLabel(img);

        l1.setBounds(50, 120, 150, 50);
        l2.setBounds(40, 200, 150, 50);
        l3.setBounds(70, 20, 300, 50);
        l4.setBounds(0, 0, 400, 400);

        l1.setFont(new Font("Consolas", Font.BOLD, 24));
        l2.setFont(new Font("Consolas", Font.BOLD, 24));
        l3.setFont(new Font("MV Boli", Font.BOLD, 28));

        t1 = new JTextField();
        p1 = new JPasswordField();

        t1.setBounds(180, 120, 180, 40);
        p1.setBounds(180, 200, 180, 40);

        b1 = new JButton("LOGIN");
        b1.setFont(f);
        b1.setBounds(130, 280, 130, 40);

        b1.addActionListener(this);
        c = this.getContentPane();
        c.setLayout(null);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(t1);
        c.add(p1);
        c.add(b1);

        // c.add(l4);
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Connection c1 = null;
            PreparedStatement ps1;
            String name, course;
            int room, roll;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                String s1 = t1.getText();
                String s2 = p1.getText();
                ps1 = c1.prepareStatement("select * from student where email=? and password=?");
                ps1.setString(1, s1);
                ps1.setString(2, s2);

                ResultSet s4 = ps1.executeQuery();

                if (s4.next()) {
                    this.dispose();
                    name = s4.getString("name");
                    roll = s4.getInt(14);
                    room = s4.getInt(13);
                    course = s4.getString("course");
                    Frame7 f7 = new Frame7(name, roll, room, course);
                } else {
                    t1.setText(null);
                    p1.setText(null);
                    JOptionPane.showMessageDialog(this, "Error", "Invalid Email or Password", JOptionPane.PLAIN_MESSAGE);
                }

            } catch (Exception e2) {

            } finally {
                try {
                    c1.close();
                } catch (Exception e3) {
                }
            }

        }
    }

}
