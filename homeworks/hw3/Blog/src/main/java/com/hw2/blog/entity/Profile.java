package com.hw2.blog.entity;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="PROFILES")
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") private Integer id;

    @Column(name = "full_name", length = 65)
    @NotBlank(message = "Please, Enter Fullname")
    @Size(min = 2, max = 65)
    private String fullname;

    @Column(name = "username", unique = true, length = 65)
    @NotBlank(message = "Please, Enter Username!")
    @Size(min = 5, max = 65)
    private String username;

    @Column(name = "password")
    @NotBlank(message = "Please, Enter password!s")
    @Size(min = 8, max = 64)
    private String password;

    @Column(name = "image", columnDefinition = "text")
    @Builder.Default
    @URL
    private String image = "https://crestedcranesolutions.com/wp-content/uploads/2013/07/facebook-profile-picture-no-pic-avatar.jpg";

    @Column(name="bio") private String bio;

    @CreationTimestamp @Column(name = "created_at",columnDefinition="timestamp default now()") private Timestamp created_at;

    @UpdateTimestamp @Column(name = "updated_at", columnDefinition="timestamp default now()") private Timestamp updated_at;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="user_id")
    private User user;


    @ManyToMany(mappedBy = "liked_profiles", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<Post> liked_posts = new HashSet<>();


    public Profile(){
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public String getImage() {
        return image;
    }

    public String getBio() {
        return bio;
    }

    public String getFullname() {
        return fullname;
    }

    public Set<Post> getLiked_posts() {
        return liked_posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.fullname;
    }

    public boolean equalsTo(Profile post_profile) {
       return (this.id == post_profile.id);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }



}

