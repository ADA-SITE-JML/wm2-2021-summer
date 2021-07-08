package com.hw2.blog.entity;

import lombok.Builder;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "POSTS")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") private Integer id;

    @Column(name="title")
    @NotBlank(message = "Title cannot be blank!")
    private String title;

    @Column(name = "body", columnDefinition = "text")
    @NotBlank(message = "Post body needed!")
    @Size(min = 32, max = 500)
    private String body;

    @Column(name = "image", columnDefinition = "text")
    @Builder.Default
    @URL
    private String image = "https://media.istockphoto.com/vectors/no-image-available-sign-vector-id922962354?k=6&m=922962354&s=612x612&w=0&h=_KKNzEwxMkutv-DtQ4f54yA5nc39Ojb_KPvoV__aHyU=";

    @CreationTimestamp @Column(name = "created_at",columnDefinition="timestamp default now()") private Timestamp created_at;

    @UpdateTimestamp @Column(name = "updated_at", columnDefinition="timestamp default now()") private Timestamp updated_at;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="profile_id")
    private Profile author;

    // i have added unique constraints, becuase (profile, post) must be unique, one user can like one post only once
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JoinTable(name = "PROFILE_LIKED_POSTS",
                joinColumns = @JoinColumn(name = "POST_ID"),
                inverseJoinColumns = @JoinColumn(name = "PROFILE_ID"),
                uniqueConstraints = {
                    @UniqueConstraint(name = "uniquePostIdProileId",
                    columnNames = {"POST_ID", "PROFILE_ID"})
                },foreignKey = @ForeignKey(name = "post_fk_id",
                    foreignKeyDefinition = "foreign key(post_id) references posts(id) on delete cascade")
                ,inverseForeignKey = @ForeignKey(name = "profile_fk_id",
                    foreignKeyDefinition = "foreign key(profile_id) references PROFILES(id) on delete cascade")
    )
    private Set<Profile> liked_profiles = new HashSet<>();


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

    public Post(Integer id, String title, String body, String image) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public Post(Profile author){
        this.author = author;
    }

    public Post(Integer id, Profile author) {
        this.id = id;
        this.author = author;
    }

    public boolean equalsTo(Post post) {
        return (this.id == post.id);
    }
}
