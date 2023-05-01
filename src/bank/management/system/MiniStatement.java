package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.sql.*;
import java.awt.event.*;


public class MiniStatement extends JFrame implements ActionListener{

    JButton ok;
    String pinNumber;
    
    public MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(400,700);
        getContentPane().setBackground(Color.WHITE);
        setLocation(600,100);
        setVisible(true);
        setTitle("Mini Statement");
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("System",Font.BOLD,15));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(100,60,200,15);
//        card.setFont(new Font("Raleway",Font.BOLD,15));
        add(card);
        
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,280);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,500,300,20);
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_Number = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("card_Number").substring(0,4)+"XXXXXXXX" + rs.getString("card_Number").substring(12));
                
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        
        try{
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                    if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance Rs. "+ bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        ok = new JButton("Ok");
        ok.setBounds(300,600,60,25);
        ok.setBackground(Color.WHITE);
        ok.addActionListener(this);
        add(ok);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ok){
//            System.exit(0);
            setVisible(false);
//            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
