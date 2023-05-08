<p align="center">
    <a href="#" target="_blank" rel="noopener noreferrer">
        <img width="300" height="120" src="https://github.com/SinceNovember/media/blob/master/images/keen/logo.svg" alt="keen logo" />
    </a>
</p>


> keen是一个包含用户之间聊天功能的前后端分离的RABC权限后台管理系统。

# 简介

**keen** 是一个通过`Springboot` `Mybatis` `Vue` `Netty` `Sa-Token` 等主流技术开发的一个前后端分离的RABC权限后台管理系统，开箱即用，可迅速搭建后台`权限认证`、`权限控制`、`按钮控制`、`动态路由`、`用户聊天`等功能。


# 功能

- **控制台**
- **系统管理**
  - **用户管理**
  - **角色管理**
  - **部门管理**
  - **菜单管理**
  - **布局管理**
- **元数据管理**
  - **系统参数**
  - **代码管理**
- **系统监控**
  - **操作日志**
  - **登陆日志**
- **消息管理**
  - **聊天管理**
  - **通知管理**


# 技术

#### 后端

| 序号 | 技术名称     | 说明             |
| ---- | ------------ | ---------------- |
| 1    | SpringBoot2  | 项目框架         |
| 2    | Mybatis      | 持久层框架       |
| 3    | Mybatis-plus | 持久层增强       |
| 4    | Hikari       | 数据库连接池     |
| 5    | Redis        | 缓存             |
| 6    | Mysql        | 数据库           |
| 7    | Sa-token     | 权限控制安全框架 |
| 8    | Kafka        | 消息队列         |
| 9    | Lombok       | 注解工具         |
| 10   | Aliyun       | 图床             |
| 11   | Netty        | 通信框架         |
| 12   | Hutool       | 通用工具         |
| 13   | Mapstruct    | bean转换         |

#### 前端

| 序号 | 技术名称    | 说明           |
| ---- | ----------- | -------------- |
| 1    | Vue2        | 前端框架       |
| 2    | Vuex        | 状态管理       |
| 3    | Vue-router  | 路由管理       |
| 4    | Axios       | HTTP 库        |
| 5    | Element-ui  | 组件库         |
| 6    | Js-cookie   | Cookie存储工具 |
| 7    | Echarts     | 图表组件       |
| 8    | Bootstrap   | 图标库         |
| 9    | Vue-cropper | 裁剪工具       |


# 界面

| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/0-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/0-2.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/1-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/1-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/2-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/2-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/3-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/3-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/4-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/4-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/5-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/5-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/6-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/6-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/7-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/7-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/8-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/8-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/9-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/9-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/10-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/10-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/11-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/11-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/12-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/12-2.png) |
| ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/13-1.png) | ![1640016007(1)](https://github.com/SinceNovember/media/blob/master/images/keen/13-2.png) |


# 安装

#### 前端运行

在`keen-vue`文件夹下运行

``` bash
#Project setup
npm install

#Compiles and hot-reloads for development
npm run serve

#Compiles and minifies for production
npm run build

#Lints and fixes files
npm run lint
```

#### 后端运行

找到`keen`模块中的`application.yml`, 配置好数据库等地址后，打开文件夹内的`KeenApplication`启动 即可
