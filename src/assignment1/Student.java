package assignment1;

import java.sql.*;

public class Student {
	
	public static void main(String[] args) throws SQLException {
	
	//connect to database
	Connection conn = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC","root","1234");
	
	//create statement to retrieve object
	Statement s = conn.createStatement();
	
	//retrieve result for the table
	ResultSet rs = s.executeQuery("Select * from student");
	
	//print column headers
	ResultSetMetaData rsmd = rs.getMetaData();
	int i = rsmd.getColumnCount();
	
	for (int j = 1; j<=i; j++) {
		System.out.print(rsmd.getColumnName(j)+"\t");
		System.out.print(" ");
	}
	
	
	//print records
	while(rs.next()) {
		System.out.print("\n");
		for (int j=1; j<=i; j++) {
			System.out.print(rs.getString(j)+"\t");
			}	
		}
	}// end of main
}// end of class
