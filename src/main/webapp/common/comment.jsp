  
  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <script>
  
	function submitData(){
var content = $("#wf-content").val();
	var url = "${pageContext.request.contextPath}/comment/save.do";
	var params = {
		content : content,
		"blog.id" : "${blog.id}"
	};
		$.ajax({
			'url' : url,
			'data' : params,
			'contentType' : "application/x-www-form-urlencoded; charset=utf-8",
			'type' : 'POST',
			'success' : function(data) {
				alert("评论已提交成功，博主审核后添加");
					window.location.reload();
			},
			'error' : function() {
				alert(result.errorInfo);
			}
		});
	}
  </script>
         <div id="container"  style="position: relative;">
        <div id="wrapper" class="" data-version="">
    <div id="wf"><div id="wf-form" class="wf-form ">
    <div class="wf-content-wrapper">
        <img class="wf-profile text-indent" src="./profile.gif.下载" title="头像" alt="头像">
        <label for="wf-content">评论输入领域</label>
        <textarea id="wf-content" placeholder="撰写评论"></textarea>
    </div>

<div class="wf-function-wrapper">



<button type="button" class="guest-write-btn wf-write-btn " id="guest-write-btn" onclick="submitData()">
    <span>发布</span>
</button></div>
</div></div></div>
  
     
    <div id="highlight"></div>
    <div class="reply-count"><div class="left">
    评论
    <span class="count-text">${totalComments }</span>

</div>
</div>
 	<c:if test="${totalComments eq 0 }">
 	<span> <center>暂无评论</center></span>
 	</c:if>
	<c:forEach items="${commentList}" var="comment">
    <div id="list" class=""><div class="reply-wrapper" data-own="0" data-secret="false" style="">
    <div class="reply-top">
        <div class="writer" data-own="0" data-seq="26943578">
            <ul class="writer-account">
              <li class="writer-img" data-path="r_profile">
                    <img src="${pageContext.request.contextPath}/static/userImages/${blogger.imagename}" alt="头像" onerror="Livere.imgError.call(this)">
                </li>
                <li class="writer-name" data-path="r_name">
                    <a title="移动到我的页面" aria-label="移动到我的页面" target="_blank">
                        <span class="writer-name-text">${comment.userIp }</span>
                    </a>
                </li>
                <li class="reply-history" data-modified="0">
                    <div class="reply-history-time">
                        <span class="modify-time" title="2018年2月7日 16:45">	
                        <fmt:formatDate value="${comment.commentDate }" type="date"
											pattern="yyyy-MM-dd HH:mm" /></span>
                        
                       
                        
                    </div>
                </li>
                <li class="reply-option">
                    <div class="reply-option-btn">
                        <button type="button" class="content-toggle-btn content-close-btn" title="关闭">
                            <i></i>
                        </button>
                        <button type="button" class="reply-menu-btn" title="打开目录">
                            <i class="i-more-b"></i>
                        </button>
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <div class="reply-bottom">
        <div class="reply-content-wrapper" data-content="很详细啊，占个楼">
            <div class="reply-content">
                
                <p>
                 ${comment.content }
                </p>
                
            </div>
            <div class="reply-addition-wrapper false  hide">
                            </div>
        </div>
        <div class="modify-wrapper"></div>
        <div class="comment-wrapper hide"></div>
        <div class="child-reply" style="margin-left:"></div>
    </div>
</div>
</div>
</c:forEach>
</div>