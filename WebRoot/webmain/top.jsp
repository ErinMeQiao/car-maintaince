<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>平台管理</title>
	<link href="<c:url value='/style/basic.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="logo"><img src='<c:url value="/images/logo.gif"/>' width="361" height="65"/></div>
  <div id="topInfo" style="width:230px;font-weight:normal;">
  	<table width="210px">
      <tr>
        <td width="130px"><label style="vertical-align:middle;">欢迎您：</label><yinbo:id2name colName="usename" colId="userid" idValue="${userid}" tableName="userinfo"/></td>
        <td width="80px">
          <img alt="安全退出" style="vertical-align:middle;" src='<c:url value='/images/exit.gif'/>' />&nbsp;&nbsp;<a href='${pageContext.request.contextPath}/login/adminlogout.action' target="_top" onclick="return confirm('确定要退出吗?');">退出系统</a></td>
      </tr>
    </table>
  </div>
</div>
<div id="headerBottomOne">
  <div id="imgpt">
  	<img src='<c:url value="/images/ptgl.gif"/>' width="100" height="28" alt="平台管理" />
  </div>
  <div class="clear"></div>
</div>
</body>
</html>
