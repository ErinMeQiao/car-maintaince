<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>

<html>
	<head>
	<title>家庭理财信息明细</title>
	<link href='<c:url value="/style/minute.css"/>' rel="stylesheet" type="text/css" />
	</head>
<body>
<div id="mainbody">
  <div id="view">
    <h1><span class="viewinfo">家庭理财 > 理财管理 > 理财信息详细</span></h1>
  </div>
  <div id="userInfo" class="door">
  	<ul>
		<li class="userInfol">理财对象：</li>
		<li class="userInfoR3"><yinbo:id2name colId="ftargetid" colName="ftargetname" idValue="${financeInfo.financetarget.ftargetid}" tableName="financetarget" /></li>
	</ul>
	<ul>
		<li class="userInfol">理财方式：</li>
		<li class="userInfoR3"><yinbo:id2name colId="mid" colName="mname" idValue="${financeInfo.changemode.mid}" tableName="changemode" /></li>
	</ul>
  	<ul>
		<li class="userInfol">理财者：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${financeInfo.fuserid}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">理财金额：</li>
		<li class="userInfoR3"><fmt:formatNumber value="${financeInfo.famt}" pattern="#,##0.00#" /></li>&nbsp;元
	</ul>
  	<ul>
		<li class="userInfol">理财说明：</li>
		<li class="userInfoR3">${financeInfo.fdescription}</li>
	</ul>
  	<ul>
		<li class="userInfol">理财日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${financeInfo.fdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
	<ul>
		<li class="userInfol">录入审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${financeInfo.approvestatus == 0}">未审批</c:if>
		<c:if test="${financeInfo.approvestatus == 1}">已审批</c:if></li>
	</ul>
	<ul>
		<li class="userInfol">脱手状态：</li>
		<li class="userInfoR3">
		<c:if test="${financeInfo.ohandstatus == 0}">未脱手</c:if>
		<c:if test="${financeInfo.ohandstatus == 1}">已脱手</c:if></li>
	</ul>
	<ul>
		<li class="userInfol">脱手审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${financeInfo.appohand == 0}">未审批</c:if>
		<c:if test="${financeInfo.appohand == 1}">已审批</c:if></li>
	</ul>
  	<ul>
		<li class="userInfol">录入人：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${financeInfo.enteruser}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">录入日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${financeInfo.enterdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
  	<ul>
		<li class="userInfol">备注：</li>
		<li class="userInfoR3">${financeInfo.fremark}</li>
	</ul>
  </div>
    <div class="h10"></div>
    <div class="operateButton">
  	<input name="backbtn" type="button"  class="button_height20" onclick="javascript:window.location.href('${pageContext.request.contextPath}/${urlKey}');" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 返 回 " />
  	</div>
</div>
  </body>
</html>
