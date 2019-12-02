@[toc]
###### 1.多任务执行
当gradle执行多个任务，并且任务之间存在依赖关系时，同一个任务只会执行一次，不管是执行的任务列表或依赖的任务，仅执行一次
```

task compile{
    doLast{
        println "compile"
    }
}

task compileTest(dependsOn: [compile]){
    doLast{
        println "compileTest"
    }
}
task compileTesr(dependsOn: [compile]){
    doLast{
        println "compileTest"
    }
}
task test1(dependsOn: [compile,compileTest]){
    doLast{
        println "test1"
    }
}
task dist(dependsOn: [compile,test1]){
    doLast{
        println "dist"
    }
}

```
执行结果
```
./gradlew test1 dist

> Task :gs_gradle_example:compile
compile

> Task :gs_gradle_example:compileTest
compileTest

> Task :gs_gradle_example:test1
test1

> Task :gs_gradle_example:dist
dist
```
###### 2.排除任务
```
./gradlew dist -x test1

> Task :gs_gradle_example:compile
compile

> Task :gs_gradle_example:dist
dist
```
-x 参数将去除dist中依赖的test1的任务（包含test1依赖的任务，即compileTest任务），因为dist也依赖compile任务，所以依然会执行
###### 3.忽略失败task，继续执行
-continue 参数，在运行时若某个任务失败，然后会进行其他任务的构建，但失败任务所依赖的后续任务不会被执行。
若compileTest任务失败，则运行时依赖于它的test1 dist也不会执行
###### 4.使用任务名缩写运行
指定执行任务时，可以使用任务名缩写，但要保证任务名缩写唯一，否则匹配不到报错
```
% ./gradlew di           

FAILURE: Build failed with an exception.

* What went wrong:
Task 'di' is ambiguous in root project 'gs_gradle_service'. Candidates are: 'dist', 'dist2'.
```
* 首字母或开头多个字母（如compile c,dist di）
* 驼峰缩写（首字母的驼峰缩写，如compileTest cT）
```
 ./gradlew cT

> Task :gs_gradle_example:compile
compile

> Task :gs_gradle_example:compileTest
compileTest

```
###### 5.强制执行task，不启动up-to-date机制
--rerun-tasks 参数，忽略up-to-date检查，此时不仅执行当前任务，其依赖的执行之前的任务也会执行
```
./gradlew --rerun-tasks jar
```
##### 2.查看构建信息
###### 1.项目构建信息
gradle projects 查看当前项目及子项目列表
```
 ./gradlew projects

> Task :projects

------------------------------------------------------------
Root project
------------------------------------------------------------

Root project 'gs_gradle_service'
+--- Project ':gs_gradle_admin'
+--- Project ':gs_gradle_core'
+--- Project ':gs_gradle_example' - this is a gs_gradle_example
+--- Project ':gs_gradle_model'
\--- Project ':gs_gradle_web'

```
可以在项目build.gradle中添加项目描述
```
#gs_gradle_example 
description "this is a gs_gradle_example"
```
###### 2.任务构建信息
gradle tasks 查看当前项目的任务列表
gradle tasks --all 列出当前项目的所有任务，包含隐藏任务

###### 3.任务信息
gradle help --task $taskName 
```
./gradlew help --task test1

> Task :help
Detailed task information for test1

Path
     :gs_gradle_example:test1

Type
     Task (org.gradle.api.Task)

Description
     -

Group
     -

```
###### 4.项目jar依赖
gradle dependencies  
gradle dependencies $subDir:dependencies 列出$subDir项目配置表中的依赖项，包含直接依赖和传递依赖，详细罗列各环境下的依赖

gradle dependencies $subDir:dependencies --configuration $compile 只列出$compile环境下的依赖项
```./gradlew dependencies gs_gradle_core:dependencies  --configuration compile

> Task :dependencies

------------------------------------------------------------
Root project
------------------------------------------------------------

No configurations

A web-based, searchable dependency report is available by adding the --scan option.

> Task :gs_gradle_core:dependencies

------------------------------------------------------------
Project :gs_gradle_core
------------------------------------------------------------

compile - Dependencies for source set 'main' (deprecated, use 'implementation' instead).
+--- org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RELEASE
|    +--- org.springframework.boot:spring-boot-loader-tools:2.0.0.RELEASE
|    |    +--- org.springframework:spring-core:5.0.4.RELEASE
|    |    |    \--- org.springframework:spring-jcl:5.0.4.RELEASE
|    |    \--- org.apache.commons:commons-compress:1.14
|    +--- io.spring.gradle:dependency-management-plugin:1.0.4.RELEASE
|    \--- org.apache.commons:commons-compress:1.14
\--- project :gs_gradle_model
     +--- org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RELEASE (*)
     \--- ch.qos.logback:logback-classic:1.2.2
          +--- ch.qos.logback:logback-core:1.2.2
          \--- org.slf4j:slf4j-api:1.7.25

```

./gradlew dependencies gs_gradle_core:properties

###### 3.略过某个任务
gradle  -qm test1 dist 仅打印多个任务的执行书序，不执行任务内的方法
```
./gradlew  -qm test1 dist                       
:gs_gradle_example:compile SKIPPED
:gs_gradle_example:compileTest SKIPPED
:gs_gradle_example:test1 SKIPPED
:gs_gradle_example:dist SKIPPED

```




