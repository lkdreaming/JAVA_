<%@ page import="java.sql.*,com.lk.bbs.*" pageEncoding="GB18030"%>

<%
	request.setCharacterEncoding("GBK");
%>

<%
			/*	����CKEditor�̶���ʽ*/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String title = new String(request.getParameter("title").getBytes(
			"GB18030"), "GBK");
	String cont = new String(request.getParameter("cont").getBytes(
			"GB18030"), "GBK");
			/*	����CKEditor�̶���ʽ����*/
	int pid = 0;
	int rootId = 0;
	try {
		pid = Integer.parseInt(request.getParameter("pid"));
		rootId = Integer.parseInt(request.getParameter("rootId"));
	} catch (NumberFormatException e) {
		out.println("ҳ�治����");
	}

	String sql = "insert into article values(null,?,?,?,?,now(),?)";
	Connection conn = DB.getConnection();
	boolean autoCommit = conn.getAutoCommit();
	conn.setAutoCommit(false);
	PreparedStatement pstmt = DB.preparedStatment(conn, sql);
	pstmt.setInt(1, pid);
	pstmt.setInt(2, rootId);
	pstmt.setString(3, title);
	pstmt.setString(4, cont);
	pstmt.setInt(5, 0);
	pstmt.executeUpdate();   
	Statement stmt = DB.creatStatement(conn);
	//isleaf=1 ��˼����Ҷ�ӽڵ�:���»ظ��õ����ӵĸ���ID��Ϊ ����Ҷ�ӽڵ�.
	stmt.executeUpdate("update article set isleaf = 1 where id =" + pid);
	conn.commit();
	conn.setAutoCommit(autoCommit);
	DB.close(pstmt);
	DB.close(stmt);
	DB.close(conn);
	response.sendRedirect("done.jsp");
%>
<!--  
<script language="JavaScript1.2" type="text/javascript">

//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
	//����innerHTML���ܶ�������delayΪһ������
    if(delay > 0) {
		delay--;
		document.getElementById("time").innerHTML = delay;
	}else {
		window.top.location.href = url;
	}
	setTimeout("delayURL('" + url + "')", 1000);  
	//ÿ��time������һ��
}



</script>

<!-- Place this in the 'body' section -->
�ظ��ɹ�,ҳ�潫��<span id="time">5</span>���Ӻ��Զ���ת����ҳ.�������ת,��������.
<a href="article.jsp">����</a>
<script type="text/javascript">
	delayURL("article.jsp");
</script>
-->