package a;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


class ETable extends JFrame{

    private DefaultTableModel model;
    private JTable table;
    private String[] s = {"Maintanance","Electric Bill","Food Bill","Wroker Payment","Other Type","Other's Expenses","Total Expense","Date"};
    private JScrollPane sp;
    private Container c;
    private Connection con=null;
    ETable(){
        setTitle("Finanace Management");
        setSize(1028,678);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        model = new DefaultTableModel(null,s);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setBounds(50,50,900,550);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Pda@3210");
            PreparedStatement ps = con.prepareStatement("select * from expenses");
            ResultSet rs = ps.executeQuery();
            this.model = (DefaultTableModel)table.getModel();
            
            while(rs.next()){
                String s1,s2,s3,s4,s5,s6,s7,s8;
                s1 = rs.getString(1);
                s2 = rs.getString(2);
                s3 = rs.getString(3);
                
                s4 = rs.getString(4);
                s5 = rs.getString(5);
                s6 = rs.getString(6);
                
                s7 = rs.getString(7);
                s8 = rs.getString(8);
                
                
                
                String[] s = {s1,s2,s3,s4,s5,s6,s7,s8};
                this.model.addRow(s);
               
            }
        }catch(Exception e1){}
        finally{
            try{
               con.close(); 
            }
            catch(Exception e2){}
        }
        
        c.add(sp);
        c.setLayout(null);
        setVisible(true);
        validate();
    }
    
}

