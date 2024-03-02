package a;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class XAdmin extends JFrame implements ActionListener {

    private JLabel l1, l2;
    private JRadioButton in, out;
    private JTextField f1, f2;
    private JButton b, see;

    private Container c;
    private Connection con = null;
    private final Font f = new Font("Consolas", Font.BOLD, 18);

    XAdmin() {
        setSize(500, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("ENTRY-EXIT REGISTER");

        l1 = new JLabel("Roll No");
        l2 = new JLabel("Room No");

        l1.setBounds(130, 70, 100, 40);
        l2.setBounds(130, 170, 100, 40);

        l1.setFont(f);
        l2.setFont(f);

        f1 = new JTextField();
        f2 = new JTextField();

        f1.setBounds(230, 70, 100, 30);
        f2.setBounds(230, 170, 100, 30);

        f1.setFont(f);
        f2.setFont(f);

        in = new JRadioButton("Entery");
        out = new JRadioButton("Exit");
        in.setFont(f);
        out.setFont(f);
        in.setBounds(140, 270, 100, 40);
        out.setBounds(240, 270, 100, 40);

        ButtonGroup g = new ButtonGroup();
        g.add(in);
        g.add(out);

        b = new JButton("Submit");
        b.setBounds(100, 400, 100, 50);
        b.setFont(f);
        b.addActionListener(this);

        see = new JButton("See List");
        see.setBounds(250, 400, 180, 50);
        see.setFont(f);
        see.addActionListener(this);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        c.add(l1);
        c.add(l2);

        c.add(in);
        c.add(out);
        c.add(f1);
        c.add(f2);
        c.add(b);
        c.add(see);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b) {
            PreparedStatement ps;
            int roll = Integer.parseInt(f1.getText());
            int room = Integer.parseInt(f2.getText());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");

                if (out.isSelected()) {
                    ps = con.prepareStatement("select * from register where roll=?");
                    ps.setInt(1, roll);
                    ResultSet rs = ps.executeQuery();
                    int c = 0;

                    try {
                        while (rs.next()) {
                            c++;
                        }
                    } catch (Exception ex) {
                    }
                    if (c == 0) {
                        ps = con.prepareStatement("insert into register values(?,?,?)");
                        ps.setInt(1, roll);
                        ps.setInt(2, room);
                        ps.setString(3, "Yes");
                    } else {
                        JOptionPane.showMessageDialog(this, "You are Alreafy out ", "Try Again", JOptionPane.PLAIN_MESSAGE);

                    }
                } else {
                    ps = con.prepareStatement("delete from register where roll=?");
                    ps.setInt(1, roll);
                }
                int count = ps.executeUpdate();
                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Updation Completed", "Updation", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "You Are Already Inside", "Error", JOptionPane.PLAIN_MESSAGE);

                }

            } catch (Exception e1) {
            } finally {
                f1.setText("");
                f2.setText("");
                out.setSelected(true);
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }
        }

        if (e.getSource() == see) {
            XTable s = new XTable();
        }
    }

}
