<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.yinbo.utils.DateTimeUtils"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<html>
	<head>
	<title>收入信息修改</title>
	<link href='<c:url value="/style/main_ht.css"/>' rel="stylesheet" type="text/css" />
	<link href='<c:url value="/scripts/formValidator/style/validator.css"/>' rel="stylesheet" type="text/css" />
	<script src='<c:url value="/scripts/formValidator/jquery_last.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidator.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidatorRegex.js"/>'></script>
	<script src='<c:url value="/common/datePicker/WdatePicker.js"/>'></script>
	<script src='<c:url value="/scripts/income/incomeupdate.js"/>'></script>
	<script type="text/javascript">
		function formsubmit(){
			$("#incomeupdateForm").submit();
		}
	</script>
	</head>

	<body> 
	<c:set var="contextvar" value="${pageContext.request.contextPath}/income"></c:set>
	<div id="mainbody">
	  <div id="view">
	    <h1><span class="viewinfo">家庭收入 > 收入管理 > 收入信息修改</span></h1>
	  </div>
	  <form action="${contextvar}/incomeupdate.action" method="post" id="incomeupdateForm" name="incomeupdateForm">
	    <div id="userInfo" class="door">
	  	  <ul>
		  	<li class="userRedstar">
			<span class="redstar"><s:actionerror/></span>
			</li>
		  </ul>
		  <input type="hidden" id="approvestatus" name="incomeInfo.approvestatus" value="${incomeInfo.approvestatus}"/>
		  <input type="hidden" id="iid" name="incomeInfo.iid" value="${incomeInfo.iid}"/>
		  <input type="hidden" id="enterdate" name="incomeInfo.enterdate" value="${incomeInfo.enterdate}"/>
		  <input type="hidden" id="enteruser" name="incomeInfo.enteruser" value="${incomeInfo.enteruser}"/>
	  	  <ul>
			<li class="userInfol">收入对象：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="incomeTarget" property="incomeInfo.incometarget.intargetid"
									colid="intargetid" colname="intargetname" table="incometarget"
									value="${incomeInfo.incometarget.intargetid}" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="incomeTargetTip" style="width:250px"></div>
			</li>
		  </ul>
	  	  <ul>
			<li class="userInfol">收入者：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="incomeUser" property="incomeInfo.iuserid"
									colid="userid" colname="usename" table="userinfo"
									value="${incomeInfo.iuserid}" where="and userid != 'admin'" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="incomeUserTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">收入金额：</li>
			<li class="userInfoR">
			  <input type="text" id="incomeMoney" name="incomeInfo.iamt" value="${incomeInfo.iamt}"/>&nbsp;元&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="incomeMoneyTip" style="width:250px"></div>
			</li>
		  </ul>	  	 
		  <ul>
			<li class="userInfol">收入日期：</li>
			<li class="userInfoR">
			  <input type="text" id="incomeDate"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${incomeInfo.idate}"/>" name="incomeInfo.idate"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,maxDate:'<%=DateTimeUtils.getDate()%>'})" class="Wdate"
					style="width: 154px" readonly/>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="incomeDateTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">收入说明：</li>
			<li class="userInfoR">
			  <textarea id="incomeCdescription" name="incomeInfo.idescription" cols="20" rows="2">${incomeInfo.idescription}</textarea>
			</li>
			<li class="userInfoR">
			  <div id="incomeCdescriptionTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">备注：</li>
			<li class="userInfoR">
			  <textarea id="incomeremark" name="incomeInfo.iremark" cols="20" rows="2">${incomeInfo.iremark}</textarea>
			</li>
			<li class="userInfoR">
			  <div id="incomeremarkTip" style="width:250px"></div>
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