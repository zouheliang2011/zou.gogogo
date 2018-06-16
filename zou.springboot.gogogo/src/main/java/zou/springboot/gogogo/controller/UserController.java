package zou.springboot.gogogo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zou.springboot.gogogo.bean.XmlPropertyTest;
import zou.springboot.gogogo.service.SpringApplicationContext;
import zou.springboot.gogogo.service.UserInfoService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserInfoService userService;
	@Autowired
	private SpringApplicationContext scontext;
	
	@RequestMapping(value = "/getname", method = RequestMethod.GET)
	public String getname(@PathParam(value = "id") String id) {
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
}
