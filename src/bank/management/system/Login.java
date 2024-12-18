package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField,pinTextField;
  
    
    Login()
    {
        setTitle("Bank");
        setLayout(null);
        
       
        
        JLabel text = new JLabel("WELCOME TO BANK");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField= new JTextField(15);
        cardTextField.setBounds(300,150,230,30);
        
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField = new JTextField(15);
        pinTextField.setBounds(300,220,230,30);
       
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login .setBounds(300,300,100,30);
        login .setBackground(Color.BLACK);
        login .setForeground(Color.WHITE);
        add( login );
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber= '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(true);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin!!");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
             new SignupOne().setVisible(true);
        }
    
    }
        
    public static void main(String args[])
    {  
        new Login().setVisible(true);
        
       
       
    }
}
 