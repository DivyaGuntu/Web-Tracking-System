package tracksystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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

@WebServlet("/addReminder")
@MultipartConfig(maxFileSize = 16177215)

public class addReminder extends HttpServlet {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public addReminder() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		 String actorid = (String) session.getAttribute("actorid");
		 System.out.println("actor id is :" + actorid);

		 if (request.getParameter("submit") != null) {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("        I need to connect to database to store this reminder information.<br />");
		out.println("        We can determine set date of the reminder, and I hope we can know the user\'s id and email by his/her name.<br />");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	
		 }
		 else if (request.getParameter("cancel") != null) {
			 
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
		 
		 
		 

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
