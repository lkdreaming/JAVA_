<%@ page pageEncoding="GB18030"%>
<%@ page import="java.util.*,java.sql.*,com.lk.bbs.*"%>
<%
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	/*�ж��Ƿ���ͨ��POST�����ύ����������*/
	if (action != null && action.trim().equals("post")) {
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String sql = "insert into article values(null,?,?,?,?,now(),?)";
		Connection conn = DB.getConnection();
		boolean autoCommit = conn.getAutoCommit();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = DB.preparedStatment(conn, sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, 0);
		pstmt.setInt(2, 0);
		pstmt.setString(3, title);
		pstmt.setString(4, cont);
		pstmt.setInt(5, 0);
		pstmt.executeUpdate();
		// ���һ��Statement����,׼��ִ�и��µ�SQL���
		Statement stmt = DB.creatStatement(conn);
		//�Ӹոյ�PreparedStatement ��ִ�е� ��������л��GeneratedKeys.�ŵ�ResultSet������.
		ResultSet rsKey = pstmt.getGeneratedKeys();
		rsKey.next();
		//����rootId ����rsKsy�е� ��һ���ʺ�Ԫ�� ��ֵ���� rootId.
		int rootId = rsKey.getInt(1);
		stmt.executeUpdate("update article set rootid = " + rootId + " where id = "	+ rootId);
		conn.commit();
		conn.setAutoCommit(autoCommit);
		DB.close(pstmt);
		DB.close(conn);
		response.sendRedirect("done.jsp");
	}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java����_������̳|ChinaJavaWorld������̳ : ���������� ...</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS"
	href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?threadID=744236">
<!-- ����CKEditor �̶���ʽ -->
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	window.onload = function() {
		CKEDITOR.replace('cont');
	};
</script>
<!-- ����CKEditor �̶���ʽ ����-->
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td width="140"><a
					href="http://bbs.chinajavaworld.com/index.jspa"><img
						src="images/header-left.gif"
						alt="Java|Java����_������̳|ChinaJavaWorld������̳" border="0"> </a></td>
				<td><img src="images/header-stretch.gif" alt="" border="0"
					height="57" width="100%"></td>
				<td width="1%"><img src="images/header-right.gif" alt=""
					border="0"></td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id="jive-flatpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><p class="jive-breadcrumbs">
							<a href="http://bbs.chinajavaworld.com/index.jspa">��ҳ</a> &#187;
							<a
								href="http://bbs.chinajavaworld.com/forumindex.jspa?categoryID=1">ChinaJavaWorld������̳|Java����_������̳</a>
							&#187; <a
								href="http://bbs.chinajavaworld.com/category.jspa?categoryID=2">Java
								2 Platform, Standard Edition (J2SE)</a> &#187; <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0">Java����*������</a>
						</p>
						<p class="jive-page-title">����������:</p></td>
					<td width="1%"><div class="jive-accountbox"></div></td>
				</tr>
			</tbody>
		</table>
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a
							href="http://bbs.chinajavaworld.com/post%21reply.jspa?threadID=744236"><img
								src="images/reply-16x16.gif" alt="�ظ�������" border="0" height="16"
								width="16"> </a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div id="jive-message-holder">
							<div class="jive-message-list">
								<div class="jive-table">
									<div class="jive-messagebox">
										<table summary="Message" border="0" cellpadding="0"
											cellspacing="0" width="100%">
											<tbody>
												<tr id="jive-message-780144" class="jive-odd" valign="top">
													<td class="jive-first" width="1%">
														<!-- ������Ϣ��table -->
														<table border="0" cellpadding="0" cellspacing="0"
															width="150">
															<tbody>
																<tr>
																	<td><table border="0" cellpadding="0"
																			cellspacing="0" width="100%">
																			<tbody>
																				<tr valign="top">
																					<td style="padding: 0px;" width="1%"><nobr>
																							<a
																								href="http://bbs.chinajavaworld.com/profile.jspa?userID=215489"
																								title="ŵ���׿�">ŵ���׿�</a>
																						</nobr>
																					</td>
																					<td style="padding: 0px;" width="99%"><img
																						class="jive-status-level-image"
																						src="images/level3.gif" title="��������" alt=""
																						border="0"><br>
																					</td>
																				</tr>
																			</tbody>
																		</table> <img class="jive-avatar"
																		src="images/avatar-display.png" alt="" border="0">
																		<br> <br> <span class="jive-description">
																			����: 34 <br> ����: 100<br> ע��: 07-5-10 <br>
																			<a href="http://blog.chinajavaworld.com/u/215489"
																			target="_blank"><font color="red">�����ҵ�Blog</font>
																		</a> </span>
																	</td>
																</tr>
															</tbody>
														</table> <!--������Ϣtable����-->
													</td>
													<td class="jive-last" width="99%"><table border="0"
															cellpadding="0" cellspacing="0" width="100%">
															<tbody>
																<tr>
																	<form action="post.jsp" method="post">
																		<!-- ��������������ҳ���ж�������ͨ��post�����ύ��ȥ�Ļ������ӹ�ȥ�� -->
																		<input type="hidden" name="action" value="post">
																		<!-- ����hidden��������pid,��ԭ����ID��ΪҪ�ظ������ӵĸ�ID -->
																		<input type="hidden" name="pid" value="" />
																		<!-- ����hidden��������rootid,����������ӵ�SQL���ʱ���õ�. -->
																		<input type="hidden" name="rootId" value="" />
																		<td width="100%"
																			style="border-top: 1px solid rgb(204, 204, 204);">����:
																			<input type="text" name="title"> <BR>
																			����:<textarea name="cont" cols="100" rows="30"></textarea>
																			<BR> <input name="Submit" type="submit"
																			value="�ύ"></td>
																	</form>
																</tr>
															</tbody>
														</table></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="jive-message-list-footer">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tbody>
										<tr>
											<td nowrap="nowrap" width="1%"></td>
											<td align="center" width="98%"><table border="0"
													cellpadding="0" cellspacing="0">
													<tbody>
														<tr>
															<td><a
																href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20"><img
																	src="images/arrow-left-16x16.gif" alt="���ص������б�"
																	border="0" height="16" hspace="6" width="16"> </a>
															</td>
															<td><a
																href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20">���ص������б�</a>
															</td>
														</tr>
													</tbody>
												</table></td>
											<td nowrap="nowrap" width="1%">&nbsp;</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div></td>
					<td width="1%"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
