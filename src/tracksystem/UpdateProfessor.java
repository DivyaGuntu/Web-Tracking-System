package tracksystem;
//Loading required libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@WebServlet("/updateProfessor")
@MultipartConfig(maxFileSize = 16177215)

public class UpdateProfessor extends HttpServlet{
static final long serialVersionUID = 1L;


public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{ 
	
  HttpSession session = request.getSession(true);
	String professorid = (String) session.getAttribute("professorid");
	System.out.println("u are at UpdateProfessor.java  and user professor id is " + professorid);
	
	 if (request.getParameter("update") != null) {
	
	 String id = request.getParameter("id");
	 String id2 = professorid;
	 String fn = request.getParameter("fn");
	 String ln = request.getParameter("ln");
   SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   String dob1 = request.getParameter("dob");
   java.util.Date d;
  String mail = request.getParameter("email");
  String email2 = mail;
  String mj = request.getParameter("major");
//  String sup = request.getParameter("supervisor");
	// String gd = request.getParameter("grad_date");
  String un = request.getParameter("uname");
  String username2 = un;
  String pwd = request.getParameter("pwd");
  String quest = request.getParameter("ques");
  String answ = request.getParameter("ans");
/*   InputStream inputStream = null; // input stream of the upload file
  
  // obtains the upload file part in this multipart request
  Part filePart = request.getPart("photo");
  if (filePart != null) {
      // prints out some information for debugging
      System.out.println(filePart.getName());
      System.out.println(filePart.getSize());
      System.out.println(filePart.getContentType());
       
      // obtains input stream of the upload file
      inputStream = filePart.getInputStream();
  } */ 
  Connection conn=null; 
  String db_url="jdbc:mysql://localhost/trackingsystem";
  String db_username = "root";
  String db_password = "1001";
  String message = null;
  System.out.println("connected successful at updateprofessor.java with fn: " + fn + "  " + ln +" " + un+ " " + dob1 +" " + mail + " "+ mj +" "+quest +" "+ answ);
	
 try{
		       Class.forName("com.mysql.jdbc.Driver");
		       conn = DriverManager.getConnection(db_url,db_username,db_password);
		       // constructs SQL statement
		       String sql = "update  professor set firstname=?, lastname=? , dateofbirth=?, email=?, major=?, securityquestion=?, securityanswer=? where professorid=?";
		       PreparedStatement statement = conn.prepareStatement(sql);
		       
		       statement.setString(1, fn);
		       statement.setString(2, ln);
		       //statement.setString(3, un);
		      // byte key = (byte) 0XF2132F32;
		       //statement.setString(5, pwd);
		       //statement.setByte(6, key);
		       
		       try {
		      		d = new SimpleDateFormat("MM/dd/yyyy").parse(dob1);
		      		statement.setDate(3, new java.sql.Date(d.getTime()));
		      	   } catch (ParseException e1) {
		      		e1.printStackTrace();
		        	}
		       statement.setString(4, mail);
		       statement.setString(5, mj);
		       statement.setString(6, quest);
		       statement.setString(7, answ);
		       
		/*       if (inputStream != null) {
		           // fetches input stream of the upload file for the blob column
		           statement.setBlob(12, inputStream);
		       } */ 
		       
		//       statement.setDate(9, gd);
		 /*      try {
		     		d = new SimpleDateFormat("MM/dd/yyyy").parse(gd);
		     		statement.setDate(8, new java.sql.Date(d.getTime()));
		     	   } catch (ParseException e1) {
		     		e1.printStackTrace();
		       	} */   
		       
		      // statement.setString(15, "false");
		       statement.setString(8, id2);
		       /// to update the user table:
		       String sql2 = "update user set email=? where userid =?";
		       PreparedStatement statement2 = conn.prepareStatement(sql2);
		       statement2.setString(1,email2);
		       //statement2.setString(2,username2);
		       statement2.setString(2,id2);
		    
		       System.out.println("prepared statment successful at updateprofessor.java" + email2);
		           
		 //      System.out.println(email2);
		
		       // sends the statement to the database server
		       int row = statement.executeUpdate();
		       int row2 = statement2.executeUpdate(); 
		       
		       
		       if (row > 0)
		       {
		    	   System.out.println("professor table is updated");
		       }
		       if (row2 > 0)
		       {
		    	   System.out.println("user table is updated");
		       }

		       if (row > 0 && row2 > 0) {
			            System.out.println("rows updated at updateprofessor.java");
			
			        	message = "professor update successful";           
			       
				      String sql3 = "select * from professor where professorid = '"+professorid+"'";
				      Statement statement3 = conn.createStatement();
				      ResultSet rs = statement3.executeQuery(sql3);
				      while(rs.next()){
				    	  
				         //Retrieve by column name
				    	//   String studentid = rs.getString("studentid"); 
				    	   String lastname = rs.getString("lastname");
				    	   String firstname = rs.getString("firstname");
				    	   String username = rs.getString("username");
				    	   String email = rs.getString("email");
				    	   String major = rs.getString("major");
				    	   String securityquestion = rs.getString("securityquestion");
				    	   String securityanswer = rs.getString("securityanswer");
				    	   Date birthdate = rs.getDate("dateofbirth");
				    	  // Date graduatedate = rs.getDate("graduatedate");
				    	  // String supervisorid = rs.getString("supervisorid");
				    	   
				    	   
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
			
			
				    	   getServletContext().getRequestDispatcher("/ProfessorHome.jsp").forward(request, response);
				      }
	      }
 }
 catch(ClassNotFoundException e)
	{ 
	   message = "ERROR: " + e.getMessage();
	}
	    
 catch (SQLException ex) 
 {
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
	    	       }
 			} 
 }
	 
 else if (request.getParameter("cancel") != null) {

		 	Connection conn=null; 
		    String db_url="jdbc:mysql://localhost/TrackingSystem";
		    String db_username = "root";
		    String db_password = "1001";
		    PrintWriter out = response.getWriter();

		   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(db_url,db_username,db_password);
		      String sql = "select * from professor where professorid = '"+professorid+"'";
		      Statement statement = conn.createStatement();
		      ResultSet rs = statement.executeQuery(sql);
		      while(rs.next()){
		    	  
		         //Retrieve by column name
		    	//   String studentid = rs.getString("studentid"); 
		    	   String lastname = rs.getString("lastname");
		    	   String firstname = rs.getString("firstname");
		    	   String username = rs.getString("username");
		    	   String email = rs.getString("email");
		    	   String major = rs.getString("major");
		    	   String securityquestion = rs.getString("securityquestion");
		    	   String securityanswer = rs.getString("securityanswer");
		    	   Date birthdate = rs.getDate("dateofbirth");
//		    	   Date graduatedate = rs.getDate("graduatedate");
//		    	   String supervisorid = rs.getString("supervisorid");
		    	   
		    	   
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


		    	   getServletContext().getRequestDispatcher("/ProfessorHome.jsp").forward(request, response);
		      }
		      	  rs.close();
			      statement.close();
			      conn.close();  
			   }
			   
			   catch(Exception e)
			   { e.printStackTrace();} 
			 
	    // Invoke SecondServlet's job here.
	}
}
}