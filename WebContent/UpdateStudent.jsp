<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.Date"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
 <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <link rel="stylesheet" href="http://cdn.jtsage.com/datebox/1.4.5/jqm-datebox-1.4.5.min.css" />
	
	<script type="text/javascript" src="http://a...content-available-to-author-only...s.com/ajax/libs/jquery/1.8.3/jquery.min.js">
	// $(document).ready(function() {
	//		$('.updatestudent').on('input', function() {
	//			var studentid = document.getElementById('studentid');
	//			var firstname = document.getElementById('fn');
	//			var lastname = document.getElementById('ln');
	//			var birthdate = document.getElementById('dob');
	//			var email = document.getElementById('email');
	//			var supervisorid = document.getElementById('supervisorid');
	//			var major = document.getElementById('major');
	//			var graddate = document.getElementById('graddate');
	//			var securityquestion = document.getElementById('ques');
	//			var securityanswer = document.getElementById('answer');				
					
				
				//session.setAttribute("firstname",firstname);
	//			document.getElementById('fn').value = firstname;
	//			document.getElementById('ln').value = lastname;
			//	if (birthdate != null || birthdate !="")
			//	{
	//				document.getElementById('dob').value = birthdate;
			//	}
			//	else 
			//	{
					//  Date birthdate = (Date) request.getAttribute("birthdate");
			//		document.getElementById('dob').value = birthdate2;
			//	}
				
	//			document.getElementById('email').value = email;
	//			document.getElementById('supervisorid').value = supervisorid;
	//			document.getElementById('major').value = major;
	//			document.getElementById('graddate').value = graddate;
	//			document.getElementById('ques').value = securityquestion;
	//			document.getElementById('answer').value = securityanswer;
				
				
	//		});
	//	});		
	</script>
	
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
    
<title>update student</title>
</head>
<body>
<p><p>
<p>Complete the update form </p>
<form action="updateStudent" enctype="multipart/form-data" method="post">
<table style="width:50%">
  <tr>
    <td>Student ID</td>
    <% String studentid = (String) request.getAttribute("studentid");
    session.setAttribute("studentid",studentid);
    %>
    <td><input type="text" name="id" value="${studentid}" id="studentid" disabled="disabled"></td>		
  </tr>
  <tr>
    <td>First Name</td>
    <% String firstname = (String) request.getAttribute("firstname");%>
    <td><input type="text" class="updatestudent" name="fn" value="${firstname}" id="fn"></td>	
  </tr>
  <tr>
    <td>Last Name</td>
    <% String lastname = (String) request.getAttribute("lastname");%>
    <td><input type="text" name="ln" class="updatestudent" value="${lastname}" id="ln"></td>		
  </tr>
    <tr>
    <td>Date Of Birth</td>
    <% Date birthdate = (Date) request.getAttribute("birthdate");
    %>
    <td><input type="text" name="dob" required class="updatestudent" id="dob" data-role="datebox" data-options='{"mode":"calbox"}'></td>		
  </tr>
  <tr>
	<% String email = (String) request.getAttribute("email");%>
    <td>Email ID</td>
    <td><input type="text" name="email" class="updatestudent" value="${email}" id="email"></td>	
  </tr>
  <tr>
    <td>Major</td>
   <% String major = (String) request.getAttribute("major");%>
    <td><input type="text" name="major" class="updatestudent" value="${major}" id="major"></td>		
  </tr>
    <tr>
    <td>Supervisor ID</td>
	   <% String supervisorid = (String) request.getAttribute("supervisorid");%>
    <td><input type="text" name="supervisor" class="updatestudent" value="${supervisorid}" id="supervisorid" disabled="disabled" ></td>		
  </tr>
    <tr>
    <td>Expected Graduate date</td>
    <% Date graduatedate = (Date) request.getAttribute("graduatedate");%>
    <td><input type="text" name="grad_date" class="updatestudent" id="graddate" data-role="datebox" data-options='{"mode":"calbox"}'></td>		
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
    <td><select name="ques" id="ques" class="updatestudent">
    <option value="ques1">What is your mother's maiden name?</option>
    <option value="ques2">Where did you born?</option>
    </select></td>		
  </tr>
  <tr>
    <td>Answer</td>
   <% String securityanswer = (String) request.getAttribute("securityanswer");%>
    <td><input type="text" name="ans" class="updatestudent" value="${securityanswer}" id="answer"></td>
   <tr>
     <td>Upload your photo</td>
     <td><input type="file" name="photo" size="30" /></td></tr>

	<script>
	function validateRequired()
	{
		var birthdatevalidate = document.getElementById('dob');
		var graddatevalidate = document.getElementById('graddate');
		    
		    if (birthdatevalidate.value == "")
		        return false;
		    else if (graddatevalidate.value=="")
		    	return false;
		    else if(graddatevalidate.value=="" && birthdatevalidate.value=="")
		    	return false;
		    
		var studentid = document.getElementById('studentid').value;
		var firstname = document.getElementById('un').value;
		var firstname = document.getElementById('fn').value;
		var lastname = document.getElementById('ln').value;
//		var birthdate = document.getElementById('dob').value;
		var email = document.getElementById('email').value;
		var supervisorid = document.getElementById('supervisorid').value;
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
		document.getElementById('supervisorid').value = supervisorid;
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