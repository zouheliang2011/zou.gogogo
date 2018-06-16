package zou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
@ImportResource(locations= {"classpath:spring/applicationContext.xml"})
@MapperScan("zou.springboot.gogogo.mapper")
public class Application {

	public static void main(String[] args) {  

        SpringApplication.run(Application.class);  
    }  
}
