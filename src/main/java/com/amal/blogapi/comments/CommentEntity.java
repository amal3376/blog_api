package com.amal.blogapi.comments;

import com.amal.blogapi.articles.ArticleEntity;
import com.amal.blogapi.commons.BaseEntity;
import com.amal.blogapi.users.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(nullable = false, length = 100)
    String title;
    @Column(length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;

}
