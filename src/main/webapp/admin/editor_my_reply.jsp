<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
</head>
<body>

  <div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin" style="padding: 20px 0 0 0;">
    <div class="layui-form-item">
      <label class="layui-form-label">回复给:</label>
      <div class="layui-input-inline">
        <input type="text"  id="tagName" value="${comment.commentAuthorName }" disabled="disabled" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">回复内容:</label>
      <div class="layui-input-inline">
        <textarea style="width: 245px; height: 100px;" lay-verify="phone" placeholder="请输入回复内容" id="replyContent" autocomplete="off" class="layui-input">${comment.commentContent }</textarea>
      </div>
    </div>
    <div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
  </div>

<jsp:include page="public/headerjs.jsp"></jsp:include>

    <script>
    var callbackdata = function () {
    	   var data = {
			commentId:${comment.commentId},
    	    commentContent:$("#replyContent").val()
     	  }
    	   return data;

    }
    </script>
</html>