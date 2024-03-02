package a;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

class STable extends JFrame {
    
    private Connection con;
    private Container c;
    private JTable table;
    private DefaultTableModel m1;
    private String[] tab = {"RollNo.","Name","Room No.","Date of Birth","Phone Number","Email","Gender","Marrital Status","Address","College","Marks(12th)","Course","Cast"};
    private JScrollPane js;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    
    public STable(int roll) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Student Search by Roll No.");
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(20, 10, 1150, 70);

        setIconImage(logo.getImage());
        
        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from adminS where roll=?");
            ps.setInt(1, roll);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = ""+set.getInt(1);//RollNo.
                String s2 = set.getString(2);//Name
                String s3 = ""+set.getInt(3);//Room
                String s4 = set.getString(4);//DOB
                String s5 = set.getString(5);//Phone No
                String s6 = set.getString(6);//Email
                String s7 = set.getString(7);//Gender
                String s8 = set.getString(8);//Married?
                String s9 = set.getString(9);//Address
                String s10 = set.getString(10);//College
                String s11 = ""+set.getFloat(11);//Percent
                String s12 = set.getString(12);//course
                String s13 = set.getString(13);//cast
                String[] data = {s1, s2, s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13};

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
    
    public STable(String name) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Student Search by Name");
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(20, 10, 1150, 70);

        setIconImage(logo.getImage());
        
        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from adminS where name=?");
            ps.setString(1, name);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = ""+set.getInt(1);//RollNo.
                String s2 = set.getString(2);//Name
                String s3 = ""+set.getInt(3);//Room
                String s4 = set.getString(4);//DOB
                String s5 = set.getString(5);//Phone No
                String s6 = set.getString(6);//Email
                String s7 = set.getString(7);//Gender
                String s8 = set.getString(8);//Married?
                String s9 = set.getString(9);//Address
                String s10 = set.getString(10);//College
                String s11 = ""+set.getFloat(11);//Percent
                String s12 = set.getString(12);//course
                String s13 = set.getString(13);//cast
                String[] data = {s1, s2, s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13};

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
    
    public STable(int room,int x) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Student Search by Roll No.");
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(20, 10, 1150, 70);

        setIconImage(logo.getImage());
        
        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from adminS where room=?");
            ps.setInt(1, room);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = ""+set.getInt(1);//RollNo.
                String s2 = set.getString(2);//Name
                String s3 = ""+set.getInt(3);//Room
                String s4 = set.getString(4);//DOB
                String s5 = set.getString(5);//Phone No
                String s6 = set.getString(6);//Email
                String s7 = set.getString(7);//Gender
                String s8 = set.getString(8);//Married?
                String s9 = set.getString(9);//Address
                String s10 = set.getString(10);//College
                String s11 = ""+set.getFloat(11);//Percent
                String s12 = set.getString(12);//course
                String s13 = set.getString(13);//cast
                String[] data = {s1, s2, s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13};

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
}