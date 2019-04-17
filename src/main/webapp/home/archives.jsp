<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
 <head>
  <jsp:include page="public/headercss.jsp"></jsp:include>
  </head>
 <body>
    <jsp:include page="public/header.jsp"></jsp:include>

  <div id="content-outer">
   <div class="layout" id="content-inner">
    <div id="archive">
     <div class="article-sort-title">

           ${archiveType} - ${archiveTitle }

     </div>
     <c:if test="${not empty articles }">
     <div class="article-sort">
		<c:forEach items="${articles}" var="a" varStatus="status" begin="0"  end="${articleCount }">
		<c:if test="${articles[status.index].createYear ne articles[status.index-1].createYear}">

		<div class="article-sort-item year">
		<strong>${a.createYear}</strong>
		</div>
		</c:if> 
      <div class="article-sort-item">
       <time class="article-sort-item__time"><fmt:formatDate pattern="yyyy-MM-dd"   value="${a.articleCreateTime }" /></time>
       <a class="article-sort-item__title" href="${pageContext.request.contextPath }/${a.articleId}">${a.articleTitle }</a>
      </div>
		</c:forEach>
     </div>
     </c:if>
    </div>
   </div>
  </div>
  
  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>
 </body>
</html>