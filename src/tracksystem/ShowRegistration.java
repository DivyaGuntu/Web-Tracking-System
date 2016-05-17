package tracksystem;

//Loading required libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

public class ShowRegistration extends HttpServlet{
 static final long serialVersionUID = 1L;


public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{ 
	
    HttpSession session = request.getSession(true);
	String profid = (String) session.getAttribute("uid");
	System.out.println(profid);
	

    Connection conn=null; 
    String db_url="jdbc:mysql://localhost/TrackingSystem";
    String db_username = "root";
    String db_password = "track";
    PrintWriter out = response.getWriter();

   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(db_url,db_username,db_password);
      String sql = "select * from professor where professorid = '"+profid+"'";
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while(rs.next()){
         //Retrieve by column name
         String pid  = rs.getString("professorid");
         String first = rs.getString("firstName");
         String last = rs.getString("lastName");
         String un = rs.getString("username");
         Date d1 = new Date(rs.getDate("dateofbirth").getTime());
         String mail  = rs.getString("email");
         String mj = rs.getString("major");
         String sq = rs.getString("securityquestion");
         String sa = rs.getString("securityanswer");
         
         

         //Display values
         out.println("ID: " + pid + "<br>");
         out.println("Firstname: " + first + "<br>");
         out.println("Lastname: " + last + "<br>");
         out.println("Date of Birth:" + d1 + "<br>");
         out.println("Email ID: " + mail + "<br>");
         out.println("Major: " + mj + "<br>");
         out.println("User Name: " + un + "<br>");
         out.println("Security question: " + sq + "<br>");
         out.println("Security answer: " + sa + "<br>");
         
      } 
      out.println("</body></html>"); 

      // Clean-up environment
      rs.close();
      statement.close();
      conn.close();  
   }
   
   catch(Exception e)
   { e.printStackTrace();}
}
}