<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/page_setup.css">

</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      


          
     
          <div class="layui-col-sm4">
            <div class="layui-card">
              <div class="layui-card-header">
            <fieldset class="layui-elem-field layui-field-title">
              <legend>主页面</legend>
            </fieldset>
            </div>
              <div class="layui-card-body">
                  <form id="myForm1"  method="POST" enctype="multipart/form-data">
         <input type="hidden" name="pageFlag" value="1">
				个人标签:&nbsp;&nbsp;&nbsp;
				<input type="text" name="pageTag" value="${pageIndex.pageTag }">
	<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;
				<img src="${pageContext.request.contextPath }/${pageIndex.imagePath}" id="prevView1"  	class="mmm" >
				    <input type="file" name="pageImage"  onchange="prev1(this)"/>      
				<br><br>
				    <button class="layui-btn" type="button" data-index="1" >修改</button>
				</form>
              </div>
            </div>
          </div>                              
                
          <div class="layui-col-sm4">
            <div class="layui-card">
               <div class="layui-card-header">            
               <fieldset class="layui-elem-field layui-field-title">
              <legend>详细页面</legend>
            </fieldset>
            </div>
              <div class="layui-card-body">
                  <form id="myForm2"  method="POST" enctype="multipart/form-data">
                <input type="hidden" name="pageFlag" value="2">
				个人标签:&nbsp;&nbsp;&nbsp;
				<input type="text" name="pageTag" value="${pageDetail.pageTag }">
				<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/${pageDetail.imagePath}" id="prevView2" class="mmm">
					    <input type="file"  name="pageImage" id="" value=""  onchange="prev2(this)"/>      
				<br><br>
				    <button class="layui-btn" type="button" data-index="2" data-type="editor">修改</button>
				</form>
              </div>
            </div>
          </div>                              
          
          
          
          <div class="layui-col-sm4">
            <div class="layui-card">
             <div class="layui-card-header">            
             <fieldset class="layui-elem-field layui-field-title">
              <legend>归档页面</legend>
            </fieldset>
            </div>
              <div class="layui-card-body">
                  <form id="myForm3"  method="POST" enctype="multipart/form-data">
                <input type="hidden" name="pageFlag" value="3">
				个人标签:&nbsp;&nbsp;&nbsp;		
			<input type="text" name="pageTag" value="${pageArchive.pageTag }">
							<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/${pageArchive.imagePath}" id="prevView3" class="mmm" >
					    <input type="file" name="pageImage" id="" value=""  onchange="prev3(this)"/>      
				<br><br>
				    <button class="layui-btn" type="button" data-index="3" data-type="editor">修改</button>
				</form>
              </div>
            </div>
          </div>
          
                    
             <div class="layui-col-sm4">
            <div class="layui-card">
             <div class="layui-card-header">           
              <fieldset class="layui-elem-field layui-field-title">
              <legend>分类页面</legend>
            </fieldset>
            </div>
              <div class="layui-card-body">
                  <form id="myForm4"  method="POST" enctype="multipart/form-data">
                <input type="hidden" name="pageFlag" value="4">
				个人标签:&nbsp;&nbsp;&nbsp;
			<input type="text" name="pageTag" value="${pageCategory.pageTag }">
				<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/${pageCategory.imagePath}" id="prevView4" class="mmm">
					    <input type="file" name="pageImage" id="123" value="" onchange="prev4(this)"/>      
				<br><br>
				    <button class="layui-btn" type="button" data-index="4" data-type="editor">修改</button>
				</form>
              </div>
            </div>
          </div>                              
          
          
          
           <div class="layui-col-sm4">
            <div class="layui-card">
              <div class="layui-card-header">            
              <fieldset class="layui-elem-field layui-field-title">
              <legend>标签页面</legend>
            </fieldset>
            </div>              
            <div class="layui-card-body">
                              <form id="myForm5"  method="POST" enctype="multipart/form-data">
              <input type="hidden" name="pageFlag" value="5">
				个人标签:&nbsp;&nbsp;&nbsp;		
					<input type="text" name="pageTag" value="${pageTag.pageTag }">
							<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/${pageTag.imagePath}" id="prevView5" class="mmm" >
					    <input type="file" name="pageImage" id="" value="" onchange="prev5(this)"/>      
				<br><br>
				    <button class="layui-btn"  type="button" data-index="5" >修改</button>
				</form>
              </div>
            </div>
          </div>
          
                     <div class="layui-col-sm4">
            <div class="layui-card">
              <div class="layui-card-header">
              <fieldset class="layui-elem-field layui-field-title">
              <legend>关于页面</legend>
            </fieldset>
            </div>              
            <div class="layui-card-body">
              <form id="myForm6"  method="POST" enctype="multipart/form-data">
              <input type="hidden" name="pageFlag" value="6">
				个人标签:&nbsp;&nbsp;&nbsp;		
				<input type="text" name="pageTag" value="${pageAbout.pageTag }">
							<br><br>
				页面图片:&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/${pageAbout.imagePath}" id="prevView6" class="mmm" >
					    <input type="file" name="pageImage" id="" value=""  onchange="prev6(this)"/>      
				<br><br>
				    <button class="layui-btn" type="button" data-index="6" data-type="editor">修改</button>
				</form>
              </div>
            </div>
          </div>
 	 </div>
  </div>
  
<jsp:include page="public/headerjs.jsp"></jsp:include>
  <script type="text/javascript">
    function prev1(event){
        var img = document.getElementById("prevView1"); 
		prevd(img,event);
    }
    function prev2(event){
        var img = document.getElementById("prevView2"); 
		prevd(img,event);
    }
    function prev3(event){
        var img = document.getElementById("prevView3"); 
		prevd(img,event);
    }
    function prev4(event){
        var img = document.getElementById("prevView4"); 
		prevd(img,event);
    }
    function prev5(event){
        var img = document.getElementById("prevView5"); 
		prevd(img,event);
    }
    function prev6(event){
        var img = document.getElementById("prevView6"); 
		prevd(img,event);
    }
    function prevd(img,event)
    {
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
    $(".layui-btn").on('click',function(){
    	var s=$(this).attr('data-index');
    	var form='#myForm'+s;
        $.ajax({
        	type: "POST",
        	url: '${pageContext.request.contextPath}/admin/update_page',
        	data: new FormData($(form)[0]),
        	cache: false,
        	async: false,
        	processData: false,
        	contentType: false,
        	dataType:"json",
        	success: function (data) {
            if(data.success==true){   
				layer.alert(data.msg,{icon:1});

            }else
            	layer.alert(data.msg,{icon:5});
        }
    });
    });

</script>
</body>
</html>

