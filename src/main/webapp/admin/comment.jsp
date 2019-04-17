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
              <legend>用户评论</legend>
<p style="text-indent:30px;">评论总数:(<strong id="ccount">${commentCount }</strong>)</p>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="40">
                    <col width="40">
                    <col width="300">
                    <col width="200">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th style="text-align:center;">评论者</th>
                    <th style="text-align:center;"> 头像</th>
                    <th style="text-align:center;">评论内容</th>
                    <th style="text-align:center;">评论页面</th>
                    <th style="text-align:center;">日期</th>
                    <th style="text-align:center;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="c">
                    <tr>
                        <td align="center">
                                ${c.commentAuthorName }
                            </td>
                            <td align="center">
                               <img src="${pageContext.request.contextPath}/${c.commentAvatarPath}" alt="" width="45" height="45" style="border-radius: 50%">
                            </td>
                        <td align="center">
                      	  ${c.commentContent}
                        </td>
                        <td align="center">
                        <a href="${pageContext.request.contextPath }/${c.article.articleId}" target="_blank">
                         ${c.article.articleTitle }
                         </a>
                        </td>

                        
                        <td>
                            <fmt:formatDate value="${c.commentCreateTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td align="center">
                                <button class="layui-btn" type="button" data-index="${c.commentId}" id="reply" data-type="editor">回复</button>
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-mini" id="del" data-type="remove" data-index="${c.commentId }">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
<%--         <%@ include file="paging.jsp" %> --%>
    </div>
  
    

      </div>
    </div>	
    
<jsp:include page="public/headerjs.jsp"></jsp:include>

  <script>
  	$("[id=del]").on("click",function(){
			  	var cid=$(this).attr('data-index');
			  	var t=$(this).parent().parent();
			  	var ccount=$("#ccount").text();
			  	layer.confirm('确定要删除？', {
			  	  btn: ['确认','取消'] //按钮
			  }, function(){
					$.post('${pageContext.request.contextPath}/admin/delete_comment',
						   {
							cid:cid
							},function(d){
								if(d.success==true)
									{
									t.remove();
									$("#ccount").text(ccount-1);
									layer.msg('删除成功');
									}else{
									layer.alert("删除失败",{icon:5});
									}
							},'json');
			  });
			  });
  	
 	$("[id=reply]").on("click",function(){
	    var str="${pageContext.request.contextPath }/admin/jump_reply_comment?cid="+$(this).attr('data-index');
		var c=$(this).parent().parent();
        layer.open({
	          type: 2
	          ,title: '回复评论'
	          ,content: str
	          ,maxmin: true
	          ,async: false
	          ,area: ['480px', '350px']
	          ,btn: ['确定', '取消']
	          ,yes: function(index, layero){
	             var comment = window["layui-layer-iframe" + index].callbackdata();
	             console.log(comment);
					$.ajax({
						url:'${pageContext.request.contextPath }/admin/insert_reply',
						data:comment,
						cache: false,
						dataType:"json",
						success:function(data)
						{
							if(data.success==true)
							{
								layer.alert(data.msg,{icon:1});
							}
							else
								layer.msg("修改失败");
						}
					});
					layer.close(index);
	          }
	        }); 
 	});
  </script>
</body>
</html>
