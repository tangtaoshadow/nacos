

# `configService`接口

> **path**:`com\alibaba\nacos\api\config\ConfigService.java`



## `getConfig`

> 用于服务启动的时候从 `Nacos` 获取配置

```java
/**
 * Get config
 *
 * @param dataId    dataId
 * @param group     group
 * @param timeoutMs read timeout
 * @return config value
 * @throws NacosException NacosException
 */
String getConfig(String dataId, String group, long timeoutMs) throws NacosException;
```

#### 请求参数

| 参数名  | 参数类型 | 描述                                                         |
| :------ | :------- | :----------------------------------------------------------- |
| dataId  | string   | 配置 ID，采用类似 package.class（如com.taobao.tc.refund.log.level）的命名规则保证全局唯一性，class 部分建议是配置的业务含义。全部字符小写。只允许英文字符和 4 种特殊字符（"."、":"、"-"、"_"），不超过 256 字节。 |
| group   | string   | 配置分组，建议填写产品名:模块名（Nacos:Test）保证唯一性，只允许英文字符和4种特殊字符（"."、":"、"-"、"_"），不超过128字节。 |
| timeout | long     | 读取配置超时时间，单位 ms，推荐值 3000。                     |

#### 返回值

| 参数类型 | 描述   |
| :------- | :----- |
| string   | 配置值 |



## `getConfigAndSignListener`

> 获取配置并注册侦听器,如果在程序首次启动开始获取配置时自行将其拉出，并且已注册的侦听器用于将来的配置更新，则可以使原始代码保持不变，只需添加系统参数即可。 `enableRemoteSyncConfig=true`（但存在网络开销）； 因此，我们建议您直接使用此接口。

```java
/**
 * Get config and register Listener
 *
 * If you want to pull it yourself when the program starts to get the configuration for the first time,
 * and the registered Listener is used for future configuration updates, you can keep the original
 * code unchanged, just add the system parameter: enableRemoteSyncConfig = "true" ( But there is network overhead);
 * therefore we recommend that you use this interface directly
 *
 * @param dataId    dataId
 * @param group     group
 * @param timeoutMs read timeout
 * @param listener {@link Listener}
 * @return config value
 * @throws NacosException NacosException
 */
String getConfigAndSignListener(String dataId, String group, long timeoutMs, Listener listener) throws NacosException;
```