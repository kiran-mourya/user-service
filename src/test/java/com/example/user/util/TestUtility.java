package com.example.user.util;

import com.example.user.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {

    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static List<User> getAllUserDetails() {
        List<User> userList = new ArrayList<>();
        User user1 = new User("1", "Pihu Sharma",
                "pihu@gmail.com", Long.valueOf("9990809324"),
                 LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user2 = new User("2", "Rani Kumari",
                "rani@gmail.com", Long.valueOf("9970809324"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user3 = new User("3", "Piyush Singh",
                "piyush@gmail.com", Long.valueOf("9970808824"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user4 = new User("4", "Piyush Verma",
                "piyush@gmail.com", Long.valueOf("9970808824"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user5 = new User("5", "Sara Ali",
                "sara@gmail.com", Long.valueOf("9970800000"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user6 = new User("6", "Raman Kumar",
                "raman@gmail.com", Long.valueOf("9960800000"),
                LocalDate.now(), LocalDate.now(), "ADMIN_ROLE", "password123");

        User user7 = new User("7", "Soumya Patel",
                "soumya@gmail.com", Long.valueOf("9950800000"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        User user8 = new User("8", "Suman Gupta",
                "suman@gmail.com", Long.valueOf("9980800000"),
                LocalDate.now(), LocalDate.now(), "USER_ROLE", "password123");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        return userList;
    }
}
