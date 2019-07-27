
# books

- book01 : 《Java Concurrency in Practice》
- book02 : 《Java并发编程的艺术》 方腾飞


## book01

> 《Java Concurrency in Practice》 童云兰 译

### pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>net.jcip</groupId>
        <artifactId>jcip-annotations</artifactId>
        <version>RELEASE</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

`jcip-annotations` 了解一下！


### 2.3.2 重入

> 在平安评级时被问到过: synchorinzed 是否可'重入'？

### 15.2.1 比较并交换

这里讲解了CAS，并用Java代码模拟CAS的实现，参考 ： `book01.ch15.SimulatedCAS`
， 这比看视频更直观，网上很多视频讲解不清晰，不如看本书直观。（蚂蚁课堂、B站上的视频可以搜索到一些）










