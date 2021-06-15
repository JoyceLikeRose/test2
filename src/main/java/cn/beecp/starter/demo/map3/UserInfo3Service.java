package cn.beecp.starter.demo.map3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.beecp.boot.DataSourceId;


@Service
public class UserInfo3Service {

    @Autowired
    UserInfo3Mapper userMapper;
	
	@DataSourceId("ds1")
    public List<UserInfo3> findAll() {
        return userMapper.findAll();
    }
	
	@DataSourceId("ds2")
    public List<UserInfo3> findAll2() {
        return userMapper.findAll2();
    }


}
