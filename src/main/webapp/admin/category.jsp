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
            <fieldset class="layui-elem-field layui-field-title">
              <legend>文章目录</legend>
            </fieldset>
	    <div class="layui-form" >
              <div class="layui-col-md4">
        <div class="layui-card">
          <div class="layui-card-header"><h3><strong>添加分类</strong></h3></div>
          <hr class="layui-bg-black">
          <div class="layui-card-body layui-text">
		   <div class="layui-form-item">                           
		               名称 <span style="color: #FF5722; ">*</span>	                       
                    <div class="layui-input-block">
                        <input type="text"  id="categoryName" placeholder="请输入分类名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                         父节点 <span style="color: #FF5722; ">*</span>
                  <div class="layui-input-block">

                    <select name="type" id="categoryPid">
                      <option value="0">无父结点</option>
                      <c:forEach items="${categories}" var="c">
                      <option value="${c.categoryId}">${c.categoryName}</option>
                      </c:forEach>
                    </select>
    
                  </div>
                    <br>
                    <div class="layui-input-block">
                       排序编号                 
                        <input type="text" id="categoryOrder" placeholder="请输入排序编号" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" id="categoryDescription" placeholder="请输入分类描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn"  data-type="insert" type="submit">添加</button>
                    </div>
                </div>
                                     <blockquote class="layui-elem-quote layui-quote-nm">
           温馨提示：
                <ul>
                    <li>1.分类名勿重复</li>
                    <li>2.父节点默认自己为根节点</li>
                    <li>3.排序默认为最低排序</li>
                </ul>
            </blockquote>
          </div>
        </div>
        </div>
              </div>
              
              
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="200">
                    <col width="250">
                    <col width="50">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>分类名称</th>
                    <th>描述</th>
                    <th>文章数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="c">
                        <tr>
                            <td>
                                ${c.categoryName}
                            </td>
                            <td>
                                ${c.categoryDescription }
                            </td>
           
                            <td align="center">
                             <span class="layui-badge layui-bg-cyan">${c.articleCount}</span>
                            </td>
                             <td align="center">
                                    <button class="layui-btn" data-index="${c.categoryId}" data-type="editor">编辑</button>
                           			<button class="layui-btn layui-btn-danger layui-btn-mini" data-index="${c.categoryId}"  data-type="remove">删除</button>
                            </td>
                        </tr>
                        <c:forEach items="${c.childrenCategory}" var="cc">
                                                <tr>
                            <td>
                               -----------${cc.categoryName}
                            </td>
                            <td>
                                ${cc.categoryDescription }
                            </td>
           
                            <td align="center">
                           		<span class="layui-badge layui-bg-blue">${cc.articleCount}</span>
                            </td>
                             <td align="center">
                                    <button class="layui-btn" data-index="${cc.categoryId}" data-type="editor">编辑</button>
                           			<button class="layui-btn layui-btn-danger layui-btn-mini" data-index="${cc.categoryId}"  data-type="remove">删除</button>
                            </td>
                        </tr>
                        </c:forEach>


                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>分类最多只有两级，一级分类pid=0，二级分类pid=其父节点id</li>
                    <li>如果该分类包含文章，将不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>
</div>

<jsp:include page="public/headerjs.jsp"></jsp:include>

  <script>
  var active = {
		    editor: function(){
		    var str="${pageContext.request.contextPath }/admin/jump_editor_category?cid="+$(this).attr('data-index');
			var c=$(this).parent().parent();
		        layer.open({
		          type: 2
		          ,title: '修改分类'
		          ,content: str
		          ,maxmin: true
		          ,async: false
		          ,area: ['480px', '350px']
		          ,btn: ['确定', '取消']
		          ,yes: function(index, layero){
		             var category = window["layui-layer-iframe" + index].callbackdata();
		             console.log(category);
						$.ajax({
							url:'${pageContext.request.contextPath }/admin/update_category',
							data:category,
							cache: false,
							dataType:"json",
							success:function(data)
							{
								if(data.success==true)
								{
									layer.alert(data.msg,{icon:1},function(){
										 window.location.reload();
									});
								}
								else
									layer.msg("修改失败");
							}
						});
						layer.close(index);
		          }
		        }); 
		      },
		    insert:function(){
				  var categoryName=$("#categoryName").val();
				  
					if(categoryName)
						{
						$.ajax({
							url:'${pageContext.request.contextPath }/admin/insert_category',
							data:{		
								categoryName:$('#categoryName').val(),
								categoryPid:$('#categoryPid').val(),
								categoryOrder:$('#categoryOrder').val(),
								categoryDescription:$('#categoryDescription').val()
		        				},
							cache: false,
							async: false,
							dataType:"json",
							success:function(data)
							{
								if(data.success==true)
									{
									layer.alert(data.msg,{icon:1},function(){
										 window.location.reload();
									});
							
									}
								else
									layer.alert(data.msg,{icon:5});
								
							}
						});
						}else
							{
							layer.alert("分类名不能为空",{icon:5});
							}
		    	 },
		    remove:function(){
		    	var cid=$(this).attr('data-index');
		    	var c=$(this).parent().parent();
		    	layer.confirm('确定要删除？', {
		    	  btn: ['确认','取消'] //按钮
		    }, function(){
				$.post('${pageContext.request.contextPath}/admin/delete_category',
		 			   {
		 				cid:cid
		 				},function(d){
		 					if(d.success==true)
		 						{	 							
		 						c.remove();			
		 						}
		 					layer.msg(d.msg);
		 				},'json');
		    }, function(){
		    });
		    	}
		   }
	$(document).on('click','.layui-btn',function(){
		var type=$(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
  </script>
</body>
</html>