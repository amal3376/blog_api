package com.amal.blogapi.users;


import com.amal.blogapi.users.dto.CreateUserDTO;
import com.amal.blogapi.users.dto.UserReponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {
    private  final  UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("")
    public ResponseEntity<UserReponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        var savedUser = usersService.createUser(createUserDTO);
        return ResponseEntity.created(URI.create("/users/"+ savedUser.getId()))
        .body(savedUser);
    }
}
