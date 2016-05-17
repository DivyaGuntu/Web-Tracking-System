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
 <script language="javascript">
function valid()
{
pid=document.forms[0].id.value;
fname=document.forms[0].fn.value;
lname=document.forms[0].ln.value;
dob1=document.forms[0].dob.value;
email1=document.forms[0].email.value;
major1=document.forms[0].major.value;
uname=document.forms[0].uname.value;
pwd1=document.forms[0].pwd.value;
ques=document.forms[0].ques.value;
ans1=document.forms[0].ans.value;
pic=document.forms[0].photo.value;
if(document.forms[0].id.value=="")
{
alert("Enter your employee id ");
return false;
}
else if(document.forms[0].fn.value=="")
{
alert("Enter first name");
return false;
}
else if(document.forms[0].ln.value=="")
{
alert("Enter last name");
return false;
}
else if(document.forms[0].dob.value=="")
{
alert("Enter date of birth");
return false;
}
else if(document.forms[0].email.value=="")
{
alert("Enter your Email");
return false;
}
else if(document.forms[0].major.value=="")
{
alert("Enter major");
return false;
}
else if(document.forms[0].uname.value=="")
{
alert("choose username");
return false;
}
else if(document.forms[0].pwd.value=="")
{
alert("Enter password");
return false;
}
else if(document.forms[0].ques.value=="")
{
alert("Please select question");
return false;
}
else if(document.forms[0].ans.value=="")
{
alert("Enter answer");
return false;
}
else if(document.forms[0].photo.value=="")
{
alert("Please upload photo");
return false;
}
else if(pid.length<4 || pid.length>8)
{
alert("Your id is of length 4-8 characters");
return false;
}
else if(pwd.length<4 || pwd.length>10)
{
alert("Password is of length 5-10 characters");
return false;
}
else if(fname.length<4 || fname.length>20)
{
alert("First name is of length 4-20 characters");
return false;
}
else if(lname.length<4 || lname.length>20)
{
alert("Last name is of length 4-20 characters");
return false;
}
else if(uname.length<4 || uname.length>12)
{
alert("Username is of length 4-12 characters");
return false;
}
else if(ans.length<1 || ans.length>50)
{
alert("Length of answer should be less than 50");
return false;
}
}
</script>

<title>Registration</title>
</head>
<body>
<p><p>
<p>Complete the registration form </p>
<form action="uploadServlet" enctype="multipart/form-data" method="post">
<table style="width:50%">
  <tr>
    <td>Professor ID</td>
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
    <tr>
    <td>UserName</td>
    <td><input type="text" name="uname" value=""></td>		
  </tr>
  <tr>
    <td>Password</td>
    <td><input type="password" name="pwd" value=""></td>		
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
<input type ="submit" name="register" value="Submit" onClick="return valid()">
<input type ="submit" name="cancel" value="Cancel">
</form>
</body>
</html>