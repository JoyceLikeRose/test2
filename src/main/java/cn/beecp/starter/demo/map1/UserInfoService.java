package cn.beecp.starter.demo.map1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userMapper;

    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }
}