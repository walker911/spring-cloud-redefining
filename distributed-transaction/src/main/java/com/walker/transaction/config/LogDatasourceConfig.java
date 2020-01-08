package com.walker.transaction.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
@Configuration
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.walker.transaction.dao.log", entityManagerFactoryRef = "logEntityManager")
public class LogDatasourceConfig {

    @Bean(name = "logDatasource")
    @Qualifier("logDatasource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.log")
    public DataSource logDatasource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "logEntityManager")
    public LocalContainerEntityManagerFactoryBean localEntityManager(TransactionManager transactionManager, UserTransaction userTransaction) {
        AtomikosJtaPlatform.setTransactionManager(transactionManager);
        AtomikosJtaPlatform.setUserTransaction(userTransaction);

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.H2);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        properties.put("hibernate.hdm2ddl.auto", "update");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(logDatasource());
        entityManager.setJpaVendorAdapter(adapter);
        entityManager.setPackagesToScan("com.walker.transaction.domain.log");
        entityManager.setPersistenceUnitName("logPersistUnit");
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }
}
