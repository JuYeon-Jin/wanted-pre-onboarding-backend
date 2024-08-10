package com.wanted.pre_onboard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wanted.pre_onboard.dao")
public class MyBatisConfig {
}
