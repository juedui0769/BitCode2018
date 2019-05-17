
参考 : <https://blog.csdn.net/iku5200/article/details/82856621>
- <https://github.com/wjup/springBoot_Mybatis/tree/master/Springboot_Mybatis>

```yml

spring:
  profiles:
    active: dev

```

激活`application-dev.yml`

```yml

mybatis:
  mapper-locations: classpath:mapping/*Mapper.xml
  type-aliases-package: com.com.example.entity

```

指定mapper文件的存放位置


