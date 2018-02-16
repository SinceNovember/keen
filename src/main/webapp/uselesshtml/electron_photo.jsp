<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>博客主页</title>
<style type="text/css">
	body{
		padding-top:10px;
		padding-bottom:40px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="blog"><strong>${blogger.nickname}的博客</strong></div>
			</div>
			<div class="col-md-8">
				<iframe style="float:right" width="420" scrolling="no" height="60" frameborder="0"
					allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			</div>
		</div>
		
		<div class="row" style="padding-top: 10px">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
				  <div class="container-fluid">				    
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				      	<li ><a class="navbar-brand" href="${pageContext.request.contextPath}/blog/index/1">博客首页</a></li>
				        <li><a class="navbar-brand" href="${pageContext.request.contextPath }/bloggerinformation.jsp">关于博主</a></li>
				        <li class="active"><a class="navbar-brand" href="${pageContext.request.contextPath}/blog/searchphoto">我的相册</a></li>
				        <li><a class="navbar-brand" href="http://www.github.com" target="_blank"> 资源小站</a></li>
				        <li><a class="navbar-brand" href="http://www.github.com/SinceNovember" target="_blank">程序人生</a></li>
				      </ul>
				      <form action="${pageContext.request.contextPath }/blog/search" class="navbar-form navbar-right" role="search">
				        <div class="form-group">
				        
				          <input type="text"  id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字">
				        </div>
				        <button type="submit" class="btn btn-default">搜索</button>
				      </form>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			</div>
		</div>
		
		<div class="row">	
		  <div class="col-md-3">
		  	<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
					博主信息
				</div>
				<div class="user_image">
					<img src="${pageContext.request.contextPath}/static/userImages/${blogger.imagename}"/>
				</div>
				<div class="nickName">${blogger.nickname }</div>
				<div class="userSign">${blogger.sign }</div>    
			</div>	
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					文章分类
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogTypeList }" var="blogType">
								<li><span><a href="${pageContext.request.contextPath }/blog/blogByType/${blogType.id}">${blogType.typeName }（${blogType.blogCount }）</a></span></li>		
							</c:forEach>					
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					文章存档
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogList }" var="blog">							
								<li><span><a href="#">${blog.releaseDateStr}（${blog.blogCount }）</a></span></li>						
							</c:forEach>						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>						
						<c:forEach items="${linkList }" var="link">
							<li><span><a href="${link.linkurl }" target="_blank">${link.linkname }</a></span></li>
						</c:forEach>											
					</ul>
				</div>
			</div>
			
			  	
		  </div>
		  	  
		  <div class="col-md-9">
		  	<div class="data_list">
		  		<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新相册
					<form action="${pageContext.request.contextPath }/blog/upload"  method="post" enctype="multipart/form-data">
					<input type="file" name="file">
					<input type="submit" value="上传">
					</form>
					<c:forEach items="${allphoto}" var="photo">
					<img src="${pageContext.request.contextPath}/${photo.photoName}" height="200" width="200"/>
					</c:forEach>
				</div>	
					
		  	</div>
		  </div>
		  
		</div>
		
		<div class="row">
			<div class="col-md-12" >
				<div class="footer" align="center" style="padding-top: 120px" >
					<font>Copyright © 2012-2016 刘宇东SSM个人博客系统 版权所有</font>
					  
				</div>
			</div>			
		</div>
	</div>
</body>
</html>
