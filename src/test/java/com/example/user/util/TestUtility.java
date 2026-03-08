package com.example.user.util;

import com.example.user.entity.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtility {

    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static List<User> getAllUserDetails() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Pihu", "Sharma", "Female",
                "pihu@gmail.com", "9990809324", 22, new Date(), new Date());

        User user2 = new User(2, "Rani", "Kumari", "Female",
                "rani@gmail.com", "9970809324", 24, new Date(), new Date());

        User user3 = new User(3, "Piyush", "Singh", "Male",
                "piyush@gmail.com", "9970808824", 26, new Date(), new Date());

        User user4 = new User(4, "Piyush", "Verma", "Male",
                "piyush@gmail.com", "9970808824", 27, new Date(), new Date());

        User user5 = new User(5, "Sara", "Ali", "Female",
                "sara@gmail.com", "9970800000", 23, new Date(), new Date());

        User user6 = new User(6, "Raman", "Kumar", "Male",
                "raman@gmail.com", "9960800000", 28, new Date(), new Date());

        User user7 = new User(7, "Soumya", "Patel", "Female",
                "soumya@gmail.com", "9950800000", 21, new Date(), new Date());

        User user8 = new User(8, "Suman", "Gupta", "Male",
                "suman@gmail.com", "9980800000", 25, new Date(), new Date());

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
