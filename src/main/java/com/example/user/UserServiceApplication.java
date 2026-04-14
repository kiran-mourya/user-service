package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;

@SpringBootApplication
public class UserServiceApplication {
    public static void main( String[] args ){

        SpringApplication.run(UserServiceApplication.class,args);
        String str = "Hello";
        String s = str +"Java";
        System.out.println(str);
        System.out.println(s);
    }


}
