package com.example.user.repository;

import com.example.user.entity.User;
import com.example.user.util.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired

    private UserRepository userRepository;

    @Test
    public void testSaveUserSuccessfully() {
        User user = getUserDetails();
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        Assertions.assertEquals(user,savedUser);
    }
    @Test
    public void testGetAllUsersDetailsSuccessfully() {
        List<User> userList = TestUtility.getAllUserDetails();

        List<User>  savedUserList = userRepository.findAll();
        assertNotNull(savedUserList);
        Assertions.assertEquals(userList.get(0).getContact(),savedUserList.get(0).getContact());
    }

    @Test
    public void testGetUsersDetailsByIDSuccessfully() {
        User user = new User(6,"raman","raman@gmail.com",new BigInteger("997080"));

        User savedUser = userRepository.findById(6).get();
        assertNotNull(savedUser);
        Assertions.assertEquals(user.getContact(),savedUser.getContact());
    }




    private User getUserDetails() {
        User user = new User();
        user.setContact(new BigInteger("7689"));
        user.setEmail("JohnDoe@gmail.com");
        user.setName("John Doe");
        return user;
    }




}
