<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
<head>
<body>
<jsp:useBean id="datenow" class="java.util.Date" />
<fmt:formatDate var="glv_formatdate" value="${datenow}" type="both" dateStyle="long" pattern="yyyyMMddHHmmss" />
</body>
</html>