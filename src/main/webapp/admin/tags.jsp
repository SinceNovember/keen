<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"></jsp:include>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/my.css" media="all">

</head>
<body>
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
            <fieldset class="layui-elem-field layui-field-title">
              <legend>标签目录</legend>
            </fieldset>
            
 <div class="layui-form" >
           <div class="layui-col-md4">
        <div class="layui-card">
          <div class="layui-card-header"><h3><strong>添加标签</strong></h3></div>
          <hr class="layui-bg-black">
          <div class="layui-card-body layui-text">
			<div class="layui-form-item">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="tagName" id="tagName" placeholder="请输入标签名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        字体大小
                        <input type="text" name="fontSize" id="fontSize" placeholder="字体大小，例如15px" value="20px" autocomplete="off" class="layui-input" >
                    </div>
                     <br>
 					<div class="layui-input-block">
                        字体颜色
                        	<input type="color" id="fontColor" value="#26211e" class="layui-input"/>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" id="confirm" lay-filter="formDemo" data-type="insert" type="submit">添加</button>
                    </div>
                </div>
                       <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>1、标签名必选，建议不要太长</li>
                    <li>2、标签名勿重复</li>
                    <li>3、字体大小跟颜色需按要求填写</li>
                </ul>
            </blockquote>
          </div>
        </div>
        </div>
        </div>
              
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="150">
                    <col width="50">
                    <col width="50">
                    <col width="150">
                    <col width="50">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>大小</th>
                    <th>颜色</th>
                    <th>样式</th>
                    <th>文章数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tags}" var="t">
                
                    <tr>
                        <td>
                            <a href="/tag/${t.tagId}" target="_blank">${t.tagName}</a>
                        </td>
                        <td>
                        ${t.fontSize }
                        </td>
                        <td>
                         ${t.fontColor }
                        </td>
                        <td>
							<span style="font-size:${t.fontSize};color:${t.fontColor}">${t.tagName }</span>
                        </td>
                        <td align="center">
                        <span class="layui-badge layui-bg-orange" id="articleCount" value="${t.articleCount}">${t.articleCount}</span>
                        </td>
                        <td align="center">
                            <button class="layui-btn" data-index="${t.tagId}" data-type="editor">编辑</button>
                            <button class="layui-btn layui-btn-danger layui-btn-mini" data-index="${t.tagId}"  data-type="remove">删除</button>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>如果该标签包含文章，将不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>
</div>
<jsp:include page="public/headerjs.jsp"></jsp:include>
<script>

    //事件
    var active = {
    editor: function(){
    var str="${pageContext.request.contextPath }/admin/jump_editor_tag?tid="+$(this).attr('data-index');
 	var tid=$(this).attr('data-index');
	var t=$(this).parent().parent();
        layer.open({
          type: 2
          ,title: '修改标签'
          ,content: str
          ,maxmin: true
          ,async: false
          ,area: ['480px', '350px']
          ,btn: ['确定', '取消']
          ,yes: function(index, layero){
             var tag = window["layui-layer-iframe" + index].callbackdata();
				$.ajax({
					url:'${pageContext.request.contextPath }/admin/update_tag',
					data:tag,
					cache: false,
					dataType:"json",
					success:function(data)
					{
						if(data.success==true)
						{
						layer.msg("修改成功");
						str='<td>'+data.tag.tagName+'</td><td>'+data.tag.fontSize+' </td><td>'+data.tag.fontColor+'</td><td>	<span style="font-size:'+data.tag.fontSize+';color:'+data.tag.fontColor+'">'+data.tag.tagName+'</span><td align="center"> <span class="layui-badge layui-bg-orange">0</span></td> <td align="center"><button class="layui-btn" data-index="'+data.tag.tagId+'" data-type="editor">编辑</button><button class="layui-btn layui-btn-danger layui-btn-mini" data-index="'+data.tag.tagId+'"  data-type="remove">删除</button>  </td></tr>';
						t.html(str);
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
		var tagName=$('#tagName').val();
		var fontSize=$('#fontSize').val();
		var fontColor=$('#fontColor').val();
			if(tagName)
				{
				$.ajax({
					url:'${pageContext.request.contextPath }/admin/insert_tag',
					data:{		
						'tagName':tagName,
        				'fontSize':fontSize,
        				'fontColor':fontColor
        				},
					cache: false,
					async: false,
					dataType:"json",
					success:function(data)
					{
						layer.alert("添加成功",{icon:1});
						str='<tr><td>'+data.tag.tagName+'</td><td>'+data.tag.fontSize+' </td><td>'+data.tag.fontColor+'</td><td>	<span style="font-size:'+data.tag.fontSize+';color:'+data.tag.fontColor+'">'+data.tag.tagName+'</span><td align="center"> <span class="layui-badge layui-bg-orange">0</span></td> <td align="center"><button class="layui-btn" data-index="'+data.tag.tagId+'" data-type="editor">编辑</button><button class="layui-btn layui-btn-danger layui-btn-mini" data-index="'+data.tag.tagId+'"  data-type="remove">删除</button>  </td></tr>';
						$("tbody").append(str);
					}
				})
				}else
					{
					layer.alert("标签名不能为空",{icon:5});
					}
    	 },
    remove:function(){
    	var tid=$(this).attr('data-index');
    	var t=$(this).parent().parent();
    	layer.confirm('确定要删除？', {
    	  btn: ['确认','取消'] //按钮
    }, function(){
		$.post('${pageContext.request.contextPath}/admin/delete_tag',
 			   {
 				tid:tid
 				},function(d){
 					if(d.success==true)
 						{
 						t.remove();
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