package com.oracle.hrb.tusousou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.oracle.hrb.tusousou.dao")
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching
public class TusousouApplication {

    public static void main(String[] args) {
        SpringApplication.run(TusousouApplication.class, args);
    }

}
