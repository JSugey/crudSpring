
package com.crudangularspring.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

/**
 *
 * @author Usuario
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.crudangularspring.dao")
@PropertySource(value= {
    "classpath:db.properties"
})
public class AppConfig {
    
    @Autowired
    private Environment env;
    
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getSessionFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        
        factoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        factoryBean.setDataSource(dataSource());        
        factoryBean.setPersistenceUnitName("myJpaPersistenceUnit");
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPackagesToScan("com.crudangularspring");
        
        return factoryBean;
    }
    
    @Bean(name="transactionManager")
    public PlatformTransactionManager getTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(getSessionFactory().getObject());
        return jpaTransactionManager;
    }
    
    @Bean
    public JpaVendorAdapter getJpaVendorAdapter(){
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driver"));
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.user"));
        dataSource.setPassword(env.getProperty("mysql.password"));
        return dataSource;
    }
    
    private Properties hibernateProperties(){
        Properties props = new Properties();
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(DIALECT, env.getProperty("hibernate.dialect"));
        props.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
      
        return props;
    }
}
