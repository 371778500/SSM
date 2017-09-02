<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>  
<html>
<head>
<meta charset="UTF-8">
<title>Shiro login</title>
</head>
<body>
<form action="login/auth" method="post" style="text-align: center;">
<div><label>用户名</label><input type="text" name="loginname" /></div>
<div><label>密   码</label><input type="text" name="password" /></div>
<div><label>验证码</label><input type="text" name="captcha" /><img src="genCaptcha" /></div>
<div><input type="submit" value="登	录" /></div>
</form>
</body>
</html>