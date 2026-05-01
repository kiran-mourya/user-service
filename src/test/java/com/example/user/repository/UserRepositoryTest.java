package com.example.user.repository;

import com.example.user.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUserSuccessfully() {
        User user = getUserDetails();
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        Assertions.assertEquals(user.getEmailAddress(), savedUser.getEmailAddress());
    }

    @Test
    public void testGetAllUsersDetailsSuccessfully() {
        userRepository.save(getUserDetails());

        List<User> savedUserList = userRepository.findAll();

        assertNotNull(savedUserList);
        Assertions.assertFalse(savedUserList.isEmpty());
        assertNotNull(savedUserList.get(0).getPhoneNumber());
    }

    @Test
    public void testGetUsersDetailsByIDSuccessfully() {
        User user = new User(
                "1002",
                "Raman",
                "raman@gmail.com",
                Long.valueOf("9008907680"),
                LocalDate.now(),
                LocalDate.now(),
                "ADMIN_ROLE",
                "password@72"
        );

        userRepository.save(user);

        Optional<User> savedUser = userRepository.findById("1002");

        Assertions.assertTrue(savedUser.isPresent());
        Assertions.assertEquals(user.getPhoneNumber(), savedUser.get().getPhoneNumber());
    }

    public User getUserDetails() {
        return new User(
                "1",
                "Pihu Sharma",
                "pihu@gmail.com",
                Long.valueOf("9990809324"),
                LocalDate.now(),
                LocalDate.now(),
                "USER_ROLE",
                "password123"
        );
    }
}