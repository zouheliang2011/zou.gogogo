package zou.springboot.gogogo.dao;


import org.springframework.stereotype.Repository;

import zou.springboot.gogogo.bean.UserInfo;

@Repository
public interface UserInfoDao {

	UserInfo findRoleById(String id);
}
