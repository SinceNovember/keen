<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单里上传图片</title>
    <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
     <script src="${pageContext.request.contextPath}/static/ajaxupload/ajaxfileupload.js"></script>
</head>
<div id="result"></div>
<img id="uploadImage" width="112" height="112" src="${pageContext.request.contextPath}/static/pic/1.jpg">

 <input type="file" id="myBlogImage" name="myfiles"/>
<input type="button" value="上传图片" onclick="ajaxFileUpload()"/>
<script type="text/javascript">

    function ajaxFileUpload() {
        $.ajaxFileUpload
        (
            {
                url: '${pageContext.request.contextPath }/upload', //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                type: 'post',
                fileElementId: 'myBlogImage', //文件上传域的ID
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                	var p='${pageContext.request.contextPath}/static/pic/'+data.picName+'';
                	$("#uploadImage").attr("src",p);

                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
				console.log(e)
                }
            }
        )
        return false;
    }
</script>
</html>