package tracksystem;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.sql.*;


public class LoginServlet extends HttpServlet{
 static final long serialVersionUID = 1L;
 
public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{
	
	 String u_type = request.getParameter("usertype");
	 
	 if (request.getParameter("login") != null)
	 {
		 String id = request.getParameter("uid");
		 String pwd = request.getParameter("pass");
	     
	    Connection conn=null; 
	    ResultSet rs = null;
	    String db_url="jdbc:mysql://localhost/trackingsystem";
	    String db_username = "root";
	    String db_password = "1001";
	    boolean status = false;
	    String message = null;
	    
	    response.setContentType("text/html");    
	    PrintWriter out = response.getWriter(); 
	   try{
	       Class.forName("com.mysql.jdbc.Driver");
	       conn = DriverManager.getConnection(db_url,db_username,db_password);
	       System.out.println("connected sucessfully");
	       // constructs SQL statement
	       if(u_type.equals("admin")) {
	       String sql = "select * from admin where username=? and password=AES_ENCRYPT(?,?)";
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, id);
	       statement.setString(2, pwd);
	       statement.setString(3, "0XF2132F32");
	       rs = statement.executeQuery();  
	       status = rs.next();    
	       if(status) 
	       {
	          message = "Admin"; 
	          
	          RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/AdminHome.jsp");
	    	  reqDispatcher.forward(request, response);
	       }
	       }
	       if(u_type.equals("professor")) {
	       //System.out.println("checking prof...");
	       String sql = "select * from professor where username=? and password= AES_ENCRYPT(?,?) and profloginstatus =?";
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, id);
	       statement.setString(2, pwd);
	       byte key= (byte) 0XF2132F32;
	       statement.setByte(3, key);
	       statement.setString(4, "true");
	       rs = statement.executeQuery();
	       
	       //status = rs.next();    
	       //if (status) 
	       while(rs.next())
	       {
	    	   System.out.println("professor login successfuly");
	           
	    	   String professorid = rs.getString("professorid"); 
	    	   String lastname = rs.getString("lastname");
	    	   String firstname = rs.getString("firstname");
	    	   String username = rs.getString("username");
	    	   String email = rs.getString("email");
	    	   String major = rs.getString("major");
	    	   String securityquestion = rs.getString("securityquestion");
	    	   String securityanswer = rs.getString("securityanswer");
	    	   Date birthdate = rs.getDate("dateofbirth");
	    	   //Date graduatedate = rs.getDate("graduatedate");
	    	   //String supervisorid = rs.getString("supervisorid");
	    	   
	    	   //InputStream inputStream = null; // input stream of the upload file
	    	 //  Blob imageBlob = rs.getBlob("photo");
	    	   //InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
	    	  // InputStream binaryStream = rs.getBinaryStream("photo");	   
	    	   
	    	   
	    	   System.out.println( lastname + " " + professorid);
	    	   request.setAttribute("professorid", professorid);
	    	   request.setAttribute("lastname", lastname);
	    	   request.setAttribute("firstname", firstname);
	    	   request.setAttribute("username", username);
	    	   request.setAttribute("email", email);
	    	   request.setAttribute("major", major);
	    	   request.setAttribute("securityquestion", securityquestion);
	    	   request.setAttribute("securityanswer", securityanswer);
	    	   request.setAttribute("birthdate", birthdate);
	    	  // request.setAttribute("graduatedate", graduatedate);
	    	  // request.setAttribute("supervisorid", supervisorid);
	    	//   request.setAttribute("photo", binaryStream);
	    	   
	    	   message = "Login successful";    
	    	   RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ProfessorHome.jsp");
	    	   reqDispatcher.forward(request, response);
	    	}
	       }
	       if(u_type.equals("student")) {
	       String sql = "select * from student where username=? and password= AES_ENCRYPT(?,?) and stloginstatus =?";
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, id);
	       statement.setString(2, pwd);
	       byte key= (byte) 0XF2132F32;
	       statement.setByte(3, key);
	       statement.setString(4, "true");
	       rs = statement.executeQuery();  
	     //  status = rs.next();    
	      // if (status) 
	       while(rs.next())   	     
	       {
	    	   
	    	   System.out.println("student login successfuly");
	           
	    	   String studentid = rs.getString("studentid"); 
	    	   String lastname = rs.getString("lastname");
	    	   String firstname = rs.getString("firstname");
	    	   String username = rs.getString("username");
	    	   String email = rs.getString("email");
	    	   String major = rs.getString("major");
	    	   String securityquestion = rs.getString("securityquestion");
	    	   String securityanswer = rs.getString("securityanswer");
	    	   Date birthdate = rs.getDate("dateofbirth");
	    	   Date graduatedate = rs.getDate("graduatedate");
	    	   String supervisorid = rs.getString("supervisorid");
	    	   
	    	   //InputStream inputStream = null; // input stream of the upload file
	    	 //  Blob imageBlob = rs.getBlob("photo");
	    	   //InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
	    	  // InputStream binaryStream = rs.getBinaryStream("photo");	   
	    	   
	    	   
	    	   System.out.println( lastname + " " + studentid);
	    	   request.setAttribute("studentid", studentid);
	    	   request.setAttribute("lastname", lastname);
	    	   request.setAttribute("firstname", firstname);
	    	   request.setAttribute("username", username);
	    	   request.setAttribute("email", email);
	    	   request.setAttribute("major", major);
	    	   request.setAttribute("securityquestion", securityquestion);
	    	   request.setAttribute("securityanswer", securityanswer);
	    	   request.setAttribute("birthdate", birthdate);
	    	   request.setAttribute("graduatedate", graduatedate);
	    	   request.setAttribute("supervisorid", supervisorid);
	    	//   request.setAttribute("photo", binaryStream);
	    	   
	    	   message = "Login successful";    
	    	   RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/StudentHome.jsp");
	    	   reqDispatcher.forward(request, response);
	       }
	       }         
	      }
	    catch(ClassNotFoundException e)
	     {   message = "ERROR: " + e.getMessage();
	     }   
	   
	    catch (SQLException ex) {
	       message = "ERROR: " + ex.getMessage();
	       ex.printStackTrace();
	    } 
	   finally {
	       if (conn != null) {
	           // closes the database connection
	           try {
	               conn.close();
	           } catch (SQLException ex) {
	               ex.printStackTrace();
	           }
	       } }
	       // sets the message in request scope
	       
	       request.setAttribute("Message", message);
	        
	       if(!status) {    	   
	    	   out.print("<p style=\"color:red\">Sorry username or password error</p>");    
	    	   getServletContext().getRequestDispatcher("/index.jsp").include(request, response);  
	       }
	 }
	 
	 else if (request.getParameter("register") != null) {
		 	
			//request.setAttribute("studentid",studentid);
		 	if (u_type.equals("student"))
		 	{
		 		getServletContext().getRequestDispatcher("/StudentRegistration.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
			}
		 	else if (u_type.equals("professor"))
	 		{
	 			getServletContext().getRequestDispatcher("/ProfessorRegistration.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
			}
		 	else if (u_type.equals("admin"))
	 		{
	 			
	 		
	 			//request.setAttribute("Message", message);
		        
		 		PrintWriter out = response.getWriter(); 
	 	    	out.print("<p style=\"color:red\">Admin can't register through online</p>");    
	 	    	getServletContext().getRequestDispatcher("/index.jsp").include(request, response);  
	 			//JOptionPane.showMessageDialog(null, "admin can't register through website");
	 			//getServletContext().getRequestDispatcher("/StudentRegistration.jsp").forward(request, response);	
	 			// Invoke SecondServlet's job here.
			}
	 }
}
}
