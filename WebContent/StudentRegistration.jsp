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

<title>Students Registration</title>
</head>
<body>
<p><p>
<p>Complete the registration form </p>
<form action="uploadServlet1" enctype="multipart/form-data" method="post">
<table style="width:50%">
  <tr>
    <td>Student ID</td>
    <td><input type="text" name="id" value=""></td>	
  </tr>
  <tr>
    <td>First Name</td>
    <td><input type="text" name="fn" value=""></td>	
  </tr>
  <tr>
    <td>Last Name</td>
    <td><input type="text" name="ln" value=""></td>		
  </tr>
    <tr>
    <td>Date Of Birth</td>
    <td><input type="text" name="dob" value="" data-role="datebox" data-options='{"mode":"calbox"}'></td>		
  </tr>
  <tr>
    <td>Email ID</td>
    <td><input type="text" name="email" value=""></td>	
  </tr>
  <tr>
    <td>Major</td>
    <td><input type="text" name="major" value=""></td>		
  </tr>
    <tr>
    <td>Supervisor ID</td>
    <td><input type="text" name="supervisor" value=""></td>		
  </tr>
    <tr>
    <td>Expected Graduate date</td>
    <td><input type="text" name="grad_date" value="" data-role="datebox" data-options='{"mode":"calbox"}'></td>		
  </tr>
  <tr>
    <tr>
    <td>UserName</td>
    <td><input type="text" name="uname" value=""></td>		
  </tr>
  <tr>
    <td>Password</td>
    <td><input type="text" name="pwd" value=""></td>		
  </tr>
  <tr>
    <td>Select security question </td>
    <td><select name="ques">
    <option value="">Select</option>
    <option value="ques1">What is your mother's maiden name?</option>
    <option value="ques2">Where did you born?</option>
    </select></td>		
  </tr>
  <tr>
    <td>Answer</td>
    <td><input type="text" name="ans" value=""></td>
   <tr>
     <td>Upload your photo</td>
     <td><input type="file" name="photo" size="30" /></td></tr>
  
</table><br></br>
<input type ="submit" name="register" value="Submit">
<input type ="submit" name="cancel" value="Cancel">
</form>
</body>
</html>