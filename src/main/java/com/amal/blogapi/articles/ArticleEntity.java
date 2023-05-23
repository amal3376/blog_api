package com.amal.blogapi.articles;

import com.amal.blogapi.commons.BaseEntity;
import com.amal.blogapi.users.UserEntity;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 150)
    String slug;
    @Column(nullable = false, length = 200)
    String title;
    String subtitle;
    @Column(nullable = false, length = 8000)
    String body;
//    String[] tagList; //TODO: Implement this

    @ManyToOne
    UserEntity author;

    @ManyToMany
            @JoinTable(
                    name = "article_likes",
                    joinColumns =@JoinColumn(name = "article_id"),
                    inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    List<UserEntity> likedBy;
}
