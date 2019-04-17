<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Demo</title>
<style type="text/css">
    input[type="submit"]{
        outline: none;
        border-radius: 5px;
        cursor: pointer;
        background-color: #31B0D5;
        border: none;
        width: 700px;
        height: 35px;
        font-size: 20px;
    }
    img{
        border-radius: 50%;
    }
    input[type="file"]{
        position: absolute;
        left: 0;
        top: 0;
        height: 2000px;
        opacity: 0;
        cursor: pointer;
    }
</style>

<script type="text/javascript">
    function prev(event){
        //获取展示图片的区域
        var img = document.getElementById("prevView"); 
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
</script>

</head>
<body>
      <img src="${pageContext.request.contextPath}/static/images/1.jpg" alt="" width="45" height="45" id="prevView">
    <input type="file" name="" id="" value="" onchange="prev(this)"/>      
</body>
</html>
