# 暑期答辩 - 启明星论坛

## 1. 项目介绍

 这个项目是暑假培训时和静宇学妹[![img](https://img-blog.csdnimg.cn/img_convert/98967201f46adfeade321b46d4d707fc.png)]一起选的，因为暑假培训有和他合作用git写过个简单的管理系统，就想着挑战一下难度大的，就选择了一系列任务里面觉得复杂一点的一个。最后实现全是一步步没有参考独立实现的

 至于项目到后面就果真复杂的超出了想象。很多模块都是第一次做，每天都是在折磨后台。

 但写完到最后能系统性的运行，然后发布到公网后还是挺舒坦的。
>【公网有效期至2020年底】【自带管理员登录，已经屏蔽了管理员登录】
项目地址：[项目体验](http://139.224.231.217:8080/index)
gitlab地址：[工作室内部git](https://git.ctguqmx.com/llz/qmx_2020_summer_llz/src/branch/SpringBoot+MybatisPlus%28qmx%29)
github地址：

## 2. 项目流程
<img src="https://img2020.cnblogs.com/blog/1920254/202009/1920254-20200929102543583-1413049345.png" alt="项目流程" border="0">

## 3. 开发环境

#### 前台：

bootstrap 

#### 后台：

Java Thymeleaf 数据库 

#### 软件：

Idea编译器 

Navicat 12 for MySQL

Postman

## 4. 需求分析

<img src="https://s1.ax1x.com/2020/09/10/wJCS9s.png" alt="首页" border="0">

## 5. 数据库设计

<img src="https://s1.ax1x.com/2020/09/10/wJCp3n.png" alt="124" border="0">

#### 数据库设计中遇到的问题及解决

##### 1. 发特殊字体评论报错

> utf8不支持一些特殊字体
>
> 更改数据库对应字段编码即可
>
> 评论及文章数据库最好设计成的utf8mb4 排序选取utf8mb4_bin

##### 2. 自动更新时间问题

> 选择datetime数据类型
>
> 默认填写 CURRENT_TIMESTAMP 及默认时间为创建时间
>
> 勾选根据当前时间段更新 -> 更新(update)时会刷新新的时间。
>
> 注意点： 此处适用于文章最后更新时间，有时候没更新就可采取后台更新 new date
>
> json文件会把时间转换为时间戳 1250212154类似的码。需要百度个转换函数后台处理变成时间即可



## 6. 前台内容
<img src="https://img2020.cnblogs.com/blog/1920254/202009/1920254-20200929102805247-660790668.png" alt="首页" border="0">
## 7. 后台设计

<img src="https://s1.ax1x.com/2020/09/10/wJ9OHS.png" alt="wJ9OHS.png" border="0" /><img src="https://s1.ax1x.com/2020/09/10/wJC9cq.png" alt="接口类型" border="0">

## 8. 一些模块的实现思路
<img src="https://img2020.cnblogs.com/blog/1920254/202009/1920254-20200929102903323-401595151.png" alt="首页" border="0">

#### [1] 后台： 轮播图自动填充

> 轮播图为了不写死，能方便更新，就单独设置了一个数据库去管理页面。
>
> 采用一个界面 = 图片 + 标题 + 链接 去储存。
>
> 随后采取一个简单的逻辑即可实现自动填充轮播图

填入： 采用 优先级 + 时间 的两个排序依据，首页获取数据库有几条链接并且自动填入；

更新： 轮播图默认设置了几个固定模块会去查询最新的对应角色发出对应的贴(开发组周任务/智能组周总结)

来替换当前连接。

对于用户 发出新的帖子就会顶替之前的旧贴，删除新贴，后台会查询其他的最新的帖子。

## 9. 待完善的问题

1. 更安全的验证方式
2. 优化数据库，优化查询时间

## 10. 收获与总结

项目总结

> 数据库设计很零散，网页写到哪，数据库设计到哪，以至于很多连表查询都是相当于复杂的，
>
> 并且很难再去优化查询了。
>
> 项目代码整体不规范，现在回过头来很多接口和控制层都要临时去读才知道功能。
>
> 未能考虑日后代码的可修改难易度，ajax写入代码难以修改。
>
> 项目虽然大量采用卡片式风格，但是界面缩小自动换行仍有自适应问题。
>
> 很多前端交互依赖jQuery，但是该部分代码混乱，函数复杂，可读性较差。
>
> 学习到了一个网站是怎么搭建出来的，数据如何储存，数据如何渲染，如何实现登录注册，点赞收藏。学会了使用f12查看接口，也学会了写接口利用ajax异步处理数据信息等等。
>
> 一开始的构思只是ssm框架，后来讨论换成springboot框架，换成新框架之后算是一种挑战吧。后来在springboot的框架上又集合了许多写法，诸如ajax等，虽然可能整个项目代码不够统一，
>
> 但是学到了很多种web代码的思路。
>
> 一直到现在，这个项目还有很多可以完善的空间。
>
> 