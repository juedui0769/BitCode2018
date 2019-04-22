> webservice-demo

### 来自网络

<https://www.cnblogs.com/fengwenzhee/p/6915606.html>

运行 `com.wxg.service.WebServicePublish`, 访问 <http://localhost:8989/ws/bb?wsdl>

```
cd ...\BitCode2018-parent\webservice-demo\src\main\java

wsimport -s ./ -p com.wxg.client -keep http://localhost:8989/ws/bb?wsdl
```

wsimport的用法参考这个链接： [wsimport用法.md](./wsimport用法.md)

编写测试类 `com.wxg.test.WsClient` , 运行可以看到结果.



