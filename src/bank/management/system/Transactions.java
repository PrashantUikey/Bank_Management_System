
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinNumber;
    
    public Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,300,600,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
//        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,15));
//        withdrawl.setBackground(Color.WHITE);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.setFont(new Font("Raleway",Font.BOLD,15));
//        fastCash.setBackground(Color.WHITE);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.setFont(new Font("Raleway",Font.BOLD,15));
//        miniStatement.setBackground(Color.WHITE);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.setFont(new Font("Raleway",Font.BOLD,15));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,14));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("Raleway",Font.BOLD,15));
        exit.addActionListener(this);
        image.add(exit);
                
       }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanaceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == miniStatement){
//            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
    
}
