
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;





public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBackground(Color.WHITE);
        amount.setForeground(Color.BLACK);
        amount.setBounds(170,350,320,25);
        add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,22));
        deposit.setBounds(355,485,150,25);
        deposit.addActionListener(this);
        add(deposit);
        
        
        back=new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,22));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit" );
                
            }
            else
            {
                try{
                    Conn conn =new Conn();
                 String query= "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null," Rs "+number+" Deposited Successfully!");
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
                 
                }
                
                catch(Exception e)
                {
                    System.out.println(e);
                    
                }
            }
            
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[])
    {
        new Deposit("").setVisible(true);
        
        
    }
    
}
