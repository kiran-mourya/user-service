package com.example.user.validation;

import com.example.user.repository.UserRepository;
import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;
import com.example.user.response.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class UserValidation {

    @Autowired
    private UserRepository userRepository;

    public ApiResponse userValidation(UserRequestDetails userRequestDetails) {
        if (userRequestDetails == null) {
            return new ApiResponse(new ResultCode("Invalid Format of data", 400, null,null),null);
        }

        // Check mandatory fields
        if (userRequestDetails.getUsername() == null || userRequestDetails.getUsername().isEmpty()) {
            return new ApiResponse(new ResultCode("UserName Must Not Be Null or Empty", 400, null,userRequestDetails.getId()),null);
        }
        if (userRequestDetails.getEmailAddress() == null || userRequestDetails.getEmailAddress().isEmpty()) {
            return new ApiResponse(new ResultCode("Email Address Must Not Be Null or Empty", 400, null,userRequestDetails.getId()),null);
        }

        // Validate email format
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(userRequestDetails.getEmailAddress());
        if (!matcher.matches()) {
            return new ApiResponse(new ResultCode("Email should be valid", 400, null,userRequestDetails.getId()),null);
        }

        // Check phone number if not null
        if (userRequestDetails.getPhoneNumber() != null && !userRequestDetails.getPhoneNumber().toString().matches("\\d{10}")) {
            return new ApiResponse(new ResultCode("Mobile number length should be 10 digits", 400, null,userRequestDetails.getId()),null);
        }
        return new ApiResponse(new ResultCode("An error occurred while adding the employee", 500, null,userRequestDetails.getId()),null);
    }

}
