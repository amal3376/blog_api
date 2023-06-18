package com.amal.blogapi.users;


import com.amal.blogapi.users.dto.CreateUserDTO;
import com.amal.blogapi.users.dto.LoginUserDTO;
import com.amal.blogapi.users.dto.UserReponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public ResponseEntity<UserReponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO) {
        var savedUser = usersService.loginuser(loginUserDTO);
        return ResponseEntity.ok(savedUser);
    }
    @ExceptionHandler(UsersService.UserNotFoundException.class)
    public ResponseEntity<String> handUserNotFoundException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
