<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <nav id="pagination">
  <div class="pagination">
 <c:if test="${firstnowPage>1}">
	<a href="${pageContext.request.contextPath }/page/${firstnowPage-1}"><i class="fa fa-chevron-left"></i></a>
    <a class="page-number" href="${pageContext.request.contextPath }/page/1">1</a>
    </c:if>
    <c:if test="${firstnowPage>3 }">
    <span class="space">…</span>
    </c:if>
      <c:if test="${firstnowPage>2 }">
    <a class="page-number" href="${pageContext.request.contextPath }/page/${firstnowPage-1}">${firstnowPage-1 }</a>
    </c:if>
    <span class="page-number current">${firstnowPage }</span>
    <c:if test="${firstnowPage<firsttotalPage-1 }">
    <a class="page-number" href="${pageContext.request.contextPath }/page/${firstnowPage+1}">${firstnowPage+1 }</a>
    </c:if>
    <c:if test="${firstnowPage<firsttotalPage-2 }"><span class="space">…</span></c:if>
    <c:if test="${firstnowPage<firsttotalPage }">
     <a class="page-number" href="${pageContext.request.contextPath }/page/${firsttotalPage }">${firsttotalPage}</a>
    <a class="page-number" href="${pageContext.request.contextPath }/page/${firstnowPage+1}"><i class="fa fa-chevron-right"></i></a>
    </c:if>  
    </div>
    </nav>
   