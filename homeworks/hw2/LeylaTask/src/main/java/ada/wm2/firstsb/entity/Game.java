package ada.wm2.firstsb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="GAME")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String NAME;

    @ManyToMany(mappedBy = "games",cascade = CascadeType.ALL )
    private Set<Gamer> gamers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Set<Gamer> getGamers() {
        return gamers;
    }

    public void setGamers(Set<Gamer> gamers) {
        this.gamers = gamers;
    }

}
