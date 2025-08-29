package com.library.mapper;

import com.library.controller.request.UserRequest;
import com.library.controller.response.BookResponse;
import com.library.controller.response.UserResponse;
import com.library.model.User;

public class UserMapper {

    public static User toEntity(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .build();
    }

    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
