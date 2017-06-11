<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<script src='${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js'></script>
	<%@ include file="/common/jquerymessager/jquerymess.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$.messager.show({
				title:'警告',
				msg:'非法的访问，请重新登录！',
				timeout:5000,
				showType:'slide'
			});
		});
    </script>
</head>
<body>
	<script language="javascript">
		function redirectUrl(redirectTime) 
		{
			setTimeout("top.window.location.href='${pageContext.request.contextPath}/adminlogin.jsp'",redirectTime*1000);
			//setTimeout("javascript:window.opener=null;window.self.close();",redirectTime*1000);
		}
		self.onload=function(){
		};
		redirectUrl(5) //5秒
</script>
</body>
</html>