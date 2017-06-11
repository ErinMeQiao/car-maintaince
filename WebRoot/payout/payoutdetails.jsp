<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>

<html>
	<head>
	<title>家庭支出信息明细</title>
	<link href='<c:url value="/style/minute.css"/>' rel="stylesheet" type="text/css" />
	</head>
<body>
<div id="mainbody">
  <div id="view">
    <h1><span class="viewinfo">家庭支出 > 支出管理 > 支出信息详细</span></h1>
  </div>
  <div id="userInfo" class="door">
  	<ul>
		<li class="userInfol">支出方式：</li>
		<li class="userInfoR3"><yinbo:id2name colId="mid" colName="mname" idValue="${payoutInfo.changemode.mid}" tableName="changemode" /></li>
	</ul>
  	<ul>
		<li class="userInfol">支出对象：</li>
		<li class="userInfoR3"><yinbo:id2name colId="ptargetid" colName="ptargetname" idValue="${payoutInfo.payouttarget.ptargetid}" tableName="payouttarget" /></li>
	</ul>
  	<ul>
		<li class="userInfol">支出者：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${payoutInfo.puserid}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">支出金额：</li>
		<li class="userInfoR3"><fmt:formatNumber value="${payoutInfo.pamt}" pattern="#,##0.00#" /></li>&nbsp;元
	</ul>
  	<ul>
		<li class="userInfol">支出说明：</li>
		<li class="userInfoR3">${payoutInfo.pdescription}</li>
	</ul>
  	<ul>
		<li class="userInfol">支出日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${payoutInfo.pdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
	<ul>
		<li class="userInfol">审批状态：</li>
		<li class="userInfoR3">
		<c:if test="${payoutInfo.approvestatus == 0}">未审批</c:if>
		<c:if test="${payoutInfo.approvestatus == 1}">已审批</c:if></li>
	</ul>
  	<ul>
		<li class="userInfol">录入人：</li>
		<li class="userInfoR3"><yinbo:id2name colId="userid" colName="usename" idValue="${payoutInfo.enteruser}" tableName="userinfo" /></li>
	</ul>
  	<ul>
		<li class="userInfol">录入日期：</li>
		<li class="userInfoR3"><fmt:formatDate value="${payoutInfo.enterdate}" pattern="yyyy-MM-dd"/></li>
	</ul>
  	<ul>
		<li class="userInfol">备注：</li>
		<li class="userInfoR3">${payoutInfo.premark}</li>
	</ul>
  </div>
    <div class="h10"></div>
    <div class="operateButton">
  	<input name="backbtn" type="button"  class="button_height20" onclick="javascript:window.location.href('${pageContext.request.contextPath}/${urlKey}');" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 返 回 " />
  	</div>
</div>
  </body>
</html>
