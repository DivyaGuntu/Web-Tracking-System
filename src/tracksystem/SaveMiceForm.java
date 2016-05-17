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

@WebServlet("/addMice")
@MultipartConfig(maxFileSize = 16177215)
public class SaveMiceForm extends HttpServlet{
 static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{
	
	HttpSession session = request.getSession(true);
	 String actorid = (String) session.getAttribute("actorid");
	 System.out.println("actor id is :" + actorid);

	 if (request.getParameter("submit") != null) {
		 
	 
				 String Mid = request.getParameter("mouceid");
				 String DoB = request.getParameter("dateofbirth");
				 String sex = request.getParameter("sex");
				// SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			     java.util.Date d;
			     String gtype = request.getParameter("genotype");
			     String ptype = request.getParameter("phenotype");
			     String weight = request.getParameter("weight");
			     String cid = request.getParameter("colonyid");
			     String cgid = request.getParameter("cageid");
			     String rid = request.getParameter("rackid");
			     String momid = request.getParameter("motherid");
			     String dadid = request.getParameter("fatherid");
			     String DoD = request.getParameter("dateofdeath");
			     
			     String strain = request.getParameter("Strain");
			     System.out.println(strain);
			     //String answ = request.getParameter("ans");
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
			     String memo = request.getParameter("memo");
			     String onset = request.getParameter("diseaseonset");   
			    Connection conn=null; 
			    String db_url="jdbc:mysql://localhost/trackingsystem";
			    String db_username = "root";
			    String db_password = "1001";
			    String message = null;
			    
			   try{
			       Class.forName("com.mysql.jdbc.Driver");
			       conn = DriverManager.getConnection(db_url,db_username,db_password);
			       // constructs SQL statement
			       String sql = "insert into mouse (mouceid,dateofbirth,sex,genotype,phenotype,weight,colonyid,cageid,rackid,motherid,fatherid,dateofdeath,strain,memo,diseaseonset,photo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			       PreparedStatement statement = conn.prepareStatement(sql);
			
			       statement.setInt(1, Integer.parseInt(Mid));//1 mouceid (Int)
			       try {
			     		d = new SimpleDateFormat("MM/dd/yyyy").parse(DoB);
			     		statement.setDate(2, new java.sql.Date(d.getTime()));//2 dateofbirth (Date)
			     	   } catch (ParseException e1) {
			     		e1.printStackTrace();
			       	}
			       statement.setString(3, sex); // 3 sex (vcar)
			       statement.setString(4, gtype);//4 genotype (vcar)
			       //statement.setInt(5, Integer.parseInt(ptype));// 5 phenotype (Int)
			       statement.setString(5, ptype);// 5 phenotype (Int)
			//       statement.setDouble(6, Double.parseDouble(weight));//statement.setString(6, weight);// 6 weight (decimal)
			       statement.setString(6,weight);//statement.setString(6, weight);// 6 weight (decimal)
			       
			       if (cid != null  && !cid.isEmpty())
			       	statement.setString(7, cid);
			       else
			       	statement.setNull(7, java.sql.Types.INTEGER);
			       
			//       statement.setString(7, cid);//7 colonyid (int)
			   
			       if (cgid != null  && !cgid.isEmpty())
			          	statement.setString(8, cgid);
			          else
			          	statement.setNull(8, java.sql.Types.NULL);
			//       statement.setString(8, cgid); // 8 cageid(vcar)
			       if (rid != null  && !rid.isEmpty())
			          	statement.setString(9, rid);
			          else
			          	statement.setNull(9, java.sql.Types.NULL);
			//       statement.setString(9, rid);//9 rackid(var)
			      
			       //statement.setInt(10, Integer.parseInt(momid));//10 motherid (Int)
			       //statement.setInt(11, Integer.parseInt(dadid));// 11 fatherid ()
			       if (momid != null  && !momid.isEmpty())
			         	statement.setString(10, momid);
			         else
			         	statement.setNull(10, java.sql.Types.NULL);
			       //statement.setString(10, momid);//10 motherid (Int)
			       if (dadid != null  && !dadid.isEmpty())
			         	statement.setString(11, dadid);
			         else
			         	statement.setNull(11, java.sql.Types.NULL);
			       //statement.setString(11, dadid);// 11 fatherid ()
			       
			       try {
			     		d = new SimpleDateFormat("MM/dd/yyyy").parse(DoD);
			     		statement.setDate(12, new java.sql.Date(d.getTime()));//12 dateofdeath(Date)
			     	   } catch (ParseException e1) {
			     		e1.printStackTrace();
			       	}
			       statement.setString(13, strain); //13  strain(vcar)
			       statement.setString(14, memo);// 14 memo(text)
			       try {
			     		d = new SimpleDateFormat("MM/dd/yyyy").parse(onset);
			     		statement.setDate(15, new java.sql.Date(d.getTime()));//15 diseaseonset(Date)
			     	   } catch (ParseException e1) {
			     		e1.printStackTrace();
			       	}
			       if (inputStream != null) {
			           // fetches input stream of the upload file for the blob column
			           statement.setBlob(16, inputStream);//16 photo(BLOB)
			       }
			
			       // sends the statement to the database server
			       int row = statement.executeUpdate();
			        if (row > 0) {
			           message = "Mouse Record added";
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

//				   }
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