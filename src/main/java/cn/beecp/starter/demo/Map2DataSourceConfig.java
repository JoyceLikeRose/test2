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
@MapperScan(basePackages = "cn.beecp.starter.demo.map2", sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class Map2DataSourceConfig {
    private static final String MAPPER_LOCATION = "classpath:cn/beecp/starter/demo/map2/*.xml";

    @Bean
    public DataSourceTransactionManager ds2TransactionManager(@Qualifier("ds2") DataSource ds2) {
        return new DataSourceTransactionManager(ds2);
    }

    @Bean
    public SqlSessionFactory ds2SqlSessionFactory(@Qualifier("ds2") DataSource ds2)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds2);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}