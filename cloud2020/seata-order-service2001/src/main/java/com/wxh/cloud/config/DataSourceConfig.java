package com.wxh.cloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.common.util.StringUtils;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private String mapperLocations = "classpath:mapper/*.xml";


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources(mapperLocations));
//
//        SqlSessionFactory factory;
//        try {
//            factory = bean.getObject();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return factory;
//    }
}
