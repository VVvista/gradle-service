1.gradle读取已有的setting.xml文件内容

2.将maven的pom.xml转化为gradle的配置文件 maven2Gradle
* 在已建好的maven项目下执行：gradle init --type pom
* 如果在新建的gradle项目中复制pom.xml文件，执行上述命令前必须新建好项目的子项目文件夹，否则执行报错
![tt](../../picture/Maven2gradle.png "tt")
3.比较构建
包含gradle的升级