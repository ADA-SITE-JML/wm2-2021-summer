package ada.wm2.firstsb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="GAMER")
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="GAMER_ID")
    private Integer id;

    @Column(name="NAME")
    private String name;


    @ManyToMany
    @JoinTable(name = "ENROLLMENTS",
            joinColumns = @JoinColumn(name = "gamer_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
