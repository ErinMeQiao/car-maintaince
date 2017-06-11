<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/commontags/strutstaglibs.jsp"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
	<head>
		<title>异常信息页面</title>
		<link href='<c:url value="/common/messages/style.css"/>'
			rel="stylesheet" type="text/css" />
			<link href='<c:url value="/merchant/style/displaytag.css"/>'
			rel="stylesheet" type="text/css" />
		<link href='<c:url value="/merchant/style/style.css"/>'
			rel="stylesheet" type="text/css" />
		<link href='<c:url value="/merchant/style/table.css"/>'
			rel="stylesheet" type="text/css" />
	</head>
	<body>
		<s:debug></s:debug>
		<div id="alert">
			<div class="left"></div>
			<div class="middle">
				<div class="title">
					<b>提&nbsp;&nbsp;示</b>
				</div>
				<div class="message">				
						<img src="${pageContext.request.contextPath}/common/messages/images/alert/error.gif" />
						<ul class="errorMessage">
            				<li>
            					<span>服务器返回异常，请联系系统管理员!</span>
            				</li>
            			</ul>	
            			</div>
            			<!-- 
            			<div class="m_button">
					[<a href="javascript:window.opener=null;window.open('','_self');window.close();" >关闭窗口</a>]
				</div>
				 -->	
            			</div>	
					<div class="right"></div>
				</div>
	</body>
</html>
