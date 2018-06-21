package zou.springboot.gogogo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zou.springboot.gogogo.bean.UserInfo;
import zou.springboot.gogogo.bean.XmlPropertyTest;
import zou.springboot.gogogo.service.SpringApplicationContext;
import zou.springboot.gogogo.service.UserInfoService;
import zou.springboot.gogogo.service.UserInfoServiceImpl;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserInfoService userService;
	@RequestMapping(value = "/getname", method = RequestMethod.GET)
	public String sensitiveIgnorBlank(@PathParam(value = "id") String id) {
		String userNameById = userService.getUserNameById(id);
		System.out.println(userNameById);
		return userNameById;
//		return keyWordSet.sensitiveWordSearch(req.getNick(), source);
	}
	

	@RequestMapping(value = "/testbean", method = RequestMethod.GET)
	public void testbean() {
		try
		{
			XmlPropertyTest bean = (XmlPropertyTest)SpringApplicationContext.getBean("customerRepositoryFoo");
			System.out.println(bean.getConfigName());
			
		}
		catch (Exception e)
		{
			System.out.println("error1");
		}
		try
		{
			XmlPropertyTest bean2 = SpringApplicationContext.getBean(XmlPropertyTest.class);
			System.out.println(bean2.getConfigName());
			
		}
		catch (Exception e)
		{
			System.out.println("error2");
		}
		try
		{
			XmlPropertyTest bean3 = (XmlPropertyTest)SpringApplicationContext.getBean("zouggg");
			System.out.println(bean3.getConfigName());
		}
		catch (Exception e)
		{
			System.out.println("error3");
		}
//		return keyWordSet.sensitiveWordSearch(req.getNick(), source);
	}
	
	@RequestMapping(value = "/testdatabase", method = RequestMethod.GET)
	public void testdatabase() {
		try
		{
			UserInfoServiceImpl bean = (UserInfoServiceImpl)SpringApplicationContext.getBean("dataUser");
			UserInfo findRoleById = bean.findRoleById("b");
			System.out.println("获取到对应的值"+findRoleById);
			
		}
		catch (Exception e)
		{
			System.out.println("error1");
			e.printStackTrace();
		}
//		return keyWordSet.sensitiveWordSearch(req.getNick(), source);
	}
}
