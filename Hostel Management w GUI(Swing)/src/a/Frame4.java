package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

class Frame4 extends JFrame implements ActionListener {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    private JRadioButton male, female, married, unmarried;
    private JTextField f1, f2, f3, f4, f6;
    private JTextArea area;
    private JComboBox c1, c2;
    private Container c;
    private JButton b;
    private final Font font = new Font("Consolas", Font.BOLD, 20);
    private JPasswordField pass;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    ImageIcon i = new ImageIcon("E:\\Submit\\Project\\src\\a\\bg1.jpg");

    Frame4() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1028, 678);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Worker Joining Form");
        setIconImage(logo.getImage());
        Image bg = i.getImage().getScaledInstance(1028, 678, Image.SCALE_DEFAULT);
        ImageIcon bgd = new ImageIcon(bg);
        l10 = new JLabel("New Worker Joining Form");
        l1 = new JLabel("Name");
        l2 = new JLabel("Date Of Birth");
        l3 = new JLabel("Phone Number");
        l4 = new JLabel("Email Address");
        l5 = new JLabel("Gender");
        l6 = new JLabel("Marital Status");
        l7 = new JLabel("Address ");
        l8 = new JLabel("Cast");
        l9 = new JLabel("Last Job Place");
        l12 = new JLabel("Work Field ");
        l13 = new JLabel("Password");
        l11 = new JLabel(bgd);

        l11.setBounds(0, 0, 1028, 678);
        l10.setBounds(320, 30, 600, 50);
        l10.setFont(new Font("Consolas", Font.BOLD, 28));

        l1.setBounds(50, 170, 200, 30);
        l2.setBounds(50, 240, 200, 30);
        l3.setBounds(50, 310, 200, 30);
        l4.setBounds(50, 380, 200, 30);
        l5.setBounds(550, 170, 200, 30);
        l6.setBounds(550, 240, 200, 30);
        l7.setBounds(550, 310, 200, 30);
        l8.setBounds(50, 450, 200, 30);
        l9.setBounds(50, 520, 200, 30);
        l12.setBounds(550, 450, 200, 30);
        l13.setBounds(550, 520, 200, 30);

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        l8.setFont(font);
        l9.setFont(font);
        l12.setFont(font);
        l13.setFont(font);

        l1.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);
        l5.setForeground(Color.BLACK);
        l6.setForeground(Color.BLACK);
        l7.setForeground(Color.BLACK);
        l8.setForeground(Color.BLACK);
        l9.setForeground(Color.BLACK);
        l12.setForeground(Color.BLACK);
        l13.setForeground(Color.BLACK);

        pass = new JPasswordField();

        f1 = new JTextField();
        f2 = new JTextField("DD/MM/YYYY");
        f3 = new JTextField();
        f4 = new JTextField("      @gmail.com");

        f6 = new JTextField();

        f6.setBounds(250, 520, 200, 30);
        f1.setBounds(250, 170, 200, 30);
        f2.setBounds(250, 240, 200, 30);
        f3.setBounds(250, 310, 200, 30);
        f4.setBounds(250, 380, 200, 30);
        pass.setBounds(700, 520, 200, 30);

        f1.setFont(font);
        f2.setFont(font);
        f3.setFont(font);
        f4.setFont(font);

        f6.setFont(font);

        area = new JTextArea();
        area.setLineWrap(true);
        area.setBounds(700, 310, 250, 100);
        area.setBackground(Color.WHITE);
        area.setFont(font);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(750, 170, 100, 30);
        female.setBounds(850, 170, 100, 30);
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        married.setBounds(750, 240, 100, 30);
        unmarried.setBounds(850, 240, 100, 30);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(male);
        g1.add(female);
        ButtonGroup g2 = new ButtonGroup();
        g2.add(married);
        g2.add(unmarried);

        String[] s = {"Sweeper", "Garderner", "Cook", "Security", "Peon"};
        String[] cast = {"SEBC", "SC", "ST", "General"};
        c1 = new JComboBox(s);
        c1.setBounds(750, 450, 100, 30);
        c2 = new JComboBox(cast);
        c2.setBounds(250, 450, 200, 30);

        b = new JButton("Register");
        b.setFont(font);
        b.setBounds(400, 590, 200, 30);
        b.addActionListener(this);

        c = this.getContentPane();
        c.setLayout(null);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(l7);
        c.add(l8);
        c.add(l9);
        c.add(l12);
        c.add(l13);

        c.add(f1);
        c.add(f2);
        c.add(f3);
        c.add(f4);

        c.add(f6);
        c.add(l10);

        c.add(male);
        c.add(female);
        c.add(married);
        c.add(unmarried);

        c.add(c1);
        c.add(c2);

        c.add(b);
        c.add(pass);
        c.add(area);
        c.add(l11);//Images Are added at The LAst

        setVisible(true);
        validate();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b) {
            String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11;
            float f;
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Pda@3210");
                s1 = f1.getText();//name
                s2 = f2.getText();//Date
                s3 = f3.getText();//Phone
                s4 = f4.getText();//Email
                s5 = f6.getText();//last Place

                s6 = area.getText();//Add
                s7 = (String) c1.getSelectedItem();//Kam
                s8 = (String) c2.getSelectedItem();//Cast
                s9 = male.isSelected() ? "Male" : "Female";
                s10 = married.isSelected() ? "Married" : "Unmarried";
                s11 = pass.getText();
                PreparedStatement ps = con.prepareStatement("insert into worker value(?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, s1);
                ps.setString(2, s2);
                ps.setString(3, s3);
                ps.setString(4, s4);
                ps.setString(5, s9);
                ps.setString(6, s10);
                ps.setString(7, s6);
                ps.setString(8, s5);

                ps.setString(9, s7);
                ps.setString(10, s8);

                ps.setString(11, s11);
                ps.setInt(12, 10000 + (int) (Math.random() * 20000));
                int co = ps.executeUpdate();
                if (co > 0) {
                    if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("") || s8.equals("") || s9.equals("") || s10.equals("") || s11.equals("")) {
                        JOptionPane.showMessageDialog(this, "Some Fields Are Empty", "Try Again", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Registration Compleleted", "Yepee", JOptionPane.PLAIN_MESSAGE);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Registration In Compleleted", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e1) {

            } finally {
                try {
                    con.close();
                    f1.setText(null);
                    f2.setText(null);
                    f3.setText(null);
                    f4.setText(null);

                    f6.setText(null);
                    area.setText(null);
                    pass.setText(null);

                } catch (Exception e2) {

                }
            }
        }

    }

}
