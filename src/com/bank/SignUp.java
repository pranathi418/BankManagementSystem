package com.bank;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.Color;

import java.awt.Font;
import java.util.*;
import javax.swing.*;
public class SignUp extends JFrame implements ActionListener{
	
	long random;
	JTextField namefield,Fatherfield,Emailfield,Addressfield,Cityfield,Pinfield,Statefield;
	JButton next;
	JRadioButton male,female,other,unmarried,married;
	JDateChooser dateChooser;
	SignUp()
	{
		setSize(850,800);
		
		setLocation(350,10);
		getContentPane().setBackground(Color.WHITE);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		setLayout(null);
		Random rd=new Random();
		random=Math.abs(rd.nextLong()%9000L+1000);
		
		JLabel text=new JLabel("Application Form : "+random);
		text.setFont(new Font("Raleway",Font.BOLD,30));
		text.setBounds(230,20,600,40);
		add(text);
		
		JLabel details=new JLabel("Page 1 : Personal Details");
		details.setFont(new Font("Raleway",Font.BOLD,25));
		details.setBounds(260,80,400,30);
		add(details);
		
		JLabel Name=new JLabel("Name :");
		Name.setFont(new Font("Raleway",Font.BOLD,20));
		Name.setBounds(100,150,100,30);
		add(Name);
		
		namefield=new JTextField();
		namefield.setFont(new Font("Raleway" ,Font.BOLD,15));
		namefield.setBounds(300,150,400,30);
		add(namefield);
		
		JLabel FatherName=new JLabel("Father's Name :");
		FatherName.setFont(new Font("Raleway",Font.BOLD,20));
		FatherName.setBounds(100,200,200,30);
		add(FatherName);
		
		Fatherfield=new JTextField();
		Fatherfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Fatherfield.setBounds(300,200,400,30);
		add(Fatherfield);
		
		JLabel DOB=new JLabel("Date Of Birth :");
		DOB.setFont(new Font("Raleway",Font.BOLD,20));
		DOB.setBounds(100,250,200,30);
		add(DOB);
		
		dateChooser=new JDateChooser();
		dateChooser.setBounds(300,250,400,30);
		dateChooser.setForeground(Color.black);
		add(dateChooser);
		
		JLabel Gender=new JLabel("Gender :");
		Gender.setFont(new Font("Raleway",Font.BOLD,20));
		Gender.setBounds(100,300,200,30);
		add(Gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,300,60,30);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(400,300,120,30);
		female.setBackground(Color.white);
		add(female);
		
		other=new JRadioButton("Other");
		other.setBounds(520,300,60,30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		JLabel Email=new JLabel("Email Address :");
		Email.setFont(new Font("Raleway",Font.BOLD,20));
		Email.setBounds(100,350,200,30);
		add(Email);
		
		Emailfield=new JTextField();
		Emailfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Emailfield.setBounds(300,350,400,30);
		add(Emailfield);
		
		JLabel MaritialStatus=new JLabel("Maritial Status :");
		MaritialStatus.setFont(new Font("Raleway",Font.BOLD,20));
		MaritialStatus.setBounds(100,400,200,30);
		add(MaritialStatus);
		
		married=new JRadioButton("Married");
		married.setBounds(300,400,100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(400,400,120,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup marriedgroup=new ButtonGroup();
		marriedgroup.add(married);
		marriedgroup.add(unmarried);
		
		JLabel Address=new JLabel("Address :");
		Address.setFont(new Font("Raleway",Font.BOLD,20));
		Address.setBounds(100,450,200,30);
		add(Address);
		
		Addressfield=new JTextField();
		Addressfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Addressfield.setBounds(300,450,400,30);
		add(Addressfield);
		
		JLabel City=new JLabel("City :");
		City.setFont(new Font("Raleway",Font.BOLD,20));
		City.setBounds(100,500,200,30);
		add(City);
		
		Cityfield=new JTextField();
		Cityfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Cityfield.setBounds(300,500,400,30);
		add(Cityfield);
		
		JLabel Pincode=new JLabel("Pincode :");
		Pincode.setFont(new Font("Raleway",Font.BOLD,20));
		Pincode.setBounds(100,550,200,30);
		add(Pincode);
		
		Pinfield=new JTextField();
		Pinfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Pinfield.setBounds(300,550,400,30);
		add(Pinfield);
		
		JLabel State=new JLabel("State :");
		State.setFont(new Font("Raleway",Font.BOLD,20));
		State.setBounds(100,600,200,30);
		add(State);
		
		Statefield=new JTextField();
		Statefield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Statefield.setBounds(300,600,400,30);
		add(Statefield);
		
		next=new JButton("Next");
		next.setBounds(650,670,100,30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String formno=""+random;
		String name=namefield.getText();
		String fname=Fatherfield.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="Female";
		}
		else
		{
			gender="other";
		}
		String mstatus=null;
		if(married.isSelected())
		{
			mstatus="Married";
		}
		else
		{
			mstatus="Unmarried";
		}
		String email=Emailfield.getText();
		String address=Addressfield.getText();
		String city=Cityfield.getText();
		String pin=Pinfield.getText();
		String state=Statefield.getText();
		
		try
		{
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else
			{
				Conn c=new Conn();
				String query="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mstatus+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignUp1(formno).setVisible(true);
			}
		}
		catch(Exception en)
		{
			System.out.println(en);
		}
	}

}
