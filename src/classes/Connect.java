package classes;

import java.sql.*;
import com.mysql.*;
import javax.swing.JOptionPane;

public class Connect {
	Connection con=null;
	public static Connection connectDb()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb","root","umakant");
		 return con;
		 }
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static void main(String[] args) {
		Connect c= new Connect();
		c.connectDb();
}
}