<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script src="${pageContext.request.contextPath}/static/js/anime.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.fancybox.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/velocity.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/velocity.ui.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/utils.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/fancybox.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/sidebar.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/fireworks.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/transition.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/scroll.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/nightshift.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/head.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/local-search.js"></script>
   <script async="" src="${pageContext.request.contextPath}/static/js/busuanzi.pure.mini.js"></script>
<%--    <script src="${pageContext.request.contextPath}/static/js/instantsearch.min.js" defer=""></script> --%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flexText.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <script type="text/javascript">

	function overFn(obj){//鼠标在上面
		$(obj).css("background","#F0F8FF");
	}
	function outFn(obj){//鼠标离开
		$(obj).css("background","white");
	}
	function clickFn(obj){//鼠标点击
		$("#display").val($(obj).html());
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
				console.log("每所");
				console.log(data.length);
				//3、将返回的商品的名称 现在showDiv中
				if(data.articleIndexList.length>0){
					for(var i=0;i<data.articleIndexList.length;i++){
						content+=	'<div class="search-result-lis " onclick='+clickFn(this)+'onmouseover='+overFn(this)+' onmouseout='+outFn(this)+'><div class="local-search__hit-item"><a href=${pageContext.request.contextPath}/'+data.articleIndexList[i].articleId+' class="search-result-title">	'+data.articleIndexList[i].articleTitle+'</a></div>';
					}
					$("#display").html(content);
					$("#display").css("display","block");
				}
			},
			"json"
		);
		if(obj.value.length==0){//判断输入框是否为空，如果为空则隐藏提示区域
			console.log("111");
			$("#display").css("display","none");
		}
	}
</script>
