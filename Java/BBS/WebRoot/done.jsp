<%@ page pageEncoding = "GB18030"%>
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
�����ɹ�,ҳ�潫��<span id="time">5</span>���Ӻ��Զ���ת����ҳ.�������ת,��������.
<a href="article.jsp">����</a>
<script type="text/javascript">
	delayURL("articleFlat.jsp");
</script>