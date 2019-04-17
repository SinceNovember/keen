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
    <div id="post-content">
     <div class="category-lists">
      <div class="category__title">
       Category - 
       <span class="category__amount">${categoryCount }</span>
      </div>
      <div>
       <ul class="category-list">
       <c:forEach items="${categories }" var="category">
        <li class="category-list-item">
        <a class="category-list-link" href="${pageContext.request.contextPath }/category/archives/${category.categoryId}"><strong>${category.categoryName}</strong></a>
        <span class="category-list-count">${category.articleCount }</span>
         <c:forEach items="${category.childrenCategory}" var="c">
         <ul class="category-list-child">
          <li class="category-list-item">
          <a class="category-list-link" href="${pageContext.request.contextPath }/category/archives/${c.categoryId}">${c.categoryName }</a>
          <span class="category-list-count">${c.articleCount }</span>
          </li>
         </ul>
         </c:forEach>
         </li>
         </c:forEach>
       </ul>
      </div>
     </div>
    </div>
   </div>
  </div>
 
  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>
 </body>
</html>