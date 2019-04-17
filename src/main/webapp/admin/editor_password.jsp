<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
</head>
<body>
 <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">修改密码</div>
          <div class="layui-card-body" pad15="">
            
            <div class="layui-form" lay-filter="">
              <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                  <input type="text" name="userName" id="userName" value="${userName}" lay-verify="required" lay-vertype="tips" class="layui-input">
                </div>
              </div>
                <div class="layui-form-item">
                <label class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="userPass" id="userPass" lay-verify="required" lay-vertype="tips" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="newPass" lay-verify="required" lay-vertype="tips"  autocomplete="off" id="newPass" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">确认新密码</label>
                <div class="layui-input-inline">
                  <input type="password" name="rePass" id="rePass" lay-verify="required" lay-vertype="tips"  autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit="" lay-filter="setmypass">确认修改</button>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>


<jsp:include page="public/headerjs.jsp"></jsp:include>
 <script type="text/javascript">
    $(".layui-btn").on('click',function(){
    	var userPass=${userPass};
    	var nowPass=$("#userPass").val()
    	var newPass=$("#newPass").val();
    	var rePass=$("#rePass").val();
    	console.log(userPass);
    	if(userPass==nowPass)
    		{
    	if(newPass==rePass)
    		{
			$.post('${pageContext.request.contextPath}/admin/update_password',
		 			   {
						userName:$("#userName").val(),
						newPass:newPass
		 				},function(d){
		 					if(d.success==true)
		 					layer.alert(d.msg,{icon:1});
		 					else
		 						layer.altert(d.msg,{icon:5});
		 				},'json');
    		}else
    			{
    			layer.tips('俩次密码不同', '#rePass');	
    			}
    		}else
    			{
    			layer.tips('密码错误', '#userPass');	
    			}
    });

</script>
</body>
</html>
