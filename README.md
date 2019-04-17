# Blog
## 简介
> 一个使用SSM开发得一个精美、小巧得博客系统:bowtie:

## 主要技术
>框架:`SpringMVC+Spring+Mybatis`<br>
后台UI:`layui`<br>
安全认证:`shiro`<br>
全文检索：`lucence`<br>
文本编辑器:`editor.md`<br>
前端主题:`hexo-theme-melody`<br>
开发环境:`eclipse`<br>


## 功能
- Markdown/Emoji
- 白天模式/夜晚模式
- 自定义主页图片/标签信息
- 自己选择标签颜色/大小
- 文章归档/分类
- 自定义个人头像/个性签名/个人标签
- 实时搜索文章
- Shiro验证登陆
- 后台界面颜色更换
- 文章评论回复/修改
- 个人信息修改/展示


# 界面展示

![](https://github.com/SinceNovember/Blog/blob/master/upload/1.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/2.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/3.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/4.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/5.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/6.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/login.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/7.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/8.png)

![](https://github.com/SinceNovember/Blog/blob/master/upload/9.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/10.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/11.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/12.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/13.png)
![](https://github.com/SinceNovember/Blog/blob/master/upload/14.png)

## 使用方法
下载后导入到IDE中，项目使用到`MAVEN`，请确保安装好MAVEN，修改resource下得db.properties下得数据库密码，导入数据库文件。<br>
登陆后台:/login.jsp<br>
#### 各图片上传文件：
- editor.md文章内图片:`/static/pic` <br>
- 评论者头像:`/static/pic/comment` <br>
- 文章缩略图:`/static/bgpic` <br>
- 个人图片以及页面图片:`/static/images` <br>

### 使用注意
>下载好得没法进行搜索,需要在D盘进行建立索引，可以在Test类中运行测试建立索引，但新发表得文章可以搜索到。<br>
许多图片被删除，需要自己重重新上传。<br>
有什么问题可以联系QQ：`83428190`。
