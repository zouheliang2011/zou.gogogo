package zou.springboot.gogogo.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class UserInfo implements Serializable{

	private String name;
	private String id;
	private String address;
	

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	
}
