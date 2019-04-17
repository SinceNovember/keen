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
              <legend>我的评论</legend>
<p style="text-indent:30px;">评论总数:(<strong id="ccount">${commentCount }</strong>)</p>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="70">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="50">
                    <col width="60">
                </colgroup>
                <thead>
                <tr >
                    <th style="text-align:center;">用户名</th>
                    <th style="text-align:center;"> 评论信息</th>
                    <th style="text-align:center;">我的回复</th>
                    <th style="text-align:center;">评论页面</th>
                    <th style="text-align:center;">日期</th>
                    <th style="text-align:center;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="c">
                    <tr>
                        <td align="center">
                                ${c.commentPname}
                            </td>
                        <td align="center">
                      	  ${c.originalContent}
                        </td>
                        <td align="center" id="${c.commentId}">
                          ${c.commentContent}
                        </td>
                        <td align="center">
                        <a href="${pageContext.request.contextPath }/${c.article.articleId}" target="_blank">
                         ${c.article.articleTitle }
                         </a>
                        </td>
                        
                        <td align="center">
                            <fmt:formatDate value="${c.commentCreateTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td align="center">
                                <button class="layui-btn" type="button" data-index="${c.commentId}" id="reply" data-type="editor">修改</button>
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
					$.post('${pageContext.request.contextPath}/admin/delete_my_comment',
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
 		var t="#"+$(this).attr('data-index');
	    var str="${pageContext.request.contextPath }/admin/jump_editor_comment?cid="+$(this).attr('data-index');
		var c=$(this).parent().parent();
		console.log(c.html());
        layer.open({
	          type: 2
	          ,title: '修改i评论'
	          ,content: str
	          ,maxmin: true
	          ,async: false
	          ,area: ['480px', '350px']
	          ,btn: ['确定', '取消']
	          ,yes: function(index, layero){
	             var comment = window["layui-layer-iframe" + index].callbackdata();
					$.ajax({
						url:'${pageContext.request.contextPath }/admin/editor_my_reply',
						data:comment,
						cache: false,
						dataType:"json",
						success:function(data)
						{
							if(data.success==true)
							{
								$(t).html(comment.commentContent);
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
