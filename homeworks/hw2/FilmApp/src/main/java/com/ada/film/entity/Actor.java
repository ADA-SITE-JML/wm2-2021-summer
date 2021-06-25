package com.ada.film.entity;


import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Actor")
public class Actor {

    @Id
    @Column(name = "ACTOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    @Column(name = "FIRST_NAME")
    @NotNull
    private String first_name;

    @Column(name = "LAST_NAME")
    @NotNull
    private String last_name;

    @Column(name = "BIRTH_PLACE")
    private String birth_place;

    @Column(name = "BIRTH_DATE", columnDefinition = "date check(BIRTH_DATE<=now())")
    private Date birth_date;

    @ManyToMany(mappedBy = "actors")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Film> films;

    public int getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }


    public String toString() { return this.first_name + " " + this.last_name; }
}
