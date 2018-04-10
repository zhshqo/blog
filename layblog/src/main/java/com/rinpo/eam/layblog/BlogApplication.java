package com.rinpo.eam.layblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(value = {"com.rinpo.eam"})
@EnableAspectJAutoProxy //启用AOP注解特性  
@EnableCaching
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//不注入默认的datasource
@ImportResource({"classpath:mybatis/spring-mybatis.xml"})
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	
}
