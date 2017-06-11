<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/strutstaglibs.jsp"%>
<%
    String userid = (String)session.getAttribute("userid"); //登录用户名
    if(userid == null)
    {
	%>
		<jsp:forward page="/common/authoritypage.jsp"/>
	<%
    }
%>