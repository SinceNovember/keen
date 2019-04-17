<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/style/template.css" media="all">

</head>
<body>
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card layadmin-serach-main">
          <div class="layui-card-header">
            <p style="font-size: 18px;">
              <span style="color: #01AAED">关键词</span> 查询到 
              <strong>${resultCount }</strong> 个结果
            </p>
          </div>
          <div class="layui-card-body">
            
            <ul class="layadmin-serach-list layui-text">
            <c:forEach items="${articleIndexList }" var="a">
              <li>
                <div class="layui-serachlist-text">
                  <h3><a href="${pageContext.request.contextPath }/${a.articleId}">${a.articleTitle }</a></h3>
					${a.htmlContent }                
</div>
              </li>
          </c:forEach>
            </ul>
            
          </div>
        </div>
      </div>
    </div>
  </div>
<jsp:include page="public/headerjs.jsp"></jsp:include>


</body>
</html>