
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class Main 
{
	

	public static void main(String[] args) throws ClassNotFoundException ,SQLException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		int age=Integer.parseInt(br.readLine());
		String address=br.readLine();
		Class.forName("com.mysql.jdbc.Driver");//to register driver class
		Connection con=null;//connection object is intialised as null
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_jdbc","root","");// to getting connection of database in SQL
		// if connection object is not null connection is established with the database in the SQL
        if(con!=null)
        {
        	System.out.println("Welcome");
        }
        
		Statement st=con.createStatement();
		String str="INSERT INTO details VALUES('"+name+"','"+age+"','"+address+"')";
		st.execute(str);
	}

}
