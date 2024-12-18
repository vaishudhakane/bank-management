
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exist;
    String pinnumber;
    
    Transaction(String pinnumber)
    {
        this.pinnumber = pinnumber;
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,30);
        text.setFont(new Font("System",Font.BOLD,22));
        add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        add(withdrawal);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exist=new JButton("Exit");
        exist.setBounds(355,520,150,30);
        exist.addActionListener(this);
        add(exist);

        
        
        
        
        
        
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exist)
        {
            System.exit(0);
            
        }
        else if(ae.getSource()== deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        }
        else if(ae.getSource()== withdrawal)
        {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
            
            
            
        }
        else if(ae.getSource()== pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
              
        }
        else if (ae.getSource() == balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == ministatement)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Transaction("").setVisible(true);
    }
    
}
