<%@ page pageEncoding = "GB18030" %>
<% 
	String logined = (String)session.getAttribute("logined");
	if(logined == null || !logined.trim().equals("true")) {
		out.println("���ȵ�¼");
		response.sendRedirect("login.jsp");
	}
%>