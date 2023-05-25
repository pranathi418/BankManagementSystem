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
public class PinChange extends JFrame implements ActionListener {
	
	JPasswordField pintextfield,rpintextfield;
	JButton Submit,back;
	String pin_number;
	PinChange(String pin_number)
	{
		
		this.pin_number=pin_number;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		JLabel pin=new JLabel("Change Your PIN:");
		pin.setBounds(270,300,700,35);
		pin.setForeground(Color.white);
		pin.setFont(new Font("System",Font.BOLD,15));
		label.add(pin);
		
		JLabel newpin=new JLabel("Enter New PIN :");
		newpin.setBounds(180,350,400,35);
		newpin.setForeground(Color.white);
		newpin.setFont(new Font("System",Font.BOLD,15));
		label.add(newpin);
		
		pintextfield=new JPasswordField();
		pintextfield.setBounds(320,350,100, 30);
		pintextfield.setFont(new Font("Raleway",Font.BOLD,15));
		add(pintextfield);
		
		JLabel rpin=new JLabel("Re-Enter New PIN:");
		rpin.setBounds(180,400,400,35);
		rpin.setForeground(Color.white);
		rpin.setFont(new Font("System",Font.BOLD,15));
		label.add(rpin);
		
		rpintextfield=new JPasswordField();
		rpintextfield.setBounds(320,400,100,30);
		rpintextfield.setFont(new Font("Raleway",Font.BOLD,15));
		add(rpintextfield);
		
		Submit=new JButton("Submit");
		Submit.setBounds(380,470,100,30);
		Submit.setBackground(Color.yellow);
		Submit.addActionListener(this);
		label.add(Submit);
		
		back=new JButton("Back");
		back.setBounds(380,510,100,30);
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
		new PinChange("").setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Submit)
		{
			try
			{
				String newpin=pintextfield.getText();
				if(!(pintextfield.getText().equals(rpintextfield.getText())))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Correct Pin");
					return;
				}
				if(newpin.length()>4)
				{
					JOptionPane.showMessageDialog(null, "PIN should be only 4 digit");
				}
				if(newpin.equals("") || (rpintextfield.getText()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter The New Pin");
					return;
				}
				Conn conn=new Conn();
				String query="update login set pin_number='"+newpin+"' where pin_number='"+pin_number+"'";
				String query1="update signup2 set pin_number='"+newpin+"' where pin_number='"+pin_number+"'";
				String query2="update bank set pin_number='"+newpin+"' where pin_number='"+pin_number+"'";

				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "PIN Changed Succesfully");
				setVisible(false);
				new Transaction(pin_number).setVisible(true);
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			new Transaction(pin_number).setVisible(true);
		}
	}

}
