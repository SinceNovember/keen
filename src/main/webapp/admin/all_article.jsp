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
              <legend>所有文章</legend>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="300">
                    <col width="120">
                    <col width="120">
                    <col width="5">
                    <col width="5">
                    <col width="20">
                    <col width="100">
                    <col width="25">
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>所属分类</th>
                    <th>标签</th>
                    <th>点击量</th>
                    <th>评论数</th>
                    <th>发布类型</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${articles}" var="a">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath }/${a.articleId}" target="_blank">
                                ${a.articleTitle }
                            </a>
                            </td>
                        <td>
                            <c:forEach items="${a.categoryList}" var="c">
                                <a href="${pageContext.request.contextPath }/category/archives/${c.categoryId}"
                                   target="_blank">${c.categoryName}</a>
                                &nbsp;
                            </c:forEach>
                         <td>
                            <c:forEach items="${a.tagList}" var="t">
                                <a href="${pageContext.request.contextPath }/tag/archives/${t.tagId}"
                                   target="_blank">${t.tagName}</a>
                                &nbsp;
                            </c:forEach>
                        </td>
                        <td align="center">
                                  <span class="layui-badge layui-bg-cyan">${a.articleViewCount}</span>
                        </td>
                        <td align="center">
                         <span class="layui-badge">${a.articleCommentCount}</span>
                        </td>
                        
                       <td align="center">
                       <c:choose>
                       <c:when test="${a.issueType eq 1}">
                         <span class="layui-badge layui-bg-green">正文</span>
                         </c:when>
                         <c:otherwise>
                         <span class="layui-badge layui-bg-cyan">草稿</span>
                         </c:otherwise>
                         </c:choose>
                        </td>
                        
                        <td>
                            <fmt:formatDate value="${a.articleCreateTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td align="center">
                            <a  lay-href="${pageContext.request.contextPath }/admin/jump_editor_article?aid=${a.articleId}"
                               class="layui-btn layui-btn-mini">编辑</a>
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-mini" id="del" data-type="remove" data-index="${a.articleId }">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                            			<jsp:include page="public/paging.jsp"></jsp:include>
            
        </form>
    </div>
  
    

      </div>
    </div>	


<jsp:include page="public/headerjs.jsp"></jsp:include>
<script>

  	$("[id=del]").on("click",function(){
			  	var aid=$(this).attr('data-index');
			  	var t=$(this).parent().parent();
			  	layer.confirm('确定要删除？', {
			  	  btn: ['确认','取消'] //按钮
			  }, function(){
					$.post('${pageContext.request.contextPath}/admin/delete_article',
						   {
							aid:aid
							},function(d){
								if(d.success==true)
									{
									layer.alert(d.msg,{icon:1},function(){
										 window.location.reload();
									});

									}else{
										layer.msg(d.msg,{icon:5});
									}
							},'json');
			  });
			  });
  </script>
</body>
</html>
