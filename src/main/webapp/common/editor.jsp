<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/static/material/wangEditor.css"/>">
<script type="text/javascript" src="<c:url value="${pageContext.request.contextPath}/static/material/jquery-1.9.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="${pageContext.request.contextPath}/static/material/wangEditor.js"/>"></script>
<!-- <script src="https://raw.github.com/leizongmin/js-xss/master/dist/xss.js"></script> -->
<script type="text/javascript">
	//获得文本编辑器对象
    var editor = new wangEditor('content');
    //上传图片地址
    editor.config.uploadImgUrl = '${pageContext.request.contextPath}/upload';
    //图片参数
    editor.config.uploadImgFileName = 'file';
    // 普通的自定义菜单
    editor.config.menus =  [
       'emotion',
       'img',
       'bold',
       'forecolor',
       'fontfamily',
       'fontsize',
       'link',
       'fullscreen'
   ];
    editor.config.emotions = {
   		'default': {
   	        title: '默认',
   	        data: 'http://www.wangeditor.com/wangEditor/test/emotions.data'
   	    }
    }
	//创建
    editor.create();
    
 	// 禁用
   	//editor.disable();

    // 启用
    //editor.enable();
    
</script>
<style>
#title,#addbtn {
	border-radius: 0;
}
</style>