操作步骤

1：在mysql数据中执行SQL创建表和数据

 文件：src\main\resources\TEST_USER.sql

2：使用Idea工具创建一个项目，并把源码导入

3：Maven编译项目

4：运行类：MybatisDsApplication


5：打开监控界面，在浏览器中输入下面地址

   http://localhost:8080/dsDemo/BeeCPMonitor.html


6：分别在浏览器中输入以下地址

  1： http://localhost:8080/dsDemo/getAllUser1    （数据源1）
  2： http://localhost:8080/dsDemo/getAllUser2    （数据源1）
  3： http://localhost:8080/dsDemo/testErrorSQL   （数据源2） 


  4： http://localhost:8080/dsDemo/getAllUserFromCombineDs     （动态切换数据源1）
  5： http://localhost:8080/dsDemo/testErrorSQLFromCombineDs   （动态切换数据源2）


7：刷新监控界面，查看执行时间，是否成功