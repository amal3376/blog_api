package com.amal.blogapi.users;


import com.amal.blogapi.articles.ArticleEntity;
import com.amal.blogapi.commons.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    String username;

    String password; //TODO: HASH this
    String bio;
    String image;

    @ManyToMany(mappedBy = "likedBy")
    List<ArticleEntity> likedArticles;

    @ManyToMany
            @JoinTable(
                    name = "user_follows",
                    joinColumns = @JoinColumn(name = "follower_id"),
                    inverseJoinColumns = @JoinColumn(name = "following_id")
            )
    List<UserEntity> following;

    @ManyToMany(mappedBy = "following")
    List<UserEntity> followers;

}
