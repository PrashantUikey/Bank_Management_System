
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanaceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinNumber;
    
    public BalanaceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        
        JLabel text = new JLabel("Your current Account Balance is Rs "+ balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        image.add(text);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(true);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanaceEnquiry("");
    }
    
}
