<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/editor/css/style.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/editor/css/editormd.css" />
        <style>
        .avatar
        {
        position: absolute;
        left: 120px;
        top: 32px;
        width:90px;
        height: 38px;
        opacity: 0;
        cursor: pointer;
        }
        </style>
</head>
<body>
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
              <fieldset class="layui-elem-field layui-field-title">
              <legend>个人资料</legend>
            </fieldset>
            <div class="layui-col-sm12">
              <div class="layui-card">
              <div class="layui-row layui-col-space15">  
              <div class="layui-col-sm9" style="position:relative;left:50px;">       
                   <div class="layui-card-body layui-text">
		   <div class="layui-form-item">     
  		  <form class="layui-form"   id="myForm"  method="POST" enctype="multipart/form-data">
				<div class="layui-col-md9">
			<input type="hidden" name="userId"  value="${user.userId}">
       				 <div class="layui-form-item">
						<div style="position:relative;left:60px">
                        <img class="layui-upload-img" src="${pageContext.request.contextPath }/${user.avatarPath}" id="prevView" width="100"
                             height="100">
                             <input type="file" name="avatarImage"  class="avatar" onchange="prev(this)"/> 
                             &nbsp; &nbsp;  
                            <div class="layui-btn"  onchange="prev(this)">上传头像</div>
                             </div>
                        <p id="demoText"></p>
        				</div>          
		                           
                    <div class="layui-input-block">
                       个人姓名
                        <input type="text"  name="userNickname" value="${user.userNickname }" placeholder="请输入个人名称" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                       主页名称                
                        <input type="text" name="pageNickname" value="${user.pageNickname }" placeholder="请输入主页名称 " autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                                        <div class="layui-input-block">
                       个人签名                
                        <input type="text" name="userSignature" value="${user.userSignature }" placeholder="请输入主页名称 " autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        个人邮箱
                        <input type="text" name="userEmail" value="${user.userEmail }" placeholder="请输入个人邮箱" autocomplete="off" class="layui-input" >
                    </div>
                    
					<br>
					  个人简介
            <div class="editormd" id="test-editormd">
			<textarea class="editormd-markdown-textarea" name="markdownProfile" id="category_content">${user.markdownProfile }</textarea>
			<!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
			<textarea class="editormd-html-textarea" name="htmlProfile"></textarea>

</div>
				<br>
				<div class="layui-input-block">
                        个人标签
                        <input type="text" name="personTag" value="${user.personTag}" placeholder="多个标签按空格隔开" autocomplete="off" class="layui-input" >
        		</div>
        		                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn"  id="save" data-type="insert" type="button">保存</button>
                    </div>
                    <br>
        	<div align="center">
        <div style="width:1200px">
        
                <blockquote class="layui-elem-quote layui-quote-nm">
            温馨提示：<br>
            1、个人简介会用于网页的关于页面展示,请仔细编写. <br>
            2、个人头像显示与后台右上角以及前台展开栏点击后显示. <br>
            3、个人标签请填写时请按空格分割，分割后展示于前台Link.
        </blockquote>
        </div>
        </div>  
        </div>
            </form>
        </div>
</div>


    </div>
    </div>
    </div>
    </div>
    </div>
    </div>



<jsp:include page="public/headerjs.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath }/static/editor/editormd.js"></script>
        <script type="text/javascript">
            $(function() {                
                var testEditor = editormd("test-editormd", {
                    width: "100%",
                    height: 400,
                    markdown : "",
                    path : '${pageContext.request.contextPath }/static/editor/lib/',
                    syncScrolling : "single",
                    emoji : true,
                    saveHTMLToTextarea : true,
                    tocm : true, // Using [TOCM]
                    tex : true, // 开启科学公式TeX语言支持，默认关闭
                    flowChart : true, // 开启流程图支持，默认关闭
                    /* 上传图片配置 */
                    imageUpload : true,
                    imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
                    imageUploadURL : "${pageContext.request.contextPath}/upload/article_image", //注意你后端的上传图片服务地址
                });
            });
        </script>
 <script type="text/javascript">
    function prev(event){
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
    $("#save").on('click',function(){
        $.ajax({
        	type: "POST",
        	url: '${pageContext.request.contextPath}/admin/update_info',
        	data: new FormData($("#myForm" )[0]),
        	cache: false,
        	async: false,
        	processData: false,
        	contentType: false,
        	dataType:"json",
        	success: function (data) {
            if(data.success==true){   
				layer.alert(data.msg,{icon:1});

            }else
            	layer.alert(data.msg,{icon:5});
        }
    });
    });

</script>
</body>
</html>
