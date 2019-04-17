<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <div class="author-info__avatar text-center">
     <img src="${pageContext.request.contextPath}/${inform.avatarPath}" width="100px" height="100px"/>
    </div>
    <div class="author-info__name text-center">
    ${inform.pageNickname }
    </div>
    <div class="author-info__description text-center">
${inform.userSignature }
    </div>
	
    <div class="follow-button">
     <a href="https://github.com/SinceNovember">Follow Me</a>
    </div>
    <hr />
    <div class="author-info-articles">
     <a class="author-info-articles__archives article-meta" href="${pageContext.request.contextPath }/archives"><span class="pull-left">Articles</span><span class="pull-right">${articleCount }</span></a>
     <a class="author-info-articles__tags article-meta" href="${pageContext.request.contextPath }/tags"><span class="pull-left">Tags</span><span class="pull-right">${tagCount }</span></a>
     <a class="author-info-articles__categories article-meta" href="${pageContext.request.contextPath }/categories"><span class="pull-left">Categories</span><span class="pull-right">${categoryCount }</span></a>
    </div>
    <hr />

    <div class="author-info-links">
     <div class="author-info-links__title text-center">
      Links
     </div>
	<c:forEach items="${inform.tags }" var="tag">
     <a class="author-info-links__name text-center" href="http://www.github.com/SinceNovember">${tag }</a>
     </c:forEach>
     
    </div>