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
    <div class="tag-cloud">
     <div class="tag-cloud__title">
      Tag - 
      <span class="tag-cloud__amount">${tagCount}</span>
     </div>
     <div class="tag-cloud-tags">
     <c:forEach items="${tags }" var="t">
			<a style="font-size:${t.fontSize};color:${t.fontColor}" href="${pageContext.request.contextPath }/tag/archives/${t.tagId}">${t.tagName }</a>
      </c:forEach>
     </div>
    </div>
   </div>
  </div>
 
  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>
 </body>
</html>