package com.cuiwei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.cuiwei")
@EnableAspectJAutoProxy   //开启AOP的自动代理
public class springConfig {
}
