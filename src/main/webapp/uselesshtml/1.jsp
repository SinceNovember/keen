<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="blog" />
<html>
<head>
    <title>个人博客后台管理</title>
   <%@include file="/admin/common/head.jspf" %>
<!--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css"> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script> --%>

    <style type="text/css">
        body {
            font-family: microsoft yahei;
        }
        
    </style>
</head>
<body class="easyui-layout">
<a href="test">aaa</a>
<div region="north" style="height: 78px; background-color: #E0ECFF">  
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">   
</div>
<div data-options="region:'center'" style="background:#eee;">  
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">  
</div>
</body>
</html>