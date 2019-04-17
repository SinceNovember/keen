<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>

  <jsp:include page="public/headercss.jsp"></jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/comment.css">
</head>
 <body>
  <canvas class="fireworks"></canvas>
  <i class="fa fa-arrow-right" id="toggle-sidebar" aria-hidden="true"></i>
  <div id="sidebar">
   <div class="toggle-sidebar-info text-center">
    <span data-toggle="Toggle article">Toggle site</span>
    <hr />
   </div>
   <div class="sidebar-toc">
    <div class="sidebar-toc__title">
     Catalog
    </div>
    <div class="sidebar-toc__progress">
     <span class="progress-notice">You've read</span>
     <span class="progress-num">0</span>
     <span class="progress-percentage">%</span>
     <div class="sidebar-toc__progress-bar"></div>
    </div>
	    <div class="sidebar-toc__content">
     <ol class="toc">
     <c:forEach items="${tocs }" var="toc">
      <li class="toc-item toc-level-2"><a class="toc-link" href="#${toc.tocId}"><span class="toc-number">${toc.tocIndex }.</span> <span class="toc-text">${toc.tocName }</span></a></li>
      </c:forEach>
     </ol>
    </div>
   </div>
   <div class="author-info hide">
	<jsp:include page="public/author_info.jsp"></jsp:include>
   </div>
  </div>
  
  
  <div id="content-outer">
   <div id="top-container" style="background-image:url(${pageContext.request.contextPath}/${page.imagePath })">
    <jsp:include page="public/page_header.jsp"></jsp:include>
    <div id="post-info">
     <div id="post-title">
   ${article.articleTitle }
     </div>
     <div id="post-meta">
     <time class="post-meta__date"><i class="fa fa-calendar" aria-hidden="true"></i> <fmt:formatDate type="date"  value="${article.articleCreateTime }" /></time>
      <span class="post-meta__separator">|</span>
      <c:forEach items="${article.categoryList }" var="c">
      <i class="fa fa-inbox post-meta__icon" aria-hidden="true"></i>
	  <c:if test="${c.categoryPid eq 0}">
		<strong>
     </c:if>
	      <a class="post-meta__categories" href="${pageContext.request.contextPath }/category/archives/${c.categoryId}">${c.categoryName}&nbsp;</a>
          </strong>
	      </c:forEach>

      <div class="post-meta-wordcount">
       <span>阅读总计: </span>
       <span class="word-count">${article. articleViewCount}</span>
       <span class="post-meta__separator">|</span>
       <span>评论总数: ${article.articleCommentCount }</span>
      </div>
     </div>
    </div>
   </div>
   <div class="layout" id="content-inner">
    <article id="post">
     <div class="article-container" id="post-content">
		${ article.htmlContent}
     </div>
    </article>
    
    
    
    <div class="post-copyright">
     <div class="post-copyright__author">
      <span class="post-copyright-meta">作者: </span>
      <span class="post-copyright-info"><a href="/cdn-cgi/l/email-protection#c3b6ada7a6a5aaada6a7">SinceNovember</a></span>
     </div>
     <div class="post-copyright__type">
      <span class="post-copyright-meta">文章类型: </span>
      <span class="post-copyright-info">
      <c:choose>
      <c:when test="${article.articleType eq 1 }">
      原创
      </c:when>
      <c:otherwise>
      转载
      </c:otherwise>
      </c:choose>
      </span>
     </div>
     <div class="post-copyright__notice">
      <span class="post-copyright-meta">Copyright Notice: </span>
      <span class="post-copyright-info">All articles in this blog are licensed under <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/">CC BY-NC-SA 4.0</a> unless stating additionally.</span>
     </div>
    </div>
    

    <div class="post-meta__tag-list">
        <c:forEach items="${article.tagList }" var="t">
     <a class="post-meta__tags" href="${pageContext.request.contextPath }/tag/archives/${t.tagId}">${t.tagName}</a>
     </c:forEach>
     
    </div>

    <div class="addthis_inline_share_toolbox pull-right"></div>
    <nav id="pagination">
     <div class="prev-post pull-left">
     <c:if test="${empty preArticle.articleId}"><a><i class="fa fa-chevron-left"></i>无</a></c:if>
     <c:if test="${not empty preArticle.articleId}">
      <a href="${pageContext.request.contextPath }/${preArticle.articleId}"> <span><i class="fa fa-chevron-left"></i>${preArticle.articleTitle }</span></a>     
      </c:if>

     </div>
     <div class="next-post pull-right">
      <c:if test="${empty nextArticle.articleId}"><a>无<i class="fa fa-chevron-right"></i></a></c:if>
     <c:if test="${not empty nextArticle.articleId}">
      <a href="${pageContext.request.contextPath }/${nextArticle.articleId}"><span>${nextArticle.articleTitle }</span><i class="fa fa-chevron-right"></i></a>
      </c:if>

     </div>
    </nav>
  <jsp:include page="public/comment.jsp"></jsp:include>
  </div>
  </div>
 

  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>


 </body>
</html>