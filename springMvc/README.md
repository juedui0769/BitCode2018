> springMvc

## Book01

> 看透springMvc源代码分析与实践[韩路彪]

- [springMvc/README.md](../springMvc/README.md)
- [sboot-springmvc/README.md](../sboot-springmvc/README.md)

### 第1章

#### 1.4.1 缓存和页面静态化

缓存的失效可以定期失效，也可以在数据变化的时候失效
- 这可以用来回答面试中常被问到的'缓存'问题
- 定期失效、数据变化时失效

页面静态化
- 将程序最后生成的页面保存起来
- 常用的`Freemarker`和`Velocity`都可以根据模板生成静态页面
- 也可以使用缓存服务器在应用服务器的上一层缓存生成的页面，如使用`Squid`，
- `Nginx`也提供了相应的功能。

#### 1.5.4 反向代理

反向代理指的是客户端直接访问的服务器并不真正提供服务，它从别的服务器获取资源然后将结果返回给用户。


### 第2章 常见协议和标准




### 第8章 Spring MVC之初体验

> 还是得编写`README.md`文件啊,我看了下local history,这个module是在20190420创建的,我现在忘得一干二净了。

根据第8章的描述，编写`web.xml`, `let'sGo-servlet.xml`, `GoController.java`, `go.jsp`,
`mvn tomcat:run`启动项目。

第8章只是介绍了一个简单的springMvc框架如何搭建的，章节末尾，在<http://repo.spring.io>下载了源代码，
然后MyEclipse中关联源码。

现在(2019年5月5日)不用这么麻烦，直接使用IDEA，在IDEA中搜索源码是很方便的。

### 第9章 创建Spring MVC之器










