package com.amal.blogapi.users;


import com.amal.blogapi.articles.ArticleEntity;
import com.amal.blogapi.commons.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Setter
@Getter
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    String username;
    String password; //TODO: HASH this
    String email;
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
