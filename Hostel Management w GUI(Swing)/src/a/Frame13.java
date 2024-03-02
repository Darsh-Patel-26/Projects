package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

class Frame13 extends JFrame implements ActionListener {

    private Container c;
    private Connection con = null;
    private JTable table;
    private DefaultTableModel m1;
    private final String[] st = {"Room No", "Roll No", "IS Done"};
    private JScrollPane js;
    private JButton b;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    Frame13() {

        setTitle("Work List");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setIconImage(logo.getImage());
        setLocationRelativeTo(null);
        setResizable(false);

        m1 = new DefaultTableModel(null, st);
        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(50, 50, 600, 400);

        b = new JButton("Delete");
        b.setBounds(300,0,100,30);
        b.addActionListener(this);
        c = this.getContentPane();
        c.setLayout(null);
        c.add(js);
        c.add(b);
        this.connectionF();
        setVisible(true);
        validate();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                this.m1 = (DefaultTableModel) table.getModel();
                int i = table.getSelectedRow();

                PreparedStatement ps = con.prepareStatement("delete from service where roll=?");
                ps.setInt(1, Integer.parseInt((table.getValueAt(i, NORMAL).toString())));
                int count = ps.executeUpdate();
                if (count > 0) {

                    this.dispose();
                    Frame13 f134 = new Frame13();
                } else {
                    JOptionPane.showMessageDialog(null, "Error Occured");
                }

            } catch (Exception eb) {
            }
        }
    }

    public void connectionF() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from service");
            ResultSet rs = ps.executeQuery();
            this.m1 = (DefaultTableModel) table.getModel();

            while (rs.next()) {
                String room = rs.getString(1);
                String roll = rs.getString(2);
                boolean isdone = false;

                Object[] ob = {room, roll, isdone};
                m1.addRow(ob);

            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }
        }
    }

}
