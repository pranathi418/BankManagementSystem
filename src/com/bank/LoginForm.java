package com.bank;
import java.awt.Image;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*; 
public class LoginForm extends JFrame implements ActionListener {//to create a frame

	//These have to be declared globally becuase these can be used by other methods in the class
	JButton Login,SignUp,Clear;
	JTextField cardTextField;
	JPasswordField PinTextField;
	LoginForm()
	{
		setTitle("Bank Management System");
		setLayout(null);
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image img2=img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);	
		ImageIcon img3=new ImageIcon(img2);
		JLabel label =new JLabel(img3);
		label.setBounds(100,5,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome Users!");
		text.setFont(new Font("Arial",Font.BOLD,35));
		text.setBounds(250,40,400,40);
		add(text);
		
		JLabel CardNumber=new JLabel("Card Number :");
		CardNumber.setFont(new Font("Raleway",Font.BOLD,20));
		CardNumber.setBounds(150,150,400,30);
		add(CardNumber);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300, 155,230, 30);
		cardTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(cardTextField);
		
		JLabel PinCode=new JLabel("PinCode :");
		PinCode.setFont(new Font("Arial",Font.BOLD,20));
		PinCode.setBounds(150,250,400,30);
		add(PinCode);
		
		PinTextField=new JPasswordField();
		PinTextField.setBounds(300, 250,230, 30);
		PinTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(PinTextField);
		
		Login=new JButton("Sign In");
		Login.setBounds(250,300,100,30);
		Login.setBackground(Color.BLACK);
		Login.setForeground(Color.WHITE);
		Login.addActionListener(this);
		add(Login);
		
		Clear=new JButton("Clear");
		Clear.setBounds(380,300,100,30);
		Clear.setBackground(Color.BLACK);
		Clear.setForeground(Color.WHITE);
		Clear.addActionListener(this);
		add(Clear);
		
		SignUp=new JButton("Sign Up");
		SignUp.setBounds(250,350,230,30);
		SignUp.setBackground(Color.BLACK);
		SignUp.setForeground(Color.WHITE);
		SignUp.addActionListener(this);
		add(SignUp);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,480);
		setLocation(350,200);
		//size of the frame on the screen
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new LoginForm();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Clear)
		{
			cardTextField.setText("");
			PinTextField.setText("");
		}
		else if(e.getSource()==Login)
		{
			Conn conn=new Conn();
			String card_number=cardTextField.getText();
			String pin_number=PinTextField.getText();
			String query="select * from login where card_number = '"+card_number+"' and pin_number = '"+pin_number+"'";
			try
			{
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transaction(pin_number).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Cardno or Pin");
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else if(e.getSource()==SignUp)
		{
			setVisible(false);
			new SignUp().setVisible(true);
		}
		// TODO Auto-generated method stub
		
		
	}

}