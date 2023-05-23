package com.amal.blogapi.users;


import com.amal.blogapi.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    String username;

    String password; //TODO: HASH this
    String bio;
    String image;

}
