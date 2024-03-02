package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Frame extends JFrame implements ActionListener {

    private JPanel p1, p2, p3;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");
    private ImageIcon i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11;
    private Container c;
    private JLabel l1, l2, l3;
    private JLabel img1, img2, img3, img4;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    private final Font font = new Font("Consolas", Font.BOLD, 18);

    Frame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1028, 600);
        setTitle("HOMES : Hostel Organizing Management And Expenses System");
        setLocationRelativeTo(null);
        setIconImage(logo.getImage());
        setResizable(false);
        i1 = new ImageIcon("E:\\Submit\\Project\\src\\a\\hostel.jpg");
        Image ii1 = i1.getImage().getScaledInstance(614, 600, Image.SCALE_DEFAULT);
        i2 = new ImageIcon(ii1);
        i3 = new ImageIcon("E:\\Submit\\Project\\src\\a\\bg2.jpg");
        Image ii2 = i3.getImage().getScaledInstance(614, 500, Image.SCALE_DEFAULT);
        i4 = new ImageIcon(ii2);

        i8 = new ImageIcon("E:\\Submit\\Project\\src\\a\\stulogin.jpg");
        i9 = new ImageIcon("E:\\Submit\\Project\\src\\a\\workerlogin.jpg");
        Image ii5 = i8.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
        Image ii6 = i9.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
        i10 = new ImageIcon(ii5);
        i11 = new ImageIcon(ii6);
        l1 = new JLabel("Student's Sign Up");
        l2 = new JLabel("Administration Login");
        l3 = new JLabel("Worker's Sign Up");
        l1.setBounds(100, 30, 200, 50);
        l3.setBounds(100, 250, 200, 30);
        l1.setFont(font);
        l3.setFont(font);

        img1 = new JLabel(i2);

        img2 = new JLabel(i4);

        img1.setBounds(0, 0, 614, 600);
        img2.setBounds(0, 0, 614, 550);

        b1 = new JButton("Cantine Menu ");
        b2 = new JButton(i10);
        b3 = new JButton(i11);
        b4 = new JButton("About");
        b5 = new JButton("Student Login");
        b6 = new JButton("Worker Login");
        b7 = new JButton("Admin Login");
        b8 = new JButton("Complain");

        b1.setBounds(70, 500, 200, 40);
        b4.setBounds(320, 500, 200, 40);
        b2.setBounds(100, 80, 200, 150);
        b3.setBounds(100, 290, 200, 150);
        b5.setBounds(100, 10, 200, 40);
        b6.setBounds(100, 60, 200, 40);
        b7.setBounds(70, 440, 200, 40);
        b8.setBounds(320, 440, 200, 40);

        b1.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        b7.setFont(font);
        b8.setFont(font);

        b5.setBackground(Color.BLACK);
        b6.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);
        b1.setBackground(Color.LIGHT_GRAY);
        b4.setBackground(Color.LIGHT_GRAY);
        b7.setBackground(Color.LIGHT_GRAY);
        b8.setBackground(Color.LIGHT_GRAY);

        b4.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);

        p1.setBounds(0, 0, 614, 600);
        p2.setBounds(614, 0, 614, 100);
        p3.setBounds(614, 80, 614, 500);
        p2.setBackground(Color.LIGHT_GRAY);

        p1.add(b1);
        p1.add(b4);
        p1.add(b7);
        p1.add(b8);
        p1.add(img1);

        p2.add(b5);
        p2.add(b6);

        p3.add(b2);
        p3.add(b3);
        p3.add(l1);
        p3.add(l3);
        p3.add(img2);

        c = this.getContentPane();
        c.setLayout(null);
        c.add(p1);
        c.add(p2);
        c.add(p3);
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b4) {
            Frame2 f2 = new Frame2();

        }
        if (e.getSource() == b2) {
            Frame3 f3 = new Frame3();
        }
        if (e.getSource() == b3) {
            Frame4 f4 = new Frame4();
        }
        if (e.getSource() == b1) {
            Frame12 f12 = new Frame12();
        }
        if (e.getSource() == b5) {
            Frame5 f5 = new Frame5();
        }
        if (e.getSource() == b6) {
            Frame6 f6 = new Frame6();
        }
        if (e.getSource() == b7) {
            Frame11 f11 = new Frame11();
        }
        if (e.getSource() == b8) {
            Frame9 f9 = new Frame9();
        }

    }
}

class Driver {

    public static void main(String[] args) {

        Frame1 open = new Frame1();
        open.welcome();
        Frame f = new Frame();
    }
}
