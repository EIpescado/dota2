<h2 style="text-align: center">DOTA2 后台管理系统(后端)</h1>

#### 项目简介
DOTA2基于 Spring Boot 2.1.6, Mybatis-plus, Spring Security, JWT, redis, Vue + elementUI 的前后端分离的后台管理系统,
取这个名称仅仅只是因为作者喜欢DOTA2这款游戏

**体验地址**  [https://www.yurwisher.cn/](https://www.yurwisher.cn/)

**[后端源码地址](https://github.com/EIpescado/dota2)** | **[前端源码地址](https://github.com/EIpescado/dota2-front)**

#### 系统功能
- 用户管理: 用户相关配置
- 角色管理: 绑定菜单,按钮,及权限
- 权限管理: todo
- 菜单管理: 菜单动态路由，按钮自由组合,灵活配置，支持多级菜单
- 部门管理: 部门相关配置
- 职位管理: 部门职位相关
- 系统配置: 系统内部定义的一些基础配置,灵活更改
- 系统缓存: 提供对redis中缓存的一些操作
- 公告管理: 编辑分布网站公告
- 消息模版: 站内消息模版相关配置
- 微信公众号集成: 通过简单配置即可完成公众号配置

#### 项目结构
项目采用分模块开发方式，将通用的配置放在公共模块

- ```dota2-starter``` 系统入口,包含部分全局配置
    - config 全局配置
    - security spring-security配置
    
- ```dota2-common``` 通用模块,常量,异常,枚举,注解,工具类等
    - base 通用父类, 抽象接口
    - constant 常量
        - cache redis缓存常量及缓存抽象接口
    - enums 枚举
        - tip 消息提示枚举
    - exception 异常
    - serializer 自定义序列化
    - utils 工具类
    - wrapper 自定义包装

- ```chaos-rbac``` 系统接口文档相关

- ```chaos-rbac``` RBAC模块,用户,角色,菜单,按钮,权限相关

- ```chaos-system``` 系统模块,缓存,全局配置,站内消息等

- ```chaos-third``` 第三方模块,微信公众号,七牛等第三方对接

- ```sql``` 初始化脚本

#### 其他
- 本项目依赖 [yq-project](https://github.com/EIpescado/yq-project.git),使用前请先clone此项目,install到本地maven仓库
