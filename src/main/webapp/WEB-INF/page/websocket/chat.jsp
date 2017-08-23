<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>websocket Page</title>
</head>
<body>
	<div id="time" style="height:200px;text-align: center;font-size: 34px;line-height: 200px;">0000-00-00 00:00:00</div>
	
	<div style="text-align: center"><button id="start">开始</button>
		 <button id="end">结束</button>
		 <button id="gointo">快进10分钟</button>
		 <button id="goouto">后退10分钟</button></div>
   
</body>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/chat.js"></script>
<script type="text/javascript">
$(function(){
	window.$_websocket = null;
    var timeclick=0;
    //开始,启动websocket连接
    $("#start").on("click",function(){
    	//判断当前浏览器是否支持WebSocket 
    	//每个客户端执行这段代码时就会开启连接，然后会传入一个id到后台，这样就实现了客户端与服务端的一个长连接
        if ('WebSocket' in window && $_websocket==null ) {
        	$_websocket = new Socket("ws://localhost:8080/SSM/webSocketServer",edittime);
        }
        else {
            alert('连接已经开启')
        }
    });
  	//结束,关闭websocket连接
    $("#end").on("click",function(){
    	if($_websocket!=null){
    		$_websocket.close();
    		$_websocket = null
    	}
    });
 	 //快进10分钟,向后台发送消息，快进十分钟
    $("#gointo").on("click",function(){
    	timeclick=timeclick+1;
    	if($_websocket!=null){
    		var info = {
   	            type : "gointo",
   	            time : timeclick*10
   	            
   	        };
   	        //向后台发送消息，触发后台监听器
   	        $_websocket.send(JSON.stringify(info));
    	}
    });
  	//后退10分钟，向后台发送消息，后退10分钟
    $("#goouto").on("click",function(){
    	timeclick=timeclick-1;
    	if($_websocket!=null){
    		var info = {
   	            type : "goouto",
   	         	time : timeclick*10
   	        };
   	        //向后台发送消息，触发后台监听器
   	        $_websocket.send(JSON.stringify(info));
    	}
    });
})

</script>
</html>