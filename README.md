# gradle-service

##### 说明
    本项目记录了gradle从基础到项目搭建的过程
    * java 1.8
    * gradle 5.6.4
    * groovy 3.0.0
##### 目录说明
* gradle-seriver为父项目，项目结构如下：

    Root project 'gs_gradle_service'
  +--- Project ':gradle-example'
  +--- Project ':gradle-model'
  +--- Project ':gradle-core'
        \--- Project ':gradle-model'
  +--- Project ':gradle-web'
        \--- Project ':gradle-core'
            \--- Project ':gradle-model'
1. gradle-example主要记录了几个示例
2. gradle-model/gradle-core为java项目
3. gradle-web为java+web项目
* notes/gradle目录记录了gradle基础和项目搭建和管理方面的知识点
