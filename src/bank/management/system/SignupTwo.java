package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
    JTextField panTextField, aadharTextField;
    JRadioButton seniorRadio, seniorRadio1, exisitingRadio, exisitingRadio1;
    JButton next;
    String formno;
    
    public SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setLocation(300,10);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        
        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setBounds(290,80,400,30);
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        add(additionalDetail);
        
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christan","Other"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(400,140,300,20);
        religionComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
        
        JLabel category = new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,22));
        add(category);
        
        String valCategory[] = {"ST","SC","OBC","General","Other"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setBounds(400,190,300,20);
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        add(categoryComboBox);
        
        JLabel income = new JLabel("Income:");
        income.setBounds(100,240,150,30);
        income.setFont(new Font("Raleway",Font.BOLD,22));
        add(income);
        
        String incomeCategory[] = {"Null","< 1,50,000","2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeCategory);
        incomeComboBox.setBounds(400,240,300,20);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        add(incomeComboBox);
        
        JLabel education = new JLabel("Education");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,22));
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100,315,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        add(qualification);
        
        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        educationComboBox = new JComboBox(educationValues);
        educationComboBox.setBounds(400,315,300,20);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100,380,200,30);
        occupation.setFont(new Font("Raleway", Font.BOLD,22));
        add(occupation);
        
        String occupationValues[] = {"","Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationComboBox = new JComboBox(occupationValues);
        occupationComboBox.setBounds(400,380,300,20);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);
        
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setBounds(100,430,200,30);
        panNumber.setFont(new Font("Raleway",Font.BOLD,22));
        add(panNumber);
        
        panTextField = new JTextField();
        panTextField.setBounds(400,430,300,20);
        panTextField.setBackground(Color.WHITE);
        add(panTextField);
        
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setBounds(100,480,300,30);
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,22));
        add(aadharNumber);
        
        aadharTextField = new JTextField();
        aadharTextField.setBounds(400,480,300,20);
        aadharTextField.setBackground(Color.WHITE);
        add(aadharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setBounds(100,530,300,30);
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
        add(seniorCitizen);
        
        seniorRadio = new JRadioButton("No");
        seniorRadio.setBounds(400,530,100,20);
        seniorRadio.setBackground(Color.WHITE);
        add(seniorRadio);
        
        seniorRadio1 = new JRadioButton("Yes");
        seniorRadio1.setBounds(500,530,100,20);
        seniorRadio1.setBackground(Color.WHITE);
        add(seniorRadio1);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorRadio);
        seniorGroup.add(seniorRadio1);
        
        JLabel exisitingAccount = new JLabel("Exisiting Account:");
        exisitingAccount.setBounds(100,580,300,30);
        exisitingAccount.setFont(new Font("Raleway",Font.BOLD,22));
        add(exisitingAccount);
        
        exisitingRadio = new JRadioButton("No");
        exisitingRadio.setBounds(400,580,100,20);
        exisitingRadio.setBackground(Color.WHITE);
        add(exisitingRadio);
        
        exisitingRadio1 = new JRadioButton("Yes");
        exisitingRadio1.setBounds(500,580,200,20);
        exisitingRadio1.setBackground(Color.WHITE);
        add(exisitingRadio1);
        
        ButtonGroup exisitingGroup = new ButtonGroup();
        exisitingGroup.add(exisitingRadio);
        exisitingGroup.add(exisitingRadio1);
        
        next = new JButton("Next");
        next.setBounds(620,660,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = this.formno;
      String religion = (String) religionComboBox.getSelectedItem();
      String category = (String) categoryComboBox.getSelectedItem();
      String income = (String) incomeComboBox.getSelectedItem();
      String education = (String) educationComboBox.getSelectedItem();
      String occupation = (String) occupationComboBox.getSelectedItem();
      String panNumber = panTextField.getText();
      String aadharNumber = aadharTextField.getText();
      
      String seniorCitizen = null;
      if(seniorRadio.isSelected()){
          seniorCitizen = "No";
      }else if(seniorRadio1.isSelected()){
          seniorCitizen = "Yes";
      }else{
          JOptionPane.showMessageDialog(null,"SeniorCitizen Required.");
      }
      
      String exisitingAccount = null;
      if(exisitingRadio.isSelected()){
          exisitingAccount = "No";
      }else if(exisitingRadio1.isSelected()){
          exisitingAccount = "Yes";
      }else{
          JOptionPane.showMessageDialog(null, "Exisiting Account Required.");
      }
              

                try {
    if (panNumber.equals("")) {
        JOptionPane.showMessageDialog(null, "PAN required");
    } else if (aadharNumber.equals("")) {
        JOptionPane.showMessageDialog(null, "Aadharcard number Required");
    } else {
        Conn c = new Conn();
        String query = "insert into SignupTwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + panNumber + "','" + aadharNumber + "','" + seniorCitizen + "','" + exisitingAccount + "')";
        c.s.executeUpdate(query);
        
//        SignupThree
        setVisible(false);
        new SignupThree(formno).setVisible(true);
    }
} catch (Exception e) {
    System.out.println(e);
}
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
