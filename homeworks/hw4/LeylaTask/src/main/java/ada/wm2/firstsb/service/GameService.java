package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Game;
import ada.wm2.firstsb.helper.StringHelperTest;
import ada.wm2.firstsb.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getGameList() {
        List<Game> gameList = (List<Game>) gameRepository.findAll();

        return gameList;
    }

    public Game getGameById(int id) {

        return gameRepository.findById(id).get();

    }

    public void save(Game game) {
        game.setNAME(StringHelperTest.StringHelperTest(game.getNAME()));
        gameRepository.save(game);
    }

    public void delete(int id) {
        gameRepository.deleteById(id);
    }
}
