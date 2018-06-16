package zou.springboot.gogogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zou.springboot.gogogo.bean.UserInfo;
import zou.springboot.gogogo.mapper.UserInfoMapper;
/*
 * 业务逻辑层,或者叫服务层,这里包含持久层的注入
 * demo 中就省略了各种校验和过滤
 */

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userMapper;
	
	public String getUserNameById(String id)
	{
		UserInfo userInfo = userMapper.getUserInfo(id);
		return userInfo.getName();
	}
}
