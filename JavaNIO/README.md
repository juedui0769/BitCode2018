
### Java NIO 系列教程

英文网址： <http://tutorials.jenkov.com/java-nio/index.html>

总览： <http://ifeve.com/java-nio-all/>

001 概述： <http://ifeve.com/overview/>

002 Channel <http://ifeve.com/channels/>

003 Buffer <http://ifeve.com/buffers/>

004 scatter/gather <http://ifeve.com/java-nio-scattergather/>
- `scatter` 分散，感觉没什么用处。
- `gather` 聚集，

005 通道之间的数据传输 <http://ifeve.com/java-nio-channel-to-channel/>
- <http://tutorials.jenkov.com/java-nio/channel-to-channel-transfers.html> ， 中文翻译版本，有些问题，建议这章直接阅读原文

006 Selector <http://ifeve.com/selectors/>
- <http://tutorials.jenkov.com/java-nio/selectors.html> , 英文原文
- 中英文对照着看会好很多

> SelectionKey.OP_ACCEPT, SelectionKey.OP_CONNECT, SelectionKey.OP_READ, SelectionKey.OP_WRITE
>
> opAccept: 16 , opConnect: 8, opRead: 1, opWrite: 4
>
> 这几个值都是 `2` 的倍数幂，相互之间做 `&` 操作，之后和自己 `&` 才是不为零的。

```java
int opAccept = SelectionKey.OP_ACCEPT;
int opConnect = SelectionKey.OP_CONNECT;
int opRead = SelectionKey.OP_READ;
int opWrite = SelectionKey.OP_WRITE;
int all = opAccept | opConnect | opRead | opWrite;
System.out.printf("opAccept: %d , opConnect: %d, opRead: %d, opWrite: %d\n",
        opAccept, opConnect, opRead, opWrite);
System.out.printf("opAccept: %d\n", opAccept);
System.out.printf("all: %d\n", all);
System.out.println((opAccept & opConnect));
System.out.println((opAccept & all));
```

007 FileChannel <http://ifeve.com/file-channel/>
- <http://tutorials.jenkov.com/java-nio/file-channel.html>









