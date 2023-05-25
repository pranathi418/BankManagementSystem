package com.bank;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class SignUp2 extends JFrame implements ActionListener {
	
	JRadioButton savingacc,fixedacc,curracc,reccacc;
	JCheckBox Atm,internetbanking,mobilebanking,emailsms,cheque,estat,policy;
	JButton submit,cancel;
	String formno;
	public SignUp2(String formno)
	{
		this.formno=formno;
		setSize(850,800);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel accountdetails =new JLabel("Page 3 : Account Details");
		accountdetails.setFont(new Font("Raleway",Font.BOLD,25));
		accountdetails.setBounds(260,80,400,30);
		add(accountdetails);
		
		JLabel acctype =new JLabel("Accpunt Type");
		acctype.setFont(new Font("Raleway",Font.BOLD,20));
		acctype.setBounds(100,150,200,30);
		add(acctype);
		
		savingacc=new JRadioButton("Saving Account");
		savingacc.setBounds(120,200,200,30);
		savingacc.setFont(new Font("Raleway",Font.BOLD,13));
		savingacc.setBackground(Color.white);
		add(savingacc);
		
		fixedacc=new JRadioButton("Fixed Deposit Account");
		fixedacc.setBounds(340,200,400,30);
		fixedacc.setFont(new Font("Raleway",Font.BOLD,13));
		fixedacc.setBackground(Color.white);
		add(fixedacc);
		
		curracc=new JRadioButton("Current Account");
		curracc.setBounds(120,250,200,30);
		curracc.setFont(new Font("Raleway",Font.BOLD,13));
		curracc.setBackground(Color.white);
		add(curracc);
		
		reccacc=new JRadioButton("Recurring Deposit Account");
		reccacc.setBounds(340,250,400,30);
		reccacc.setFont(new Font("Raleway",Font.BOLD,13));
		reccacc.setBackground(Color.white);
		add(reccacc);
		
		ButtonGroup acctypegroup=new ButtonGroup();
		acctypegroup.add(savingacc);
		acctypegroup.add(fixedacc);
		acctypegroup.add(curracc);
		acctypegroup.add(reccacc);
		
		JLabel CardNumber =new JLabel("Card Number");
		CardNumber.setFont(new Font("Raleway",Font.BOLD,23));
		CardNumber.setBounds(100,320,400,30);
		add(CardNumber);
		
		JLabel cardtext =new JLabel("Your 16 Digit Card Number");
		cardtext.setFont(new Font("Raleway",Font.BOLD,13));
		cardtext.setBounds(100,345,400,30);
		add(cardtext);
		
		JLabel cnumber =new JLabel("XXXX-XXXX-XXXX-1828");
		cnumber.setFont(new Font("Raleway",Font.BOLD,23));
		cnumber.setBounds(300,330,400,30);
		add(cnumber);
		
		JLabel PinNumber =new JLabel("PIN");
		PinNumber.setFont(new Font("Raleway",Font.BOLD,23));
		PinNumber.setBounds(100,400,100,30);
		add(PinNumber);
		
		JLabel Pintext =new JLabel("Your 4 Digit Password");
		Pintext.setFont(new Font("Raleway",Font.BOLD,13));
		Pintext.setBounds(100,425,300,30);
		add(Pintext);
		
		JLabel pnumber =new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,23));
		pnumber.setBounds(300,412,100,30);
		add(pnumber);
		
		JLabel services =new JLabel("Services Required :");
		services.setFont(new Font("Raleway",Font.BOLD,23));
		services.setBounds(100,470,300,30);
		add(services);
		
		Atm=new JCheckBox("ATM CARD");
		Atm.setBounds(100,500,200,30);
		Atm.setFont(new Font("Raleway",Font.BOLD,13));
		Atm.setBackground(Color.white);
		add(Atm);
		
		mobilebanking=new JCheckBox("Mobile Banking");
		mobilebanking.setBounds(100,540,200,30);
		mobilebanking.setFont(new Font("Raleway",Font.BOLD,13));
		mobilebanking.setBackground(Color.white);
		add(mobilebanking);
		
		
		internetbanking=new JCheckBox("Internet Banking");
		internetbanking.setBounds(100,580,200,30);
		internetbanking.setFont(new Font("Raleway",Font.BOLD,13));
		internetbanking.setBackground(Color.white);
		add(internetbanking);
		
		cheque=new JCheckBox("Cheque Book");
		cheque.setBounds(300,500,400,30);
		cheque.setFont(new Font("Raleway",Font.BOLD,13));
		cheque.setBackground(Color.white);
		add(cheque);
		
		emailsms=new JCheckBox("EMAIL & SMS Alerts");
		emailsms.setBounds(300,540,400,30);
		emailsms.setFont(new Font("Raleway",Font.BOLD,13));
		emailsms.setBackground(Color.white);
		add(emailsms);
		
		estat=new JCheckBox("E-Statement");
		estat.setBounds(300,580,400,30);
		estat.setFont(new Font("Raleway",Font.BOLD,13));
		estat.setBackground(Color.white);
		add(estat);
		
		policy=new JCheckBox("I Hereby declared that the above details are correct to the best of my knowledge");
		policy.setBounds(100,650,550,30);
		policy.setFont(new Font("Raleway",Font.BOLD,13));
		policy.setBackground(Color.white);
		add(policy);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setBounds(250,700,100,30);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setBounds(400,700,100,30);
		cancel.addActionListener(this);
		cancel.setForeground(Color.white);
		add(cancel);
		
		setLayout(null);
		setVisible(true);
		setLocation(350,10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp2("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit)
		{
			String accounttype=null;
			if(savingacc.isSelected())
			{
				accounttype="Saving Account";
			}
			else if(fixedacc.isSelected())
			{
				accounttype="Fixed Deopisit Account";
			}
			else if(curracc.isSelected())
			{
				accounttype="Current Account";
			}
			else if(reccacc.isSelected())
			{
				accounttype="Recurring Deposit Account";
			}
			Random random=new Random();
			String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pin=""+Math.abs((random.nextLong()%9000L)+1000L);
			String services=" ";
			if(Atm.isSelected())
			{
				services=services+"ATM Card";
			}
			if(mobilebanking.isSelected())
			{
				services=services+" , Mobile Banking";
			}
			if(internetbanking.isSelected())
			{
				services=services+" , Internet Banking";
			}
			if(cheque.isSelected())
			{
				services=services+" , Cheque Book";
			}
			if(estat.isSelected())
			{
				services=services+" , E-Statement";
			}
			if(emailsms.isSelected())
			{
				services=services+" , Email & SMS Alerts";
			}
			try
			{
				if(accounttype.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Account Type Is Required");
				}
				if(!policy.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Please Accept The Policy");
				}
				else
				{
					Conn conn=new Conn();
					String query1="insert into signup2 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pin+"','"+services+"')";
					String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\n Pin : "+pin);
					setVisible(false);
					new Deposit(pin).setVisible(true);
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else if(e.getSource()==cancel)
		{
			setVisible(false);
			new LoginForm().setVisible(true);
		}
		
	}
}

