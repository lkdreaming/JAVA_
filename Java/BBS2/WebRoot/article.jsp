<%@page pageEncoding="GB18030"%>
<%@page import="java.util.*,java.sql.*,com.lk.BBS.*"%>
<%!public void tree(List<Article> articles, Connection conn, int id, int grade) {
		String sql = "select * from article where pid =" + id;
		Statement stmt = DB.getStmt(conn);
		ResultSet rs = DB.executQuery(stmt, sql);
		try {
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setPid(rs.getInt("pid"));
				article.setRootid(rs.getInt("rootid"));
				article.setTitle(rs.getString("title"));
				article.setPdate(rs.getDate("pdate"));
				article.setLeaf(rs.getInt("isLeaf") == 0 ? true : false);
				article.setGrade(grade);
				articles.add(article);
				if (!article.isLeaf()) {
					tree(articles, conn, article.getId(), grade + 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
		}

	}%>

<%
	List<Article> articles = new ArrayList<Article>();
	Connection conn = DB.getConn();
	tree(articles, conn, 0, 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java����_������̳|ChinaJavaWorld������̳ : Java����*������</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS"
	href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript"
	src="images/common.js"></script>
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
	<div id="jive-forumpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="98%"><p class="jive-breadcrumbs">��̳: Java����*������
							(ģ��)</p>
						<p class="jive-description">̽��Java���Ի���֪ʶ,�����﷨�� ���һ����
							��ͬ��ߣ�л���κ���ʽ�Ĺ��</p>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a
							href="http://bbs.chinajavaworld.com/post%21default.jspa?forumID=20"><img
								src="images/post-16x16.gif" alt="����������" border="0" height="16"
								width="16"> </a></td>
						<td class="jive-icon-label"><a id="jive-post-thread"
							href="http://bbs.chinajavaworld.com/post%21default.jspa?forumID=20">����������</a>
							<a
							href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;isBest=1"></a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td><span class="nobreak"> ҳ: 1,316 - <span
							class="jive-paginator"> [ <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0&amp;isBest=0">��һҳ</a>
								| <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0&amp;isBest=0"
								class="">1</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=25&amp;isBest=0"
								class="jive-current">2</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=50&amp;isBest=0"
								class="">3</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=75&amp;isBest=0"
								class="">4</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=100&amp;isBest=0"
								class="">5</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=125&amp;isBest=0"
								class="">6</a> | <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=50&amp;isBest=0">��һҳ</a>
								] </span> </span>
					</td>
				</tr>
			</tbody>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div class="jive-thread-list">
							<div class="jive-table">
								<table summary="List of threads" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th class="jive-first" colspan="3">����</th>
											<th class="jive-author"><nobr> ���� &nbsp; </nobr>
											</th>
											<th class="jive-view-count"><nobr> ��� &nbsp; </nobr>
											</th>
											<th class="jive-msg-count" nowrap="nowrap">�ظ�</th>
											<th class="jive-last" nowrap="nowrap">��������</th>
										</tr>
									</thead>
									<%
										Iterator<Article> it = articles.iterator();
										while (it.hasNext()) {
											Article article = it.next();
											String preStr = "";
											for (int i = 0; i < article.getGrade(); i++) {
												preStr += "----";
											}
									%>
									<tbody>
										<tr class="jive-even">
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="�Ѷ�" border="0"
														height="16" width="16">
													<!-- div-->
												</div></td>
											<td nowrap="nowrap" width="1%">&nbsp; &nbsp;</td>
											<td class="jive-thread-name" width="95%"><a
												id="jive-thread-1"
												href="http://bbs.chinajavaworld.com/thread.jspa?threadID=744236&amp;tstart=25"><%=preStr + article.getTitle()%></a>
											</td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">fei870407</a>
											</span></td>
											<td class="jive-view-count" width="1%">104</td>
											<td class="jive-msg-count" width="1%">5</td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">
													2007-9-13 ����9:31 <br> by: <a
														href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182"
														title="jingjiangjun" style="">jingjiangjun &#187;</a>
												</div></td>
										</tr>
									<%-- 	  
										<tr class="jive-odd">
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="�Ѷ�" border="0"
														height="16" width="16">
													<!-- div-->
												</div></td>
											<td nowrap="nowrap" width="1%">&nbsp; &nbsp;</td>
											<td class="jive-thread-name" width="95%"><a
												id="jive-thread-2"
												href="http://bbs.chinajavaworld.com/thread.jspa?threadID=744234&amp;tstart=25"><%=article.getTitle()%></a>
											</td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="http://bbs.chinajavaworld.com/profile.jspa?userID=226028">403783154</a>
											</span></td>
											<td class="jive-view-count" width="1%">52</td>
											<td class="jive-msg-count" width="1%">2</td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">
													2007-9-13 ����8:40 <br> by: <a
														href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780172#780172"
														title="downing114" style="">downing114 &#187;</a>
												</div></td>
										</tr>
										--%>
									</tbody>
									<%
										}
									%>
								</table>
							</div>
						</div>
						<div class="jive-legend"></div></td>
				</tr>
			</tbody>
		</table>
		<br> <br>
	</div>
</body>
</html>