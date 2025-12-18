package com.adrar.api;

import com.adrar.api.entity.WrapNameOnly;
import com.adrar.api.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        userService
                .getAllUserFilter()
                .forEach(u -> System.out.println(new WrapNameOnly(u)));
    }
}
