package org.shop.rest.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("org.shop")
@PropertySource(value = {"classpath:application.properties"})
public class ApplicationContextConfig {
    @Value("${db.driver}")
    private String propDbDriver;
    @Value("${db.url}")
    private String propDbUrl;
    @Value("${db.username}")
    private String propDbUserName;
    @Value("${db.password}")
    private String propDbPassword;
    @Value("${db.hibernate.dialect}")
    private String propHibernateDialect;
    @Value("${db.hibernate.show_sql}")
    private String propHibernateShowSql;
    @Value("${db.hibernate.hbm2ddl.auto}")
    private String propHibernateHbm2DdlAuto;
    @Value("${db.entitymanager.packages.to.scan}")
    private String propPackagesToScan;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(propPackagesToScan);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(propDbDriver);
        dataSource.setUrl(propDbUrl);
        dataSource.setUsername(propDbUserName);
        dataSource.setPassword(propDbPassword);
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernateDialect", propHibernateDialect);
        properties.put("hibernateShowSql", propHibernateShowSql);
        properties.put("hibernateHbm2DdlAuto", propHibernateHbm2DdlAuto);
        return properties;
    }
}
