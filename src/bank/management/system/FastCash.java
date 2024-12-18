package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,30);
        text.setFont(new Font("System",Font.BOLD,22));
        add(text);
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        add(withdrawal);
        
        fastcash=new JButton("RS 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        add(exit);

        
        
        
        
        
        
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exit)
        {
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
           
            
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else 
                    {
                       balance -= Integer.parseInt(rs.getString("amount"));
                       
                            
                    }
                }
                if(ae.getSource()!= exit && balance <Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null," Insufficient Balance!!");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null," Rs "+amount+" Debited Successfully!");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
                
            }
        }
    }
    
    public static void main(String args[])
    {
        new FastCash("").setVisible(true);
    }
    
}
