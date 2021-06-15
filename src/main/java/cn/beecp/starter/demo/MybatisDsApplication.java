package cn.beecp.starter.demo;

import cn.beecp.boot.EnableDataSourceMonitor;
import cn.beecp.boot.EnableMultiDataSource;
import cn.beecp.starter.demo.map1.UserInfo;
import cn.beecp.starter.demo.map2.UserInfo2;
import cn.beecp.starter.demo.map2.UserInfo2Service;
import cn.beecp.starter.demo.map1.UserInfoService;
import cn.beecp.starter.demo.map1.UserInfoService;
import cn.beecp.starter.demo.map2.UserInfo2Service;
import cn.beecp.starter.demo.map3.UserInfo3;
import cn.beecp.starter.demo.map3.UserInfo3Service;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableMultiDataSource
@EnableDataSourceMonitor
@SpringBootApplication
@RestController
public class MybatisDsApplication {
    @Autowired
    private UserInfoService service1;
    @Autowired
    private UserInfo2Service service2;
    @Autowired
    private UserInfo3Service service3;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDsApplication.class, args);
    }

    @RequestMapping("/getAllUser1")
    public List<UserInfo> getAllUserInfo1() throws Exception {
        return service1.findAll();
    }

    @RequestMapping("/getAllUser2")
    public List<UserInfo2> getAllUserInfo2() throws Exception {
        return service2.findAll();
    }

    @RequestMapping("/testErrorSQL")
    public List<UserInfo2> testErrorSQL() throws Exception {
        return service2.findAll2();
    }


    @RequestMapping("/getAllUserFromCombineDs")
    public List<UserInfo3> getAllUserFromCombineDs() throws Exception {
        return service3.findAll();
    }

    @RequestMapping("/testErrorSQLFromCombineDs")
    public List<UserInfo3> testErrorSQLFromCombineDs() throws Exception {
        return service3.findAll2();
    }


}
