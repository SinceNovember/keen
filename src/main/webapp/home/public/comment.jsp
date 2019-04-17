<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
 <div class="commentAll">
    <!--评论区域 begin-->
    <div class="reviewArea clearfix">
    <form id="myForm"  method="POST" enctype="multipart/form-data">
    <input type="hidden" name="commentArticleId" value="${article.articleId }">
        <textarea class="content comment-input" name="commentContent" placeholder="Please enter a comment&hellip;"></textarea>
    	<img src="${pageContext.request.contextPath}/static/pic/comment/default.jpg" alt="" width="45" height="45" style="border-radius: 50%" id="prevView">
    	 <input type="file" name="commentAvatarImage" id="" value="default.jpg" onchange="prev(this)"/>        
        <a  href="javascript:myadd();" class="plBtn" id="review" >评论</a>
        <div class="inputbox">
        姓名:&nbsp;<input type="text" name="commentAuthorName" id="cname" style="width:100px;height:45px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        邮箱:&nbsp;<input type=”text" name="commentAuthorEmail" style="width:230px;height:45px;"/>
        </div>
        </form>
    </div>
    <!--评论区域 end-->
    <!--回复区域 begin-->
    <div class="comment-show">
    <c:choose>
    <c:when test="${not empty comments }">
    <c:forEach items="${comments }"	var="c">
    
        <div class="comment-show-con clearfix">
            <div class="comment-show-con-img pull-left"><img src="${pageContext.request.contextPath}/${c.commentAvatarPath}"  height="48" width="48" style="border-radius: 50%" alt="加载失败"></div>
            <div class="comment-show-con-list pull-left clearfix">
                <div class="pl-text clearfix">
                    <a href="#" class="comment-size-name">${c.commentAuthorName } : </a>
                    <span class="my-pl-con">&nbsp;${c.commentContent }</span>
                </div>
                <div class="date-dz">
                    <span class="date-dz-left pull-left comment-time"> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${c.commentCreateTime }" /></span>
                    <div class="date-dz-right pull-right comment-pl-block">
<!--                         <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> -->
<!--                         <span class="pull-left date-dz-line">|</span> -->
                        <a href="javascript:;" class="date-dz-z pull-left" data-index="${c.commentId}" ><i class="fa fa-heart"></i>&nbsp;赞 (<i class="z-num">${c.commentLikeCount }</i>)</a>
<!--                         asdassd  asdassd  asdassd -->
                    </div>
                </div>
                <div class="hf-list-con"></div>
            </div>
            <c:if test="${not empty c.childComment }">
					<c:forEach items="${c.childComment }" var="cc">
					        <div class="comment-show-con clearfix">
					
                    <div class="comment-show-con-img1 pull-left"><img src="${pageContext.request.contextPath}/${cc.commentAvatarPath}"  height="48" width="48" style="border-radius: 50%" alt="加载失败"></div>
            <div class="comment-show-con-list1 pull-left clearfix">
                <div class="pl-text clearfix">
                    <a href="#" class="comment-size-name">${cc.commentAuthorName } : </a>
                    <span class="my-pl-con">&nbsp;${cc.commentContent }</span>
                </div>
                <div class="date-dz">
                    <span class="date-dz-left pull-left comment-time"> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${cc.commentCreateTime }" /></span>
                    <div class="date-dz-right pull-right comment-pl-block">
<!--                         <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> -->
<!--                         <span class="pull-left date-dz-line">|</span> -->
                        <a href="javascript:;" class="date-dz-z pull-left" data-index="${cc.commentId}" ><i class="fa fa-heart"></i>&nbsp;赞 (<i class="z-num">${cc.commentLikeCount }</i>)</a>
                    </div>
                </div>
                <div class="hf-list-con"></div>
            </div>
            </div>
            </c:forEach>
            </c:if>
            
        </div>
        </c:forEach>
        </c:when>
        <c:otherwise>
        <div class="comment-show-con clearfix" id="comment_p">
        <input type="hidden" value="1" id="no_comment">
		<p align="center">暂无评论</p>
        </div>
        </c:otherwise>
        </c:choose>
    <!--回复区域 end-->
</div>

   </div>
    <script>
function myadd()
{
	var content=$(".content").val();
	var name=$("#cname").val();
	var temp=$("#no_comment").val();
	if(content&&name)
	{
    $.ajax({
    	type: "POST",
    	url: '${pageContext.request.contextPath}/insert_comment',
    	data: new FormData($("#myForm" )[0]),
    	cache: false,
    	async: false,
    	processData: false,
    	contentType: false,
    	dataType:"json",
    	success: function (data) {
        if(data.success==true){   
        	var oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="${pageContext.request.contextPath}/'+data.comment.commentAvatarPath+'" height="48" width="48"  style="border-radius: 50%" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+data.comment.commentAuthorName+': </a> <span class="my-pl-con">&nbsp;'+ data.comment.commentContent +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+data.commentCreateTime+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-z pull-left"><i class="fa fa-heart"></i>&nbsp;赞 (<i class="z-num">0</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
        	if(temp==1)
        		$("#comment_p").remove();
			$(".comment-show").prepend(oHtml);
        	layer.alert(data.msg,{icon:1});

        }else
        	layer.alert(data.msg,{icon:5});
    }
});
    }else
    	{
    	layer.msg("内容跟名称不能为空");
    	}

}
<!--点赞-->

$('.comment-show').on('click','.date-dz-z',function(){
    var zNum = $(this).find('.z-num').html();
    if($(this).is('.date-dz-z-click')){
        zNum--;
        $(this).removeClass('date-dz-z-click red');
        $(this).find('.z-num').html(zNum);
        $(this).find('.date-dz-z-click-red').removeClass('red');
    }else {
        zNum++;
        $(this).addClass('date-dz-z-click');
        $(this).find('.z-num').html(zNum);
        $(this).find('.date-dz-z-click-red').addClass('red');
    }
	$.post('${pageContext.request.contextPath}/update_like',
 			   {
 				commentId:$(this).attr('data-index'),
				commentLikeCount:zNum
 				},'json');
});


// 	预览图片
    function prev(event){
        //获取展示图片的区域
        console.log("tttt");
        var img = document.getElementById("prevView"); 
        //获取文件对象
        let file = event.files[0];
        //获取文件阅读器
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function(){
            //给img的src设置图片url
            img.setAttribute("src", this.result);
        }
    }
    </script> 