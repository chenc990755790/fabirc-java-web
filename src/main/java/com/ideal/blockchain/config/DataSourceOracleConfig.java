package com.ideal.blockchain.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
//@EnableJpaRepositories(basePackages = {"com.ideal.blockchain.dao.oracle"}, entityManagerFactoryRef = "entityManagerFactoryOracle",
//        transactionManagerRef = "transactionManagerOracle")
//@EnableTransactionManagement
public class DataSourceOracleConfig {
    @Autowired
    protected Environment env;

    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    @Bean
    public DataSource primaryDruidDataSource(Environment environment) {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(env.getRequiredProperty("spring.datasource.oracle.driver-class-name"));
        source.setUrl(env.getRequiredProperty("spring.datasource.oracle.url"));
        source.setUsername(env.getRequiredProperty("spring.datasource.oracle.username"));
        source.setPassword(env.getRequiredProperty("spring.datasource.oracle.password"));
        return source;
    }

    @Bean(name = "entityManagerFactoryOracle")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder,Environment environment) {
        return builder
                .dataSource(primaryDruidDataSource(environment))
                .packages("com.ideal.blockchain.entity.saas","com.ideal.blockchain.entity.loan") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerOracle")
    public EntityManager entityManagerPrimary(EntityManagerFactoryBuilder builder,Environment environment) {
        return entityManagerFactoryPrimary(builder,environment).getObject().createEntityManager();
    }



    @Bean(name = "transactionManagerOracle")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder,Environment environment) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder,environment).getObject());
    }


}
