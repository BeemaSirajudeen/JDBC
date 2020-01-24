import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class CaseStudy_1 
{

		public static void main(String[] args)throws ClassNotFoundException ,SQLException, IOException 
		{ 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String c;
         Class.forName("com.mysql.jdbc.Driver");//to register driver class
 		 Connection con=null;//connection object is intialised as null
 		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_jdbc","root","");
 		 Statement st=con.createStatement();
 		 do
 		{
 			System.out.println("\nMenu\n1.Registration\n2.Display\n3.Exit\nEnter your choice");
 		
         int n=Integer.parseInt(br.readLine());
         switch(n)
         {
         case 1: System.out.println("Name: ");
         String name=br.readLine();
         System.out.println("Address: ");
         String address=br.readLine();
         System.out.println("Contact_Number: ");
         String contactNumber=br.readLine();
         System.out.println("email: ");
         String email=br.readLine();
         System.out.println("Proof_Type: ");
         String ProofType=br.readLine();
         System.out.println("Proof_Id: ");
         String ProofId=br.readLine();
         String str="INSERT INTO registration VALUES('"+name+"','"+address+"','"+contactNumber+"','"+email+"','"+ProofType+"','"+ProofId+"')";
 		 st.execute(str);
 		 break;
         case 2:String str1="SELECT * FROM registration";
         ResultSet rs=st.executeQuery(str1);
         System.out.println("Name\tAddress\t\tContactNumber\t\temail\t\tProofType\tProofId");
         while(rs.next())
         {
        	 String Name=rs.getString("Name");
        	 String Address=rs.getString("Address");
        	 String Contact_Number=rs.getString("Contact_Number");
        	 String Email=rs.getString("Email");
        	 String  Proof_Type=rs.getString("Proof_Type");
        	 String Proof_Id=rs.getString("Proof_Id");
        	 System.out.println(Name+"\t"+Address+"\t\t"+Contact_Number+"\t\t"+Email+"\t\t"+Proof_Type+"\t"+Proof_Id);
         }
         case 3:System.exit(0);
         default:System.out.println("Invalid");
         }
         System.out.println("Do you want to continue");
         c=br.readLine();
 		}
 		while(c.equals("yes"));
   }

}
