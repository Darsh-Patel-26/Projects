package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

class Frame6 extends JFrame implements ActionListener {

    private Container c;
    private JButton b1;
    private JLabel l1, l2, l3;
    private JTextField t1;
    private JPasswordField p1;
    private final Font f = new Font("Consolas", Font.PLAIN, 20);
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");

    Frame6() {

        setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(logo.getImage());
        setTitle("Login");
        l1 = new JLabel("Email");
        l2 = new JLabel("Password");
        l3 = new JLabel("Worker Login Page");

        l1.setBounds(50, 120, 150, 50);
        l2.setBounds(40, 200, 150, 50);
        l3.setBounds(70, 20, 300, 50);

        l1.setFont(new Font("Consolas", Font.BOLD, 24));
        l2.setFont(new Font("Consolas", Font.BOLD, 24));
        l3.setFont(new Font("Consolas", Font.BOLD, 28));
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);

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
        c.setBackground(Color.DARK_GRAY);

        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            Connection c1 = null;
            PreparedStatement ps1;
            String name, job;
            int id;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                String s1 = t1.getText();
                String s2 = p1.getText();
                ps1 = c1.prepareStatement("select * from worker where email=? and password=?");
                ps1.setString(1, s1);
                ps1.setString(2, s2);

                ResultSet s4 = ps1.executeQuery();
                if (s4.next()) {
                    this.dispose();
                    name = s4.getString("name");
                    id = s4.getInt("id");
                    job = s4.getString("job");
                    Frame8 f8 = new Frame8(name, id, job);
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
