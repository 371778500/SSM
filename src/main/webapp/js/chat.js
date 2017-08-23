function Socket(url,callback) {
    
	var socket = new WebSocket(url);

	//开启连接websocket
    socket.onopen = function(event){
        var info = {
            type : "start",
            username:"lcp"
        };
        //向后台发送消息，触发后台监听器
        socket.send(JSON.stringify(info));
    }

    //监听后台发送的消息 
    socket.onmessage = function(event) {
        callback(event);
    }

    //连接关闭
    socket.onclose = function(event) {
    	console.log("socket error");
    	socket.close();
    }

    //连接出错
    socket.onerror = function(event) {
        console.log("socket error");
        $_websocket=null;
        socket.close();
    }
    return socket;
}

//回调方法，处理接受前台的消息
function edittime(event){
	var jsonStr = event.data;
	var data = JSON.parse(jsonStr);
	$("#time").html("");
	$("#time").html(data.time);
}

