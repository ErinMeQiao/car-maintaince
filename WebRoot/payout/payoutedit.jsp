<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.yinbo.utils.DateTimeUtils"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<html>
	<head>
	<title>支出信息修改</title>
	<link href='<c:url value="/style/main_ht.css"/>' rel="stylesheet" type="text/css" />
	<link href='<c:url value="/scripts/formValidator/style/validator.css"/>' rel="stylesheet" type="text/css" />
	<script src='<c:url value="/scripts/formValidator/jquery_last.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidator.js"/>'></script>
	<script src='<c:url value="/scripts/formValidator/formValidatorRegex.js"/>'></script>
	<script src='<c:url value="/common/datePicker/WdatePicker.js"/>'></script>
	<script src='<c:url value="/scripts/payout/payoutupdate.js"/>'></script>
	<script type="text/javascript">
		function formsubmit(){
			$("#payoutupdateForm").submit();
		}
	</script>
	</head>

	<body> 
	<c:set var="contextvar" value="${pageContext.request.contextPath}/payout"></c:set>
	<div id="mainbody">
	  <div id="view">
	    <h1><span class="viewinfo">家庭支出 > 支出管理 > 支出信息修改</span></h1>
	  </div>
	  <form action="${contextvar}/payoutupdate.action" method="post" id="payoutupdateForm" name="payoutupdateForm">
	    <div id="userInfo" class="door">
	  	  <ul>
		  	<li class="userRedstar">
			<span class="redstar"><s:actionerror/></span>
			</li>
		  </ul>
		  <input type="hidden" id="approvestatus" name="payoutInfo.approvestatus" value="${payoutInfo.approvestatus}"/>
		  <input type="hidden" id="pid" name="payoutInfo.pid" value="${payoutInfo.pid}"/>
		  <input type="hidden" id="enterdate" name="payoutInfo.enterdate" value="${payoutInfo.enterdate}"/>
		  <input type="hidden" id="enteruser" name="payoutInfo.enteruser" value="${payoutInfo.enteruser}"/>
	  	  <ul>
			<li class="userInfol">支出方式：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="payoutType" property="payoutInfo.changemode.mid"
									colid="mid" colname="mname" table="changemode"
									value="${payoutInfo.changemode.mid}" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutTypeTip" style="width:250px"></div>
			</li>
		  </ul>
	  	  <ul>
			<li class="userInfol">支出对象：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="payoutTarget" property="payoutInfo.payouttarget.ptargetid"
									colid="ptargetid" colname="ptargetname" table="payouttarget"
									value="${payoutInfo.payouttarget.ptargetid}" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutTargetTip" style="width:250px"></div>
			</li>
		  </ul>
	  	  <ul>
			<li class="userInfol">支出者：</li>
			<li class="userInfoR">
			  <yinbo:SelectTag id="payoutUser" property="payoutInfo.puserid"
									colid="userid" colname="usename" table="userinfo"
									value="${payoutInfo.puserid}" where="and userid != 'admin'" style="width:154px;" />&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutUserTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">支出金额：</li>
			<li class="userInfoR">
			  <input type="text" id="payoutMoney" name="payoutInfo.pamt" value="${payoutInfo.pamt}"/>&nbsp;元&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutMoneyTip" style="width:250px"></div>
			</li>
		  </ul>	  	 
		  <ul>
			<li class="userInfol">支出日期：</li>
			<li class="userInfoR">
			  <input type="text" id="payoutDate"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${payoutInfo.pdate}"/>" name="payoutInfo.pdate"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,maxDate:'<%=DateTimeUtils.getDate()%>'})" class="Wdate"
					style="width: 154px" readonly/>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutDateTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">支出说明：</li>
			<li class="userInfoR">
			  <textarea id="payoutPdescription" name="payoutInfo.pdescription" cols="20" rows="2">${payoutInfo.pdescription}</textarea>&nbsp;<span class="redstar">*</span>
			</li>
			<li class="userInfoR">
			  <div id="payoutPdescriptionTip" style="width:250px"></div>
			</li>
		  </ul>
		  <ul>
			<li class="userInfol">备注：</li>
			<li class="userInfoR">
			  <textarea id="payoutremark" name="payoutInfo.premark" cols="20" rows="2">${payoutInfo.premark}</textarea>
			</li>
			<li class="userInfoR">
			  <div id="payoutremarkTip" style="width:250px"></div>
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