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
      <label class="layui-form-label">名称 <span style="color: #FF5722; ">*</span>	 </label>
      <div class="layui-input-inline">
                        <input type="text"  id="categoryName" value="${category.categoryName }" placeholder="请输入分类名称" autocomplete="off" class="layui-input" required>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">父节点<span style="color: #FF5722; ">*</span></label>
      <div class="layui-input-inline">
            <select name="type" id="categoryPid">
                      <c:forEach items="${parentCategories}" var="c">
                            <option value="${c.categoryId }">${c.categoryName}</option>
                      </c:forEach>
                    </select>
          </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">排序编号</label>
      <div class="layui-input-inline">
                        <input type="text" id="categoryOrder" value="${category.categoryOrder }" placeholder="请输入排序编号" autocomplete="off" class="layui-input" >
      </div>
    </div>
        <div class="layui-form-item">
      <label class="layui-form-label">分类描述</label>
      <div class="layui-input-inline">
                        <input type="text" id="categoryDescription" value="${category.categoryDescription }" placeholder="请输入分类描述" autocomplete="off" class="layui-input" >
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
    			   categoryId:${category.categoryId},
					categoryName:$('#categoryName').val(),
					categoryPid:$('#categoryPid').val(),
					categoryOrder:$('#categoryOrder').val(),
					categoryDescription:$('#categoryDescription').val()
    	   };
    	   return data;
    	  }
    </script>
</html>