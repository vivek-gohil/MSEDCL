package com.msedcl.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.msedcl.main")
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("SpringConfiguration class object created!!");
	}

	@Bean
	JdbcTemplate getJdbcTemplate() {
		System.out.println("getJdbcTemplate()  called");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root123");
		dataSource.setUrl("jdbc:mysql://localhost:3306/msedcldb");
		return new JdbcTemplate(dataSource);
	}
}
