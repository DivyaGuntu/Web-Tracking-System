<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <div>
    	<form method="POST" action="addReminder">
    	<% String actorid = (String) request.getAttribute("actorid");
    session.setAttribute("actorid",actorid);
    %>
    	
    		<table>
    		<tr>
    		<td>
    			<span>User Name: </span>
    		</td>
    		<td>
    			<input name="usr" id="usr" />
    		</td>
    		</tr>
    		<tr>
    			<td>
    				Reminder Name:
    			</td>
    			<td>
    				<input name="remname" id="remname" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Reminde Date:
    			</td>
    			<td>
    				<input type="text" name="date" id="date" data-role="datebox" data-options='{"mode":"calbox"}'/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Description:
    			</td>
    			<td>
    				<input name="note" id="note" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Frequency: 
    			</td>
    			<td>
    				<input name="fr" id="fr" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<button type="submit" name="submit" id="sumbit">Submit</button>
    			</td>
    			<td>
    			<!--  	<button type="reset" name="reset">Reset</button> -->
    			<input type="submit" name="cancel" value="Cancel">
    			</td>
    		</tr>
    	</form>
    </div>
  </body>
</html>
