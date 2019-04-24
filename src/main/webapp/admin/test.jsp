
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>图片上传示例 - Editor.md examples</title>
        <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />
  <script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
    </head>
    <body>
        <div id="layout" style="height: 2000px;background: #f6f6f6;">
            <header>
                <h1>图片上传示例</h1>
                <p>Image upload example</p>
            </header>
            <div id="test-editormd">
                <textarea style="display:none;">#### Settings

```javascript
{
    imageUpload    : false,
    imageFormats   : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
    imageUploadURL : "./php/upload.php",
}
```

#### JSON data

```json
{
    success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
    message : "提示的信息，上传成功或上传失败及错误信息等。",
    url     : "图片地址"        // 上传成功时才返回
}
```</textarea>
        </div>
        <button id="qqq" value="点击">点击</button>
        </div>        
              <script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
        <script src="../static/editor/editormd.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
        	$("#qqq").click(function(){
        		layer.alert("添加成功",{icon:1});
        		console.log("继器");
                layer.open({
                    type: 2
                    ,title: '修改标签'
                    ,content: 'editor_tag.jsp'
                    ,maxmin: true
                    ,area: ['480px', '350px']
                    ,btn: ['确定', '取消']
                    ,yes: function(index, layero){
                      var iframeWindow = window['layui-layer-iframe'+ index]
                      ,submitID = 'LAY-user-front-submit'
                      ,submit = layero.find('iframe').contents().find('#'+ submitID);

                      //监听提交
                      iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                        var field = data.field; //获取提交的字段
                        
                        //提交 Ajax 成功后，静态更新表格中的数据
                        //$.ajax({});
                        table.reload('LAY-user-front-submit'); //数据刷新
                        layer.close(index); //关闭弹层
                      });  
                      
                      submit.trigger('click');
                    }
                  }); 
        	});
        });
//             $(function() {                
//                 var testEditor = editormd("test-editormd", {
//                     width: "90%",
//                     height: 640,
//                     markdown : "",
//                     path : '../static/editor/lib/',
//                     //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为 true
//                     //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为 true
//                     //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为 true
//                     //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为 0.1
//                     //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为 #fff
//                     imageUpload : true,
//                     imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
//                     imageUploadURL : "./php/upload.php?test=dfdf",
                    
//                     /*
//                      上传的后台只需要返回一个 JSON 数据，结构如下：
//                      {
//                         success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
//                         message : "提示的信息，上传成功或上传失败及错误信息等。",
//                         url     : "图片地址"        // 上传成功时才返回
//                      }
//                      */
//                 });
//             });
        </script>
    </body>
</html>