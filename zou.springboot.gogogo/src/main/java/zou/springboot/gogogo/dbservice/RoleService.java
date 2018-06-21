package zou.springboot.gogogo.dbservice;

import zou.springboot.gogogo.bean.UserInfo;

public interface RoleService {
	UserInfo findRoleById(String id);
}