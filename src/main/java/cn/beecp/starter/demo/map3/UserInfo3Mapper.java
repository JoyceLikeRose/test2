package cn.beecp.starter.demo.map3;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfo3Mapper {

    List<UserInfo3> findAll();

    List<UserInfo3> findAll2();
}
