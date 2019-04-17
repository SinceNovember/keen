<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <div class="layui-card-body"  align="center">
            <div id="test-laypage-demo1">
            <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-2">
		      <c:choose >
		         <c:when test="${firstnowPage>1}">
				<a href="${pageContext.request.contextPath }/admin/${type}/1">首页</a>
				<a href="${pageContext.request.contextPath }/admin/${type}/${firstnowPage-1}">上一页</a>
				  <a class="page-number" href="${pageContext.request.contextPath }/admin/${type}/1">1</a>
				</c:when>
			  <c:otherwise>
				<a class="layui-laypage-prev layui-disabled">首页</a>
				<a  class="layui-laypage-prev layui-disabled">上一页</a>
			  </c:otherwise>
			  </c:choose>
	  		  <c:if test="${firstnowPage>3 }">
	  		  <span class="space">…</span>
	  		  </c:if>
	   		   <c:if test="${firstnowPage>2 }">
	 		   <a class="page-number" href="${pageContext.request.contextPath }/admin/${type}/${firstnowPage-1}" class="layui-laypage-em">${firstnowPage-1 }</a>
			    </c:if>
			    <span class="layui-laypage-curr" style="background-color:#009688;"><em>${firstnowPage }</em></span>
			    <c:if test="${firstnowPage<firsttotalPage-1 }">
			    <a class="page-number" href="${pageContext.request.contextPath }/admin/${type}/${firstnowPage+1}" class="layui-laypage-em">${firstnowPage+1 }</a>
			    </c:if>
			    <c:if test="${firstnowPage<firsttotalPage-2 }"><span class="space">…</span></c:if>
			     <c:choose >
	            <c:when test="${firstnowPage<firsttotalPage }">
	                 <a class="page-number" href="${pageContext.request.contextPath }/admin/${type}/${firsttotalPage }">${firsttotalPage}</a>
			    <a  href="${pageContext.request.contextPath }/admin/${type}/${firstnowPage+1}">下一页</a>
			    <a href="${pageContext.request.contextPath }/admin/${type}/${firsttotalPage }" >尾页</a>
				</c:when>
				<c:otherwise>
			    <a  class="layui-laypage-prev layui-disabled">下一页</a>
			    <a   class="layui-laypage-prev layui-disabled">尾页</a>
				</c:otherwise>
				</c:choose>

            </div>
            </div>
          </div>