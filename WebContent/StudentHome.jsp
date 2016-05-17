<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <link rel="stylesheet" href="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.min.css" />
	 <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/external/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="http://dev.jtsage.com/jQM-DateBox/js/doc.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.core.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.mode.calbox.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.mode.datebox.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.mode.flipbox.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.mode.slidebox.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.mode.customflip.min.js"></script>
    <script type="text/javascript" src="http://cdn.jtsage.com/datebox/i18n/jqm-datebox.lang.utf8.js"></script>
    <script type="text/javascript">
    jQuery.extend(jQuery.mobile,
    {
      ajaxEnabled: false
    });
    </script>

<title>Student Homepage</title>
</head>
<%@page import="java.util.Date"%>
<%@page import="java.io.InputStream"%>

<form action="homeStudent" method="Post">
<body>
<h4>Hello, <%
String lastname = (String) request.getAttribute("lastname");
out.println(lastname);
%></h4>
<%--
<h4> the followings are your personal info. </h4>

<table>
<tr>

<td><h4> Student ID: 
<% String studentid = (String) request.getAttribute("studentid");
out.println(studentid);
session.setAttribute("studentid",studentid);%> 
</h4></td>
<td><h4>First Name:
<% String firstname = (String) request.getAttribute("firstname");
out.println(firstname);
%></h4></td>
</tr>
<tr>
<td><h4>Username:
<% String username = (String) request.getAttribute("username");
out.println(username);
%></h4> </td>

<td><h4>Email:
<% String email = (String) request.getAttribute("email");
out.println(email);
%></h4> </td>
</tr>
<tr>
<td>
<h4>Security Question:
<% String securityquestion = (String) request.getAttribute("securityquestion");
if (securityquestion.equals("ques1"))
	out.println("your Security question is : What is your mother's maiden name?");
else if (securityquestion.equals("ques2"))
	out.println("your Security question is : Where did you born?");
%></h4> </tr>
<tr>
<td><h4>Major:
<% String major = (String) request.getAttribute("major");
out.println(major);
%></h4> </td>

<td>
<h4>SupervisiorID:
<% String supervisorid = (String) request.getAttribute("supervisorid");
out.println(supervisorid);
%></h4> </td> </tr>

<tr>
<td><h4>Birthdate:
<% 
Date birthdate = (Date) request.getAttribute("birthdate");
out.println(birthdate);
%></h4> </td>

<td>
<h4>Graduate Date:
<% Date graduatedate = (Date) request.getAttribute("graduatedate");
out.println(graduatedate);
%></h4> </td>
</tr>
<tr>
<td>
<h4>Photo:
<% //InputStream binaryStream = (InputStream) request.getAttribute("photo");
//out.println(binaryStream);
%></h4> </td>

</tr>
</table>
 --%>
<input type="submit" name="view" value="View Details">
<input type="submit" name="update" value="Update Details">
<input type="submit" name="addcage" value="Add Cage">
<input type="submit" name="addmice" value="Add Mice">
<input type="submit" name="addrack" value="Add Rack">
<input type="submit" name="addexperiment" value="Add Experiment">
<input type="submit" name="addreminder" value="Add Reminder">
<input type="submit" name="logout" value="Logout">

</body>
</form>
</html>