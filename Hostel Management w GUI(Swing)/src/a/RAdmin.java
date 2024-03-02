package a;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class RAdmin extends JFrame implements ActionListener {

    private Connection con;
    private Container c;
    private JLabel l1, l2, l4, l5,lbg;
    private JButton b1, b2,b3, b4,b5;
    private JTextField f1, f2, f3;
    private JTable table;
    private DefaultTableModel m1;
    private String[] tab = {"Room No.", "Roll"};
    private JScrollPane js;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private final ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\RAdmin.jpg");

    public RAdmin() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1028, 678);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Room Allocation");
        setIconImage(logo.getImage());
        Image bg = i.getImage().getScaledInstance(1028, 678, Image.SCALE_DEFAULT);
        ImageIcon bgd = new ImageIcon(bg);
        c = this.getContentPane();
        c.setLayout(null);
        
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(150, 350, 700, 250);
        c.add(js);

        lbg = new JLabel(bgd);
        lbg.setBounds(0, 0, 1028, 678);
        
        l1 = new JLabel("Room Allocation");
        l1.setBounds(380, 30, 600, 50);
        l1.setFont(new Font("Consolas", Font.BOLD, 28));
        c.add(l1);

        l2 = new JLabel("Room NO.");
        l2.setBounds(100, 120, 150, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(l2);

        b1 = new JButton("Available Rooms");
        b1.setBounds(500, 120, 170, 30);
        b1.addActionListener(this);
        b1.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(b1);

        f1 = new JTextField();
        f1.setBounds(250, 120, 150, 25);
        f1.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(f1);

        l4 = new JLabel("Room No.");
        l4.setBounds(100, 280, 150, 30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(l4);

        f3 = new JTextField();
        f3.setBounds(250, 280, 150, 25);
        f3.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(f3);

        b2 = new JButton("Search");
        b2.setBounds(500, 280, 100, 25);
        b2.addActionListener(this);
        b2.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(b2);
        
        b3 = new JButton("Check Roll No.");
        b3.setBounds(700, 120, 170, 30);
        b3.addActionListener(this);
        b3.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(b3);

        l5 = new JLabel("Add Roll No.");
        l5.setBounds(100, 200, 150, 30);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(l5);

        f2 = new JTextField();
        f2.setBounds(250, 200, 150, 25);
        f2.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(f2);

        b4 = new JButton("Add");
        b4.setBounds(500, 200, 100, 30);
        b4.addActionListener(this);
        b4.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(b4);
        
        b5 = new JButton("Remove");
        b5.setBounds(700, 200, 100, 30);
        b5.addActionListener(this);
        b5.setFont(new Font("Consolas", Font.BOLD, 14));
        c.add(b5);

        c.add(lbg);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from rooms where not roll =?");
            ps.setInt(1, 0);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = set.getString(1);
                String s2 = set.getString(2);
                String[] data = {s1, s2};

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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                PreparedStatement ps = con.prepareStatement("select roomNo from rooms where roll=?");
                ps.setInt(1, 0);
                ResultSet set = ps.executeQuery();
                
                RTable r = new RTable(set,"Room");
                
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }
        if (e.getSource() == b2) {
            STable st = new STable(Integer.parseInt(f3.getText()),0);
            f3.setText(null);
            
        }
        if (e.getSource() == b3) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                PreparedStatement ps = con.prepareStatement("select roll from student where room=?");
                ps.setInt(1, 0);
                ResultSet set = ps.executeQuery();
                
                RTable r = new RTable(set,"Roll No.");
                
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }
        if (e.getSource() == b4) {
            String s1 = f1.getText();
            String s2 = f2.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                PreparedStatement ps = con.prepareStatement("update student set room=? where roll=?");
                ps.setInt(1, Integer.parseInt(s1));
                ps.setInt(2, Integer.parseInt(s2));
                int c = ps.executeUpdate();
                
                ps = con.prepareStatement("update rooms set roll=? where roomNo=?");
                ps.setInt(1, Integer.parseInt(s2));
                ps.setInt(2, Integer.parseInt(s1));
                
                int c1 = ps.executeUpdate();
                
                if(c>0 && c1>0){
                    JOptionPane.showMessageDialog(this," Updated Succesfully","Updation",JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                    RAdmin r = new RAdmin();
                }
                else
                {
                    JOptionPane.showMessageDialog(this," Updated Failed","Updation",JOptionPane.PLAIN_MESSAGE);
        
                }
                
            } catch (Exception ee) {
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }
        if (e.getSource() == b5) {
            String s1 = f1.getText();
            String s2 = f2.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                PreparedStatement ps = con.prepareStatement("update student set room=? where roll=?");
                ps.setInt(1, Integer.parseInt("0"));
                ps.setInt(2, Integer.parseInt(s2));
                int c = ps.executeUpdate();
                
                ps = con.prepareStatement("update rooms set roll=? where roomNo=?");
                ps.setInt(1, Integer.parseInt("0"));
                ps.setInt(2, Integer.parseInt(s1));
                
                int c1 = ps.executeUpdate();
                
                if(c>0 && c1>0){
                    JOptionPane.showMessageDialog(this," Updated Succesfully","Updation",JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                    RAdmin r = new RAdmin();
                }
                else
                {
                    JOptionPane.showMessageDialog(this," Updated Failed","Updation",JOptionPane.PLAIN_MESSAGE);
        
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


