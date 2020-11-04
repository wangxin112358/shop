shop商城框架是1.0.0-RELEASE版本

集成：
1.springboot（1.5.9.RELEASE）
2.mybatis（1.3.0）
3.dubbo+zookeeper（dubbo：2.8.4）
4.redis(spring-boot-starter-data-redis 1.5.9.RELEASE)
5.mysql
6.log4j(1.2.16)

介绍:
父工程为shop，子工程为shop-provider,shop-consumer,两个子工程都可以独立链接数据库，设置数据源，独立使用redis。
shop-provider为dubbo生产者，shop-consumer为消费者，这两个工程端口号不一样

使用：
测试接口:testProvider/testMethod,testConsumer/testMethod 可以体现查询数据库作用（shop-provider 和 shop-consumer都有此接口）
测试接口:testProvider/dubboProvider 简单返回一个字符串（shop-provider里）
测试接口:testProvider/testRedis 测试redis缓存（shop-provider里，在consumer里也可以使用）
测试接口:testConsumer/dubboConsumer 测试dubbo，在shop-consumer里可以调用到shop-provider里的方法

使用dubbo（启动本地zookeeper）:
如果有个功能想在shop-consumer里调用shop-provider里的方法，
1.把com.alibaba的dubbo的2.8.4依赖加到本地私库里，https://mvnrepository.com/上没有，可以网上下载如果找不到找王鑫要
下载后写换到\dubbox-master目录下，.执行命令mvn install -Dmaven.test.skip=true，找到dubbo-2.8.4.jar ，使用 mvn install:install-file -Dfile=C:\dubbo-2.8.4.jar -DgroupId=com.alibaba -DartifactId=dubbo -Dversion=2.8.4 -Dpackaging=jar 上传到 自己本地maven库里

2.把shop-provider 里的此service的实现类加上
@org.springframework.stereotype.Service("***")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = **.class)
可效仿TestDubboProviderServiceImpl，
3.把此service复制到shop-consumer里的相同路径下，只能在consumer里自己的service实现类里调用词service，
扫描注解用@Reference
4.shop-consumer 的controller调用自己的service就好


测试数据库名shop
测试表
CREATE TABLE `test` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

