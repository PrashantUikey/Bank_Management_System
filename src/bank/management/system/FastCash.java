
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{

    JButton hundred, fiveHundred,oneThousand,twoThousand,fiveThousand,tenThousand,back;
    String pinNumber;
    
    public FastCash(String pinNumber){
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
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,600,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        hundred.setFont(new Font("Raleway",Font.BOLD,15));
//        deposit.setBackground(Color.WHITE);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355,415,150,30);
        fiveHundred.setFont(new Font("Raleway",Font.BOLD,15));
//        withdrawl.setBackground(Color.WHITE);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        oneThousand = new JButton("Rs 1000");
        oneThousand.setBounds(170,450,150,30);
        oneThousand.setFont(new Font("Raleway",Font.BOLD,15));
//        fastCash.setBackground(Color.WHITE);
        oneThousand.addActionListener(this);
        image.add(oneThousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355,450,150,30);
        twoThousand.setFont(new Font("Raleway",Font.BOLD,15));
//        miniStatement.setBackground(Color.WHITE);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.setFont(new Font("Raleway",Font.BOLD,15));
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.setFont(new Font("Raleway",Font.BOLD,14));
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);
                
       }
    
    @Override
    public void actionPerformed(ActionEvent ae){
//        String hundred100 = hundred.getText();
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){ // looping all the rows 
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    Date date = new Date();
                     String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"Rs. "+amount +" Debited Successfully");
                     
                     setVisible(false);
                     new Transactions(pinNumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
    
}
