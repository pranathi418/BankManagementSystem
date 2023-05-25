package com.bank;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class SignUp1 extends JFrame implements ActionListener{
	
	JTextField Panfield,Addarfield,Pinfield,Statefield;
	JButton next;
	JRadioButton yes,no,eyes,eno;
	JComboBox religion,category,education,occupation,income;
	String formno;
	SignUp1(String formno)
	{
		this.formno=formno;
		System.out.println(formno);
		setSize(850,800);
		
		setLocation(350,10);
		getContentPane().setBackground(Color.WHITE);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		JLabel additionaldetails=new JLabel("Page 2 : Additional Details");
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,25));
		additionaldetails.setBounds(260,80,400,30);
		add(additionaldetails);
		
		JLabel relname=new JLabel("Religion :");
		relname.setFont(new Font("Raleway",Font.BOLD,20));
		relname.setBounds(100,150,100,30);
		add(relname);
		
		String valreligion[]= {"Hindu","Muslim","Sikh","Christianity","ohters"};
		religion=new JComboBox(valreligion);
		religion.setBackground(Color.white);
		religion.setBounds(300,150,400,30);
		add(religion);
		
		
		JLabel categoryname=new JLabel("Category :");
		categoryname.setFont(new Font("Raleway",Font.BOLD,20));
		categoryname.setBounds(100,200,200,30);
		add(categoryname);
		
		String valcategory[]= {"General","OBC","ST","SC","Other"};
		category=new JComboBox(valcategory);
		category.setBackground(Color.white);
		category.setBounds(300,200,400,30);
		add(category);
		
		JLabel incomename=new JLabel("Income :");
		incomename.setFont(new Font("Raleway",Font.BOLD,20));
		incomename.setBounds(100,250,200,30);
		add(incomename);
		
		String valincome[]= {"Null","< 1,50,000","<2,50,000","< 5,00,000","Upto 10,00,000"};
		income=new JComboBox(valincome);
		income.setBackground(Color.white);
		income.setBounds(300,250,400,30);
		add(income);
		
		JLabel edu=new JLabel("Educational");
		edu.setFont(new Font("Raleway",Font.BOLD,20));
		edu.setBounds(100,300,200,30);
		add(edu);
		
		JLabel qua=new JLabel("Qualification :");
		qua.setFont(new Font("Raleway",Font.BOLD,20));
		qua.setBounds(100,340,200,30);
		add(qua);
		
		String valeduqualification[]= {"Non-Graduate","Graduate","Post Graduation","Doctrate","Others"};
		education=new JComboBox(valeduqualification);
		education.setBackground(Color.white);
		education.setBounds(300,325,400,30);
		add(education);
		
		JLabel Occu=new JLabel("Occupation :");
		Occu.setFont(new Font("Raleway",Font.BOLD,20));
		Occu.setBounds(100,400,200,30);
		add(Occu);
		
		String valoccupation[]= {"Salaried","Self-Employed","Bussiness","Student","Retired"};
		occupation=new JComboBox(valoccupation);
		occupation.setBackground(Color.white);
		occupation.setBounds(300,400,400,30);
		add(occupation);
		
		JLabel pannumber =new JLabel("PAN Number :");
		pannumber.setFont(new Font("Raleway",Font.BOLD,20));
		pannumber.setBounds(100,450,200,30);
		add(pannumber);
		
		Panfield=new JTextField();
		Panfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Panfield.setBounds(300,450,400,30);
		add(Panfield);
		
		JLabel addar=new JLabel("Adhar Number :");
		addar.setFont(new Font("Raleway",Font.BOLD,20));
		addar.setBounds(100,500,200,30);
		add(addar);
		
		Addarfield=new JTextField();
		Addarfield.setFont(new Font("Raleway" ,Font.BOLD,15));
		Addarfield.setBounds(300,500,400,30);
		add(Addarfield);
		
		JLabel seniorcitizen=new JLabel("Senior Citizen :");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorcitizen.setBounds(100,550,200,30);
		add(seniorcitizen);
		
		yes=new JRadioButton("Yes");
		yes.setBounds(300,550,100,30);
		yes.setBackground(Color.white);
		add(yes);
		
		no=new JRadioButton("No");
		no.setBounds(400,550,120,30);
		no.setBackground(Color.white);
		add(no);
		
		ButtonGroup citizengroup=new ButtonGroup();
		citizengroup.add(yes);
		citizengroup.add(no);
		
		JLabel existacc=new JLabel("Exixsting Account :");
		existacc.setFont(new Font("Raleway",Font.BOLD,20));
		existacc.setBounds(100,600,200,30);
		add(existacc);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,600,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(400,600,120,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
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
		new SignUp1("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_religion=(String) religion.getSelectedItem();
		String s_category=(String) category.getSelectedItem();
		String s_income=(String) income.getSelectedItem();
		String s_educational=(String) education.getSelectedItem();
		String s_occupation=(String) occupation.getSelectedItem();
		String s_pan=Panfield.getText();
		String s_addar=Addarfield.getText();
		String s_citizen=null;
		if(yes.isSelected())
		{
			s_citizen="Yes";
		}
		else
		{
			s_citizen="No";
		}
		String s_existacc=null;
		if(eyes.isSelected())
		{
			s_existacc="Yes";
		}
		else
		{
			s_existacc="NO";
		}	
		try
		{
			if(s_pan.equals(""))
			{
				JOptionPane.showMessageDialog(null, "PanNumber is Required");
			}
			if(s_addar.equals(""))
			{
				JOptionPane.showMessageDialog(null, "AddarNumber is Required");
			}
			else
			{
				Conn c=new Conn();
				String query="insert into signup1 values ('"+formno+"','"+s_religion+"','"+s_category+"','"+s_income+"','"+s_educational+"','"+s_occupation+"','"+s_pan+"','"+s_addar+"','"+s_citizen+"','"+s_existacc+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignUp2(formno).setVisible(true);
				
			}
		}
		catch(Exception en)
		{
			System.out.println(en);
		}
	}

}
