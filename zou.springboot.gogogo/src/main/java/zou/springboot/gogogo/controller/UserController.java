package zou.springboot.gogogo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zou.springboot.gogogo.service.UserInfoService;


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
}
