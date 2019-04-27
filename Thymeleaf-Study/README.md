> Thymeleaf Study

### V2升级到V3的注意点

<https://www.thymeleaf.org/doc/articles/thymeleaf3migration.html> ，
不知从哪里入手，先从这个版本升级文档中开始，也不错。

#### 1. Template changes

removing any `th:inline="text"` attributes you might have

#### 8. Performance improvements

Thymeleaf 3’s engine has been rewritten from scratch with the main focus put on performance. Thymeleaf 3 performs much better than the previous versions so we hope it covers the needs of more and more projects. But Thymeleaf 3’s performance is not only about rendering time: it has also been specifically designed to have a low memory footprint and help reduce latency in high-concurrency scenarios.

> Thymeleaf3的引擎已经从零开始重写，主要的重点放在性能上。
Thymeleaf3的性能比以前的版本好得多，所以我们希望它能满足越来越多的项目的需要。
但是Thymeleaf3的性能不仅与渲染时间有关：它还被专门设计为在高并发场景中具有低内存占用和帮助减少延迟。

But performance improvements do not stop at the architectural level: there are also some performance goodies in v3.0 like the ability to enable the SpringEL (Spring Expression Language or SpEL) compiler that, since version 4.2.4 of the Spring Framework, can be used by Thymeleaf in order to give an extra push to template processing performance in Spring-enabled environments. See Configuring the SpringEL compiler.

> 但是性能改进并不止于体系结构级别：v3.0中也有一些性能优点，比如启用Springel(Spring Expression Language或Spel)编译器的能力，自SpringFramework的4.2.4版本以来，Thymeleaf可以使用该编译器，以便在启用Spring的环境中对模板处理性能起到额外的推动作用。
请参见配置Springel编译器。

And if you are not using Spring and therefore your expression language is OGNL, we’ve made some performance improvements there too, even making a couple of contributions to the OGNL codebase that should benefit Thymeleaf’s performance in environments such as those based on the new MVC1.0 (JSR371) standard.

> 如果您没有使用Spring，因此您的表达式语言是OGNL，那么我们也在那里做了一些性能改进，甚至对OGNL代码库做出了一些贡献，这应该有利于Thymeleaf在诸如基于新MVC1.0(JSR371)标准的环境中的性能。

#### 9. Independence from the Servlet API

Versions prior to Thymeleaf 3.0 were already independent from the Java Servlet API in the sense that Thymeleaf allowed offline execution of the template engine, i.e. processing templates without the application living in a web container. This was useful in scenarios such as processing email templates.

> Thymeleaf 3.0之前的版本已经独立于JavaservletAPI，因为Thymeleaf允许离线执行模板引擎，即处理模板时应用程序不在Web容器中。
这在处理电子邮件模板等场景中很有用。

But Thymeleaf 3.0 includes a series of improvements that can make Thymeleaf truly independent from the Servlet API in web environments that do not make use of Java Servlets such as many of the reactive frameworks available today (more on this in the next section), which will be now able to integrate with Thymeleaf in an easier and more elegant way.

> 但是Thymeleaf 3.0包含了一系列的改进，可以使Thymeleaf真正独立于不使用JavaServlet的Web环境中的ServletAPI，比如现在可用的许多反应性框架(下一节将详细介绍)，这些框架现在将能够以一种更简单、更优雅的方式与Thymeleaf集成。

-------------







