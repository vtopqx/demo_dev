<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>水印设置</title>
<!-- 引入依赖的Jquery和JQuery-Form -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.form/4.2.1/jquery.form.min.js" 
    integrity="sha384-tIwI8+qJdZBtYYCKwRkjxBGQVZS3gGozr3CtI+5JF/oL1JmPEHzCEnIKbDbLTCer" 
    crossorigin="anonymous"></script>
    
</head>
<body>
<div>
<form id="addForm" action="<%=basePath%>/mark/doAdd.do" method="POST" enctype="multipart/form-data">
    <!-- 可以是任意个文件域 -->
    <h3>水印设置</h3>
        上传world文件：<input type="file" name="file1"/>
    <br>
        上传水印图片 ：
    <input type="file" name="file2"/>
    <br>
        设置水印文字：<input id="font_txt" type="text" name="name" /> 
     <br>
     说明：(分别支持图片水印和文字水印，上传水印图片时则自动忽略水印文字)
       <br>
       <br>
    <input type="button" id="submitBtn" value="生成水印文件"/>
      <br>
</form>
 <br>
生成水印下载：<a id="download" href="javascript:void(0);"></a>

<!-- 自定义JavaScript -->
<script type="text/javascript">
    $("#submitBtn").on("click", function(){
    	$("#download").attr("href","javascript:void(0);"); 
    	$("#download").text("正在生成水印,请稍后...");
    	var path = '<%=basePath%>upload/';
        $("#addForm").ajaxSubmit({
            success : function(data){
            	if(data.indexOf(".doc")!=-1 || data.indexOf(".docx")!=-1){
            		$("#download").attr("href",path+data); 
                    $("#download").text(path+data);
            	}else{
            		$("#download").text(data);
            	}
            },
            error : function(){
            	$("#download").text("文件过大，请上传小于50M文件!");
            }
        });
    });
</script>
</div>

</body>
</html>