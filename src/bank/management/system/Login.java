
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    
//    The JButton is locally define so, we have to define globally
    JButton login, signUp, clear;
    
//    
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
//        Putting the image in the login page.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
//        Scaling the image
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//        Image is cannot push into the JLabel so, we have to convert it into ImageIcon.
        ImageIcon i3 = new ImageIcon(i2);
        
        
//        we have to place the image in the frame. Therefore we have to make the object and then place the image into the frame.
//         JLabel is used to display an object.
        JLabel label = new JLabel(i3 );
        add(label);
        label.setBounds(180,10,100,100);
        
//        For set the background color
        getContentPane().setBackground(Color.white);
        
//      Insert Text. //Welcome to ATM
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Roboto Mono",Font.BOLD,38));
        text.setBounds(300,40,400,40);
        add(text);
        
//        Insert Card no.
        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Roboto Mono",Font.BOLD,28));
        card.setBounds(120,180,150,30);
        add(card);
        
//        Input
        cardTextField = new JTextField();
        cardTextField.setBounds(300,180,250,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,18));
        add(cardTextField);
        
//        Insert pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Roboto Mono",Font.BOLD,30));
        pin.setBounds(120,250,150,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,250,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,18));
        add(pinTextField);
        
//        button
        login = new JButton("SIGN IN");
        login.setBounds(300, 320, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450, 320, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,365,250,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    
    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == clear) {
        cardTextField.setText("");
        pinTextField.setText("");
    } else if (ae.getSource() == login) {
        Conn conn = new Conn();
        String cardNumber = cardTextField.getText();
        String pinNumber = pinTextField.getText();
        String query = "SELECT * FROM login WHERE card_Number = '"+cardNumber+"' and pin_Number = '"+pinNumber+"'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect card number or pin.");
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == signUp) {
        setVisible(false);
        new SignupOne().setVisible(true);
    }
}

    public static void main(String[] args) {
        new Login();
    }
    
}
