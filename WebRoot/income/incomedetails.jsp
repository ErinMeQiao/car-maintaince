<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>

<html>
	<head>
	<title>家庭收入信息明细</title>
	<link href='<c:url value="/style/minute.css"/>' rel="stylesheet" type="text/css" />
	</head>
<body>
<div id="mainbody">
  <div id="view">
    <h1><span class="viewinfo">家庭收入 > 收入管理 > 收入信息详细</span></h1>
  </div>
  <div id="userInfo" class="door">
  	<ul>
		<li class="userInfol">收入对象：</li>
		<li class="userInfoR3"><yinbo:id2name colId="intargetid" colName="intargetname" idValue="${incomeInfo.incometarget.intargetid}" tableName="incometarget" /></li>
	</ul>
  	<ul>
		<li class="userInfol">收入者：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${incomeInfo.iuserid}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">收入金额：</li>
		<li class="userInfoR3"><fmt:formatNumber value="${incomeInfo.iamt}" pattern="#,##0.00#" /></li>&nbsp;元
	</ul>
  	<ul>
		<li class="userInfol">收入说明：</li>
		<li class="userInfoR3">${incomeInfo.idescription}</li>
	</ul>
  	<ul>
		<li class="userInfol">收入日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${incomeInfo.idate}" pattern="yyyy-MM-dd"/></li>
	</ul>
	<ul>
		<li class="userInfol">审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${incomeInfo.approvestatus == 0}">未审批</c:if>
		<c:if test="${incomeInfo.approvestatus == 1}">已审批</c:if></li>
	</ul>
  	<ul>
		<li class="userInfol">录入人：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${incomeInfo.enteruser}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">录入日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${incomeInfo.enterdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
  	<ul>
		<li class="userInfol">备注：</li>
		<li class="userInfoR3">${incomeInfo.iremark}</li>
	</ul>
  </div>
    <div class="h10"></div>
    <div class="operateButton">
  	<input name="backbtn" type="button"  class="button_height20" onclick="javascript:window.location.href('${pageContext.request.contextPath}/${urlKey}');" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 返 回 " />
  	</div>
</div>
  </body>
</html>
