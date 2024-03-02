package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;

class EAdmin extends JFrame implements ActionListener {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    private JLabel total;
    private JTextField f1, f2, f3, f4, f5, f6;
    private JRadioButton rb1, rb2;
    private Container c;
    private JButton but, see;
    private Connection con = null;

    public EAdmin() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1028, 678);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Expense Management");
        c = this.getContentPane();
        c.setLayout(null);

        l1 = new JLabel("Expense sheet");
        l1.setBounds(400, 10, 500, 30);
        l1.setFont(new Font("Consolas", Font.BOLD, 30));
        c.add(l1);

        l2 = new JLabel("Maintanance");
        l2.setBounds(60, 100, 150, 30);
        l2.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(l2);

        l3 = new JLabel("Electricity bill");
        l3.setBounds(60, 200, 200, 30);
        l3.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(l3);

        l4 = new JLabel("Food Bill");
        l4.setBounds(60, 300, 200, 30);
        l4.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(l4);

        l5 = new JLabel("Workers payment");
        l5.setBounds(60, 400, 200, 30);
        l5.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(l5);

        l6 = new JLabel("Other");
        l6.setBounds(560, 100, 150, 30);
        l6.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(l6);
        l7 = new JLabel("Other Type");
        l7.setBounds(550, 200, 200, 25);
        l7.setFont(new Font("Consolas", Font.BOLD, 18));
        l7.setVisible(false);
        c.add(l7);
        l8 = new JLabel("Fees");
        l8.setBounds(550, 250, 200, 25);
        l8.setFont(new Font("Consolas", Font.BOLD, 18));
        l8.setVisible(false);
        c.add(l8);

        total = new JLabel("Total");
        total.setBounds(570, 400, 300, 30);
        total.setFont(new Font("Consolas", Font.BOLD, 18));
        c.add(total);

        f1 = new JTextField();
        f1.setBounds(250, 95, 200, 25);
        f1.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f1);

        f2 = new JTextField();
        f2.setBounds(250, 195, 200, 25);
        f2.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f2);

        f3 = new JTextField();
        f3.setBounds(250, 295, 200, 25);
        f3.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f3);

        f4 = new JTextField();
        f4.setBounds(250, 400, 200, 25);
        f4.setFont(new Font("Consolas", Font.BOLD, 16));
        c.add(f4);

        f5 = new JTextField();
        f5.setBounds(660, 200, 200, 25);
        f5.setFont(new Font("Consolas", Font.BOLD, 16));
        f5.setVisible(false);

        f6 = new JTextField();
        f6.setBounds(660, 250, 200, 25);
        f6.setFont(new Font("Consolas", Font.BOLD, 16));
        f6.setVisible(false);

        rb1 = new JRadioButton("False");
        rb1.setBounds(800, 100, 100, 20);
        rb1.addActionListener(this);

        rb2 = new JRadioButton("True");
        rb2.setBounds(700, 100, 100, 20);
        rb2.addActionListener(this);

        but = new JButton("Submit");
        but.addActionListener(this);
        but.setBounds(280, 570, 100, 30);
        c.add(but);

        see = new JButton("Expenses Table");
        see.addActionListener(this);
        see.setBounds(480, 570, 200, 30);
        c.add(see);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        rb1.setSelected(true);
        c.add(rb1);
        c.add(f5);
        c.add(f6);
        c.add(rb2);
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (rb2.isSelected()) {
            f5.setVisible(true);
            f6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
        }
        if (rb1.isSelected()) {
            f5.setVisible(false);
            f6.setVisible(false);
            l7.setVisible(false);
            l8.setVisible(false);
        }

        if (e.getSource() == see) {
            ETable tabl = new ETable();
        }

        if (e.getSource() == but) {

            if (f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Something is Empty", "ERROR", JOptionPane.WARNING_MESSAGE);
            } else {

                if (rb2.isSelected()) {
                    try {
                        int x6;
                        int x1 = Integer.parseInt(f1.getText());
                        int x2 = Integer.parseInt(f2.getText());
                        int x3 = Integer.parseInt(f3.getText());
                        int x4 = Integer.parseInt(f4.getText());
                        String s = f5.getText();
                        x6 = Integer.parseInt(f6.getText());
                        LocalDate d = LocalDate.now();
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
                        PreparedStatement ps = con.prepareStatement("insert into expenses values(?,?,?,?,?,?,?,?)");

                        ps.setInt(1, x1);
                        ps.setInt(2, x2);
                        ps.setInt(3, x3);
                        ps.setInt(4, x4);
                        ps.setString(5, s);
                        ps.setInt(6, x6);

                        ps.setInt(7, x1 + x2 + x3 + x4 + x6);
                        ps.setString(8, d.toString());
                        int cc = ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Data Stored", "Success", JOptionPane.PLAIN_MESSAGE);
                        total.setText("Total : " + (x1 + x2 + x3 + x4 + x6));
                    } catch (Exception e2) {
                    } finally {
                        try {
                            con.close();
                        } catch (Exception e4) {

                        }
                    }
                } else {
                    try {

                        int x1 = Integer.parseInt(f1.getText());
                        int x2 = Integer.parseInt(f2.getText());
                        int x3 = Integer.parseInt(f3.getText());
                        int x4 = Integer.parseInt(f4.getText());
                        String s = f5.getText();
                        LocalDate d = LocalDate.now();
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                        PreparedStatement ps = con.prepareStatement("insert into expenses values(?,?,?,?,?,?,?,?)");

                        ps.setInt(1, x1);
                        ps.setInt(2, x2);
                        ps.setInt(3, x3);
                        ps.setInt(4, x4);
                        ps.setString(5, "Empty");
                        ps.setInt(6, 0);

                        ps.setInt(7, x1 + x2 + x3 + x4);
                        ps.setString(8, d.toString());
                        int cc = ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Data Stored", "Success", JOptionPane.PLAIN_MESSAGE);

                        total.setText("Total : " + (x1 + x2 + x3 + x4));
                    } catch (Exception e3) {
                    } finally {
                        try {

                            f1.setText("");
                            f2.setText("");
                            f3.setText("");
                            f4.setText("");
                            f5.setText("");
                            f6.setText("");
                            con.close();
                        } catch (Exception e4) {

                        }
                    }

                }
            }

        }
    }
}

