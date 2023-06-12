package com.amal.blogapi.users;

import com.amal.blogapi.users.dto.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UsersServiceTests {

    @Autowired private UsersRepository usersRepository;
    private  UsersService usersService;
    private UsersService getUsersService(){
        if (usersService == null){
            var modelMapper = new ModelMapper();
            usersService= new UsersService(usersRepository,modelMapper);
        }
        return usersService;0000000000000000
    }

    @Test
    public  void testCreateUser(){
        var newUserDTO = new CreateUserDTO();
        newUserDTO.setEmail("amalendushekhar5@gmail.com");
        newUserDTO.setUsername("amal");
        newUserDTO.setPassword("jha@3376");
        var savedUser = getUsersService().createUser(newUserDTO);
        assertNotNull(savedUser);
    }

}
