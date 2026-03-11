package com.msedcl.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.msedcl.main")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
