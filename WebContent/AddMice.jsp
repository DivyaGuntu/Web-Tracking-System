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

<title>Add New Mice</title>
</head>
<body>
<p><p>
<p>Complete the Mice Form </p>
<form action="addMice" enctype="multipart/form-data" method="post">
<% String actorid = (String) request.getAttribute("actorid");
    session.setAttribute("actorid",actorid);
    %>

<table style="width:50%">
  <tr>
    <td>Mouse ID</td>
    <td><input type="text" name="mouceid" value="" placeholder="Type-Int" maxlength=4 ></td>	
  </tr>
  <tr>
    <td>Date of birth</td>
    <td><input type="text" name="dateofbirth" value="" placeholder="mm/dd/yyyy" maxlength=10 data-role="datebox" data-options='{"mode":"calbox"}'></td>	
  </tr>
        <tr>
   <td>Select Sex</td>
    <td><select name="sex">
    <option value="">Select</option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    </select></td>		
  </tr>	
   <!--
    <tr>
    <td>sex</td>
  <td><select name="Sex">
    <option value="">Select</option>
    <option value="Male">Strain1</option>
    <option value="Female">Strain2</option>
    </select></td>		

  </tr> -->
 <!--   <tr>
    <td>Genotype</td>
    <td><input type="text" name="genotype" value="Genotype"></td>	
  </tr>-->
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
    <td><input type="text" name="phenotype" value="" placeholder="Type-Int Size-7" maxlength=7 ></td>		
  </tr>
    <tr>
    <td>Weight</td>
    <td><input type="text" name="weight" value=""placeholder="Type-decimal Size-6" maxlength=6 ></td>		
  </tr>
    <tr>
    <td>Colony ID</td>
    <td><input type="text" name="colonyid" value="" placeholder="Type-Int Size-4" maxlength=4 ></td>		
  </tr>
  <tr>
    <tr>
    <td>Cage ID</td>
    <td><input type="text" name="cageid" value="" placeholder="Type-String Size-4" maxlength=4 ></td>		
  </tr>
  <tr>
    <td>Rack ID</td>
    <td><input type="text" name="rackid" value="" placeholder="Type-String Size-4" maxlength=4 ></td>		
  </tr>
    <tr>
    <td>Mother ID</td>
    <td><input type="text" name="motherid" value="" placeholder="Type-Int Size-6" maxlength=6 ></td>		
  </tr>
      <tr>
    <td>Father ID</td>
    <td><input type="text" name="fatherid" value="" placeholder="Type-Int Size-6" maxlength=6 ></td>		
  </tr>
  <tr>
    <td>Date of Death</td>
    <td><input type="text" name="dateofdeath" value="" placeholder="mm/dd/yyyy" maxlength=10 data-role="datebox" data-options='{"mode":"calbox"}'></td>		
  </tr>
  <tr>
    <td>Strain</td>
    <td><select name="Strain">
    <option value="">Select</option>
    <option value="Strain1">Strain1</option>
    <option value="Strain2">Strain2</option>
    </select></td>		
  </tr>
  
   <tr>
     <td>Upload your photo</td>
     <td><input type="file" name="photo" size="30" /></td>
     </tr>
<!--     
    <tr>
    <td>Memo</td>
    <td><input type="text" name="memo" value="memo"></td>		
  </tr> -->
    <tr>
    <tr>
    <td>Memo</td>
    <td><textarea name="memo" rows="10" cols="50"></textarea></td>		
  </tr>
      <tr>
    <td>Diseaseonset</td>
    <td><input type="text" name="diseaseonset" value="" placeholder="mm/dd/yyyy" maxlength=10 data-role="datebox" data-options='{"mode":"calbox"}' ></td>		
  </tr>
</table><br></br>
<input type ="submit" name="submit" value="Submit">
<input type ="submit" name="cancel" value="Cancel">

</form>
</body>
</html>