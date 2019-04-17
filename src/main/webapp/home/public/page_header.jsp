<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
   <div id="page-header">
    <span class="pull-left"><strong></h2><a href="${pageContext.request.contextPath }/page/1">${inform.pageNickname }のBlog</a></strong></span>
    <i class="fa fa-bars toggle-menu pull-right" aria-hidden="true"></i>
    <span class="pull-right menus">
<!-- 	<input type="search" class="site-page social-icon search"  placeholder="搜索"> -->

    <a class="site-page social-icon search" ><i class="fa fa-search"></i><span> 搜索</span></a>
    <a class="site-page" href="${pageContext.request.contextPath }/page/1"><i class="menu-item-icon fa fa-fw fa-home"></i>首页</a>
    <a class="site-page" href="${pageContext.request.contextPath }/archives"><i class="menu-item-icon fa fa-fw fa-archive"></i>归档</a>
    <a class="site-page" href="${pageContext.request.contextPath }/tags"><i class="menu-item-icon fa fa-fw fa-tags"></i>标签</a>
    <a class="site-page" href="${pageContext.request.contextPath }/categories"><i class="menu-item-icon fa fa-fw fa-th"></i>分类</a>
    <a class="site-page" href="${pageContext.request.contextPath }/about">   <i class="menu-item-icon fa fa-fw fa-user fa-fw"></i>关于</a></span>
   </div>