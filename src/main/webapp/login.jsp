<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Admin Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css">
    </head>
    <body>
        <div class="page-container">
            <h1>Login</h1>
            <form action="${pageContext.request.contextPath }/login">
                <input type="text" id="userName" name="userName" class="username" placeholder="Username">
                <input type="password" id="userPass" name="userPass" class="password" placeholder="Password">
                <button type="submit" id="login">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                
                    <a  href="https://www.github.com/SinceNovember"><i class="fa fa-github fa-3x" style=" color:#FFF;"></i></a>
                                    </p>
            </div>
        </div>
		  <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/supersized.3.2.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/supersized-init.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/scripts.js"></script>

</body>
</html>
