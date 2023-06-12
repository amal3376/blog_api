package com.amal.blogapi.users.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserReponseDTO {
    Integer id;
    String email;
    String username;
    String bio;
    String image;

}
