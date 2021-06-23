package com.ada.film.entity;


import com.sun.istack.NotNull;

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

    @Column(name = "BIRTH_DATE")
    private Date birth_date;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films;


}
