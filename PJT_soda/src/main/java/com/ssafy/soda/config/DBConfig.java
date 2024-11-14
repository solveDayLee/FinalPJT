package com.ssafy.soda.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.soda.model.dao")
public class DBConfig {

}
