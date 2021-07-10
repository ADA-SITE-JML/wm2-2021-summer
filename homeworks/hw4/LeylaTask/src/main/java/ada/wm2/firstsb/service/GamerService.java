package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Game;
import ada.wm2.firstsb.entity.Gamer;
import ada.wm2.firstsb.repo.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamerService {

    @Autowired
    private GamerRepository gamerRepository;

    public List<Gamer> getGamerList() {
        List<Gamer> gamerList = (List<Gamer>) gamerRepository.findAll();

        return gamerList;
    }

    public Gamer getGamerById(int id) {

        return gamerRepository.findById(id).get();

    }

    public void save(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    public void delete(int id) {
        gamerRepository.deleteById(id);
    }

}
