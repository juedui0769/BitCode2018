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

<https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html>
有PDF下载, 才发现我之前下载过，PC和笔记本上都有一个"unsingthymeleaf.pdf"文件。
之前应该是阅读到第`3`章了，但是，我没有一点印象，现在又从第一章开始阅读。

## usingthymeleaf

### 1 Introducing Thymeleaf

1.1 What is Thymeleaf?

1.2 What kind of templates can Thymeleaf process?

1.3 Dialects: The Standard Dialect

> 第一章就是对`Thymeleaf`的综合介绍。告诉Thymeleaf能做什么，可以处理哪些模板(哪些类型的文件:html,xml,text,js,css,raw)，
以及`Dialects`，这个后文应该会详细介绍的。

### 2 The Good Thymes Virtual Grocery

The Good Thymes Virtual Grocery : 百度、腾讯，都翻译不出来。

[grocery](https://fanyi.baidu.com/#en/zh/grocery) : 食品杂货店(在美国英语中grocery store常用以指supermarket);食品杂货

文档在这里以一个食品杂货店为例引出`Thymeleaf`的使用。

2.1 A website for a grocery

2.2 Creating and configuring the Template Engine
- The Template Resolver
- The Template Engine

### 3 Using Texts

#### 3.1 A multi-language welcome

```xml
<p th:text="#{home.welcome}">Welcome to our grocery store!</p>

<p data-th-text="#{home.welcome}">Welcome to our grocery store!</p>
```

建议使用`th:*`,而不是`data-`,因为`th:*`可以用在`XML`,`TEXT`...任何Thymeleaf支持的模式中,而`data-`只能用在`HTML`模式中。

国际化支持: standard message resolver 会在同目录下寻找`.properties`文件, 
比如, 针对`/WEB-INF/templates/home.html`, 会寻找同目录下的
- `/WEB-INF/templates/home_en.properties` for English texts.
- `/WEB-INF/templates/home_es.properties` for Spanish language texts.
- `/WEB-INF/templates/home.properties` for default texts (if the locale is not matched).

Contexts
- `${x}` will return a varialbe `x` stored into the Thymeleaf context or as a *request* attribute.
- `${param.x}` will return a request parameter called `x` (which might be multivalued).
- `${session.x}` will return a session attribute called `x`.
- `${application.x}` will return a servlet context attribute called `x`.

#### 3.2 More on texts and variables

**Unescaped Text**

`th:utext` for "unescaped text"

**Using and displaying variables**

```xml
<body>
    <p th:utext="#{home.welcome}">Welcome to our grocery store!</p>
    <p>Today is: <span th:text="${today}">13 February 2011</span></p>
</body>
```

注意！ `#{}` , `${}`
- `#{}` : message expressions
- `${}` : variable expressions

The `${today}` expression simply means "get the variable called today", but these expressions could be more 
complex (like `${user.name}` for "get the variable called user, and call its `getName()` method").

### 4 Standard Expression Syntax

Simple expressions: 
- Variable Expressions: `${...}`
- Selection Variable Expressions: `*{...}`
- Message Expressions: `#{...}`
- Link URL Expressions: `@{...}`
- Fragment Expressions: `~{...}`

Text operations:
- String concatenation: `+`
- Literal substitutions: `|The name is ${name}|`

Arithmetic operations:
- Binary operations: `+, -, *, /, %`
- Minus sign (unary operator): `-`

Boolean operations:
- Binary operators: `and`, `or`
- Boolean negation (unary operator): `!`, `not`

Comparisons and equality:
- Comparators: `<, >, <=, >=` (`gt, lt, ge, le`)
- Equality operators: `==, !=` (`eq, ne`)

Conditional operators:
- if-then: `(if) ? (then)`
- if-then-else: `(if) ? (then) : (else)`
- Default: `(value) ?: (defaultvalue)`

Special tokens:
- No-Operation: `_`

All these features can be combined and nested:

```
'User is of type ' + (${user.isAdmin()} ? 'Administrator' : (${user.type} ?: 'Unknown'))
```

#### 4.1 Messages

在message中引入动态值

```xml
<p th:utext="#{home.welcome(${session.user.name})}">
Welcome to our grocery store, Sebastian Pepper!
</p>

<p th:utext="#{${welcomeMsgKey}(${session.user.name})}">
Welcome to our grocery store, Sebastian Pepper!
</p>
```

#### 4.2 Variables

```
# 这跟JS差不多,访问对象的属性,实际调用属性的getter方法,也可以使用`[]`代替`.`
${person.father.name}
${person['father']['name']}

# map
${countriesByCode.ES}
${personsByName['Stephen Zucchini'].age}

# arrays, collections
${personArray[0].name}

# 也可以调用方法,可以传递参数
${person.createCompleteName()}
${person.createCompleteNameWithSeparator('-')}
```

Expression Basic Objects
- `#ctx` : the context object.
- `#vars` : the context variables.
- `#locale` : the context locale.
- `#request` : HttpServletRequest
- `#response` : HttpServletResponse
- `#session` : HttpSession
- `#servletContext` ServletContext

> 附录A 有更详细的清单

Expression Utility Objects
- `#execInfo`:
- `#message`:
- `#uris`:
- `#conversions`:
- `#dates`:
- `#calendars`:
- `#numbers`:
- `#strings`:
- `#objects`:
- `#bools`:
- `#arrays`:
- `#lists`:
- `#sets`:
- `#maps`:
- `#aggregates`:
- `#ids`:

> 附录B 有详细介绍

Reformatting dates in our home page

```html
ctx.setVariable("today", Calendar.getInstance());

<p>
  Today is: <span th:text="${#calendars.format(today, 'dd MMMM yyyy')}">13 May 2011</span>
</p>
```

#### 4.3 Expressions on selections (asterisk syntax)

```xml
<div th:object="${session.user}">
    <p>Name: <span th:text="${#object.firstName}">Sebastian</span>.</p>
    <p>Surname: <span th:text="${session.user.lastName}">Pepper</span>.</p>
    <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
</div>
```

- 因为指定`th:object="${session.user}"`,所以`*{nationality}`就代表`${session.user.nationality}`
- 也可以加上`${#object.}`前缀 -> `${#object.nationality}`
- `${session.user.nationality}` 也可以写成 `*{session.user.nationality}`

#### 4.4 Link URLs

```xml
<!-- Will produce 'http://localhost:8080/gtvg/order/details?orderId=3' (plus rewriting) -->
<a href="details.html"
    th:href="@{http://localhost:8080/gtvg/order/details(orderId=${o.id})}">view</a>
<!-- Will produce '/gtvg/order/details?orderId=3' (plus rewriting) -->
<a href="details.html" th:href="@{/order/details(orderId=${o.id})}">view</a>
<!-- Will produce '/gtvg/order/3/details' (plus rewriting) -->
<a href="details.html" th:href="@{/order/{orderId}/details(orderId=${o.id})}">view</a>
```

A menu for our home page

Server root relative URLs

```xml
@{~/path/to/something}
```

#### 4.5 Fragments


```xml
<div th:insert="~{commons :: main}">...</div>

<div th:with="frag=~{footer :: #main/text()}">
    <p th:insert="${frag}">
</div>
```

#### 4.6 Literals

- String 使用`'`包括的内容。
- number 可以做算术运算
- boolean 注意 `==` 的放置位置
    - `<div th:if="${user.isAdmin()} == false"> ...`
    - `<div th:if="${user.isAdmin() == false}"> ...`
- null

#### 4.7 Appending texts

```xml
<span th:text="'The name of the user is ' + ${user.name}">
```

#### 4.8 Literal substitutions

```xml
<span th:text="|Welcome to our application, ${user.name}!|">

<span th:text="'Welcome to our application, ' + ${user.name} + '!'">
```

以上两句是相等的。

> Only variable/message expressions (`${...}`, `*{...}`, `#{...}`) are allowed inside `|...|` literal substitutions.

#### 4.9 Arithmetic operations


#### 4.10 Comparators and Equality

- gt (`>`)
- gt, lt, ge, le, not, eq, neq/ne

#### 4.11 Conditional expressions

```xml
<tr th:class="${row.even}? 'even' : 'odd'">
    ...
</tr>
```

```xml
<tr th:class="${row.even}? (${row.first}? 'first' : 'even') : 'odd'">
    ...
</tr>
```

#### 4.12 Default expressions (Elvis operator)


#### 4.13 The No-Operation token

```xml
<span th:text="${user.name} ?: 'no user authenticated'">...</span>

<span th:text="${user.name} ?: _">no user authenticated</span>
```

#### 4.14 Data Conversion / Formatting

`${{...}}`, `*{{...}}`

> 这里没明白，似乎得继承接口，做些处理，让Thymeleaf来调用。

#### 4.15 Preprocessing

这个没看懂。

### 5 Setting Attribute Values

#### 5.1 Setting the value of any attribute

```
th:attr

<input type="submit" value="Subscribe!" th:attr="value=#{subscribe.submit}"/>
```

也可以设置多个属性，例子如下：

```xml
<img src="../../images/gtvglogo.png"
    th:attr="src=@{/images/gtvglogo.png},title=#{logo},alt=#{logo}" />

<img src="/gtgv/images/gtvglogo.png" title="Logo de Good Thymes" 
    alt="Logo de Good Thymes" />
```

#### 5.2 Setting value to specific attributes

这一节将所有的 HTML5 attribute 都列举出来了

#### 5.3 Setting more than one value at a time

- `th:alt-title`: will set `alt` and `title`.
- `th:lang-xmllang`: will set `lang` and `xml:lang`.

#### 5.4 Appending and prepending

- `th:attrappend`: 添加后缀
- `th:attrprepend`: 添加前缀
- `th:classappend`: 
- `th:styleappend`: 添加样式

```xml
<input type="button" value="Do it!" class="btn" th:attrappend="class=${' ' + cssStyle}" />

<tr th:each="prod : ${prods}" class="row" th:classappend="${prodStat.odd}? 'odd'">
```

#### 5.5 Fixed-value boolean attributes


> 边阅读文档边做记录很容易疲惫，进度会非常缓慢。所以我决定先不做笔记，先快速阅读一遍文档。
>
> 目前 8.3 Flexible layouts: beyond mere ... -> Advanced conditional insertion of fragments


















































