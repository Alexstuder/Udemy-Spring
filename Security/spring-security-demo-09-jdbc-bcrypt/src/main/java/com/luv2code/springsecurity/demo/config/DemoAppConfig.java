package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// set a variable to hold the propertiese
	
	@Autowired
	private Environment env;
	
	// set up a logger for idagnostic
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	
	// define a bean for the View Resolver
	
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}

	// define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// create a connetion pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		
		// set a jdbc drive class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// log the connection props
		// just make shure we are Really reading from the right Propertie file
		myLogger.info(">>> jdbc.url = "+ env.getProperty("jdbc.url"));
		myLogger.info(">>> jdbc.user = "+ env.getProperty("jdbc.user"));
		
		// set the database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(getIntProperty(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(getIntProperty(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(getIntProperty(env.getProperty("connection.pool.maxIdleTime")));
		
		
		
		
		return securityDataSource;
		
	}
	// need a helper method
	//read environment property and convert ti int
	private int getIntProperty(String propName) {
		
		return Integer.parseInt(propName);
	}
}
