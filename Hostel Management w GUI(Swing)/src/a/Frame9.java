package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

class Frame9 extends JFrame implements ActionListener {

    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField f1, f2;
    private JTextArea f3;
    private JButton b1, b2;
    private Container c;
    private JComboBox combo;
    private String[] type = {"Cleaning", "Management", "Mess", "Workers", "Water"};
    private Font f = new Font("Consolas", Font.BOLD, 18);
    private JScrollPane sp;
    private ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\problem.jpg");

    Frame9() {

        setSize(700, 500);
        setTitle("Your Comfort is Our Priority");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        l3 = new JLabel("Complain secton");
        l1 = new JLabel("Roll No");
        l2 = new JLabel("Room No");
        l4 = new JLabel("Complain");
        l5 = new JLabel("Complain Type");
        Image im = i.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(im);
        l6 = new JLabel(i2);
        l6.setBounds(0, 0, 700, 500);

        l1.setBounds(70, 100, 150, 30);
        l2.setBounds(70, 200, 150, 30);
        l4.setBounds(70, 300, 150, 30);
        l3.setBounds(250, 20, 250, 30);
        l5.setBounds(350, 100, 250, 30);

        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(new Font("Consolas", Font.BOLD, 22));
        l4.setFont(f);
        l5.setFont(f);

        f1 = new JTextField();
        f2 = new JTextField();
        f3 = new JTextArea();
        sp = new JScrollPane(f3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        f1.setBounds(210, 100, 80, 30);
        f2.setBounds(210, 200, 80, 30);
        sp.setBounds(210, 300, 250, 150);
        sp.setFont(f);

        combo = new JComboBox(type);
        combo.setBounds(510, 100, 150, 30);

        b1 = new JButton("<html><p>Request</p><p>Solution</p></html>");
        b2 = new JButton("<html><p>Display</p><p>Complaints</p><p>(Only Admins)</p></html>");
        b1.setBounds(550, 370, 120, 70);
        b2.setBounds(550, 300, 120, 70);
        b1.addActionListener(this);
        b2.addActionListener(this);
        c = this.getContentPane();
        c.setLayout(null);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);

        c.add(sp);
        c.add(f2);
        c.add(f1);

        c.add(combo);

        c.add(b1);
        c.add(b2);

        c.add(l6);
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            Frame11 f11 = new Frame11(this);
            this.dispose();
        }

        if (e.getSource() == b1) {
            Connection c = null;
            PreparedStatement ps;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");

                String s1 = f1.getText();
                String s2 = f2.getText();
                String s3 = f3.getText();
                String s4 = (String) combo.getSelectedItem();
                LocalDate date = LocalDate.now();
                String s5 = date.toString();
                ps = c.prepareStatement("insert into complain value(?,?,?,?,?)");

                ps.setString(1, s1);
                ps.setString(2, s2);
                ps.setString(3, s4);
                ps.setString(4, s3);
                ps.setString(5, s5);

                if ((f1.getText()).equals("") || (f2.getText()).equals("") || (f1.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Some Fields Are Empty", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {
                    int count = ps.executeUpdate();

                    if (count > 0) {

                        JOptionPane.showMessageDialog(this, "Complain Registered", "Update", JOptionPane.PLAIN_MESSAGE);
                        this.dispose();

                    }
                }
            } catch (Exception e1) {

            } finally {
                try {
                    c.close();
                } catch (Exception e3) {
                }
            }

        }
    }
}
