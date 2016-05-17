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
<title>Add Colony</title>
</head>
<body>

<p>Complete the Colony info </p>
<form action="addColony" enctype="multipart/form-data" method="post">
<% String actorid = (String) request.getAttribute("actorid");
    session.setAttribute("actorid",actorid);
    %>
<table style="width:50%">
  <tr>
    <td>Colony ID</td>
    <td><input type="number" name="id" value="" maxlength=4></td>	
  </tr>
  <tr>
    <td>Colony Name</td>
    <td><input type="text" name="name" value="" maxlength=30></td>	
  </tr>
  <tr>
   <td>Select Genotype</td>
    <td><select name="genotype">
    <option value="">Select</option>
    <option value="CDSD">CDSD</option>
    <option value="ZDSD">ZDSD</option>
    </select></td>		
  </tr>
    <tr>
    <td>Phenotype</td>
    <td><input type="number" name="phenotype" value="" maxlength=7></td>		
  </tr>
  <tr>
    <td>Professor ID</td>
    <td><input type="text" name="professorid" value="" maxlength=8></td>		
  </tr>
  <tr>
    <tr>
    <td>Memo</td>
    <td><textarea name="memo" rows="10" cols="50"></textarea></td>		
  </tr>
</table><br></br>
<input type ="submit" name="submit" value="Submit">
<input type ="submit" name="cancel" value="Cancel">
</form>
</body>
</html>