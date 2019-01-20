package com.dudusam.mini.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.dudusam.mini", considerNestedRepositories = true)
public class DatabaseConfig {

    @Bean(name="dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ConfigFile.get("db.driver"));
        dataSource.setUrl(ConfigFile.get("db.url"));
        dataSource.setUsername(ConfigFile.get("db.username"));
        dataSource.setPassword(ConfigFile.get("db.password"));
        return dataSource;
    }

    @Bean
    @Qualifier(value = "hibernateTransactionManager")
    public HibernateTransactionManager hibernateTransactionManager(){
        //return new HibernateTransactionManager((SessionFactory) this.hibernateSessionFactoryBean().getObject());
        return new HibernateTransactionManager(hibernateSessionFactoryBean().getObject());
    }

    @Bean(name="hibernateSessionFactoryBean")
    public LocalSessionFactoryBean hibernateSessionFactoryBean(){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(this.dataSource());
        bean.setPackagesToScan("com.dudusam.mini");
        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        // db 수정할 경우 : update로 변경, 평시에는 none으로 사용
		props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.cache.use_second_level_cache", "true");
        props.setProperty("hibernate.cache.use_query_cache", "true");
        props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "10");
        props.setProperty("hibernate.c3p0.idle_test_period", "60000");
        bean.setHibernateProperties(props);
        return bean;
    }

    @Bean
    @Primary
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactoryBean().getObject());
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean(name="jpaSessionFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpsAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpsAdapter);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("com.dudusam.mini");
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties jpaHibernateProperties(){
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", ConfigFile.get("db.dialect"));
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.cache.use_second_level_cache", "true");
        props.setProperty("hibernate.cache.use_query_cache", "true");
        props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "10");
        props.setProperty("hibernate.c3p0.idle_test_period", "60000");
        return props;
    }


}
