<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
<head>
		<title>家庭消费管理系统登录</title>
		<link href="<c:url value='/style/adminlogin.css'/>" rel="stylesheet" type="text/css" />
		<script src='${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js'></script>
		<%@ include file="/common/jquerymessager/jquerymess.jsp"%>
		<script type="text/javascript">
		function changeVanCode(){		
		    $("#kaptchafield").focus();
			var src = "${pageContext.request.contextPath}/Kaptcha.jpg?param="+Math.round(Math.random()*10000);
			$("#checkImage").attr({ src: src, alt: "Kaptcha.jpg" });
		}
    </script>
	</head>
<body>
<s:if test="hasActionErrors()">
	<s:iterator value="actionErrors">  
	   <script language="JavaScript">
	        $.messager.alert('信息提示','<s:property escape="false"/>','error');
	   </script>
	</s:iterator>
</s:if>
<center>
<div id="wrapper">
<s:form action="/login/adminlogin.action" theme="simple" styleId="loginForm" method="post">
  <div id="cont">
    <ul>
      <li>用户ID</li>
      <li>
		<s:textfield name="userid" maxlength="18" cssClass="inputstyle"></s:textfield>
	  </li>
    </ul>
    <ul>
      <li>密&nbsp;&nbsp;&nbsp;&nbsp;码</li>
      <li>
        <s:password name="pwd" cssClass="inputstyle" maxlength="18"></s:password>
      </li>
    </ul>
	<ul>
		<li>验证码</li>
		<li style="text-align:left;">
		<s:textfield name="kaptchafield" id="kaptchafield" cssClass="inputstyle" maxlength="4" size="4"></s:textfield>
		</li>
		<li class="onepage2"><img border="0" id="checkImage" src="${pageContext.request.contextPath}/Kaptcha.jpg" /></li>
		<li class="onepage"><a id="changeImage" href="javascript:changeVanCode()">换一张</a></li>
	</ul>
  </div>
  <div id="enterht"><input type="image" src='${pageContext.request.contextPath}/images/enterht.gif'"/></div>
 </s:form>
</div>
</center>
</body>
</html>
