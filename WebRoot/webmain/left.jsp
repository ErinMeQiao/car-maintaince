<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commontags/jstltaglibs.jsp"%>
<html>
  <head>
    <title>平台管理</title>
    <link href='<c:url value="/style/dtree.css"/>' rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/JavaScript" src="<c:url value="/scripts/mytree.js"/>"></script>
</head>
  <body>
  <div class="dtree">
	<!-- JSTL输出 -->
    <a href="javascript: t.openAll();">全部展开</a> | <a href="javascript: t.closeAll();">全部折叠</a>
			<script language="JavaScript">
             t = new dTree('t');
             t.config.target = "mainFrame";
             t.config.useCheckBox=true;
             t.config.imageDir = '../../treeimage/';
             t.reSetImagePath();
             t.config.folderLinks = true;
             
			 //根节点
			 t.add("0","-1","","");//必须的菜单
			 <c:forEach var="menu" items="${menuList}">
			 t.add('${menu.menuid}','${menu.parentmenuid}','${menu.menuname}','${menu.menuurl}');
			 </c:forEach>
			 document.write(t);
         </script>
	</div>
	</body>
</html>
