
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JButton back, change;
    JPasswordField pin, repin;
    String pinNumber;
    public PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(165,320,180,25);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setForeground(Color.WHITE);
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(pin);
        
        JLabel repinText = new JLabel("Re-Enter New PIN:");
        repinText.setBounds(165,360,180,25);
        repinText.setFont(new Font("Raleway",Font.BOLD,16));
        repinText.setForeground(Color.WHITE);
        image.add(repinText);
        
        repin = new JPasswordField();
        repin.setBounds(330,360,180,25);
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        try{
            String cPin = pin.getText();
            String cRepin = repin.getText();
            
            if(!cPin.equals(cRepin)){
                JOptionPane.showMessageDialog(null, "Enterd PIN does not match");
                return;
            }
            
            if(cPin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter new PIN");
               return;
            }
            
            if(cRepin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
            }
            
            Conn c = new Conn();
            String query1 = "update bank set pin = '"+cRepin+"' where pin = '"+pinNumber+"'";
            String query2 = "update signupthree set pin_Number = '"+cRepin+"' where pin_Number = '"+pinNumber+"'";
            String query3 = "update login set pin_Number = '"+cRepin+"' where pin_Number ='"+pinNumber+"'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            setVisible(false);
            new Transactions(cRepin).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
   public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
