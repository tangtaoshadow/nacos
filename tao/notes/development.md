**Repository:** [Author: GitHub](https://github.com/tangtaoshadow/) 

**Introduction:**  spring cloud alibaba nacos 源码修改

**Author:**[杭州电子科技大学](http://www.hdu.edu.cn/)   [唐涛](https://www.promiselee.cn/tao) 

**CreateTime:**`2020-5-24 17:29:02`

**UpdateTime:**`2020-5-24 17:33:36`

**Copyright:**  唐涛 [HOME | 首页](https://www.promiselee.cn/tao) **©**  ***2020***  [<img alt="tangtao" style="width:35px;display:inline;" src="https://www.promiselee.cn/share_static/files/github/tao-logo.svg"/>](https://www.promiselee.cn/tao)  [<img style="width:25px;display:inline;margin-bottom:5px;" alt="github" src="https://www.promiselee.cn/share_static/files/github/github-logo.svg"/>](https://github.com/tangtaoshadow)

**Email:**  <tangtao2099@outlook.com> [16011324@hdu.edu.cn](mailto:16011324@hdu.edu.cn)

**Link:**  [知乎](https://www.zhihu.com/people/tang-tao-24-36/activities)   [GitHub](https://github.com/tangtaoshadow) [语雀](https://www.yuque.com/tangtao-frbji)



## 启动方式

`2020-5-24 17:26:44`

> 从 `com.alibaba.nacos` 位置开始启动

```java
package com.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.*;

/**
 * @author nacos
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.nacos")
@ServletComponentScan
@EnableScheduling
public class Nacos {

    public static void main(String[] args) {
        SpringApplication.run(Nacos.class, args);
    }
}

```

### 启动模式

修改模式为 `standalone`，并配置本地存放位置

```bash
-Dnacos.standalone=true -Dnacos.home=C:\\nacos
```



### 成功

```bash
2020-05-24 17:32:05.117  INFO 16868 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8848 (http) with context path '/nacos'
2020-05-24 17:32:05.127  INFO 16868 --- [           main] c.c.StartingSpringApplicationRunListener : Nacos Log files: C:\nacos\logs
2020-05-24 17:32:05.128  INFO 16868 --- [           main] c.c.StartingSpringApplicationRunListener : Nacos Log files: C:\nacos\conf
2020-05-24 17:32:05.129  INFO 16868 --- [           main] c.c.StartingSpringApplicationRunListener : Nacos Log files: C:\nacos\data
2020-05-24 17:32:05.129  INFO 16868 --- [           main] c.c.StartingSpringApplicationRunListener : Nacos started successfully in stand alone mode. use embedded storage
2020-05-24 17:32:05.642  INFO 16868 --- [)-192.168.159.1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-05-24 17:32:05.654  INFO 16868 --- [)-192.168.159.1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 12 ms
```



## 配置数据库

`2020-5-24 17:22:16`

> 修改为自定义数据库 `mysql8.0`

### mysql建库建表

#### 💨👀建库

```sql
-- 本地执行
DROP DATABASE IF EXISTS nacos_config;
-- 数据库不存在就创建
CREATE DATABASE
    IF NOT EXISTS nacos_config DEFAULT CHARSET utf8mb4;
-- 选中
USE nacos_config;
```

#### 💨👀建表

> 找到mysql数据库文件：`distribution/conf/nacos-mysql.sql`，继续执行sql,也可以配置idea直接执行💖。

