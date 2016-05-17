<%@ page import ="javax.servlet.*"%>
<%@ page import ="javax.servlet.http.*"%>

<HTML>
<body bgcolor="#FFEBCD">
<FORM ACTION="index.jsp" TARGET=_top>
<%!
String uname=" ";
%>

<H2 ALIGN=CENTER><U>LOGOUT</U></H2>
<BR>
<DIV ALIGN=CENTER>
<%
try {
uname=(String)session.getValue("userid");
 if(uname==null) {%>
  <BR><BR>
   <H1><U>No valid Session exist for user try logging in!</U></H1> 
 <%}else {  
    session.invalidate();  %>
    <BR><BR><H3>User<I><%=" "+uname+" "%></I>Logged out.</H3>  
<%}%>
<%}catch(Exception e) { e.printStackTrace();  } %>
<BR><BR><BR><H3><B>To login</B></H3><INPUT TYPE=SUBMIT VALUE=Login>
</DIV>
</BODY>
</HTML>