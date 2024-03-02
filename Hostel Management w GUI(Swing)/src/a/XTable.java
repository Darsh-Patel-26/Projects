package a;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

class XTable extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private String[] s = {"Roll NO", "Room NO", "IS OUT"};
    private JScrollPane sp;
    private Container c;
    private Connection con = null;

    XTable() {
        setTitle("Students Who Are Not IN");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        c = this.getContentPane();
        c.setLayout(null);

        model = new DefaultTableModel(null, s);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setBounds(50, 30, 400, 400);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from register");
            ResultSet rs = ps.executeQuery();
            this.model = (DefaultTableModel) table.getModel();

            while (rs.next()) {
                String s1, s2, s3;
                s1 = rs.getString(1);
                s2 = rs.getString(2);
                s3 = rs.getString(3);
                String[] s = {s1, s2, s3};
                this.model.addRow(s);

            }
        } catch (Exception e1) {
        } finally {
            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        c.add(sp);
        c.setLayout(null);
        setVisible(true);
        validate();
    }

}
