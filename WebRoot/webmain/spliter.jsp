<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
<head>
    <title>平台管理</title>
	<META content="MSHTML 6.00.2600.0" name=GENERATOR>
	<link href="<c:url value='/style/basic.css'/>" rel="stylesheet" type="text/css" />
	<SCRIPT language=javascript>
	function expand()
	{
		if(parent.fset.cols=="190,7,*")
		{
			document.all.expandpic.src="<c:url value='/images/hide.gif'/>";
			parent.fset.cols="0,7,*";
			document.all.expandpic.src="<c:url value='/images/show.gif'/>";
		}
		else
		{
			document.all.expandpic.src="<c:url value='/images/hide.gif'/>";
			parent.fset.cols="190,7,*";

	}
}
</SCRIPT>
<style>
<!--
.spm{ background:#D9D9D9;}
-->
</style>
</HEAD>
<!-- 
	.spm{ background:#c0deae;}
 -->
<BODY leftMargin=0 topMargin=0>
<TABLE width="7" height="100%" border=0 cellPadding=0 cellSpacing=0>
  <TBODY>
  <TR>
      <td class="spm">
      <div align="center">
        <img src="<c:url value='/images/hide.gif'/>" alt="显示/隐藏菜单" name="expandpic" id=expandpic style="CURSOR: hand" onClick="javascript:expand()">
      </div>
    </TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>
