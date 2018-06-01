<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html class="theme-next mist use-motion" lang="zh-Hans"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Cache-Control" content="no-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
  <link href="${pageContext.request.contextPath}/static/material/jquery.fancybox.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/material/css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/material/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/material/main.css" rel="stylesheet" type="text/css">
      <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/material/comment.zero.css">
            <title>SinceNovember-详细内容</title>
        
        
            <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/material/bluebird.zero.css">
<script type="text/javascript">


		window.onload = function() {
		    //配置
		    var config = {
		        vx: 4,	//小球x轴速度,正为右，负为左
		        vy: 4,	//小球y轴速度
		        height: 2,	//小球高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 50,		//点个数
		        color: "169,169,169", 	//点颜色
		        stroke: "169,169,169", 		//线条颜色
		        dist: 6000, 	//点吸附距离
		        e_dist: 20000, 	//鼠标吸附加速距离
		        max_conn: 10 	//点到点最大连接数
		    }

		    //调用
		    CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/material/canvas-particle.js"></script>
<script src="${pageContext.request.contextPath}/static/material/hm.js"></script><script src="${pageContext.request.contextPath}/static/material/hm.js(1)"></script><script src="${pageContext.request.contextPath}/static/material/push.js"></script><script src="${pageContext.request.contextPath}/static/material/push.js"></script><script src="${pageContext.request.contextPath}/static/material/embed.dist.js" async=""></script><script src="${pageContext.request.contextPath}/static/material/hm.js(2)"></script><script async="" src="${pageContext.request.contextPath}/static/material/0f81ff2f.js" charset="utf-8"></script><script type="text/javascript" id="hexo.configurations">
  var NexT = window.NexT || {};
  var CONFIG = {
    root: '/',
    scheme: 'Mist',
    sidebar: {"position":"right","display":"post"},
    fancybox: true,
    motion: true,
    duoshuo: {
      userId: 'undefined',
      author: '博主'
    },
    algolia: {
      applicationID: '',
      apiKey: '',
      indexName: '',
      hits: {"per_page":10},
      labels: {"input_placeholder":"Search for Posts","hits_empty":"We didn't find any results for the search: ${query}","hits_stats":"${hits} results found in ${time} ms"}
    }
  };

</script>
  <link rel="canonical" href="http://www.ezlippi.com/categories/android/">
<script src="${pageContext.request.contextPath}/static/material/pace.min.js"></script>
<link href="${pageContext.request.contextPath}/static/material/pace-theme-flash.css" rel="stylesheet">
<style>
    .pace .pace-progress {
        background: #1E92FB; /*进度条颜色*/
        height: 3px;
    }
    .pace .pace-progress-inner {
         box-shadow: 0 0 10px #1E92FB, 0 0 5px     #1E92FB; /*阴影颜色*/
    }
    .pace .pace-activity {
        border-top-color: #1E92FB;    /*上边框颜色*/
        border-left-color: #1E92FB;    /*左边框颜色*/
    }
    .comments
    {
 	    position:relative;
    left:440px;
    top:-180px;
    }
    .footerstyle
    { 
    position:relative;
     top:100px;
    }
</style>
</head> 
<body> <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
  <div id="mydiv" style="height:1000px;">
  <div class="container one-collumn sidebar-position-right  ">
    <div class="headband"></div>
	<jsp:include page="common/head.jsp"></jsp:include>
    <main id="main" class="main">
      <div class="main-inner">
        <div class="content-wrap">
          <div id="content" class="content">
  <div id="posts" class="posts-expand">
  <article class="post post-type-normal" itemscope="" itemtype="http://schema.org/Article" style="opacity: 1; display: block; transform: translateY(0px);">
  <span style="display:none" itemprop="author" itemscope="" itemtype="http://schema.org/Person">
    <meta itemprop="name" content="EZLippi">
    <meta itemprop="description" content="">
    <meta itemprop="image" content="/images/avatar.gif">
  </span>
  <span style="display:none" itemprop="publisher" itemscope="" itemtype="http://schema.org/Organization">
    <meta itemprop="name" content="EZLippi-浮生志">
    <span style="display:none" itemprop="logo" itemscope="" itemtype="http://schema.org/ImageObject">
      <a href="${pageContext.request.contextPath}/static/material/avatar.jpg" class="fancybox" rel="group"><img style="display:none;" itemprop="url image" alt="EZLippi-浮生志" src="${pageContext.request.contextPath}/static/material/avatar.jpg"></a>
    </span>
  </span>
          <header class="post-header">
          <h2 class="post-title" itemprop="name headline">
                ${blog.title }
          </h2>
        <div class="post-meta">
          <span class="post-time">
              <span class="post-meta-item-icon">
                <i class="fa fa-calendar-o"></i>
              </span>
                <span class="post-meta-item-text">发表于</span>
              <time title="Post created" itemprop="dateCreated datePublished" datetime="2018-02-04T15:38:32+08:00">
                  ${blog.releaseDateStr }
              </time>
          </span>
            <span class="post-category">
              <span class="post-meta-divider">|</span>
              <span class="post-meta-item-icon">
                <i class="fa fa-folder-o"></i>
              </span>
                <span class="post-meta-item-text">分类于</span>
                <span itemprop="about" itemscope="" itemtype="http://schema.org/Thing">
                  <a href="${pageContext.request.contextPath }/blog/categories/${blog.blogType.id}" itemprop="url" rel="index">
                    <span itemprop="name">${blog.blogType.typeName }</span>
                  </a>
                </span>
            </span>
             <span >
               <span class="post-meta-divider">|</span>
               <span class="post-meta-item-icon">
               <i class="fa fa-eye"></i>
               </span>
                 <span class="post-meta-item-text">点击量  </span>
                 <span class="leancloud-visitors-count">${blog.clickHit }</span>
				 <span>次</span>
             </span>
              </span>
                <span>
               <span class="post-meta-divider">|</span>
               <span class="post-meta-item-icon">
                <i class="fa fa-comment"></i>
               </span>
                 <span class="post-meta-item-text">回复量</span>
                 <span class="leancloud-visitors-count">${blog.replyHit }</span>
				 <span>条</span>
             </span>
        </div>
      </header>
    <div class="post-body" itemprop="articleBody">
    ${blog.content }
    </div>
    <div>
    </div>
  
        <div class="post-tags">
          <c:forEach var="key" items="${keyWords}">
            <a href="#" rel="tag">#${key }</a>
            </c:forEach>
        </div>
        
    <footer class="post-footer">
     <div>    
      <ul class="post-copyright">
         <li class="post-copyright-link">
          <strong>本文作者：</strong>
				${blogger.nickname }
        </li>
        <li class="post-copyright-link">
          <strong>本文标题：</strong>
    	 ${blog.title }
        </li>
        <li class="post-copyright-link">
          <strong>本文链接：</strong>
          <a href="${pageContext.request.contextPath }/blog/articles/${blog.id }" title=" ${blog.title }">${pageContext.request.contextPath }/blog/articles/${blog.id }</a>
        </li>
        <li class="post-copyright-date">
            <strong>发布时间：</strong>
		 <time title="Post created" itemprop="dateCreated datePublished" datetime="2018-02-04">
               ${blog.releaseDateStr }
              </time>
        </li>  
      </ul>
  </div>  
    <div class="post-nav">
   
          <div class="post-nav-next post-nav-item">
             <c:if test="${!empty preBlog }">
              <a href="${pageContext.request.contextPath }/blog/articles/${preBlog.id }" rel="next" title="${preBlog.title }">
               &lt;&nbsp;${preBlog.title }
              </a>
                 </c:if>
          </div>
       

          <c:if test="${!empty nextBlog }">
                    <span class="post-nav-divider"></span>
          <div class="post-nav-prev post-nav-item">
              <a href="${pageContext.request.contextPath }/blog/articles/${nextBlog.id }" rel="prev" title="${nextBlog.title }">
                ${nextBlog.title } &nbsp;>
              </a>
          </div>
          </c:if>
        </div>
      
    </footer>
  </article>
    <div class="post-spread">
    </div>
  </div>
          </div>
        </div>
        
 <div class="sidebar-toggle">
    <div class="sidebar-toggle-line-wrap">
      <span class="sidebar-toggle-line sidebar-toggle-line-first"></span>
      <span class="sidebar-toggle-line sidebar-toggle-line-middle"></span>
      <span class="sidebar-toggle-line sidebar-toggle-line-last"></span>
    </div>
  </div>
  <aside id="sidebar" class="sidebar">
    <div class="sidebar-inner">
      <section class="site-overview sidebar-panel sidebar-panel-active">
        <div class="site-author motion-element" itemprop="author" itemscope="" itemtype="http://schema.org/Person">
          <img class="site-author-image" itemprop="image" src="${pageContext.request.contextPath}/static/userImages/${blogger.imagename}" alt="EZLippi">
          <p class="site-author-name" itemprop="name">SinceNovember</p>
          <p class="site-description motion-element" itemprop="description">Since Huaian</p>
        </div>
        <nav class="site-state motion-element">
            <div class="site-state-item site-state-posts">
              <a href="${pageContext.request.contextPath }/blog/archive/1">
                <span class="site-state-item-count">${countsallblogs }</span>
                <span class="site-state-item-name">日志</span>
              </a>
            </div>
            <div class="site-state-item site-state-categories">
              <a href="${pageContext.request.contextPath }/blog/category">
                <span class="site-state-item-count">${countsallcategories }</span>
                <span class="site-state-item-name">分类</span>
              </a>
            </div>
            <div class="site-state-item site-state-tags">
              <a href="${pageContext.request.contextPath }/blog/tags">
                <span class="site-state-item-count">${countsalltags }</span>
                <span class="site-state-item-name">标签</span>
              </a>
            </div>
        </nav>
   
      </section>
    </div>
  </aside>
      </div>
    </main>
 <div class="comments" id="comments">
    
      <div id="lv-container" >
      <jsp:include page="common/comment.jsp"></jsp:include>
      
      </div>
    
  </div>
  <div class="footerstyle">
   <jsp:include page="common/footer.jsp"></jsp:include>
   </div>
    <div class="back-to-top">
      <i class="fa fa-arrow-up"></i>
    </div>
  </div>
  
  </div>

<script type="text/javascript">
  if (Object.prototype.toString.call(window.Promise) !== '[object Function]') {
    window.Promise = null;
  }
</script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/fastclick.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/jquery.lazyload.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/velocity.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/velocity.ui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/jquery.fancybox.pack.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/utils.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/motion.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/material/bootstrap.js"></script>

	<!-- 页面点击小红心 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/material/love.js"></script>
</body>
</html>