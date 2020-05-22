package com.ideal.blockchain.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPostgres",
        transactionManagerRef = "transactionManagerPostgres",
        basePackages = {"com.ideal.blockchain.dao.postgres"})
public class DataSourcePostgresConfig {

    @Autowired
    protected Environment env;

    @Bean
    public DataSource otherDataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(env.getRequiredProperty("spring.datasource.postgres.driver-class-name"));
        source.setUrl(env.getRequiredProperty("spring.datasource.postgres.url"));
        source.setUsername(env.getRequiredProperty("spring.datasource.postgres.username"));
        source.setPassword(env.getRequiredProperty("spring.datasource.postgres.password"));
        return source;
    }

    @Bean(name = "entityManagerPostgres")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryPostgres")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(otherDataSource())
                .properties(getProperties())
                .packages("com.ideal.blockchain.entity.postgres")
                .persistenceUnit("otherPersistentUnit")
                .build();
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        map.put("hibernate.enable_lazy_load_no_trans", "true");
        return map;
    }

    @Bean(name = "transactionManagerPostgres")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}

