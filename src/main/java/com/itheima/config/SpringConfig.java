package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.itheima.service"})
@PropertySource({"classpath:jdbc.properties"})
@Import({SpringDataJPAConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
