package com.amal.blogapi.users;

import com.amal.blogapi.security.jwt.JWTService;
import com.amal.blogapi.users.dto.CreateUserDTO;
import com.amal.blogapi.users.dto.LoginUserDTO;
import com.amal.blogapi.users.dto.UserReponseDTO;
//import lombok.var;
//import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private  final  UsersRepository usersRepository;
    public final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserReponseDTO createUser(CreateUserDTO createUserDTO){
        //TODO: Encrypt Password
        //TODO: Validate Email
        //TODO: Check if the username already exists
        var newUserEntity = modelMapper.map(createUserDTO, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        var savedUser = usersRepository.save(newUserEntity);
        var userResponseDTO = modelMapper.map(savedUser, UserReponseDTO.class);

//        var newUserEntity = new UserEntity();
//        newUserEntity.setUsername(createUserDTO.getUsername());
//        newUserEntity.setEmail(createUserDTO.getEmail());
//        newUserEntity.setPassword(createUserDTO.getPassword());
//        var savedUser = usersRepository.save(newUserEntity);
//        var userResponseDTO = new UserReponseDTO();
//        userResponseDTO.setId(savedUser.getId());
//        userResponseDTO.setUsername(savedUser.getUsername());
//        userResponseDTO.setEmail(savedUser.getEmail());
        userResponseDTO.setToken(jwtService.createJWT(savedUser.getId()));
        return userResponseDTO;
    }

    public UserReponseDTO loginuser(LoginUserDTO loginUserDTO){
        var userEntity = usersRepository.findByUsername(loginUserDTO.getUsername());
        //implement password matching
        if (userEntity == null){
            throw new UserNotFoundException(loginUserDTO.getUsername());
        }
        //TODO: Encrypt Password
        var passMatch = passwordEncoder.matches(loginUserDTO.getPassword(),userEntity.getPassword());
        if (!passMatch){
            throw new IllegalArgumentException("Incorrect password");
        }
        var userResponseDTO = modelMapper.map(userEntity,UserReponseDTO.class);
        userResponseDTO.setToken(jwtService.createJWT(userEntity.getId()));
        return  userResponseDTO;

    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(Integer id){
            super("User with id " + id + "not found");
        }

        public UserNotFoundException(String userName){
            super("User with id " + userName + "not found");
        }
    }
    public static class IncorrectPasswordException extends IllegalArgumentException{
        public IncorrectPasswordException(){
            super("Incorrect Password");
        }
    }
}
