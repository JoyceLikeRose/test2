package cn.beecp.starter.demo.map1;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    List<UserInfo> findAll();
}
