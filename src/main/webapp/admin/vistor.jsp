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

<!--    列表 -->
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
               <fieldset class="layui-elem-field layui-field-title">
              <legend>所有访问者</legend>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="100">
                    <col width="100">
                    <col width="200">
                    <col width="20">                 
                </colgroup>
                <thead>
                <tr>
                    <th style="text-align:center;">时间</th>
                    <th style="text-align:center;">IP</th>
                    <th style="text-align:center;">访问者浏览器</th>
                    <th style="text-align:center;">操作</th>                  
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vistors}" var="vistor">
                    <tr>
                        <td align="center">
                              <i class="layui-icon layui-icon-log"> </i><fmt:formatDate value="${vistor.visitTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                         <td align="center">
                            ${vistor.ip }
                            </td>
                        <td align="center">
                            ${ vistor.browser}
                            </td>        
                                 <td align="center">
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-mini" id="del" data-type="remove" data-index="${vistor.id }">删除</button>
                        </td>                               
                    </tr>
                </c:forEach>
	
                </tbody>

            </table>
<%--                <jsp:include page="public/paging.jsp"></jsp:include> --%>
        </form>
    </div>
      </div>
    </div>	


<jsp:include page="public/headerjs.jsp"></jsp:include>
<script>

  	$("[id=del]").on("click",function(){
			  	var id=$(this).attr('data-index');
			  	var t=$(this).parent().parent();
			  	layer.confirm('确定要删除？', {
			  	  btn: ['确认','取消'] //按钮
			  }, function(){
					$.post('${pageContext.request.contextPath}/admin/delete_vistor',
						   {
							id:id
							},function(d){
								if(d.success==true)
									{
									layer.msg("修改成功");
										t.remove();	
									}else{
									layer.alert(d.msg,{icon:5});
									}
							},'json');
			  });
			  });
  </script>
</body>
</html>
