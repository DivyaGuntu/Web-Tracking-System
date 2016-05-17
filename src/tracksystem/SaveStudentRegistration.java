package tracksystem;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.sql.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.util.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/uploadServlet1")
@MultipartConfig(maxFileSize = 16177215)
public class SaveStudentRegistration extends HttpServlet{
 static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{

	
	if (request.getParameter("register") != null) {

	
			 String id = request.getParameter("id");
			 String id2 = id;
			 String fn = request.getParameter("fn");
		     String ln = request.getParameter("ln");
		//     SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		     String dob1 = request.getParameter("dob");
		     java.util.Date d;
		     String mail = request.getParameter("email");
		     String email2 = mail;
		     String mj = request.getParameter("major");
		     String sup = request.getParameter("supervisor");
			 String gd = request.getParameter("grad_date");
		     String un = request.getParameter("uname");
		     String username2 = un;
		     String pwd = request.getParameter("pwd");
		     String quest = request.getParameter("ques");
		     String answ = request.getParameter("ans");
		     InputStream inputStream = null; // input stream of the upload file
		     
		     // obtains the upload file part in this multipart request
		     Part filePart = request.getPart("photo");
		     if (filePart != null) {
		         // prints out some information for debugging
		         System.out.println(filePart.getName());
		         System.out.println(filePart.getSize());
		         System.out.println(filePart.getContentType());
		          
		         // obtains input stream of the upload file
		         inputStream = filePart.getInputStream();
		     }
		     
		    Connection conn=null; 
		    String db_url="jdbc:mysql://localhost/trackingsystem";
		    String db_username = "root";
		    String db_password = "1001";
		    String message = null;
		    
		   try{
		       Class.forName("com.mysql.jdbc.Driver");
		       conn = DriverManager.getConnection(db_url,db_username,db_password);
		       // constructs SQL statement
		       String sql = "insert into student (studentid, firstname , lastname , username, password, dateofbirth, email, major, securityquestion, securityanswer, photo, supervisorid, graduatedate, stloginstatus) values (?, ?, ?, ?, AES_ENCRYPT(?, ?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		       PreparedStatement statement = conn.prepareStatement(sql);
		       statement.setString(1, id);
		       statement.setString(2, fn);
		       statement.setString(3, ln);
		       statement.setString(4, un);
		       byte key = (byte) 0XF2132F32;
		       statement.setString(5, pwd);
		       statement.setByte(6, key);
		       
		       try {
		      		d = new SimpleDateFormat("MM/dd/yyyy").parse(dob1);
		      		statement.setDate(7, new java.sql.Date(d.getTime()));
		      	   } catch (ParseException e1) {
		      		e1.printStackTrace();
		        	}
		       statement.setString(8, mail);
		       statement.setString(9, mj);
		       statement.setString(10, quest);
		       statement.setString(11, answ);
		       
		       if (inputStream != null) {
		           // fetches input stream of the upload file for the blob column
		           statement.setBlob(12, inputStream);
		       }
		       
		       statement.setString(13, sup);
		       try {
		     		d = new SimpleDateFormat("MM/dd/yyyy").parse(gd);
		     		statement.setDate(14, new java.sql.Date(d.getTime()));
		     	   } catch (ParseException e1) {
		     		e1.printStackTrace();
		       	}
		       
		       statement.setString(15, "false");
		      
		       /// to update the user table:
		       String sql2 = "insert into user (userid, email, username) values (?,?,?)";
		       PreparedStatement statement2 = conn.prepareStatement(sql2);
		       statement2.setString(1,id2);
		       statement2.setString(2,email2);
		       statement2.setString(3,username2);
		       int row2 = statement2.executeUpdate(); 
		      
		       
		       // sends the statement to the database server
		       int row = statement.executeUpdate();
		        if (row > 0 && row2 > 0) {
		           message = "Registration successful, you can access your account once it is approved";
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
		       }
		       // sets the message in request scope
		       request.setAttribute("Message", message);
		        
		       // forwards to the message page
		       getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
		   }
		   
	}
	else if(request.getParameter("cancel") != null) {
	       getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
}