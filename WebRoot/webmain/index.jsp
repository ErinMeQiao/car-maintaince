<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
	<head>
		<title>家庭消费管理系统</title>
		<script type="text/javascript">
    		history.go(1);
    	</script>
	</head>
		<%
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0); 
		%>
	<frameset rows="97,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src='<c:url value="/webmain/top.jsp"/>' name="topFrame" scrolling="no" noresize>
		<frameset id="fset" rows="*" cols="190,7,*" framespacing="0" frameborder="0" border="0">
			<frame src='<c:url value="/sysmanage/menumanage/findMenuList.action"/>' name="leftFrame" scrolling="auto" noresize>
			<frame src='<c:url value="/webmain/spliter.jsp"/>' name="middle" scrolling="no" noresize>
			<frame src='<c:url value="/webmain/main.jsp"/>' name="mainFrame" noresize>
		</frameset>
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>