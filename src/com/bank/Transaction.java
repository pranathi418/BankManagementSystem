package com.bank;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Transaction extends JFrame implements ActionListener {
	
	
	JButton deposit,withdraw,fastcash,ministatement,pinchange,balence,exit;
	String pin_number;
	Transaction(String pin_number)
	{
		
		this.pin_number=pin_number;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		JLabel Text=new JLabel("Please Select Your Transaction");
		Text.setBounds(225,300,700,35);
		Text.setForeground(Color.white);
		Text.setFont(new Font("System",Font.BOLD,15));
		label.add(Text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170,350,150,30);
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdraw=new JButton("WithDraw");
		withdraw.setBounds(340,350,150,30);
		withdraw.setBackground(Color.white);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBounds(170,390,150,30);
		fastcash.setBackground(Color.white);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		ministatement=new JButton("Balence Enquiry");
		ministatement.setBounds(340,390,150,30);
		ministatement.setBackground(Color.white);
		ministatement.addActionListener(this);
		label.add(ministatement);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(170,430,150,30);
		pinchange.addActionListener(this);
		pinchange.setBackground(Color.white);
		label.add(pinchange);
		
		
		
		exit=new JButton("Exit");
		exit.setBounds(340,470,150,30);
		exit.addActionListener(this);
		exit.setBackground(Color.red);
		label.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transaction("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==deposit)
		{
			setVisible(false);
			new Deposit(pin_number).setVisible(true);
		}
		else if(e.getSource()==withdraw)
		{
			setVisible(false);
			new WithDrawl(pin_number).setVisible(true);
		}
		else if(e.getSource()==fastcash)
		{
			setVisible(false);
			new FastCash(pin_number).setVisible(true);
		}
		else if(e.getSource()==pinchange)
		{
			setVisible(false);
			new PinChange(pin_number).setVisible(true);
		}
		else if(e.getSource()==balence)
		{
			setVisible(false);
			new BalenceQuery(pin_number).setVisible(true);
		}
	}

}
