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

<title>Add New Cage</title>
</head>
<body>
<p><p>
<p>Complete the Cage info </p>
<form action="addCage" enctype="multipart/form-data" method="post">
 <% String actorid = (String) request.getAttribute("actorid");
    session.setAttribute("actorid",actorid);
    %>
<table style="width:50%">
  <tr>
    <td>Cage ID</td>
    <td><input type="text" name="id" value="" maxlength=4></td>	
  </tr>
  <tr>
    <td>Number of Mice</td>
    <td><input type="number" name="numberofmice" value="" maxlength=2></td>	
  </tr>
    <tr>
    <td>Space</td>
    <td><input type="number" name="space" value="" maxlength=4></td>		
  </tr>
  <tr>
    <td>Colony ID</td>
    <td><input type="number" name="colonyid" value="" maxlength=4></td>		
  </tr>
  <tr>
    <td>Rack ID</td>
    <td><input type="text" name="rackid" value="" maxlength=4></td>		
  </tr>
  <tr>
    <td>Mouse 1 ID</td>
    <td><input type="number" name="mouse1id" value="" maxlength=6 min=6></td>		
  </tr>
  <tr>
    <td>Mouse 2 ID</td>
    <td><input type="number" name="mouse2id" value="" maxlength=6 min=6></td>		
  </tr>
  <tr>
    <td>Mouse 3 ID</td>
    <td><input type="number" name="mouse3id" value="" maxlength=6 min=6></td>		
  </tr>
  <tr>
    <td>Mouse 4 ID</td>
    <td><input type="number" name="mouse4id" value="" maxlength=6 min=6></td>		
  </tr>
  <tr>
    <td>Mouse 5 ID</td>
    <td><input type="number" name="mouse5id" value="" maxlength=6 min=6></td>		
  </tr>
</table><br></br>
 <input type ="submit" name="submit" value="Submit">
 <input type ="submit" name="cancel" value="Cancel">
</form>
</body>
</html>