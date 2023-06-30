package com.mycompany.tacheCompteApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class TacheCompteApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(TacheCompteApplication.class, args);
    }

}
