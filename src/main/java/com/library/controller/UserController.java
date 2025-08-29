package com.library.controller;

import com.library.controller.request.UserRequest;
import com.library.controller.response.BookResponse;
import com.library.controller.response.UserResponse;
import com.library.mapper.BookMapper;
import com.library.mapper.UserMapper;
import com.library.model.User;
import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers()
                .stream()
                .map(UserMapper::toResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
        var user = UserMapper.toEntity(request);
        var savedUser = userService.createUser(user);
        return ResponseEntity.ok(UserMapper.toResponse(savedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
