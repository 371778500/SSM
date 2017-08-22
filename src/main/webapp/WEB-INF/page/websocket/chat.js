function diao(url,callback) {
    
	var socket = new WebSocket(url);

	//开启连接websocket
    socket.onopen = function(event){
        console.log(currentUser," login in");
        var message = {
            type : 0,
            username : currentUser
        };
        //向后台发送消息，触发后台监听器
        socket.send(JSON.stringify(message));
    }

    //监听后台发送的消息 
    socket.onmessage = function(event) {
        callback(event);
    }

    //连接关闭
    socket.onclose = function(event) {

    }

    //连接出错
    socket.onerror = function(event) {
        console.log("socket error");
        socket.close();
    }
    return socket;
}



//回调方法，处理接受前台的消息
function messageHandle(event) {
	console.log(event.data.type);
    var jsonStr = event.data;
    var data = JSON.parse(jsonStr);
    var $message = null;
    switch(data.type) {
        //更新聊天显示框
        case 1:
            if(data.username == currentUser) return;
            $message = messagePackage({
               username : data.username,
                timeSign : data.timeSign,
                content : data.content
            });
            $show.append($message);
            //让滚动条自动滚到底
            $show.get(0).scrollTop = $show.get(0).scrollHeight;
            break;
        //向已经在线的用户发送用户列表更新信息
        case 2:
            var $userName = $("<p></p>");
            $userName.text(data.username);
            $("#usersInfo").append($userName);

            break;
        //将所有已经在线的用户信息发送给刚加入的用户
        case 3:
            var usernames = data.usernames;
            var $usersInfo = $("#usersInfo");
            $usersInfo.empty();
            for(var i= 0,len=usernames.length;i<len;i++) {
                var $userName = $("<p></p>");
                $userName.text(usernames[i]);
                $usersInfo.append($userName);
            }
           
            break;
        //删除用户信息
        case 4:
            var $usersInfo = $("#usersInfo");
            $usersInfo.find(":contains("+data.username+")").remove();
    }

}
//获取时间
function getTime() {
    var currentTime = {};
    var raw = new Date();
    currentTime.date = raw.getFullYear() + "-" + raw.getMonth() + "-" + raw.getDate();
    currentTime.time = raw.getHours() + ":" + raw.getMinutes() + ":" + String(raw.getMilliseconds()).slice(0,2);
    return currentTime;
}