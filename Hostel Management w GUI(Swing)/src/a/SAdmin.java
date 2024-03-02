package a;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class SAdmin extends JFrame implements ActionListener {

    private Connection con;
    private Container c;
    private JLabel l1, l2, l3, l4, lbg;
    private JButton b1, b3, b4;
    private JTextField f1, f2, f3;
    private JRadioButton rb1, rb2;
    private JTable table;
    private DefaultTableModel m1;
    private String[] tab = {"Roll No.", "Name", "Room No."};
    private JScrollPane js;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private final ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\SAdmin.png\\");
    ButtonGroup bgb;

    public SAdmin() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1028, 678);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Student Administration");

        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(150, 400, 700, 200);

        setIconImage(logo.getImage());
        Image bg = i.getImage().getScaledInstance(1028, 678, Image.SCALE_DEFAULT);
        ImageIcon bgd = new ImageIcon(bg);

        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);

        l1 = new JLabel("Student Administration Page");
        l1.setBounds(500, 10, 150, 30);
        l1.setBounds(320, 30, 600, 50);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Consolas", Font.BOLD, 28));
        c.add(l1); // Add label to the frame

        l2 = new JLabel("Roll No.");
        l2.setBounds(40, 100, 150, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(l2);

        l3 = new JLabel("Name");
        l3.setBounds(40, 150, 150, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(l3);

        b4 = new JButton("Add Roll No.");
        b4.setBounds(150, 210, 150, 30);
        b4.addActionListener(this);
        c.add(b4);

        b1 = new JButton("Remove");
        b1.setBounds(350, 210, 150, 30);
        b1.addActionListener(this);
        c.add(b1);

        f1 = new JTextField();
        f1.setBounds(150, 100, 500, 30);
        f1.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f1);

        f2 = new JTextField();
        f2.setBounds(150, 150, 500, 30);
        f2.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f2);

        l4 = new JLabel("Search by");
        l4.setBounds(40, 300, 150, 30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(l4);

        rb1 = new JRadioButton("Roll No.");
        rb1.setBounds(200, 300, 150, 30);
        c.add(rb1);

        rb2 = new JRadioButton("Name");
        rb2.setBounds(350, 300, 150, 30);
        c.add(rb2);

        bgb = new ButtonGroup();
        bgb.add(rb1);
        bgb.add(rb2);

        f3 = new JTextField();
        f3.setBounds(500, 300, 150, 30);
        f3.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f3);

        b3 = new JButton("Search");
        b3.setBounds(700, 300, 150, 30);
        b3.addActionListener(this);
        c.add(b3);

        lbg = new JLabel(bgd);
        lbg.setBounds(0, 0, 1028, 678);
        c.add(lbg);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select roll,name,room from student");
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = set.getString(1);
                String s2 = set.getString(2);
                String s3 = set.getString(3);
                String[] data = {s1, s2, s3};

                m1.addRow(data);
            }
        } catch (Exception ee) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                int roll = Integer.parseInt(f1.getText());//ROLL no.
                String name = f2.getText();//name
                PreparedStatement ps = con.prepareStatement("delete from student where roll=? and name=?");

                ps.setInt(1, roll);
                ps.setString(2, name);

                int c = ps.executeUpdate();

                if (c > 0) {
                    JOptionPane.showMessageDialog(this,  " Updated Succesfully", "Updation", JOptionPane.PLAIN_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this,  " Updation Failed", "Updation", JOptionPane.PLAIN_MESSAGE);

                }
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }
        if (e.getSource() == b3) {
            try {
                if(rb1.isSelected()) {
                    STable st = new STable(Integer.parseInt(f3.getText()));
                }
                else {
                    STable st = new STable(f3.getText());
                }
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }

        }
        if (e.getSource() == b4) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                int roll = Integer.parseInt(f1.getText());//ROLL no.
                String name = f2.getText();//name
                PreparedStatement ps = con.prepareStatement("update student set roll=? where name=?");

                ps.setInt(1, roll);
                ps.setString(2, name);

                int c = ps.executeUpdate();

                if (c > 0) {
                    JOptionPane.showMessageDialog(this, roll + " Updated Succesfully", "Updation", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                    SAdmin s2 = new SAdmin();

                } else {
                    JOptionPane.showMessageDialog(this, roll + " Updation Failed", "Updation", JOptionPane.PLAIN_MESSAGE);

                }
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }
    }
}