
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
public SignupThree(String formno){
    this.formno = formno;
    setLayout(null);
    setSize(850,800);
    setLocation(300,10);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE);
    
    
    JLabel heading = new JLabel("Page 3: Account Details");
    heading.setBounds(290,50,400,30);
    heading.setFont(new Font("Raleway",Font.BOLD,22));
    add(heading);
    
    JLabel type = new JLabel("Account Type:");
    type.setBounds(100,100,200,30);
    type.setFont(new Font("Raleway",Font.BOLD,22));
    add(type);
    
    r1 = new JRadioButton("Saving Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBounds(100,150,150,20);
    r1.setBackground(Color.WHITE);
    add(r1);
    
    r2 = new JRadioButton("Fixed Deposit Account");
    r2.setBounds(350,150,200,20);
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    add(r2);
    
    r3 = new JRadioButton("Current Account");
    r3.setBounds(100,180,150,20);
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.white);
    add(r3);
    
    r4 = new JRadioButton("Recurring Deposit Account");
    r4.setBounds(350,180,250,20);
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.white);
    add(r4);
    
    ButtonGroup typeButton = new ButtonGroup();
    typeButton.add(r1);
    typeButton.add(r2);
    typeButton.add(r3);
    typeButton.add(r4);
    
    JLabel card = new JLabel("Card Number:");
    card.setBounds(100,250,200,30);
    card.setFont(new Font("Raleway",Font.BOLD,22));
    add(card);
    
    JLabel number = new JLabel("XXXX-XXXX-XXXX-6547");
    number.setBounds(350,250,300,30);
    number.setFont(new Font("Raleway",Font.BOLD,22));
    add(number);
    
    JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
    cardDetail.setBounds(100,280,300,20);
    cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
    add(cardDetail);
    
    JLabel pin = new JLabel("PIN:");
    pin.setBounds(100,320,100,30);
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    add(pin);
    
    JLabel pinNumber = new JLabel("XXXX");
    pinNumber.setBounds(350,320,100,30);
    pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
    add(pinNumber);
    
    JLabel pinNumberDetail = new JLabel("Your 4 Digit PIN Number.");
    pinNumberDetail.setBounds(100,350,300,20);
    pinNumberDetail.setFont(new Font("Raleway",Font.BOLD,12));
    add(pinNumberDetail);
    
    JLabel services = new JLabel("Services Required:");
    services.setBounds(100,420,250,30);
    services.setFont(new Font("Raleway",Font.BOLD,22));
    add(services);
    
    
    c1 = new JCheckBox("ATM CARD");
    c1.setBounds(100,460,200,30);
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBackground(Color.WHITE);
    add(c1);
    
    c2 = new JCheckBox("Internet Banking");
    c2.setBounds(300,460,200,30);
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBackground(Color.WHITE);
    add(c2);
    
    c3 = new JCheckBox("Mobile Banking");
    c3.setBounds(100,500,200,30);
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBackground(Color.WHITE);
    add(c3);
    
    c4 = new JCheckBox("EMAIL and SMS Alert");
    c4.setBounds(300,500,200,30);
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBackground(Color.WHITE);
    add(c4);
    
    c5 = new JCheckBox("Cheque Book");
    c5.setBounds(100,540,200,30);
    c5.setFont(new Font("Raleway", Font.BOLD,16));
    c5.setBackground(Color.WHITE);
    add(c5);
    
    c6 = new JCheckBox("E-Statement");
    c6.setBounds(300,540,200,30);
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("Raleway",Font.BOLD,16));
    add(c6);
    
    c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
    c7.setBounds(100,630,600,20);
    c7.setFont(new Font("Raleway", Font.BOLD,12));
    c7.setBackground(Color.WHITE);
    add(c7);
    
    submit = new JButton("Submit");
    submit.setBounds(300,690,100,30);
    submit.setFont(new Font("Raleway",Font.BOLD,15));
    submit.setBackground(Color.black);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    add(submit);
    
    cancel= new JButton("Cancel");
    cancel.setBounds(480,690,100,30);
    cancel.setFont(new Font("Raleway",Font.BOLD,15));
    cancel.setBackground(Color.red);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
}    

@Override
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        String type = null;
        if(r1.isSelected()){
            type = "Saving Account";
        }else if(r2.isSelected()){
            type = "Fixed Deposite";
        }else if(r3.isSelected()){
            type = "Currenct Account";
        }else if(r4.isSelected()){
            type = "Recurring Deposite Account";
        }
        
//        Random cardNumber and Pin
        Random random = new Random();
        String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        String pinNumber = "" + Math.abs((random.nextLong() % 9000) + 1000L);
        String services = "";
        
        if(c1.isSelected()){
            services = services + "ATM CARD";
        }else if(c2.isSelected()){
            services = services + "Internet Banking";
        }else if(c3.isSelected()){
            services = services + "Mobile Banking";
        }else if(c4.isSelected()){
            services = services + "EMAIL and SMS Alert";
        }else if(c5.isSelected()){
            services = services + "Cheque Book";
        }else if(c6.isSelected()){
            services = services + "E-Statemenet";
        }
        
//        Excption Handling
        try{
            if(type.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type Is Required.");
            }else if(services.equals("")){
                JOptionPane.showMessageDialog(null, "Atleast Required One Services.");
            }else if(c7.equals("")){
                JOptionPane.showMessageDialog(null, "Tick The Declaration Box.");
            }else{
                Conn c = new Conn();
                String query = "INSERT INTO SignupThree VALUES('"+formno+"','"+type+"','"+cardNumber+"','"+pinNumber+"','"+services+"')";
                String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Your Card Number:" + cardNumber + "\n PIN:" + pinNumber);
                setVisible(false);
                new Deposit(pinNumber).setVisible(false);
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
    }else if(ae.getSource() == cancel){
        setVisible(false);
        new Login().setVisible(true);
    }
}

public static void main(String args[]){
        new SignupThree("");
}
}
