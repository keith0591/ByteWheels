package com.bytemark.bytewheels;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.DataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@PropertySource(value = "file:${propfile}/application.properties")
@EnableJpaRepositories

public class BytewheelsApplication {
	
	@Autowired
	Environment env;
	

	public static void main(String[] args) {
		SpringApplication.run(BytewheelsApplication.class, args);
	}
	
	 /*@Bean
	public DataSource datasource(){
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName(env.getProperty("org.postgresql.Driver"));
		    dataSource.setUsername(env.getProperty("datasource.username"));
		    dataSource.setPassword(env.getProperty("org.postgresql.Driver"));
		    dataSource.setSchema(env.getProperty("org.postgresql.Driver"));
		    dataSource.setUrl("jdbc:postgresql://localhost:5432"); 
		    return dataSource;
	}*/
    
}
