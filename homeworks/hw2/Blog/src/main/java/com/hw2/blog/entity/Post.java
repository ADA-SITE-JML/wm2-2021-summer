package com.hw2.blog.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "POSTS")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") private Integer id;


    @NotNull @Column(name="title") private String title;

    @Column(name = "body", columnDefinition = "text") private String body;

    @Column(name = "image", columnDefinition = "text") private String image;


    @CreationTimestamp @Column(name = "created_at",columnDefinition="timestamp default now()") private Timestamp created_at;

    @UpdateTimestamp @Column(name = "updated_at", columnDefinition="timestamp default now()") private Timestamp updated_at;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="profile_id")
    private Profile author;
    
    // i have added unique constraints, becuase (profile, post) must be unique, one user can like one post only once
    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "PROFILE_LIKED_POSTS",
                joinColumns = @JoinColumn(name = "POST_ID"),
                inverseJoinColumns = @JoinColumn(name = "PROFILE_ID"),
                uniqueConstraints = {
                    @UniqueConstraint(name = "uniquePostIdProileId",
                    columnNames = {"POST_ID", "PROFILE_ID"})
                })
    private Set<Profile> liked_profiles;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Profile getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getImage() {
        return image;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(Profile author) {
        this.author = author;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Set<Profile> getLiked_profiles() {
        return liked_profiles;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post(){

    }

    public Post(Profile author){
        this.author = author;
    }

    public boolean equalsTo(Post post) {
        return (this.id == post.id);
    }
}
