# SSM+quartz+websocket+webservice+shiro

SSM:
基于spring springMVC mybatis 搭建的项目示例
添加任务调度quartz功能示例

quartz:
测试quartz 任务的启动，暂停，恢复，删除，重置
可以在启动服务时访问如下链接查看工作台日子：

启动：http://localhost:8080/SSM/quartz/start1
启动：http://localhost:8080/SSM/quartz/start2
暂停：http://localhost:8080/SSM/quartz/stop
恢复：http://localhost:8080/SSM/quartz/upstop
删除：http://localhost:8080/SSM/quartz/del
重置：http://localhost:8080/SSM/quartz/uodate


websocket:
 实现消息的发送
测试路径： http://localhost:8080/SSM/test/websocket

webservice:
发布代码在 service包下，客户端代码在client包下，客户端代码是通过创建 web service cilent项目自动生成的
测试地址：http://localhost:8080/SSM/ws/webservice?wsdl

shiro : 拦截未登录的链接资源
测试地址：：http://localhost:8080/SSM/login
http://localhost:8080/SSM/success
