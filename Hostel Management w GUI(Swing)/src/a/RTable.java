package a;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

class RTable extends JFrame {

    private Container c;
    private JTable table;
    private DefaultTableModel m1;
    private JScrollPane js;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");

    public RTable(ResultSet r, String col) throws Exception {
        String[] tab = {col};
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Room Available");
        m1 = new DefaultTableModel(null, tab);

        table = new JTable(m1);

        js = new JScrollPane(table);
        js.setBounds(20, 10, 250, 390);

        setIconImage(logo.getImage());

        c = this.getContentPane();
        c.setLayout(null);

        c.add(js);

        this.m1 = (DefaultTableModel) table.getModel();

        while (r.next()) {
            String s = r.getString(1);
            String[] data = {s};
            m1.addRow(data);
        }
        setVisible(true);
        validate();
    }
}
