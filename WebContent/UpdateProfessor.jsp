<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
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
    
<%@page import="java.util.Date"%>

<title>Update Professor</title>
</head>
<form action="updateProfessor" enctype="multipart/form-data" method="post">
<table style="width:50%">
  <tr>
    <td>Professor ID</td>
    <% String professorid = (String) request.getAttribute("professorid");
    session.setAttribute("professorid",professorid);
    %>
    <td><input type="text" name="id" value="${professorid}" id="professorid" disabled="disabled"></td>		
  </tr>
  <tr>
    <td>First Name</td>
    <% String firstname = (String) request.getAttribute("firstname");%>
    <td><input type="text" class="updateprofessor" name="fn" value="${firstname}" id="fn"></td>	
  </tr>
  <tr>
    <td>Last Name</td>
    <% String lastname = (String) request.getAttribute("lastname");%>
    <td><input type="text" name="ln" class="updateprofessor" value="${lastname}" id="ln"></td>		
  </tr>
    <tr>
    <td>Date Of Birth</td>
    <% Date birthdate = (Date) request.getAttribute("birthdate");
    %>
    <td><input type="text" name="dob" required class="updateprofessor" id="dob" data-role="datebox" data-options='{"mode":"calbox"}'></td>		
  </tr>
  <tr>
	<% String email = (String) request.getAttribute("email");%>
    <td>Email ID</td>
    <td><input type="text" name="email" class="updateprofessor" value="${email}" id="email"></td>	
  </tr>
  <tr>
    <td>Major</td>
   <% String major = (String) request.getAttribute("major");%>
    <td><input type="text" name="major" class="updateprofessor" value="${major}" id="major"></td>		
  </tr>
  <tr>
    <tr>
    <td>UserName</td>
	 <% String username = (String) request.getAttribute("username");%>
    <td><input type="text" name="uname" value="${username}" id="uname" disabled="disabled"></td>		
  </tr>
  <tr>
    <td>Password</td>
    <td><input type="text" name="pwd" disabled="disabled"></td>		
  </tr>
  <tr>
    <td>Select security question </td>
    <td><select name="ques" id="ques" class="updateprofessor">
    <option value="ques1">What is your mother's maiden name?</option>
    <option value="ques2">Where did you born?</option>
    </select></td>		
  </tr>
  <tr>
    <td>Answer</td>
   <% String securityanswer = (String) request.getAttribute("securityanswer");%>
    <td><input type="text" name="ans" class="updateprofessor" value="${securityanswer}" id="answer"></td>
   <tr>
     <td>Upload your photo</td>
     <td><input type="file" name="photo" size="30" /></td></tr>

	<script>
	function validateRequired()
	{
		var birthdatevalidate = document.getElementById('dob');
		//var graddatevalidate = document.getElementById('graddate');
		    
		    if (birthdatevalidate.value == "")
		        return false;
		  //  else if (graddatevalidate.value=="")
		   // 	return false;
		   // else if(graddatevalidate.value=="" && birthdatevalidate.value=="")
		   // 	return false;
		    
		var professorid = document.getElementById('professorid').value;
		var firstname = document.getElementById('un').value;
		var firstname = document.getElementById('fn').value;
		var lastname = document.getElementById('ln').value;
//		var birthdate = document.getElementById('dob').value;
		var email = document.getElementById('email').value;
//		var supervisorid = document.getElementById('supervisorid').value;
		var major = document.getElementById('major').value;
//		var graddate = document.getElementById('graddate').value;
		var securityquestion = document.getElementById('ques').value;
		var securityanswer = document.getElementById('answer').value;				
			
		
		//session.setAttribute("firstname",firstname);
		document.getElementById('fn').value = firstname;
		document.getElementById('ln').value = lastname;
	//	if (birthdate != null || birthdate !="")
	//	{
	//		document.getElementById('dob').value = birthdate;
	//	}
	//	else 
	//	{
			//  Date birthdate = (Date) request.getAttribute("birthdate");
	//		document.getElementById('dob').value = birthdate2;
	//	}
		
		document.getElementById('email').value = email;
//		document.getElementById('supervisorid').value = supervisorid;
		document.getElementById('major').value = major;
	//	document.getElementById('graddate').value = graddate;
		document.getElementById('ques').value = securityquestion;
		document.getElementById('answer').value = securityanswer;
	}
	</script>
 </table><br></br>
<input type ="submit" name="update" value="Submit Changes" onclick="return validateRequired()">
<input type ="submit" name="cancel" value="Cancel">
</form>
</body>
</html>