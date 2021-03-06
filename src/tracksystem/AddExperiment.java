package tracksystem;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addExperiment")
@MultipartConfig(maxFileSize = 16177215)
public class AddExperiment extends HttpServlet{
	 static final long serialVersionUID = 1L;
	 


	public void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException{
		
		 HttpSession session = request.getSession(true);
		 String actorid = (String) session.getAttribute("actorid");
		 System.out.println("actor id is :" + actorid);
		
		 if (request.getParameter("submit") != null) {
			 
				 String id = request.getParameter("id");
				// String id2 =id;
				 String name = request.getParameter("name");
			     String summary = request.getParameter("summary");
			     //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			     //String dob1 = request.getParameter("dob");
			  //   java.util.Date d;
				
			     String drugs = request.getParameter("drugs");
			     //String email2 = mail;
			     String dose = request.getParameter("dose");
			     String observation = request.getParameter("observation");
		
			     /*     String username2 =un;
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
			     } */ 
			     
			    Connection conn=null; 
			    String db_url="jdbc:mysql://localhost:3306/trackingsystem";
			    String db_username = "root";
			    String db_password = "1001";
			    String message = null;
			    
			   try{
			       Class.forName("com.mysql.jdbc.Driver");
			       conn = DriverManager.getConnection(db_url,db_username,db_password);
			       System.out.println("connected sucessfully");
			       // constructs SQL statement
			       String sql = "insert into experiment (experimentid, name, summary, drugs, dose, observation) values(?, ?, ?, ?, ?, ?)";
			        
			       PreparedStatement statement = conn.prepareStatement(sql);
			       
			       statement.setString(1, id);
			       statement.setString(2, name);
			       statement.setString(3, summary);       
			       
			      // if (phenotype != null  && !phenotype.isEmpty())
			          	statement.setString(4, drugs);
			      // else
			        //  	statement.setNull(4, java.sql.Types.INTEGER);
			         
			       //statement.setString(4, phenotype);
			       
		//	       if (professorid != null  && !professorid.isEmpty())
			         	statement.setString(5, dose);
			   //    else
			     //    	statement.setNull(5, java.sql.Types.NULL);
			      
			       
			      // statement.setString(5, professorid);
			       statement.setString(6, observation);
			        
			       // sends the statement to the database server
			       int row = statement.executeUpdate();
			       
			       if (row > 0 ) 
			        {
			           message = "An experiment was added successfuly";    
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
		 else  if (request.getParameter("cancel") != null) {
			 
			 Connection conn=null; 
			    String db_url="jdbc:mysql://localhost:3306/trackingsystem";
			    String db_username = "root";
			    String db_password = "1001";
			    String message = null;
			    
			   try{
			       Class.forName("com.mysql.jdbc.Driver");
			       conn = DriverManager.getConnection(db_url,db_username,db_password);
			       System.out.println("connected sucessfully");
			       // constructs SQL statement
			      
			       System.out.println("executing student table query");
			       
			       String sql = "select * from student where studentid = '"+actorid+"'";
				   Statement statement = conn.createStatement();
				   ResultSet rs = statement.executeQuery(sql);
			       
				   System.out.println("executing professr table query");
			       //String sql = "select * from student where studentid=?";
			       //PreparedStatement statement = conn.prepareStatement(sql);
			       //statement.setString(1, actorid);
			       
				   String sql2 = "select * from professor where professorid = '"+actorid+"'";
				   Statement statement2 = conn.createStatement();
				   ResultSet rs2 = statement2.executeQuery(sql2);
			       
			      // String sql2 = "select * from professor where professorid=?";
			       //PreparedStatement statement2 = conn.prepareStatement(sql2);
			       //statement2.setString(1, actorid);
				   System.out.println("again actor id is :" + actorid);
			      // statement.setString(2, name);
			       //ResultSet rs = statement.executeQuery(sql);
				   if(rs.next()){
				    	  
					   System.out.println("at the student condition");
					   
				         //Retrieve by column name
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

				    	   System.out.println("student directed to home page");
				    	   
				    	   message = "student directed to home page";    
				    	   RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/StudentHome.jsp");
				    	   reqDispatcher.forward(request, response);
				    	   rs.close();
				    	   statement.close();
				   }
				   else if (rs2.next()) 
				   {
					   
				      // statement.setString(2, name);
		//		       ResultSet rs2 = statement2.executeQuery(sql2);
			//		   if(rs.next()){
					   
						   //Retrieve by column name
				    	   String professorid = rs2.getString("professorid"); 
				    	   String lastname = rs2.getString("lastname");
				    	   String firstname = rs2.getString("firstname");
				    	   String username = rs2.getString("username");
				    	   String email = rs2.getString("email");
				    	   String major = rs2.getString("major");
				    	   String securityquestion = rs2.getString("securityquestion");
				    	   String securityanswer = rs2.getString("securityanswer");
				    	   Date birthdate = rs2.getDate("dateofbirth");
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
				    	   //request.setAttribute("supervisorid", supervisorid);
				    	   
				    	   getServletContext().getRequestDispatcher("/ProfessorHome.jsp").forward(request, response);
				    	   rs2.close();
						   statement2.close();

//					   }
				   }
				   
				   	
				      conn.close();  
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
			 
		     }
		 }
}
}