
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener
{
    long random;
    
    JRadioButton married,unmarried,syes,sno;
    JTextField addressTextField,cityTextField;
    JButton next;
    
    
    JComboBox religion,category,occupation,education,income;
    String formno;
            
    SignupTwo(String formno)
    {
        this.formno = formno;
        
        
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM--PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
      
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
    
         
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] ={"General","OBC","SC","ST","Other"};
        category =new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomeCategory[] ={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income =new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        
        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        
        
        
       
        
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[] ={"Non-Graduation","Graduation","Doctrate","Post-Graduation","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
       
        
        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[] ={"Salarized","Self-Employed","Businessmen","Student","Retired"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
      
        
        JLabel address= new JLabel("PAN number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city= new JLabel("Aadhar number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state= new JLabel("Senoir Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        married= new JRadioButton("YES");
        married.setBounds(300,540,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("NO");
        unmarried.setBounds(450,540,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
       
        JLabel pincode= new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        syes= new JRadioButton("YES");
        syes.setBounds(300,590,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450,590,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup existingaccount = new ButtonGroup();
        existingaccount.add(syes);
        existingaccount.add(sno);
        
        
        
        
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        add(next);

        
        
        
        
        
        
        
        
         
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String sreligion= (String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation =(String)education.getSelectedItem();
        String soccupation =(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(married.isSelected())
        {
            seniorcitizen="YES";
        }
        else if(unmarried.isSelected())
        {
            seniorcitizen="NO";
        }
        
        String existingaccount=null;
        
        if(syes.isSelected())
        {
            existingaccount="YES";
        }
        else if(sno.isSelected())
        {
            existingaccount="NO";
        }
        
        String saadhar=addressTextField.getText();
        String span=cityTextField.getText();
       
        
        try{
            
            
                Conn c=new Conn();
                //String query="insert into signup values ("+formno+","+name+","+fname+","+dob+","+gender+","+email+","+marital+","+city+","+pin+","+state+")";
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
    }
    
    public static void main(String args[])
    {
        new SignupTwo("").setVisible(true);
    }
}