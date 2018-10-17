package com.example.cookiedemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

@SpringBootApplication
public class CookieDemo1Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();

        new SpringApplicationBuilder(CookieDemo1Application.class)
                .properties("server.port="+port).run(args);
    }
}
