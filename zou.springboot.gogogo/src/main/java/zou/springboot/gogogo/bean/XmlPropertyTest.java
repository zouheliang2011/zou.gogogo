package zou.springboot.gogogo.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class XmlPropertyTest {

	private String configName="application.xml test";

	public String getConfigName()
	{
		return configName;
	}

	public void setConfigName( String configName )
	{
		this.configName = configName;
	}
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	
}