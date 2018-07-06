1、2018-06-16 第一版测试，只是最简单的springboot框剪加上mybaits的数据读取，中途也遇到了一些问题，都是配置上的问题。目前能正确的读取数据库数据
同时也测试了yml 和properties文件是否共存的问题，答案是肯定的，能共存。https://blog.csdn.net/zouheliang/article/details/80448343
2、增加spring的配置文件看是否能和注解共存，该怎么引用.  首先可以实现一个ApplicationContextAware接口，在通过ApplicationContext的getbean方式来获取
里面的bean对象，而springboot是有一个@ImportResource(locations= {"classpath:spring/applicationContext.xml"})注解，只需要在main类上面加上就可以访问配置文件中的bean了。
3、增加一种通过spring配置数据源的方式访问数据库 首先配置数据源：database.properties配置文件，增加mapper文件spring-mybaits.xml（命名不好），SqlMapConfig.xml数据库配置文件的扫描文件。当再其他路径的时候有用/
接口服务依赖接口，而且组合了dao接口，这时候再bean里面可以不用setter注入，直接用注解@Autowired即可。用接口注入一直报注入失败，是接口不是实现无法注入。此处pjo需要实现序列化具体看代码

2、2018-07-06 新增AOPtest类
   做一个AOP切面测试，主要给所有请求增加日志和时间统计