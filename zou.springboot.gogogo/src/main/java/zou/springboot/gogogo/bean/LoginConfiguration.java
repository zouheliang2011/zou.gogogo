package zou.springboot.gogogo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 目前没有在yml文件中有，如果有格式和前缀都相同才能读取
 *
 */
@Component
@ConfigurationProperties(prefix = "test")
public class LoginConfiguration {
	private String login_platform_name;
	

	public String getLogin_platform_name()
	{
		return login_platform_name;
	}

	public void setLogin_platform_name( String login_platform_name )
	{
		this.login_platform_name = login_platform_name;
	}


}
