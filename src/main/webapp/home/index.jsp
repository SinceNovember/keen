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

  <div id="content-outer" >
   <div class="layout" id="content-inner">
   
   <c:forEach items="${articles }" var="a">
       <div class="recent-post-item article-container">
     <a class="article-title" href="${pageContext.request.contextPath}/${a.articleId}">${a.articleTitle }</a>
     <time class="post-meta__date"><i class="fa fa-calendar" aria-hidden="true"></i> <fmt:formatDate pattern="yyyy-MM-dd"  value="${a.articleCreateTime }" /></time>
     <span class="article-meta">
     <span class="article-meta__separator">|</span>
     <c:forEach items="${a.categoryList }" var="c">
     <i class="fa fa-inbox article-meta__icon" aria-hidden="true"></i><a class="article-meta__categories" href="${pageContext.request.contextPath }/category/archives/${c.categoryId}">
     <c:if test="${c.categoryPid eq 0}">
		<strong>
     </c:if>
          ${c.categoryName }
          </strong>
     </a>
     </c:forEach>    </span>
     <span class="article-meta tags"><span class="article-meta__separator">|</span>
        <c:forEach items="${a. tagList}" var="t">
     <i class="fa fa-tag article-meta__icon" aria-hidden="true"></i><a class="article-meta__tags" href="${pageContext.request.contextPath }/tag/archives/${t.tagId}">${t.tagName }</a>
     </c:forEach>
     </span>
          <span class="article-meta tags"><span class="article-meta__separator">|</span>
     <i class="fa fa-eye"></i>${a.articleViewCount}
     </span>
     
               <span class="article-meta tags"><span class="article-meta__separator">|</span>
     <i class="fa fa-comment"></i>${a.articleCommentCount}
     </span>
     <div class="content">
   	  ${a.summary}
     </div>
     <a class="more" href="${pageContext.request.contextPath}/${a.articleId}">Read more</a>
     <hr />
    </div>
  </c:forEach>
    
 <jsp:include page="public/paging.jsp"></jsp:include>
   </div>
  </div>
  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>
    
 </body>
</html>