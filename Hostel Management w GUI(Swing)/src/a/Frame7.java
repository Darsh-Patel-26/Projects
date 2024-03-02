package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Frame7 extends JFrame implements ActionListener, ItemListener {

    private JLabel l1, l2, l3, l4, l5, l6;
    private JButton b1, b2, b3;
    private JComboBox c1;
    private Container c;
    private JTextField t1;
    private JTextArea area;
    private final String[] s = {"Email", "Address", "Password", "Phone Number"};
    private Font f = new Font("Consolas", Font.BOLD, 18);
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private final ImageIcon bg1 = new ImageIcon("E:\\Submit\\Project\\src\\a\\stude.jpg");
    private String name, course;
    private int roll, room;
    private Image img;
    private ImageIcon bg2;
    private JLabel bg;

    Frame7(String name, int roll, int room, String course) {
        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(logo.getImage());
        setTitle("Students Page");

        this.name = name;
        this.course = course;
        this.roll = roll;
        this.room = room;
        l1 = new JLabel("1.Update Info");
        l2 = new JLabel("2.Cleaning Service");
        l3 = new JLabel("3.Get ID Card");
        l4 = new JLabel("Roll No : " + roll);
        l5 = new JLabel("Room NO : " + room);
        l6 = new JLabel("Name : " + name);
        l1.setFont(new Font("Consolas", Font.BOLD, 19));
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.RED);
        c1 = new JComboBox(s);
        c1.setBounds(400, 100, 100, 30);
        area = new JTextArea();
        area.setBounds(400, 140, 260, 70);
        area.setVisible(false);

        l1.setBounds(200, 150, 200, 50);
        l2.setBounds(200, 280, 200, 50);
        l3.setBounds(200, 380, 200, 50);
        l4.setBounds(500, 0, 200, 50);
        l5.setBounds(300, 0, 200, 50);
        l6.setBounds(20, 0, 200, 50);

        t1 = new JTextField();
        t1.setBounds(400, 160, 260, 30);
        t1.setFont(f);

        b1 = new JButton("Update");
        b2 = new JButton("Set Request");
        b3 = new JButton("Get PDF");

        b1.setBounds(400, 220, 150, 30);
        b2.setBounds(400, 280, 150, 30);
        b3.setBounds(400, 380, 150, 30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        c1.addItemListener(this);

        img = bg1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        bg2 = new ImageIcon(img);

        bg = new JLabel(bg2);
        bg.setBounds(0, 0, 700, 500);
        c = this.getContentPane();
        c.setLayout(null);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);

        c.add(t1);

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(c1);
        c.add(area);

        c.add(bg);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = (String) c1.getSelectedItem();
            Connection con = null;
            PreparedStatement ps = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                if (s1 == "Email") {
                    ps = con.prepareStatement("update student set email=? where roll=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.roll);

                } else if (s1 == "Password") {
                    ps = con.prepareStatement("update student set password=? where roll=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.roll);
                } else if (s1 == "Address") {
                    ps = con.prepareStatement("update student set address=? where roll=?");

                    ps.setString(1, area.getText());
                    ps.setInt(2, this.roll);

                } else if (s1 == "Phone Number") {
                    ps = con.prepareStatement("update student set pnum=? where roll=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.roll);
                }
                int c = ps.executeUpdate();

                if (c > 0) {
                    JOptionPane.showMessageDialog(this, s1 + " Updated Succesfully", "Updation", JOptionPane.PLAIN_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, s1 + " Updated Failed", "Updation", JOptionPane.PLAIN_MESSAGE);

                }
            } catch (Exception e4) {
            } finally {
                try {
                    con.close();
                } catch (Exception e5) {
                }
            }

        }
        if (e.getSource() == b2) {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                PreparedStatement ps = con.prepareStatement("insert into service values(?,?,?)");
                ps.setInt(1, this.roll);
                ps.setInt(2, this.room);
                ps.setString(3, "false");
                int x = ps.executeUpdate();
                if (x > 0) {
                    JOptionPane.showMessageDialog(null, "Succes");
                } else {
                    JOptionPane.showMessageDialog(null, "UNSucces");

                }
            } catch (Exception e3) {
            }

        }
        if (e.getSource() == b3) {
            ID id = new ID(this.name, this.roll, this.room, "B.Tech");
            JOptionPane.showMessageDialog(this, "Id Card Created", "Message", JOptionPane.PLAIN_MESSAGE);
        }

    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == c1) {
            if (c1.getSelectedIndex() == 1) {
                t1.setVisible(false);
                area.setVisible(true);

            } else {
                area.setVisible(false);
                t1.setVisible(true);
            }
        }

    }

}
