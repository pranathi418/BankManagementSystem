package com.bank;
import java.sql.*;
public class Conn {
	
// For connecting to JDBC we need to follow these steps
//	1) Register The Drivers
	Connection c;
	Statement s;
	public Conn()
	{
		try
		{
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","PRANathi@123");
			s=c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
