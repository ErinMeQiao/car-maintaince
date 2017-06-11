<%@ page language="java" import="com.yinbo.web.utils.Struts2Utils" pageEncoding="UTF-8"%>
<%@ page import="com.yinbo.orm.support.Page"%>
<%@ include file="/commontags/displaytag.jsp"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<%@ include file="/commontags/yinbotaglibs.jsp"%>
<%@ include file="/common/dateformatexport.jsp"%>
<html>
	<head>
		<title>家庭支出管理</title>
		<link href='<c:url value="/style/displaytag.css"/>' rel="stylesheet" type="text/css" />
		<link href='<c:url value="/style/main_ht.css"/>' rel="stylesheet" type="text/css" />
		<script src='<c:url value="/common/datePicker/WdatePicker.js"/>'></script>
		<script src='${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js'></script>
		<%@ include file="/common/jquerymessager/jquerymess.jsp"%>
		<c:set var="contextvar" value="${pageContext.request.contextPath}/payout"></c:set>
		<script type="text/javascript">
			function delconfirm(id){
				$.messager.confirm('删除提示', '您确定要删除此支出信息吗?', function(r){
					if(r){
						setTimeout(function(){ 
					    	window.location.href = '${contextvar}/payoutdelete.action?payoutInfo.pid='+id;
						},0);
					}
				});
			}
		</script>
		<script type="text/javascript">
			function enappconfirm(id){
				$.messager.confirm('审批提示', '您确定要审批此支出录入信息吗?', function(r){
					if(r){
						setTimeout(function(){ 
					    	window.location.href='${contextvar}/enterapprove.action?payoutInfo.pid='+id;
						},0);
					}
				});
			}
		</script>
	</head>

<body>

<div id="mainbody">
	<div id="view">
    	<h1><span class="viewinfo">家庭支出 > 支出管理</span></h1>
	</div>
	<div class="mycountTable">
		<form action="${contextvar}/payoutlist.action" method="post" id="payoutListForm" name="payoutListForm">
			<div id="userInfo">
			<c:if test="${userObj.roleinfo.roleid == 1}">
			<ul>	  
				<li class="userInfol">支出者</li>
				<li class="userInfoR">
					<yinbo:SelectTag id="pUserid" property="pUserid"
						colid="userid" colname="usename" table="userinfo"
						value="${pUserid}" where=" and userid != 'admin'" style="width:134px;" />
				</li>
			</ul>
			</c:if>
			<ul>
				<li class="userInfol">起始日期</li>
				<li class="userInfoR">
					<input id="startdate" name="startdate" class="Wdate" type="text" value="${startdate}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly/>
				</li>
				<li class="userInfol">结束日期</li>
				<li class="userInfoR">
					<input id="enddate" name="enddate" class="Wdate" type="text" value="${enddate}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly/>
				</li>
				<li class="userInfoR4">
					<input id="merButton" name="merButton" class="button_height20" type="submit" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value=" 查 询 ">
				</li>
			</ul>
			</div>
			<div class="clear"></div>
			<div class="h10"></div>
			<div class="operateButton"></div>
		</form>
		<c:if test="${userObj.roleinfo.roleid != 1}">
		<div style="padding:5px 0;">
			<input type="button" class="button_height20" onmouseover="this.className='button_height20_over'" onmouseout="this.className='button_height20'" value="支出录入" onclick="javascript:window.location='${contextvar}/payoutadd.action'">
		</div>
		</c:if>
		<div class="paytab">
			<display:table sort="external" partialList="true" id="row"
				export="true" name="objList" size="rsSize" class="myTableRight"
				requestURI="${contextvar}/payoutlist.action"
				pagesize="<%=Page.DEFAULT_PAGE_SIZE%>">
				<display:setProperty name="export.pdf.filename" value="merlist${glv_formatdate}.pdf" />
 				<display:setProperty name="export.excel.filename" value="merlist${glv_formatdate}.xls" />
 				<display:setProperty name="export.csv.filename" value="merlist${glv_formatdate}.csv" />
	 			<display:setProperty name="export.xml.filename" value="merlist${glv_formatdate}.xml" />
				<display:column style="white-space: nowrap;"
					title="支出者" class="doccenter">
					<yinbo:id2name colId="userid" colName="usename" idValue="${row.puserid}" tableName="userinfo" isChar="true" cutLength="6" />
				</display:column>
				<display:column style="white-space: nowrap;"
					title="支出对象" class="doccenter">
					<yinbo:id2name colId="ptargetid" colName="ptargetname" idValue="${row.payouttarget.ptargetid}" tableName="payouttarget" />
				</display:column>
				<display:column style="white-space: nowrap;"
					title="支出金额" class="docright">
					<fmt:formatNumber value="${row.pamt}"
					pattern="#,##0.00#" />
				</display:column>
				<display:column style="white-space: nowrap;"
					title="支出日期" class="doccenter">
					<fmt:formatDate  value="${row.pdate}" pattern="yyyy-MM-dd"/>
				</display:column>
				<display:column style="white-space: nowrap;"
					title="支出说明" class="docleft">
					<c:if test="${fn:length(row.pdescription) gt 20}">
						<c:set var="dotString" value="…"></c:set>
						<span title="<c:out value="${row.pdescription}"/>"><c:out value="${fn:substring(row.pdescription,0,20)}${dotString}"/></span>
					</c:if>
					<c:if test="${fn:length(row.pdescription) le 20}">
						<c:out value="${row.pdescription}"/>
					</c:if>
				</display:column>
				<display:column style="white-space: nowrap;"
					title="审批状态" class="doccenter">
					<c:if test="${row.approvestatus == 0}">未审批
					</c:if>
					<c:if test="${row.approvestatus == 1}">已审批
					</c:if>
				</display:column>
				<display:column style="white-space: nowrap;" title="操作" media="html" class="doccenter">
					<c:if test="${userObj.roleinfo.roleid == 1}">
					<c:if test="${row.approvestatus == 0}"><a href='#' onclick='enappconfirm(<c:out value="${row.pid}" />);'><img src='<c:url value="/images/award.png"/>' alt="录入审批" border="0"/></a></c:if>
					</c:if>
					<a href='${contextvar}/payoutdetails.action?payoutInfo.pid=<c:out value="${row.pid}" />'><img src='<c:url value="/images/detail.gif"/>' alt="详细" border="0"/></a>
					<c:if test="${row.approvestatus == 0 || userObj.roleinfo.roleid == 1}">
					<a href='${contextvar}/payoutedit.action?payoutInfo.pid=<c:out value="${row.pid}" />'><img src='<c:url value="/images/page_edit.png"/>' alt="修改" border="0"/></a>
					<a href='#' onclick='delconfirm(<c:out value="${row.pid}" />);'><img src='<c:url value="/images/del.png"/>' alt="删除" border="0"/></a>
					</c:if>
				</display:column>
			</display:table>
		</div>
	</div>
</div>
</body>
</html>
