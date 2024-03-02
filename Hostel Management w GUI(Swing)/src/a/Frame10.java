package a;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import javax.swing.table.*;

class Frame10 extends JFrame {

    private JTable table;
    private Container c;
    private String[] row = {"Roll No", "Room No", "Type Of Complain", "Complain", "Date"};
    private JScrollPane sp;
    private DefaultTableModel m = new DefaultTableModel(null, row);
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ResultSetMetaData pmd = null;

    public Frame10() {

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Complain Section");
        table = new JTable(m);
        sp = new JScrollPane(table);
        sp.setBounds(50, 70, 700, 500);
        c = this.getContentPane();
        c.setLayout(null);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");

            ps = con.prepareStatement("select * from complain");
            rs = ps.executeQuery();

            this.m = (DefaultTableModel) table.getModel();

            String s1, s2, s3, s4, s5;
            while (rs.next()) {

                s1 = rs.getString(1);
                s2 = rs.getString(2);
                s3 = rs.getString(3);
                s4 = rs.getString(4);
                s5 = rs.getString(5);
                String[] sr = {s1, s2, s3, s4, s5};
                m.addRow(sr);

            }

        } catch (Exception e1) {
        } finally {
            try {
                con.close();
            } catch (Exception e2) {
            }
        }
        c.add(sp);
        this.setVisible(true);
        validate();
    }

}
