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
    <article id="page">
       ${about }

    </article>
   </div>
<%--      <jsp:include page="public/comment.jsp"></jsp:include> --%>
   
  </div>
 
  <jsp:include page="public/footer.jsp"></jsp:include>
  <jsp:include page="public/headerjs.jsp"></jsp:include>
 </body>
</html> 