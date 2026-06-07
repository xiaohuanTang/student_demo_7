# week7作业
学号：42435014  
姓名：唐小欢

## 项目简介
基于SpringBoot+JPA+MySQL实现学生信息管理系统，完成学生数据的增删改查与多条件查询。

## 实现功能
1. 搭建SpringBoot项目，引入Spring Data JPA与MySQL依赖
2. 配置数据库连接与JPA参数，完成实体类和数据表映射
3. 使用Repository继承JpaRepository，实现学生信息增删改查
4. 编写JPA方法查询、JPQL查询和原生SQL查询，完成多条件检索
5. 提供Controller接口和前端页面，支持浏览器访问学生信息管理功能

## 启动
先执行`sql/schema.sql`和`sql/data.sql`初始化数据库，修改`application.yml`中的数据库用户名和密码后启动项目，访问`http://localhost:8080`进入学生信息管理系统。
