<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>websocket Page</title>
</head>
<body>
	<div id="time" style="height:500px;"></div>
	
	<div><button id="start">开始</button>
		 <button id="end">结束</button>
		 <button id="gointo">快进10秒</button>
		 <button id="goouto">后退10秒</button></div>
   
</body>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="chat.js"></script>
<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
    	websocket = new Socket("ws://localhost:8080/SSM/webSocketServer.do",messageHandle);
    }
    else {
        alert('当前浏览器 Not support websocket')
    }


</script>
</html>