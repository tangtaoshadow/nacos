# nacos 结构剖析





## 模块依赖结构
> 更新时间：2020-5-25 00:12:10

![nacos-模块依赖图-2020-5-25 000113.png](https://cdn.nlark.com/yuque/0/2020/png/389953/1590336723915-0d2faa50-135a-4be4-962c-2fa891c499b7.png#align=left&display=inline&height=461&margin=%5Bobject%20Object%5D&name=nacos-%E6%A8%A1%E5%9D%97%E4%BE%9D%E8%B5%96%E5%9B%BE-2020-5-25%20000113.png&originHeight=461&originWidth=614&size=40346&status=done&style=none&width=614)
### 各模块作用

- address模块: 主要查询nacos集群中节点个数以及IP的列表.
- api模块: 主要给客户端调用的api接口的抽象.
- common模块: 主要是通用的工具包和字符串常量的定义
- client模块: 主要是对依赖api模块和common模块,对api的接口的实现,给nacos的客户端使用.
- cmdb模块: 主要是操作的数据的存储在内存中,该模块提供一个查询数据标签的接口.
- config模块: 主要是服务配置的管理, 提供api给客户端拉去配置信息,以及提供更新配置
的,客户端通过长轮询的更新配置信息.数据存储是mysql.
- naming模块: 主要是作为服务注册中心的实现模块,具备服务的注册和服务发现的功能.
- console模块: 主要是实现控制台的功能.具有权限校验、服务状态、健康检查等功能.
- core模块: 主要是实现Spring的PropertySource的后置处理器,用于加载nacos的default的配置信息.
- distribution模块: 主要是打包nacos-server的操作,使用maven-assembly-plugin进行自定义打包,



## 依赖


> 更新时间：2020-5-25 01:18:40

### nacos-core


> 主要是实现Spring的`PropertySource`的后置处理器,用于加载`nacos`的default的配置信息.



```xml
<modelVersion>4.0.0</modelVersion>

<artifactId>nacos-core</artifactId>
<packaging>jar</packaging>
<dependency>
      <groupId>${project.groupId}</groupId>
      <artifactId>nacos-common</artifactId>
</dependency>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-consistency</artifactId>
</dependency>
```


## nacos-distribution
### 
> 主要是打包nacos-server的操作,使用maven-assembly-plugin进行自定义打包，部署相关工程-源码最终打包发布



```xml
<artifactId>nacos-distribution</artifactId>
<name>nacos-distribution ${project.version}</name>
<packaging>pom</packaging>

<dependencies>
    <dependency>
        <groupId>com.alibaba.nacos</groupId>
        <artifactId>nacos-console</artifactId>
    </dependency>
</dependencies>
```


### nacos-istio
> istio对接-.基于最新的MCP协议



```xml
<modelVersion>4.0.0</modelVersion>
<artifactId>nacos-istio</artifactId>
<packaging>jar</packaging>

<name>nacos-istio ${project.version}</name>
<url>http://maven.apache.org</url>

<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-api</artifactId>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-client</artifactId>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-config</artifactId>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-naming</artifactId>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-core</artifactId>
    </dependency>
```


## nacos-naming


> 主要是作为服务注册中心的实现模块,具备服务的注册和服务发现的功能



```xml
<modelVersion>4.0.0</modelVersion>

<artifactId>nacos-naming</artifactId>
<packaging>jar</packaging>

<name>nacos-naming ${project.version}</name>
<url>http://maven.apache.org</url>
 <dependency>
 <groupId>${project.groupId}</groupId>
 <artifactId>nacos-core</artifactId>
 </dependency>

<dependency>
<groupId>${project.groupId}</groupId>
<artifactId>nacos-api</artifactId>
</dependency>
```


### nacos-console


> 主要是实现控制台的功能.具有权限校验、服务状态、健康检查等功能.



```xml
<artifactId>nacos-console</artifactId>
<!--<packaging>war</packaging>-->
<packaging>jar</packaging>
<name>nacos-console ${project.version}</name>
<url>http://maven.apache.org</url>
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
<dependencies>

    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-config</artifactId>
    </dependency>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-naming</artifactId>
    </dependency>

    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>nacos-istio</artifactId>
    </dependency>
```


### nacos-consistency




```xml
<artifactId>nacos-consistency</artifactId>
    <packaging>jar</packaging>

    <name>nacos-consistency ${project.version}</name>
    <url>http://maven.apache.org</url>


    <dependencies>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>nacos-common</artifactId>
        </dependency>
```


## nacos-config


> 主要是服务配置的管理, 提供`api`给客户端拉去配置信息,以及提供更新配置 的,客户端通过长轮询的更新配置信息.数据存储是`mysql`.



```xml
<artifactId>nacos-config</artifactId>
<packaging>jar</packaging>

<name>nacos-config ${project.version}</name>
<url>http://maven.apache.org</url>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-api</artifactId>
</dependency>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-core</artifactId>
</dependency>
```


### nacos-common


> 主要是通用的工具包和字符串常量的定义



```xml
<artifactId>nacos-common</artifactId>
<packaging>jar</packaging>
```


### nacos-cmdb


> 主要是操作的数据的存储在内存中,该模块提供一个查询数据标签的接口



```xml
<artifactId>nacos-cmdb</artifactId>
<packaging>jar</packaging>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-core</artifactId>
</dependency>

<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-api</artifactId>
</dependency>
```


### nacos-client


> 主要是对依赖api模块和`common`模块,对api的接口的实现,给nacos的客户端使用



```
<artifactId>nacos-client</artifactId>
<packaging>jar</packaging>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-common</artifactId>
</dependency>

<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-api</artifactId>
</dependency>
```


### nacos-api


> 主要给客户端调用的api接口的抽象，总体接口规范



```
<artifactId>nacos-api</artifactId>
<packaging>jar</packaging>
```


### nacos-address


> 主要查询nacos集群中节点个数以及IP的列表



```xml
<modelVersion>4.0.0</modelVersion>
<artifactId>nacos-address</artifactId>
<packaging>jar</packaging>
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>nacos-naming</artifactId>
    <exclusions>
        <exclusion>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-cmdb</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```
### 
