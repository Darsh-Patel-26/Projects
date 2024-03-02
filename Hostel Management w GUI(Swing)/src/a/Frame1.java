package a;
import javax.swing.*;
import java.awt.*;

class Frame1 extends JFrame {

    public void welcome(){
        JWindow w = new JWindow();

        JLabel l2 = new JLabel("WELCOME");
        JLabel l3 = new JLabel("TO");
        JLabel l4 = new JLabel("HOMES");
        l2.setBounds(120,100,250,50);
        l3.setBounds(120,150,250,50);
        l4.setBounds(120,200,250,50);
        l2.setFont(new Font("MV Boli",Font.BOLD,26));
        l3.setFont(new Font("MV Boli",Font.BOLD,26));
        l4.setFont(new Font("MV Boli",Font.BOLD,26));
        l2.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);

        ImageIcon i1 = new ImageIcon("E:\\Submit\\Project\\src\\a\\brand.jpg");
        Image image = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(image);
        JLabel l = new JLabel(i3);
        l.setBounds(0,0,400,380);

        w.setLayout(null);
        w.setSize(400,400);
        w.setLocationRelativeTo(null);

        JProgressBar j = new JProgressBar() ;
        j.setStringPainted(true);
        j.setForeground(Color.DARK_GRAY);
        j.setBounds(0,380,400,20);

        w.setVisible(true);
        w.add(j);
        w.add(l2);
        w.add(l3);
        w.add(l4);
        w.add(l);

        for(int i=0;i<=100;i++){
            try{
                j.setValue(i);
                Thread.sleep(60);
            }
            catch(Exception e){
                l2.setText("Exception");
                l3.setText("Occurred");
                l4.setText("While Loading");

            }
            if(i>30 && i<50){
                j.setString("Wait While Project Loads");
            }
            else if(i>50 && i<80){
                j.setString("Loading Project");
            }
            else if(i>80 && i<99 ){
                j.setString("Opening Project");
            }
            else if(i == 99){
                w.dispose();
            }
        }

    }
}