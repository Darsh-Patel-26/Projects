package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Frame8 extends JFrame implements ActionListener, ItemListener {

    private JLabel l1, l2, l3, l4, l6;
    private JButton b1, b2, b3;
    private JComboBox c1;
    private Container c;
    private JTextField t1;
    private JTextArea area;
    private final String[] s = {"Email", "Address", "Password", "Phone Number"};
    private Font f = new Font("Consolas", Font.BOLD, 18);
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private String name, work;
    private int id;
    private final ImageIcon bg1 = new ImageIcon("E:\\Submit\\Project\\src\\a\\work.jpg");
    private Image img;
    private ImageIcon bg2;
    private JLabel bg;

    Frame8(String name, int id, String field) {

        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(logo.getImage());
        setTitle("Workers Page");

        this.name = name;
        this.id = id;
        this.work = field;
        l1 = new JLabel("1.Update Info");
        l2 = new JLabel("2.Cleaning Service");
        l3 = new JLabel("3.Get ID Card");
        l4 = new JLabel("ID No : " + id);
        l6 = new JLabel("Name : " + name);
        l1.setFont(new Font("Consolas", Font.BOLD, 20));
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);

        l6.setFont(f);
        c1 = new JComboBox(s);
        c1.setBounds(250, 100, 100, 30);
        area = new JTextArea();
        area.setBounds(400, 100, 260, 80);
        area.setVisible(false);

        l1.setBounds(50, 100, 200, 50);
        l2.setBounds(100, 280, 200, 50);
        l3.setBounds(100, 380, 200, 50);
        l4.setBounds(400, 0, 200, 50);
        l6.setBounds(50, 0, 200, 50);

        t1 = new JTextField();
        t1.setBounds(400, 100, 260, 30);
        t1.setFont(f);

        b1 = new JButton("Update");
        b2 = new JButton("Give Service");
        b3 = new JButton("Get PDF");

        b1.setBounds(280, 200, 150, 30);
        b2.setBounds(350, 280, 150, 30);
        b3.setBounds(350, 380, 150, 30);
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
                    ps = con.prepareStatement("update worker set email=? where id=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.id);

                } else if (s1 == "Password") {
                    ps = con.prepareStatement("update worker set password=? where id=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.id);
                } else if (s1 == "Address") {
                    ps = con.prepareStatement("update worker set address=? where id=?");

                    ps.setString(1, area.getText());
                    ps.setInt(2, this.id);

                } else if (s1 == "Phone Number") {
                    ps = con.prepareStatement("update worker set pnum=? where id=?");

                    ps.setString(1, t1.getText());
                    ps.setInt(2, this.id);
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
            this.dispose();
            Frame13 f13 = new Frame13();
        }
        if (e.getSource() == b3) {
            IDWorker work = new IDWorker(this.name, this.id, this.work);
            JOptionPane.showMessageDialog(this, "ID Created ", "ID creator", JOptionPane.PLAIN_MESSAGE);

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
