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
public class FastCash extends JFrame implements ActionListener {
	
	
	JButton r1,r2,r3,r4,r5,r6,back;
	String pin_number;
	FastCash(String pin_number)
	{
		
		this.pin_number=pin_number;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		JLabel Text=new JLabel("Select WithDrawl Ammount :");
		Text.setBounds(225,300,700,35);
		Text.setForeground(Color.white);
		Text.setFont(new Font("System",Font.BOLD,15));
		label.add(Text);
		
		r1=new JButton("Rs 100");
		r1.setBounds(170,350,150,30);
		r1.setBackground(Color.white);
		r1.addActionListener(this);
		label.add(r1);
		
		r2=new JButton("Rs 500");
		r2.setBounds(340,350,150,30);
		r2.setBackground(Color.white);
		r2.addActionListener(this);
		label.add(r2);
		
		r3=new JButton("Rs 1000");
		r3.setBounds(170,390,150,30);
		r3.setBackground(Color.white);
		r3.addActionListener(this);
		label.add(r3);
		
		r4=new JButton("Rs 2000");
		r4.setBounds(340,390,150,30);
		r4.setBackground(Color.white);
		r4.addActionListener(this);
		label.add(r4);
		
		r5=new JButton("Rs 5000");
		r5.setBounds(170,430,150,30);
		r5.addActionListener(this);
		r5.setBackground(Color.white);
		label.add(r5);
		
		r6=new JButton("Rs 10,000");
		r6.setBounds(340,430,150,30);
		r6.setBackground(Color.white);
		r6.addActionListener(this);
		label.add(r6);
		
		back=new JButton("back");
		back.setBounds(340,470,150,30);
		back.addActionListener(this);
		back.setBackground(Color.yellow);
		label.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Date date=new Date();
		if(e.getSource()==back)
		{
			setVisible(false);
			new Transaction(pin_number).setVisible(true);
		}
		else
		{
			String ammount =((JButton) e.getSource()).getText().substring(3);
			Conn c=new Conn();
			try
			{
				ResultSet rs=c.s.executeQuery("select *from bank where pin_number='"+pin_number+"'");
				int balence=0;
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
				if(e.getSource()!= back && balence <Integer.parseInt(ammount))
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				String query = "INSERT INTO bank VALUES ('" + pin_number + "', '" + date + "', 'Withdrawal', '" + ammount + "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ammount+"/- Debited Succesfully");
				setVisible(false);
				new Transaction(pin_number).setVisible(false);
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		
		
	}

}
