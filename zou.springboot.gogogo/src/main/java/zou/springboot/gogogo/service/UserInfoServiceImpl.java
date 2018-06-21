package zou.springboot.gogogo.service;

import org.springframework.beans.factory.annotation.Autowired;

import zou.springboot.gogogo.bean.UserInfo;
import zou.springboot.gogogo.dao.UserInfoDao;
import zou.springboot.gogogo.dbservice.RoleService;

public class UserInfoServiceImpl implements RoleService {

	@Autowired
	private UserInfoDao userDAO; 
	@Override
	public UserInfo findRoleById( String id )
	{
		UserInfo findRoleById = getUserDAO().findRoleById(id);
		return findRoleById;
	}
	public UserInfoDao getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO( UserInfoDao userDAO )
	{
		this.userDAO = userDAO;
	}

}
