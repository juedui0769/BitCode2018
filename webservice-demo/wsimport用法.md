> wsimport用法.md

--------------

```
用法: wsimport [options] <WSDL_URI>

\其中 [options] 包括:
  -b <path>                 指定 jaxws/jaxb 绑定文件或附加模式
                            (每个 <path> 都必须具有自己的 -b)
  -B<jaxbOption>            将此选项传递给 JAXB 模式编译器
  -catalog <file>           指定用于解析外部实体引用的目录文件
                            支持 TR9401, XCatalog 和 OASIS XML 目录格式。
  -d <directory>            指定放置生成的输出文件的位置
  -encoding <encoding>      指定源文件所使用的字符编码
  -extension                允许供应商扩展 - 不按规范
                            指定功能。使用扩展可能会
                            导致应用程序不可移植或
                            无法与其他实现进行互操作
  -help                     显示帮助
  -httpproxy:<host>:<port>  指定 HTTP 代理服务器 (端口默认为 8080)
  -keep                     保留生成的文件
  -p <pkg>                  指定目标程序包
  -quiet                    隐藏 wsimport 输出
  -s <directory>            指定放置生成的源文件的位置
  -target <version>         按给定的 JAXWS 规范版本生成代码
                            默认为 2.2, 接受的值为 2.0, 2.1 和 2.2
                            例如, 2.0 将为 JAXWS 2.0 规范生成兼容的代码
  -verbose                  有关编译器在执行什么操作的输出消息
  -version                  输出版本信息
  -wsdllocation <location>  @WebServiceClient.wsdlLocation 值
  -clientjar <jarfile>      创建生成的 Artifact 的 jar 文件以及
                            调用 Web 服务所需的 WSDL 元数据。
  -generateJWS              生成存根 JWS 实现文件
  -implDestDir <directory>  指定生成 JWS 实现文件的位置
  -implServiceName <name>   生成的 JWS 实现的服务名的本地部分
  -implPortName <name>      生成的 JWS 实现的端口名的本地部分

\扩展:
  -XadditionalHeaders              映射标头不绑定到请求或响应消息不绑定到
                                   Java 方法参数
  -Xauthfile                       用于传送以下格式的授权信息的文件:
                                   http://username:password@example.org/stock?wsdl
  -Xdebug                          输出调试信息
  -Xno-addressing-databinding      允许 W3C EndpointReferenceType 到 Java 的绑定
  -Xnocompile                      不编译生成的 Java 文件
  -XdisableAuthenticator           禁用由 JAX-WS RI 使用的验证程序,
                                   将忽略 -Xauthfile 选项 (如果设置)
  -XdisableSSLHostnameVerification 在提取 wsdl 时禁用 SSL 主机名
                                   验证

\示例:
  wsimport stock.wsdl -b stock.xml -b stoc
```

