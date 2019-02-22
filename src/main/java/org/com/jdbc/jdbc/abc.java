package org.com.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class abc 
{ 
	public static void main(String a[]) 
	{ 
		//Creating the connection 
		String url = "jdbc:mysql://127.0.0.1:3306/emp"; 
		//String url = "jdbc:Mysql://localhost:3306/keyconcept"; 
		String user = "root"; 
		String pass = "root"; 

		//Entering the data 
		Scanner k = new Scanner(System.in); 
		System.out.println("enter name"); 
		String name = k.next(); 
		System.out.println("enter roll no"); 
		int roll = k.nextInt(); 
		System.out.println("enter class"); 
		String cls = k.next(); 

		//Inserting data using SQL query 
		String sql = "insert into student1 values('"+name+"',"+roll+",'"+cls+"')"; 
		String selectQuery = "select * from student1";
		Connection con=null; 
		try
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Reference to connection interface 
			con = DriverManager.getConnection(url,"root","root"); 

			Statement st = con.createStatement(); 
			int m = st.executeUpdate(sql); 
			ResultSet rsResultSet=st.executeQuery(selectQuery);
			rsResultSet.absolute(5);  
			System.out.println(rsResultSet.getString(1)+" "+rsResultSet.getString(2)+" "+rsResultSet.getString(3)); 
			System.out.println(m);
			if (m == 1) 
				System.out.println("inserted successfully : "+sql); 
			else
				System.out.println("insertion failed"); 
			con.close(); 
		} 
		catch(Exception ex) 
		{ 
			System.err.println(ex); 
		} 
	} 
} 

