package a;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.*;

class WTable extends JFrame {
    
    private Connection con;
    private Container c;
    private JTable table;
    private DefaultTableModel m1;
    private String[] tab = {"I.D.","Name","Job","Date of Birth","Phone Number","Email","Gender","Marrital Status","Address","Last Worked","Cast"};
    private JScrollPane js;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    
    public WTable(int id) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Worker Search by I.D.");
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
            PreparedStatement ps = con.prepareStatement("select * from adminW where id=?");
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = ""+set.getInt(1);//id.
                String s2 = set.getString(2);//Name
                String s3 = set.getString(3);//job
                String s4 = set.getString(4);//DOB
                String s5 = set.getString(5);//Phone No
                String s6 = set.getString(6);//Email
                String s7 = set.getString(7);//Gender
                String s8 = set.getString(8);//Married?
                String s9 = set.getString(9);//Address
                String s10 = set.getString(10);//Last work
                String s11 = set.getString(11);//cast
                String[] data = {s1, s2, s3,s4,s5,s6,s7,s8,s9,s10,s11};

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
    
    public WTable(String name) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Worker Search by Name");
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
            PreparedStatement ps = con.prepareStatement("select * from adminW where name=?");
            ps.setString(1, name);
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = ""+set.getInt(1);//id.
                String s2 = set.getString(2);//Name
                String s3 = set.getString(3);//job
                String s4 = set.getString(4);//DOB
                String s5 = set.getString(5);//Phone No
                String s6 = set.getString(6);//Email
                String s7 = set.getString(7);//Gender
                String s8 = set.getString(8);//Married?
                String s9 = set.getString(9);//Address
                String s10 = set.getString(10);//Last work
                String s11 = set.getString(11);//cast
                String[] data = {s1, s2, s3,s4,s5,s6,s7,s8,s9,s10,s11};

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