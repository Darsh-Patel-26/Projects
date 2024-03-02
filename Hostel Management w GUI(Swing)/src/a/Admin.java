package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Admin extends JFrame implements ActionListener,ItemListener {

    private JButton b1, b2, b3, b4, b5, b6;
    private JLabel l1, l2, l3;
    private Container c;
    private JComboBox c1;
    private JTextField f1;
    private JPasswordField pass;
    private final String[] s = { "Password","Username"};
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private final ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\admin.jpg");

    public Admin() {
        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1028, 678);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Administrator Page");
        setIconImage(logo.getImage());
        Image bg = i.getImage().getScaledInstance(1028, 678, Image.SCALE_DEFAULT);
        ImageIcon bgd = new ImageIcon(bg);

        c1 = new JComboBox(s);
        f1 = new JTextField();
        l2 = new JLabel(bgd);
        l1 = new JLabel("H.O.M.E.S Administrator Page");
        l3 = new JLabel("Reset :");
        b1 = new JButton("Student Administration");
        b2 = new JButton("Worker Administration");
        b3 = new JButton("Expense Management");
        b4 = new JButton("Room Management");
        b5 = new JButton("Save");
        b6 = new JButton("Entry  -  Exit");
        pass = new JPasswordField();

        c1.setBounds(100, 520, 200, 30);
        f1.setBounds(100, 560, 200, 30);
        pass.setBounds(100, 560, 200, 30);
        l2.setBounds(0, 0, 1028, 678);
        l1.setBounds(260, 60, 600, 50);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Consolas", Font.BOLD, 32));
        l3.setBounds(20, 520, 200, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Consolas", Font.BOLD, 16));
        b1.setBounds(200, 200, 220, 50);
        b2.setBounds(200, 390, 220, 50);
        b3.setBounds(590, 200, 220, 50);
        b4.setBounds(590, 390, 220, 50);
        b5.setBounds(100, 600, 200, 30);
        b6.setBounds(420, 300, 200, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        c1.addItemListener(this);

        c = this.getContentPane();
        c.setLayout(null);

        c.add(l1);
        c.add(c1);
        c.add(pass);
        c.add(f1);
        c.add(l3);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        c.add(l2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            SAdmin s = new SAdmin();
        }
        if (e.getSource() == b2) {
            WAdmin w = new WAdmin();
        }
        if (e.getSource() == b3) {
            EAdmin e1 = new EAdmin();
        }
        if (e.getSource() == b4) {
            RAdmin r = new RAdmin();
        }
        if(e.getSource()==b6){
            XAdmin reg = new XAdmin();
        }
        if (e.getSource() == b5) {
            String s1 = (String) c1.getSelectedItem();
            Connection con = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                if (s1 == "Username") {
                    ps = con.prepareStatement("update admin set username=?");
                    ps.setString(1, f1.getText());
                } else if (s1 == "Password") {
                    ps = con.prepareStatement("update admin set password=?");
                    ps.setString(1, pass.getText());
                }
                int c = ps.executeUpdate();

                if (c > 0) {
                    JOptionPane.showMessageDialog(this, s1 + " Updated Succesfully", "Updation", JOptionPane.PLAIN_MESSAGE);
                    f1.setText(null);
                    pass.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, s1 + " Updated Failed", "Updation", JOptionPane.PLAIN_MESSAGE);
                    f1.setText(null);
                    pass.setText(null);
                }
            } catch (Exception e4) {
            } finally {
                try {
                    con.close();
                } catch (Exception e5) {
                }
            }
        }
    }
    
    public void itemStateChanged(ItemEvent e) {

            if(e.getSource() == c1){
                if(c1.getSelectedIndex() == 1){
                    pass.setVisible(false);
                    f1.setVisible(true);

                }
                else{
                    f1.setVisible(false);
                    pass.setVisible(true);
                    }
            }

    }
}
