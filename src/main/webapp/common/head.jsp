  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/font-awesome/css/font-awesome.min.css">
    <header id="header" class="header" itemscope="" itemtype="http://schema.org/WPHeader">
      <div class="header-inner"><div class="site-meta custom-logo">
  <div class="custom-logo-site-title">
    <a href="${pageContext.request.contextPath }/blog/1" class="brand" rel="start" style="opacity: 1;">
      <span class="logo-line-before"><i class="" style="transform: translateX(100%);"></i></span>
      <span class="site-title" style="opacity: 1; top: 0px;">SinceNovember</span>
      <span class="logo-line-after"><i class="" style="transform: translateX(-100%);"></i></span>
    </a>
  </div>
      <h1 class="site-subtitle" itemprop="description" style="opacity: 1; top: 0px;"></h1>
</div>
<div class="site-nav-toggle">
  <button>
    <span class="btn-bar"></span>
    <span class="btn-bar"></span>
    <span class="btn-bar"></span>
  </button>
</div>
<nav class="site-nav">
    <ul id="menu" class="menu">     
        <li class="menu-item menu-item-home menu-item-active" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/blog/1" rel="section">           
              <i class="menu-item-icon fa fa-fw fa-home"></i> <br>           
            首页
          </a>
        </li>    
        <li class="menu-item menu-item-categories" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/blog/category" rel="section">           
              <i class="menu-item-icon fa fa-fw fa-th"></i> <br>           
            分类
          </a>
        </li>        
        <li class="menu-item menu-item-archives" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/blog/archive/1" rel="section">           
              <i class="menu-item-icon fa fa-fw fa-archive"></i> <br>           
            归档
          </a>
        </li>        
        <li class="menu-item menu-item-tags" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/blog/tags" rel="section">            
              <i class="menu-item-icon fa fa-fw fa-tags"></i> <br>          
            标签
          </a>
        </li>  
        <li class="menu-item menu-item-about" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/about.jsp" rel="section">           
              <i class="menu-item-icon fa fa-fw fa-user fa-fw"></i> <br>       
            关于
          </a>
        </li> 
              <li class="menu-item menu-item-archives" style="opacity: 1; transform: translateY(0px);">
          <a href="${pageContext.request.contextPath }/other.jsp" rel="section">           
              <i class="menu-item-icon fa fa-fw fa-user fa-paper-plane"></i> <br>       
         其他
          </a>
        </li> 
        <li class="menu-item menu-item-search" style="opacity: 1; transform: translateY(0px);">        
                             
                             <form action="${pageContext.request.contextPath }/blog/search">
               <input type="text"  id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字"><br>      
             <button type="submit"  rel="section">搜索</button> 

       </form>
        </li> 
    </ul>
</nav>
 </div>
    </header>