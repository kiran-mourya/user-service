package com.example.user.repository;

import com.example.user.entity.User;
import com.example.user.util.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
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

//        List<User> userList = TestUtility.getAllUserDetails();
//
//        userRepository.saveAll(userList);

        List<User> savedUserList = userRepository.findAll();

        Assertions.assertNotNull(savedUserList);
        Assertions.assertFalse(savedUserList.isEmpty());

        Assertions.assertNotNull(
                savedUserList.get(0).getPhoneNumber()
        );
    }

    @Test
    public void testGetUsersDetailsByIDSuccessfully() {

        User user = new User(
                6,
                "Raman",
                "Kumar",
                "Male",
                "raman@gmail.com",
                "9970800000",
                28,
                new Date(),
                new Date()
        );

        userRepository.save(user);

        Optional<User> savedUser = userRepository.findById(6);

        Assertions.assertTrue(savedUser.isPresent());

        Assertions.assertEquals(
                user.getPhoneNumber(),
                savedUser.get().getPhoneNumber()
        );
    }

    public User getUserDetails() {
        return new User(
                1,
                "Pihu",
                "Sharma",
                "Female",
                "pihu@gmail.com",
                "9990809324",
                22,
                new Date(),
                new Date()
        );
    }

}
