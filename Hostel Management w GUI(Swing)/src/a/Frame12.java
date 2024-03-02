package a;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;

class Frame12 extends JFrame {

    private JTable table;
    private DefaultTableModel m1;
    private Container c;
    private Connection con = null;
    private String[] tab = {"Time", "Moday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday", "Suday"};
    private JScrollPane js;
    private ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\cantine.jpg");
    private Image im;
    private ImageIcon bg;
    private JLabel l;

    Frame12() {
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("MESS MENU");
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(50, 100, 700, 300);

        im = i.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        bg = new ImageIcon(im);
        l = new JLabel(bg);
        l.setBounds(0, 0, 800, 600);
        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);
        c.add(l);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from mess");
            ResultSet set = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (set.next()) {
                String s1 = set.getString(1);
                String s2 = set.getString(2);
                String s3 = set.getString(3);
                String s4 = set.getString(4);
                String s5 = set.getString(5);
                String s6 = set.getString(6);
                String s7 = set.getString(7);
                String s8 = set.getString(8);
                String[] menu = {s1, s2, s3, s4, s5, s6, s7, s8};

                m1.addRow(menu);
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
