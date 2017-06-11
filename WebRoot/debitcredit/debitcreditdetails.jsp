<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>

<html>
	<head>
	<title>家庭借贷信息明细</title>
	<link href='<c:url value="/style/minute.css"/>' rel="stylesheet" type="text/css" />
	</head>
<body>
<div id="mainbody">
  <div id="view">
    <h1><span class="viewinfo">家庭借贷 > 借贷管理 > 借贷信息详细</span></h1>
  </div>
  <div id="userInfo" class="door">
  	<ul>
		<li class="userInfol">借贷者：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${debitcreditInfo.cduser}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">借贷金额：</li>
		<li class="userInfoR3"><fmt:formatNumber value="${debitcreditInfo.cdamt}" pattern="#,##0.00#" /></li>&nbsp;元
	</ul>
  	<ul>
		<li class="userInfol">借贷对方名称：</li>
		<li class="userInfoR3">${debitcreditInfo.cdname}</li>
	</ul>
  	<ul>
		<li class="userInfol">借贷说明：</li>
		<li class="userInfoR3">${debitcreditInfo.cddescription}</li>
	</ul>
  	<ul>
		<li class="userInfol">借贷日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${debitcreditInfo.cddate}" pattern="yyyy-MM-dd"/></li>
	</ul>
	<ul>
		<li class="userInfol">借贷标志：</li>
		<li class="userInfoR3">
		<c:if test="${debitcreditInfo.cdflag == 0}">贷入</c:if>
		<c:if test="${debitcreditInfo.cdflag == 1}">借出</c:if></li>
	</ul>
		<ul>
		<li class="userInfol">偿还标志：</li>
		<li class="userInfoR3">
		<c:if test="${debitcreditInfo.repayflag == 0}">未偿还</c:if>
		<c:if test="${debitcreditInfo.repayflag == 1}">已偿还</c:if></li>
	</ul>
	<ul>
		<li class="userInfol">偿还审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${debitcreditInfo.restatusapp == 0}">未审批</c:if>
		<c:if test="${debitcreditInfo.restatusapp == 1}">已审批</c:if></li>
	</ul>
	<ul>
		<li class="userInfol">录入审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${debitcreditInfo.approvestatus == 0}">未审批</c:if>
		<c:if test="${debitcreditInfo.approvestatus == 1}">已审批</c:if></li>
	</ul>
  	<ul>
		<li class="userInfol">录入人：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${debitcreditInfo.enteruser}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">录入日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${debitcreditInfo.enterdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
  	<ul>
		<li class="userInfol">备注：</li>
		<li class="userInfoR3">${debitcreditInfo.cdremark}</li>
	</ul>
  </div>
    <div class="h10"></div>
    <div class="operateButton">
  	<input name="backbtn" type="button"  class="button_height20" onclick="javascript:window.location.href('${pageContext.request.contextPath}/${urlKey}');" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 返 回 " />
  	</div>
</div>
  </body>
</html>
