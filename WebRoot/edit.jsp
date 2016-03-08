<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script charset="utf-8" src="kindeditor-all.js"></script>
<script charset="utf-8" src="/lang/zh_CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>
  </head>
  
  <body>
    <textarea id="editor_id" name="content" style="width:700px;height:300px;">
<b><span style="color:#B8D100;">大家好</span></b><span style="color:#B8D100;"></span><span style="color:#B8D100;">颠三倒四但是但是</span>
</textarea>

<img src="http://api.map.baidu.com/staticimage?center=121.518547%2C31.193826&zoom=10&width=558&height=360&markers=121.518547%2C31.193826&markerStyles=l%2CA" alt="" /><b><span style="color:#B8D100;">大家好</span></b><span style="color:#B8D100;"></span><span style="color:#B8D100;">颠三倒四但是但是</span>
  </body>
</html>
