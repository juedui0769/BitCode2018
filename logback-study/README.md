
官网 : <https://logback.qos.ch/>

参考 <https://www.cnblogs.com/warking/p/5710303.html>

<https://www.cnblogs.com/lixuwu/p/5804793.html>

#### importnew

<http://www.importnew.com/28541.html>

这篇文章是完整看完了的，感觉还不错，对logback有了感性的认识。

> 现在欠缺的是实际配置。比如：应对某个问题，想追踪某个类或包的日志，
> 如何在logback中配置以达到目的……


### spring, logback

参考 <https://blog.csdn.net/zhanglf02/article/details/77849025>

```xml
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>

    <dependency>
        <groupId>org.logback-extensions</groupId>
        <artifactId>logback-ext-spring</artifactId>
        <version>0.1.4</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>jcl-over-slf4j</artifactId>
        <version>1.7.25</version>
    </dependency>
```

### logback-ext-spring

`ch.qos.logback.ext.spring`

`ch.qos.logback.ext.spring.LogbackConfigurer`

### jcl-over-slf4j

`org.apache.commons.logging.impl.SLF4JLocationAwareLog`









