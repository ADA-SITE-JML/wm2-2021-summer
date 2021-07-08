package com.assignment02.assignment.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 24, message = "First name cannot be fewer than 2 characters and greater than 24")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 24, message = "Last name cannot be fewer than 2 characters and greater than 24")
    private String lastName;

    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "TEAMS_PLAYERS", joinColumns = @JoinColumn(name = "PLAYER_ID"), inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player() { }

    public Player(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
