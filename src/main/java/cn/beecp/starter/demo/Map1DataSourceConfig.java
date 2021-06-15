package cn.beecp.starter.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "cn.beecp.starter.demo.map1", sqlSessionFactoryRef = "ds1SqlSessionFactory")
public class Map1DataSourceConfig {
    private static final String MAPPER_LOCATION = "classpath:cn/beecp/starter/demo/map1/*.xml";

    @Bean
    @Primary
    public DataSourceTransactionManager ds1TransactionManager(@Qualifier("ds1") DataSource ds1) {
        return new DataSourceTransactionManager(ds1);
    }

    @Bean
    @Primary
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ds1") DataSource ds1)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}