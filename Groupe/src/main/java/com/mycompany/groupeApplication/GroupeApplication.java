package com.mycompany.groupeApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class GroupeApplication
{
    public static void main(String[] args) {
        SpringApplication.run(GroupeApplication.class, args);
    }
}
