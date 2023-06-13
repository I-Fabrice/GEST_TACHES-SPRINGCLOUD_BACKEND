package com.mycompany.tacheApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
// @ImportAutoConfiguration({FeignAutoConfiguration.class})
public class TacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacheApplication.class, args);
    }
}
