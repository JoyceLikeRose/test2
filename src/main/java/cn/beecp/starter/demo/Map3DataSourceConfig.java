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
@MapperScan(basePackages = "cn.beecp.starter.demo.map3", sqlSessionFactoryRef = "ds3SqlSessionFactory")
public class Map3DataSourceConfig {
    private static final String MAPPER_LOCATION = "classpath:cn/beecp/starter/demo/map3/*.xml";

    @Bean
    public DataSourceTransactionManager ds3TransactionManager(@Qualifier("combineDs") DataSource combineDs) {
        return new DataSourceTransactionManager(combineDs);
    }

    @Bean
    public SqlSessionFactory ds3SqlSessionFactory(@Qualifier("combineDs") DataSource combineDs)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(combineDs);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}