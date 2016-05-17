<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
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
uname=document.forms[0].uid.value;
pwd=document.forms[0].pass.value;
if(document.forms[0].uid.value=="")
{
alert("Enter username");
return false;
}
else if(document.forms[0].pass.value=="")
{
alert("Enter password");
return false;
}
else if(uname.length<4 || uname.length>12)
{
alert("Username is of length 4-12 characters");
return false;
}
else if(pwd.length<4 || pwd.length>10)
{
alert("Password is of length 5-10 characters");
return false;
}
}
</script>

<title>Login Application</title>  
</head>  
<body>  
<center>   <form action="LoginServlet" method="post">  
<!--          <fieldset style="width: 300px">  -->
            <legend> Login to Application </legend>  
            <table>
                <tr> 
                 <td>Admin<input type="radio" name="usertype" value="admin" CHECKED></td>
                 <td>Professor<input type="radio" name="usertype" value="professor"></td>
                <td>Student<input type="radio" name="usertype" value="student"></td> 
                </tr>   
                <tr>  
                    <td>User ID</td>  
<!--                     <td><input type="text" name="uid" required="required" /></td>   -->
						<td><input type="text" name="uid" />
                </tr>  
                <tr>  
                    <td>Password</td>  
<!--                      <td><input type="password" name="pass" required="required" /></td> -->
 						<td><input type="password" name="pass" />
                </tr>  
                <tr>  
               <!--     <input type="submit" name="login" value="Login" /></td>  --> 
                </tr>  
				<tr>
				
				</tr>
            </table>  
             <input type="submit" name="login" value="Login" onClick="return valid()" /></td>  
              <input type="submit" name="register" value="Register"></td>
 <!--         </fieldset> --> 
    </form></center>  
</body>  
</html>  