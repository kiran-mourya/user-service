package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.exception.UserAlreadyExistsException;
import com.example.user.exception.UserNotFoundException;
import com.example.user.repository.UserRepository;
import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;
import com.example.user.response.ResultCode;
import com.example.user.response.UserResponseDetails;
import com.example.user.validation.UserValidation;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper =  modelMapper;
    }

    @Override
    public ApiResponse addUser(UserRequestDetails userRequest) {
        User userRequesttoSave = null;
        User userResponseAfterSave = null;
        UserResponseDetails userResponseDetails = null;
        Date currentDate = new Date();
        userRequest.setCreatedDate(currentDate);
        userRequest.setModifiedDate(currentDate);
        ApiResponse apiResponse = UserValidation.userValidation(userRequest);
        if (userRepository.findUserByEmailAddress(userRequest.getEmailAddress())) {
            throw new UserAlreadyExistsException(
                    "User already exists with email:  "+userRequest.getEmailAddress(),
                    userRequest.getId()
            );
        }
                userRequesttoSave = modelMapper.map(userRequest, User.class);
                userResponseAfterSave = userRepository.save(userRequesttoSave);
                userResponseDetails = modelMapper.map(userResponseAfterSave, UserResponseDetails.class);
        apiResponse = new ApiResponse(new ResultCode("user saved successfully !",200,"description",userResponseAfterSave.getUid()
        ),userResponseDetails);

        return apiResponse;
    }

    @Override
    public ApiResponse getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDetails> userResponseDetailsList = new ArrayList<>();

        for(User user: userList){
            UserResponseDetails userResponseDetails = modelMapper.map(user,UserResponseDetails.class);
            userResponseDetailsList.add(userResponseDetails);
        }
        ApiResponse apiResponse = new ApiResponse();
           apiResponse.setResponseList(userResponseDetailsList);

        return new ApiResponse(new ResultCode("user details fetched successfully !",200,"description",
                userList.get(0).getUid()),userResponseDetailsList);
    }

    @Override
    public ApiResponse getUsersById(Integer userId) {
        User user = null;
        UserResponseDetails userResponseDetails=null;
        try{
             user = userRepository.findById(userId).get();
             userResponseDetails =  modelMapper.map(user,UserResponseDetails.class);
             if(user.getEmailAddress().isEmpty()){
                 return new ApiResponse(new ResultCode("user does not exists !",404,"description",
                         user.getUid()),userResponseDetails);

             }
        }catch(Exception ex){
            throw new UserNotFoundException("User does not exists in db! ",userId);
        }

        return new ApiResponse(new ResultCode("user details fetched successfully !",200,"description",
                userId),userResponseDetails);
    }

    @Override
    public ApiResponse deleteUser(Integer userId) {

        try{
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isEmpty()) {
                throw new UserNotFoundException("User not found for deletion", userId);
            }
            userRepository.deleteById(userId);
        }catch(Exception ex){
           // UserNotFoundException
        }

        return new ApiResponse(new ResultCode("user deleted successfully !",204,"description",userId),null);
    }


}
