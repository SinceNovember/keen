# Blog
## 一个用SSM写的一个博客系统
框架:`SpringMVC+Spring+Mybatis`<br>
后台前端:`easyui`<br>
安全认证:`shiro`<br>
全文检索：`lucence`<br>
文本编辑器:`ueditor`<br>
前端主题:`hexo`<br>
jquery效果:`粒子效果`<br>
开发环境:`eclipse`<br>
### 后台功能
博客的管理：写博客以及查看博客的信息，可对进行增删改查以及搜索<br>
博客类别管：对博客所具有的类别进行管理<br>
评论管理：评论审核以及评论信息管理<br>
博主个人信息管理:对自己信息进行修改<br>
系统管理：修改密码，刷新系统缓存，以及退出<br>
后台进入方式:`/login.jsp`<br>
### 前台功能
文章分类，显示后台编写的博客，可对文章进行评论，点击量以及阅读量统计<br>
上传图片，关于博主的信息，利用luncene对全文进行检索,并且添加了粒子效果<br>
### 使用方法
下载文件，导入项目，并将WEB-INF下面lib下面的三个jar导入项目，将resources下的db.sql导入到数据库,并修改jdbc.properties下得数据库的账号密码信息。`如果编辑器无法进行上传图片,请将项目下\static\ueditor1_4_3_3\jsp\config.json下的imageUrlPrefix改为:http://服务器的ip/SSM_blog即可.`<br>
####导入文件后
第一步:<br>
将webapp下的WEB-INF下的lib的三个文件进行导入.<br>
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/1.png)
第二步:<br>
进行添加服务器：Properties下的Java BuildPath的Libraries中的Add Library下的Server Runtime中进行添加服务器<br>
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/2.png)
第三步:<br>
Properties下的Project Facets中点击Dynamic Web Module 以及Java 后点击Apply.<br>
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/3.png)
第四步:<br>
Properties下的Deployment Assembly中Add Folder下的src->main->webapp文件夹.<br>
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/4.png)
第五步:<br>
Properties下的Deployment Assembly中的Add->Java Build Path Entries->全选所有.<br>
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/5.png)
### webapp文件夹解释
admin文件夹:<br>
存放后台得页面.<br>
common文件夹:<br>
存放前台得一些常用jsp页面代码.<br>
static 文件:<br>
存放所有得外部资源如图片，js,css以及一些插件.<br>
foreground与uselsshtml:<br>
无用文件夹.<br>
所有得前端页面均放在webapp主目录下。<br>
### 系统展示
#### 前台界面:
主页:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/index.png)
明细页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/detail.png)
分类页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/category.png)
分类明细页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/categories.png)
标签页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/tags.png)
介绍页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/about.png)
标签页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/tags.png)
搜索结果页面：
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/search.png)
其他页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/other.png)
#### 后台界面:
写博客页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/writeblog.png)
博客管理页面:
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/blogmanager.png)
博客类别管理页面：
![](https://github.com/SinceNovember/Blog/blob/master/backgroundimage/blogtype.png)

