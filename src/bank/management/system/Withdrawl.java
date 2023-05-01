
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{

    JButton withdrawl, back;
    JTextField withdrawlAmount;
    String pinNumber;
    
    public Withdrawl(String pinNumber){
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
        
        JLabel text = new JLabel("Enter the amount you want to withdrwal");
        text.setBounds(180,300,400,20);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        withdrawlAmount = new JTextField();
        withdrawlAmount.setBounds(170,350,320,35);
        withdrawlAmount.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(withdrawlAmount);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(370,490,130,25);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,15));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(370,520,130,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            String wAmount = withdrawlAmount.getText();
            Date date = new Date();
            
            if(withdrawlAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the amount you want to withdrawl.");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+wAmount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + wAmount + " Withdrawl Successfull");
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
        new Withdrawl("");
    }
    
}
