package br.com.lds.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.lds.web.bean.page"})
public class WebConfig{

}
