package com.oracle.hrb.tusousou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

@Configuration
public class UserConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Jedis getJedis() {
        Jedis jedis = new Jedis();
        jedis = new Jedis("192.168.233.129", 8000);
        jedis.auth("123456");
        return jedis;
    }

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);

    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }


}
