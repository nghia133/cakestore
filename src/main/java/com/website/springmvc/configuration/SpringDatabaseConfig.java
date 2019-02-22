package com.website.springmvc.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@ComponentScan(basePackages = "com.website.springmvc")
@EnableTransactionManagement
@Configuration
public class SpringDatabaseConfig extends WebMvcConfigurerAdapter {
	@Bean
	public LocalSessionFactoryBean sessionFactory(BasicDataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "com.website.springmvc.entities" });
		sessionFactory.setAnnotatedClasses();
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;

	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.search.default.directory_provider", "org.hibernate.search.store.impl.FSDirectoryProvider");
		properties.put("hibernate.search.default.indexBase", "indexes");
		return properties;

	}

	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/cakestore");
		datasource.setUsername("root");
		datasource.setPassword("");
		return datasource;

	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txmanager = new HibernateTransactionManager();
		txmanager.setSessionFactory(s);
		return txmanager;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   
	   
	    return multipartResolver;
	}

}
