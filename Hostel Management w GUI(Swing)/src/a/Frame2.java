package a;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

class Frame2 extends JFrame {

    private JLabel l, l2;
    private ImageIcon i1;
    private final ImageIcon logo = new ImageIcon("E:\\Submit\\Project\\src\\a\\logo.jpg");

    private final String s4 = "<html><body><p>- This Project Coded By Group JRE(Java Runtime Engineers) of BECSE-II from MSU.</p><p>-Given Image is LOGO of the Project.</p><br>-> It is Made in Java Swing.<p>So far we have used as many components in java to make it.</p><br><p>-> Memebers of Group</p><br><p>1.Sujal Patel</p><p>2.Dhaval Rathod</p><p>3.Darsh Patel</p><p>4.Jaimin Chaudhari</p><p>5.Rasania Mihir</p><br><p>* Mentor Of Group</p><p><h2>Dr.Mamata Padole</h2></p></body></html>";
    private Font f = new Font("Consolas", Font.PLAIN, 18);

    Frame2() {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setIconImage(logo.getImage());
        setTitle("ABOUT");
        Image ii4 = logo.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(ii4);
        l = new JLabel(i1);
        l2 = new JLabel(s4);
        l2.setBounds(30, 0, 500, 450);
        l2.setFont(f);
        l2.setForeground(Color.WHITE);
        l.setBounds(350, 230, 200, 200);

        add(l);
        add(l2);
        setVisible(true);
        validate();
    }
}
