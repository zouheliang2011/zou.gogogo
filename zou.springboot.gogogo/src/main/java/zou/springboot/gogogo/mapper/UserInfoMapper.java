package zou.springboot.gogogo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import zou.springboot.gogogo.bean.UserInfo;

@Mapper
public interface UserInfoMapper {

	UserInfo getUserInfo(@Param("id") String id);
}
