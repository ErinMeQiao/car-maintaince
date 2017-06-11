<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.yinbo.utils.DateTimeUtils"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<html>
	<head>
	<title>理财录入</title>
	<link href='<c:url value="/style/main_ht.css"/>' rel="stylesheet" type="text/css" />
	<link href='<c:url value="/scripts/formValidator/style/validator.css"/>' rel="stylesheet" type="text/css" />
	<script src='<c:url value="/scripts/formValidator/jquery_last.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidator.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidatorRegex.js"/>'></script>
	<script src='<c:url value="/common/datePicker/WdatePicker.js"/>'></script>
	<script src='<c:url value="/scripts/finance/financeenter.js"/>'></script>
	<script type="text/javascript">
		function formsubmit(){
			$("#financeenterForm").submit();
		}
	</script>
	</head>

	<body> 
	<c:set var="contextvar" value="${pageContext.request.contextPath}/finance"></c:set>
	<div id="mainbody">
	  <div id="view">
	    <h1><span class="viewinfo">家庭理财  > 理财录入</span></h1>
	  </div>
	  <form action="${contextvar}/financeenter.action" method="post" id="financeenterForm" name="financeenterForm">
	    <div id="userInfo" class="door">
	  	  <ul>
		  	<li class="userRedstar">
			<span class="redstar"><s:actionerror/></span>
			</li>
		  </ul>
		  <input type="hidden" id="approvestatus" name="financeInfo.approvestatus" value="0"/>
		  <input type="hidden" id="ohandstatus" name="financeInfo.ohandstatus" value="0"/>
		  <input type="hidden" id="appohand" name="financeInfo.appohand" value="0"/>
	  	  <ul>
			<li class="userInfol">理财对象：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="financeTarget" property="financeInfo.financetarget.ftargetid"
									colid="ftargetid" colname="ftargetname" table="financetarget"
									value="${financeInfo.financetarget.ftargetid}" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeTargetTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">理财方式：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="financeType" property="financeInfo.changemode.mid"
									colid="mid" colname="mname" table="changemode"
									value="${financeInfo.changemode.mid}" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeTypeTip" style="width:250px"></div>
			</li>
		  </ul>
	  	   <ul>
			<li class="userInfol">理财者：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="financeUser" property="financeInfo.fuserid"
									colid="userid" colname="usename" table="userinfo"
									value="${financeInfo.fuserid}" where="and userid != 'admin'" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeUserTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">理财金额：</li>
			<li class="userInfoR">
			  <input type="text" id="financeMoney" name="financeInfo.famt" value="${financeInfo.famt}"/>&nbsp;元&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeMoneyTip" style="width:250px"></div>
			</li>
		  </ul>	  	 
		  <ul>
			<li class="userInfol">理财日期：</li>
			<li class="userInfoR">
			  <input type="text" id="financeDate"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${financeInfo.fdate}"/>" name="financeInfo.fdate"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,maxDate:'<%=DateTimeUtils.getDate()%>'})" class="Wdate"
					style="width: 154px" readonly/>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeDateTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">理财说明：</li>
			<li class="userInfoR">
			  <textarea id="financeFdescription" name="financeInfo.fdescription" cols="20" rows="2">${financeInfo.fdescription}</textarea>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="financeFdescriptionTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">备注：</li>
			<li class="userInfoR">
			  <textarea id="financeremark" name="financeInfo.fremark" cols="20" rows="2">${financeInfo.fremark}</textarea>
			</li>
			<li class="userInfoR">
			  <div id="financeremarkTip" style="width:250px"></div>
			</li>
		  </ul>
	    </div>
	    <div class="h10"></div>
	    <div class="operateButton">
	      <input name="userButton" type="button" onclick="formsubmit()" class="button_height20" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 确 定 " />
	    </div>
	  </form>
	</div>
	</body>
</html>