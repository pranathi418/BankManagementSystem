package com.bank;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class Deposit extends JFrame implements ActionListener {
	JTextField ammount;
	JButton back,deposit;
	String pinnumber;
	Deposit(String pin_number)
	{
		this.pinnumber=pin_number;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		JLabel Text=new JLabel("Please Enter The Amount To Be Deoposited :");
		Text.setBounds(170,300,700,35);
		Text.setForeground(Color.white);
		Text.setFont(new Font("System",Font.BOLD,15));
		label.add(Text);
		
//		deposit=new JButton("Deposit");
//		deposit.setBounds(170,350,150,30);
//		deposit.setBackground(Color.white);
//		deposit.addActionListener(this);
//		label.add(deposit);
		
		ammount=new JTextField();
		ammount.setFont(new Font("Raleway",Font.BOLD,15));
		ammount.setBounds(170,350,200,30);
		label.add(ammount);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(340,430,150,30);
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		label.add(deposit);
		
		back=new JButton("Back");
		back.setBounds(340,470,150,30);
		back.setBackground(Color.yellow);
		back.addActionListener(this);
		label.add(back);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==deposit)
		{
			String number =ammount.getText();
			Date date=new Date();
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the ammont");
			}
			else
			{
				try
				{
					Conn conn=new Conn();
					String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+"/- Deposited Successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
			
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}

}
