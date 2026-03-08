package com.example.user.response;

import java.util.List;

public class ApiResponse {
    private ResultCode resultCode;
    private Object response;
    private UserResponseDetails[] responseList;

    public ApiResponse(){}

    public ApiResponse(ResultCode resultCode, Object response) {
        this.resultCode = resultCode;
        this.response = response;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public UserResponseDetails[] getResponseList() {
        return responseList;
    }

    public void setResponseList(List<UserResponseDetails> responseList) {
        this.responseList = responseList.toArray(new UserResponseDetails[0]);
    }
}
