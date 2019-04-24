<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
    
    <title>没有人可以组织我</title>
</head>
			<form class="input-group input-group-lg" style="margin-top:10px;position:relative;">
			      <input type="text" class="form-control"  placeholder="请输入图片类型" style="font-size: 16px;" onkeyup="searchWord(this)"  autocomplete="off"/>
			      <span class="input-group-btn">
<!-- 			        <button class="btn btn-default" type="button" style="font-size: 16px;">搜索</button> -->
			      </span>
		    </form>
			<div id="showDiv1" style="display:none; position:absolute;z-index:1000;top:146px;background:white; width:188px;font-size: 16px;color:black;border:1px solid #ccc;">
<%-- 				<%//这里用于显示动态提示的数据 %> --%>
			</div>
</body>
<!-- 完成异步搜索//不能同时运行两个不同的ajax，问题暂未解决 -->
<script type="text/javascript">

	function overFn(obj){//鼠标在上面
		$(obj).css("background","#F0F8FF");
	}
	function outFn(obj){//鼠标离开
		$(obj).css("background","white");
	}
	function clickFn(obj){//鼠标点击
		$("#search1").val($(obj).html());
		$("#showDiv1").css("display","none");
	}
	//上面的是提示框的css代码，下面的是ajax获取代码
	function searchWord(obj){
		//1、获得输入框的输入的内容
		var word = $(obj).val();
		//2、根据输入框的内容去数据库中模糊查询---List<Product>
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/search",
			{"q":word},
			function(data){
				//3、将返回的商品的名称 现在showDiv中
				if(data.articleIndexList.length>0){
					console.log(data.articleIndexList.length);
					for(var i=0;i<data.articleIndexList.length;i++){
						content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data.articleIndexList[i].articleTitle+"</div>";
					}
					$("#showDiv1").html(content);
					$("#showDiv1").css("display","block");
				}
				if(obj.value.length==0){//判断输入框是否为空，如果为空则隐藏提示区域
					$("#showDiv1").css("display","none");
				}
			},
			"json"
		);
		
	}
</script>
</html>