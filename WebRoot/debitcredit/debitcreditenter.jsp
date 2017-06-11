<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.yinbo.utils.DateTimeUtils"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<html>
	<head>
	<title>借贷录入</title>
	<link href='<c:url value="/style/main_ht.css"/>' rel="stylesheet" type="text/css" />
	<link href='<c:url value="/scripts/formValidator/style/validator.css"/>' rel="stylesheet" type="text/css" />
	<script src='<c:url value="/scripts/formValidator/jquery_last.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidator.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidatorRegex.js"/>'></script>
	<script src='<c:url value="/common/datePicker/WdatePicker.js"/>'></script>
	<script src='<c:url value="/scripts/debitcredit/debitcreditenter.js"/>'></script>
	<script type="text/javascript">
		function formsubmit(){
			$("#debitcreditenterForm").submit();
		}
	</script>
	</head>

	<body> 
	<c:set var="contextvar" value="${pageContext.request.contextPath}/debitcredit"></c:set>
	<div id="mainbody">
	  <div id="view">
	    <h1><span class="viewinfo">家庭借贷 > 借贷管理  > 借贷录入</span></h1>
	  </div>
	  <form action="${contextvar}/debitcreditenter.action" method="post" id="debitcreditenterForm" name="debitcreditenterForm">
	    <div id="userInfo" class="door">
	  	  <ul>
		  	<li class="userRedstar">
			<span class="redstar"><s:actionerror/></span>
			</li>
		  </ul>
		  <input type="hidden" id="restatusapp" name="debitcreditInfo.restatusapp" value="0"/>
		  <input type="hidden" id="approvestatus" name="debitcreditInfo.approvestatus" value="0"/>
		  <input type="hidden" id="repayflag" name="debitcreditInfo.repayflag" value="0"/>
	  	   <ul>
			<li class="userInfol">借贷者：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="debitcreditUser" property="debitcreditInfo.cduser"
									colid="userid" colname="usename" table="userinfo"
									value="${debitcreditInfo.cduser}" where="and userid != 'admin'" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditUserTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">借贷金额：</li>
			<li class="userInfoR">
			  <input type="text" id="debitcreditMoney" name="debitcreditInfo.cdamt" value="${debitcreditInfo.cdamt}"/>&nbsp;元&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditMoneyTip" style="width:250px"></div>
			</li>
		  </ul>	  
		  <ul>
			<li class="userInfol">借贷对方名称：</li>
			<li class="userInfoR">
			  <input id="debitcreditcdname" name="debitcreditInfo.cdname" value="${debitcreditInfo.cdname}"/>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditcdnameTip" style="width:250px"></div>
			</li>
		  </ul>
	  	  <ul>
			<li class="userInfol">借贷标志：</li>
			<li class="userInfoR">
				<select name="debitcreditInfo.cdflag" id="debitcreditInfocdflag" style="width: 155px">
					<option value="">请选择</option>
					<option value="1" <c:if test="${debitcreditInfo.cdflag eq 1}">selected</c:if>>借出</option>
					<option value="0" <c:if test="${debitcreditInfo.cdflag eq 0}">selected</c:if>>贷入</option>
				</select>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR"><div id="debitcreditInfocdflagTip" style="width: 250px"></div></li>
		  </ul>	 	 
		  <ul>
			<li class="userInfol">借贷日期：</li>
			<li class="userInfoR">
			  <input type="text" id="debitcreditDate"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${debitcreditInfo.cddate}"/>" name="debitcreditInfo.cddate"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,maxDate:'<%=DateTimeUtils.getDate()%>'})" class="Wdate"
					style="width: 154px" readonly/>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditDateTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">借贷说明：</li>
			<li class="userInfoR">
			  <textarea id="debitcreditCdescription" name="debitcreditInfo.cddescription" cols="20" rows="2">${debitcreditInfo.cddescription}</textarea>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditCdescriptionTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">备注：</li>
			<li class="userInfoR">
			  <textarea id="debitcreditremark" name="debitcreditInfo.cdremark" cols="20" rows="2">${debitcreditInfo.cdremark}</textarea>
			</li>
			<li class="userInfoR">
			  <div id="debitcreditremarkTip" style="width:250px"></div>
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