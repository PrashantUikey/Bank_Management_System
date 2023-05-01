
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import java.sql.*;

public class Deposit extends JFrame implements ActionListener{

    JButton deposit, back;
    JTextField amount;
    String pinNumber;
    
    public Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0); 
        setUndecorated(true);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposite.");
        text.setForeground(Color.WHITE);
        text.setBounds(190,300,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(170,350,320,35);
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(370,490,130,25);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(370,520,130,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String depositAmount = amount.getText();
            Date date = new Date();
            
            if(depositAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank value('"+pinNumber+"','"+date+"','Deposit','"+depositAmount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+ depositAmount + " Deposited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Deposit("");
    }
    
}
