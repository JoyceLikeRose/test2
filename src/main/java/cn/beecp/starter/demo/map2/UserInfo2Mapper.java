package cn.beecp.starter.demo.map2;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfo2Mapper {

    List<UserInfo2> findAll();

    List<UserInfo2> findAll2();
}
