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

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            访问量
            <span class="layui-badge layui-bg-blue layuiadmin-badge">周</span>
          </div>
          <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font">9,999,666</p>
            <p>
              总计访问量 
              <span class="layuiadmin-span-color">88万 <i class="layui-inline layui-icon layui-icon-flag"></i></span>
            </p>
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            总文章数
            <i class="layui-icon layui-icon-list" style="font-size:25px;color:#1e9fff"></i>
          </div>
          <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font" >${articleCount }</p>
            <p>
              <a lay-href="${pageContext.request.contextPath }/admin/articles/1">
				查看所有
              <span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-down"></i></span>
            </a>
            </p>
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            总评论数
            <i class="layui-icon layui-icon-reply-fill" style="color:#1e9fff"></i>
          </div>
          <div class="layui-card-body layuiadmin-card-list">

            <p class="layuiadmin-big-font">${commentCount}</p>
            <p>
              <a lay-href="${pageContext.request.contextPath }/admin/comment">
				查看所有
              <span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-down"></i></span>
            </a>
            </p>
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            总标签数
               <i class="layui-icon layui-icon-note" style="color:#1e9fff"></i>
          </div>
          <div class="layui-card-body layuiadmin-card-list">

            <p class="layuiadmin-big-font">${tagCount }</p>
            <p>
              <a lay-href	="${pageContext.request.contextPath }/admin/jump_tag">
				查看所有
              <span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-down"></i></span>
            </a>
            </p>
          </div>
        </div>
      </div>   
      <div class="layui-col-sm4">
        <div class="layui-card">
          <div class="layui-card-header">最新评论</div>
          <div class="layui-card-body">
            <ul class="layuiadmin-card-status layuiadmin-home2-usernote">
            <c:forEach items="${comments }" var="c">
              <li>
                <h3>  <img src="${pageContext.request.contextPath }/${c.commentAvatarPath}" class="layui-nav-img">${c.commentAuthorName }</h3>
                <p>${c.commentContent }</p>
                <span><fmt:formatDate type="both"  value="${c.commentCreateTime }" /></span>
                <button type="button" data-index="${c.commentId}" id="reply"  class="layui-btn layui-btn-xs layuiadmin-reply">回复</button>
              </li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
      <div class="layui-col-sm8">
        <div class="layui-row layui-col-space15">
          <div class="layui-col-sm12">
            <div class="layui-card">
              <div class="layui-card-header">最新发布文章<i class="layui-icon layui-icon-file-b" style="font-size: 20px;"></i>  
              </div>
              <div class="layui-card-body">
                <table class="layui-table layuiadmin-page-table">
                   <colgroup>
                    <col width="300">
                    <col width="150">
                    <col width="100">
                    <col width="150">
                </colgroup>
                  <thead>
                    <tr>
                      <th >标题</th>
                      <th>分类</th>
                      <th style="text-align:center;">发布类型</th>
                      <th style="text-align:center;">发布时间</th>
                    </tr> 
                  </thead>
                  <tbody>
                  <c:forEach items="${recentArticles }" var="a">
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
                            </td>
                      <td align="center">                       
                      <c:choose>
                       <c:when test="${a.issueType eq 1}">
                         <span class="layui-badge layui-bg-green">正文</span>
                         </c:when>
                         <c:otherwise>
                         <span class="layui-badge layui-bg-cyan">草稿</span>
                         </c:otherwise>
                         </c:choose></td>
                      <td align="center"><i class="layui-icon layui-icon-log"> </i>  <fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
				</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

          <div class="layui-col-sm12">
            <div class="layui-card">
              <div class="layui-card-header">最新日志<i class="layui-icon layui-icon-notice" style="font-size: 20px;"></i> </div>
              <div class="layui-card-body">
                <div class="layui-row layui-col-space15">
                  <div class="layui-col-sm12">
                    <table class="layui-table layuiadmin-page-table">
                    <colgroup>
                    <col width="300">
                    <col width="150">
                    <col width="100">
                    <col width="150">
                </colgroup>
                      <thead>
                        <tr>
                          <th>详细内容</th>
                          <th style="text-align:center;">类型</th>
                          <th style="text-align:center;">ip</th>
                          <th style="text-align:center;">时间</th>
                        </tr> 
                      </thead>
                      <tbody>
                      <c:forEach items="${logs }" var="log">
                        <tr>
                          <td>${log.detail }</td>
                          <td align="center">${log.type }</td>
                          <td align="center">${log.ip }</td>
                           <td align="center"><i class="layui-icon layui-icon-log"> </i> <fmt:formatDate value="${log.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
						</c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
        
      </div>
    </div>

<jsp:include page="public/headerjs.jsp"></jsp:include>


  <script>
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

