<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!-- saved from url=(0043)https://www.ezlippi.com/categories/Android/ -->
<html class="theme-next mist use-motion" lang="zh-Hans"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Cache-Control" content="no-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
  <link href="${pageContext.request.contextPath}/static/material/jquery.fancybox.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/material/css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/material/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/material/main.css" rel="stylesheet" type="text/css">
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
</style>
</head>
  	 <!-- custom analytics part create by xiamo -->
<body>
  <div class="pace-progress-inner"></div>
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
  <header class="post-header">
	<h2 class="post-title" itemprop="name headline">about</h2>
</header>
      <h2 id="个人简介："><a href="#" class="headerlink" title="个人简介："></a>个人简介：</h2><ul>
<li>SinceNovember</li>
<li>Web后台开发、Java开发者</li>
<li>来自江苏淮安</li>
<li>Email: 83428190@qq.com </li>
</ul>
<h3 id="关于本站："><a href="#" class="headerlink" title="关于本站："></a>关于本站：</h3><ul>
<li>使用主题<a href="https://hexo.io/" target="_blank" rel="external">hexo-theme</a></li>
<li>后台使用SpringMVC+Spring+Mybatis框架.</li>
<li>折腾开始于2018年2月1日.</li>
<li><a href="https://www.github.com/SinceNovember">获取源码</a>
</ul>
<h2 id="个人签名"><a href="#" class="headerlink" title="个人签名"></a>个人签名</h2><ul>
${blogger.sign}
</ul>
<h2 id="其他流言"><a href="#" class="headerlink" title="其他流言"></a>其他流言</h2><ul>
${blogger.profile}
</ul>
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
   <jsp:include page="common/inform.jsp"></jsp:include>
      </div>
    </main>
   <jsp:include page="common/footer.jsp"></jsp:include>
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