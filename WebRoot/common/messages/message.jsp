<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
	<head>
		<title>执行信息页面</title>
		<link href='<c:url value="/common/messages/style.css"/>'
			rel="stylesheet" type="text/css" />
	</head>
<body>
		<c:set var="success_image"
			value="${pageContext.request.contextPath}/common/messages/images/alert/ok.gif"></c:set>
		<c:set var="error_image"
			value="${pageContext.request.contextPath}/common/messages/images/alert/error.gif"></c:set>
		<div id="alert">
			<div class="left"></div>
			<div class="middle">
				<div class="title">
					<b>提&nbsp;&nbsp;示</b>
				</div>
				<div class="message">
					<s:if test="hasActionMessages()">
						<img src="${success_image}" />
						<s:actionmessage />
					</s:if>
					<s:if test="hasActionErrors()">
						<img src="${error_image}" />
						<s:actionerror />
					</s:if>
					<s:if test="hasFieldErrors()">
						<img src="${error_image}" />
						<s:fielderror />
					</s:if>
					<s:if test="##request.errMes.length()>0">
						<img src="${error_image}" />
						<s:property value="#request.errMes" />
					</s:if>
					<s:if test="hasFieldErrors()">
						<img src="${error_image}" />
						<s:fielderror />
					</s:if>
					<s:if test="exception.message!=null" >
						<img src="${error_image}" />
						<ul class="errorMessage">
            				<li>
            					<span>服务器返回异常，请联系系统管理员!</span>
            				</li>
            			</ul>
					</s:if>
					<s:property value="#exception.message" />
				</div>
				<div class="m_button">
					<c:if test="${urlKey ne null}">[<a href="${pageContext.request.contextPath}/${urlKey}">返 回</a>]</c:if>
				</div>
			</div>
			<div class="right"></div>

		</div>
	</body>
</html>
