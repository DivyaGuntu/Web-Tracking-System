package tracksystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homePorfessor")
@MultipartConfig(maxFileSize = 16177215)
public class ProfessorHome extends HttpServlet{
 static final long serialVersionUID = 1L;


 public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{

	 
 HttpSession session = request.getSession(true);
	String professorid = (String) session.getAttribute("professorid");
	System.out.println("from professor home . java "+professorid);

	 
	 if (request.getParameter("update") != null) {
		 
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
		    	  
		    	  System.out.println("reterving professor info at professorhome . java "+professorid);
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
		    	 //  Date graduatedate = rs.getDate("graduatedate");
		    	  // String supervisorid = rs.getString("supervisorid");
		    	   
		    	   
		    	   System.out.println( lastname + " " + professorid);
		    	  // request.setAttribute("actorid", studentid);
		    	   request.setAttribute("professorid", professorid);
		    	   request.setAttribute("lastname", lastname);
		    	   request.setAttribute("firstname", firstname);
		    	   request.setAttribute("username", username);
		    	   request.setAttribute("email", email);
		    	   request.setAttribute("major", major);
		    	   request.setAttribute("securityquestion", securityquestion);
		    	   request.setAttribute("securityanswer", securityanswer);
		    	   request.setAttribute("birthdate", birthdate);
		    	   //request.setAttribute("graduatedate", graduatedate);
		    	   //request.setAttribute("supervisorid", supervisorid);
   

		      }  
		      
		//      out.println("</body></html>"); 

		      // Clean-up environment
		      rs.close();
		     statement.close();
		      conn.close();  
		   }
		   
		   catch(Exception e)
		   { e.printStackTrace();} 
		 
	       getServletContext().getRequestDispatcher("/UpdateProfessor.jsp").forward(request, response);	
		 
		 // Invoke FirstServlet's job here.
		} else if (request.getParameter("addcage") != null) {
			request.setAttribute("actorid",professorid);
			getServletContext().getRequestDispatcher("/AddCage.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}
	 	
		else if (request.getParameter("addrack") != null) {
		request.setAttribute("actorid",professorid);
		getServletContext().getRequestDispatcher("/AddRack.jsp").forward(request, response);	
	    // Invoke SecondServlet's job here.
		}
	 
		else if (request.getParameter("addmice") != null) {
			request.setAttribute("actorid",professorid);
			getServletContext().getRequestDispatcher("/AddMice.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}
		else if (request.getParameter("addexperiment") != null) {
			request.setAttribute("actorid",professorid);
			getServletContext().getRequestDispatcher("/AddExperiment.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}
		else if (request.getParameter("addreminder") != null) {
			request.setAttribute("actorid",professorid);
			getServletContext().getRequestDispatcher("/Reminderindex.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}
		else if (request.getParameter("addcolony") != null) {
			request.setAttribute("actorid",professorid);
			getServletContext().getRequestDispatcher("/AddColony.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}

		else if (request.getParameter("logout") != null) {
			//request.setAttribute("actorid",studentid);
			session = null; 
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);	
		    // Invoke SecondServlet's job here.
		}
	 
 /*   Connection conn=null; 
    String db_url="jdbc:mysql://localhost/TrackingSystem";
    String db_username = "root";
    String db_password = "1001";
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
    //  rs.close();
     // statement.close();
      conn.close();  
   }
   
   catch(Exception e)
   { e.printStackTrace();} */
}
}