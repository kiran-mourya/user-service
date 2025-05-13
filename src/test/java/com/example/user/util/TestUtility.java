package com.example.user.util;

import com.example.user.entity.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {

    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static List<User> getAllUserDetails() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,null,"pihu@gmail.com",new BigInteger("9990809324"));

        User user2 = new User(2,"rani","rani@gmail.com",new BigInteger("9970809324"));
        User user3 = new User(3,"piyush","piyush@gmail.com",new BigInteger("9970808824"));
        User user4 = new User(4,"piyush","piyush@gmail.com",new BigInteger("9970808824"));
        User user5 = new User(5,"sara","sara@gmail.com",new BigInteger("997080"));
        User user6 = new User(6,"raman","raman@gmail.com",new BigInteger("997080"));
        User user7 = new User(7,"soumya","soumya@gmail.com",new BigInteger("997080"));
        User user8 = new User(8,"suman","suman@gmail.com",new BigInteger("998080"));

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
