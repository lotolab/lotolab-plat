## application-base

```yml
loto:
  # 名称
  name: loto
  # 版本
  version: 1.0.0
  # 版权年份
  copyrightYear: 2024
  # 文件路径 示例（ Windows配置D:/loto/uploadPath，Linux配置 /data/loto/uploadPath）
  profile: D:/data/loto/uploadPath
  # 获取ip地址开关
  addressEnabled: false
  # 验证码类型 math 数字计算 char 字符验证
  captchaType: math

# 日志配置
logging:
  level:
    com.ruoyi: debug
    org.springframework: warn

# Token 配置
token:
  # 令牌自定义标识
  header: Authorization
  # 令牌密钥
  secret: lotoGTTUIFANCCPFREE9527
  # 令牌有效期（默认30分钟）
  expireTime: 30

# 用户配置
user:
  password:
    # 密码最大错误次数
    maxRetryCount: 5
    # 密码锁定时间（默认10分钟）
    lockTime: 10
```


## application-druid

```yml 
# 数据源配置
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driverClassName: com.mysql.cj.jdbc.Driver
    druid:
      # 主库数据源
      master:
        url: jdbc:mysql://127.0.0.1:6489/loto_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8
        username: admin
        password: 51Tfccp

      # 从库数据源
      slave:
        # 从数据源开关/默认关闭
        enabled: false
        url:
        username:
        password:

      # 初始连接数
      initialSize: 5
      # 最小连接池数量
      minIdle: 10
      # 最大连接池数量
      maxActive: 20
      # 配置获取连接等待超时的时间
      maxWait: 60000
      # 配置连接超时时间
      connectTimeout: 30000
      # 配置网络超时时间
      socketTimeout: 60000
      # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
      timeBetweenEvictionRunsMillis: 60000
      # 配置一个连接在池中最小生存的时间，单位是毫秒
      minEvictableIdleTimeMillis: 300000
      # 配置一个连接在池中最大生存的时间，单位是毫秒
      maxEvictableIdleTimeMillis: 900000
      # 配置检测连接是否有效
      validationQuery: SELECT 1 FROM DUAL
      testWhileIdle: true
      testOnBorrow: false
      testOnReturn: false
      webStatFilter:
        enabled: true
      statViewServlet:
        enabled: true
        # 设置白名单，不填则允许所有访问
        allow:
        url-pattern: /druid/*
        # 控制台管理用户名和密码
        login-username: loto
        login-password: 51TFCCP
      filter:
        stat:
          enabled: true
          # 慢SQL记录
          log-slow-sql: true
          slow-sql-millis: 1000
          merge-sql: true
        wall:
          config:
            multi-statement-allow: true
```


-----

## application-obs

```yml
loto:
  obs:
    type: tencent

    # Tencent COS
    tencent:
      app-id: 1xxxx
      bucket: xxxx-01-1xxxxxx
      region: ap-beijing
      cdn: https://cdn.xxx.lotolab.com
      secret-id: AK-tfxxxxx
      secret-key: xxxxxx
```


------

## Cache configuration application-redis

```yml
# Redis Cache
spring:
  redis:
    host: 127.0.0.1
    port: 18964
    # local virtual DB index
    database: 7
    password: Tfccp51
    timeout: 10s
    lettuce:
      pool:
        # 连接池中的最小空闲连接
        min-idle: 0
        # 连接池中的最大空闲连接
        max-idle: 8
        # 连接池的最大数据库连接数
        max-active: 8
        # #连接池最大阻塞等待时间（使用负值表示没有限制）
        max-wait: -1ms
```


 ------

## application-wechat

```yml
wechat:
  mp:
    app-id: mpxxx
    secret-key: somexxx
    callback-url: https://xxxx
```
