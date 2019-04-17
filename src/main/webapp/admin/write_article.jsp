<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
  <link rel="stylesheet" href="../static/editor/css/style.css" />
  <link rel="stylesheet" href="../static/editor/css/editormd.css" />
 
        <style>
            input[type="file"]{
        position: absolute;
        left: 0;
        top: 0;
        height: 200px;
        opacity: 0;
        cursor: pointer;
    }
        </style>
<!--        预览图片 -->
        <script type="text/javascript">
    function prev(event){
        //获取展示图片的区域
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
</head>
<body>
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
            <fieldset class="layui-elem-field layui-field-title">
              <legend>编辑文章</legend>
            </fieldset> 
    <form class="layui-form"   id="myForm"  method="POST" enctype="multipart/form-data">
<div class="layui-col-md8">
	<div align="center">
        <div class="layui-form-item"  style="width: 90%;" >
                <input type="text" name="articleTitle" id="articleTitle" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
</div>
        <div class="layui-form-item layui-form-text">
        <div id="layout" style="height: 650px;background: #f6f6f6;">
            <div class="editormd" id="test-editormd">
<textarea class="editormd-markdown-textarea" name="markdownContent" id="category_content"></textarea>
<!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
<textarea class="editormd-html-textarea" name="htmlContent"></textarea>

</div>
        
        	<div align="center">
        <div style="width:1200px">
        
                <blockquote class="layui-elem-quote layui-quote-nm">
            温馨提示：<br>
            1、文章内容的数据表字段类型为MEDIUMTEXT,每篇文章内容请不要超过500万字 <br>
            2、写文章之前，请确保标签和分类存在，否则可以先新建；请勿刷新页面，博客不会自动保存 <br>
			3.  写的文章前俩个空格断将作文文章summary,大标题前会自动有空格段
        </blockquote>
        </div>
        </div>  
        </div>
        </div>
</div>


<div class="layui-col-md4">
<div style="width:350px">
        <div class="layui-card">
          <div class="layui-card-header"><h2>发布</h2></div>
          <hr class="layui-bg-black">
          <div class="layui-card-body layui-text">
         <img src="${pageContext.request.contextPath}/static/bgpic/default.jpg" alt="" width="300" height="200" id="prevView">
    	 <input type="file" name="articleImage" id="" value="default.jpg" onchange="prev(this)"/>        
            <table class="layui-table">
              <colgroup>
                <col width="100">
                <col>
              </colgroup>
                  <label class="layui-form-label">文章类型：</label>
                  	
                  <div class="layui-input-block">
                    <select name="articleType" lay-verify="required" lay-filter="aihao">
                      <option value="1">原创</option>
                      <option value="0">转载</option>
                    </select>
                  </div>
                                <label class="layui-form-label">发布类型：</label>
                  <div class="layui-input-block">
                    <select name="issueType" lay-verify="required" lay-filter="aihao">
                      <option value="1">正文</option>
                      <option value="0">草稿</option>
                    </select>
                    <br>
                         <button class="layui-btn" type="button" id="issue">立即发布</button>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="getCateIds()">重置</button>
                  </div>
                </div>
            </table>
          </div>
        </div>
        
                <div class="layui-card">
          <div class="layui-card-header"><h2>文章分类</h2></div>
          <hr class="layui-bg-black">
          <div class="layui-card-body layui-text">
            <table class="layui-table">
              <colgroup>
                <col width="100">
                <col>
              </colgroup>
                     <c:forEach items="${categories}" var="category">         
                    <input type="checkbox" name="articleCategoryId" lay-skin="primary" title="${category.categoryName }" value="${category.categoryId}"><br>
                    <c:forEach items="${category.childrenCategory}" var="c">
                     &nbsp;	&nbsp;	&nbsp;	<input type="checkbox" name="articleCategoryId" lay-skin="primary" title="${c.categoryName }" value="${c.categoryId }"><br>
                     </c:forEach>
					</c:forEach>
            </table>
          </div>
        </div>
               <div class="layui-card">
          <div class="layui-card-header"><h2>标签</h2></div>
          <hr class="layui-bg-black">
          <div class="layui-card-body layui-text">
            <table class="layui-table">
              <colgroup>
                <col width="100">
                <col>
              </colgroup>
              <c:forEach items="${tags}" var="tag">
                    <input type="checkbox" name="articleTagId" lay-skin="primary" title="${tag.tagName }" value="${tag.tagId }">
			</c:forEach>
            </table>
          </div>
        </div>
       
        </div>
        </div>
    </form>
    </div>
    </div>
<jsp:include page="public/headerjs.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath }/static/editor/editormd.js"></script>
        <script type="text/javascript">
            $(function() {                
                var testEditor = editormd("test-editormd", {
                    width: "90%",
                    height: 1300,
                    markdown : "",
                    path : '../static/editor/lib/',
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
        <script>
        $("#issue").on("click",function(){
 		var title=$("#articleTitle").val();
 		var content=$("#category_content").val();
 		console.log(title);
 		console.log(content);
 		if(title&&content){
 			
       $.ajax({
    	type: "POST",
    	url: '${pageContext.request.contextPath}/admin/write_article',
    	data: new FormData($("#myForm" )[0]),
    	cache: false,
    	async: false,
    	processData: false,
    	contentType: false,
    	dataType:"json",
    	success: function (data) {
    	console.log(data.success);
        if(data.success==true){   
        	layer.alert(data.msg,{icon:1});
        }else
        	layer.alert(data.msg,{icon:5});

    }
});
 		}else
 			{
 			layer.alert("标题和正文不能为空");
 			}
        });
</script>
</body>
</html>
