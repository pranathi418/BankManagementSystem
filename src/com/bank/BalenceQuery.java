package com.bank;
import java.awt.Color;
import java.util.*;
import java.util.Date;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class BalenceQuery extends JFrame implements ActionListener {
	
	JPasswordField pintextfield,rpintextfield;
	JButton Submit,back;
	String pin_number;
	BalenceQuery(String pin_number)
	{
		
		this.pin_number=pin_number;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		back=new JButton("Back");
		back.setBounds(380,510,100,30);
		back.setBackground(Color.yellow);
		back.addActionListener(this);
		label.add(back);
		
		Conn c=new Conn();
		int balence=0;
		try
		{
			ResultSet rs=c.s.executeQuery("select *from bank where pin_number='"+pin_number+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balence+=Integer.parseInt(rs.getString("ammount"));
				}
				else
				{
					balence-=Integer.parseInt(rs.getString("ammount"));
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		JLabel Text=new JLabel("Your Current Account Balence is Rs "+balence);
		Text.setBounds(170,300,400,35);
		Text.setForeground(Color.white);
		Text.setFont(new Font("System",Font.BOLD,15));
		label.add(Text);
		
		setSize(900,900);
		setLocation(300,0);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back)
		{
			setVisible(false);
			new Transaction(pin_number).setVisible(true);
		}
			
		
	}
	public static void main(String[] args)
	{
		new BalenceQuery("");
	}
}