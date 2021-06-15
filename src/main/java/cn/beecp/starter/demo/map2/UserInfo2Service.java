package cn.beecp.starter.demo.map2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfo2Service {

    @Autowired
    UserInfo2Mapper userMapper;

    public List<UserInfo2> findAll() {
        return userMapper.findAll();
    }

    public List<UserInfo2> findAll2() {
        return userMapper.findAll2();
    }


}
