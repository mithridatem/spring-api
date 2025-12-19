package com.adrar.api;

import com.adrar.api.entity.WrapNameOnly;
import com.adrar.api.service.UserService;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ApiApplication implements CommandLineRunner {

    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
    }
}
