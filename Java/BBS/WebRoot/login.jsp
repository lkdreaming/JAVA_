<%@ page pageEncoding="GB18030"%>

<%
	boolean logined = false;
	String action = request.getParameter("action");
	String username = "";
	String password = "";
	if (action != null && action.trim().equals("login")) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		if (username == null || !username.equals("admin")) {
			out.println("username is incorrect!");
		} else if (password == null || !password.equals("admin")) {
			out.println("password is incorrect!");
		} else {
		/* �����¼�ɹ�,��session��loginedֵ���ó�true		*/
			session.setAttribute("logined", "true");
			response.sendRedirect("articleFlat.jsp");
		
		}
	}
%>


<head>
<title>��¼</title>

</head>
<body>
	<form action="login.jsp" method="post">

		<table align="center">
			<input type="hidden" name="action" value="login" />
			<tr>
				<td align="right">�û���:</td>
				<td><input type="text" name="username" value="<%=username%>" />
				</td>
			<tr>
				<td align="right">����:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="�ύ" /><input name="reset" type="reset" value="����"></td>
				<!-- 			<td> -->
				<!-- 				<input name="reset" type="reset" value="����"> -->
				<!-- 			</td> -->
			</tr>


		</table>




	</form>
</body>