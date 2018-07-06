package zou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import zou.springboot.gogogo.bean.LoginConfiguration;

/*
 * 这里application的位置比较重要，默认是扫描这个包及其子包（package）下面的注解文件，所以这个一般是再比较外层
 */

@ServletComponentScan
@SpringBootApplication 
//如果这个不注释那么就会包找不到Consider defining a bean of type 'xxxMapper' in your configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({LoginConfiguration.class})
@ImportResource(locations= {"classpath:spring/*.xml"})
@MapperScan("zou.springboot.gogogo.mapper")
@ComponentScan("zou.springboot")
public class Application {

	private final static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {  

        SpringApplication.run(Application.class); 
        //测试修改logback是否能动态生效，测试结果是可以动态生效
//        while(true)
//        {
//        	logger.debug("this is debug");
//        	logger.info("this is info");
//        	logger.error("this is error");
//        	try
//			{
//				Thread.sleep(1000);
//			}
//			catch (InterruptedException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
        
    }  
}
