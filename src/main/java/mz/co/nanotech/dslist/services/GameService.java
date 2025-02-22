package mz.co.nanotech.dslist.services;

import mz.co.nanotech.dslist.dto.GameDTO;
import mz.co.nanotech.dslist.dto.GameMinDTO;
import mz.co.nanotech.dslist.entities.Game;

import java.util.List;

public interface GameService {

    GameDTO getGame(Long id);
    List<GameMinDTO>  findAll();
    List<GameMinDTO> findByList(Long listId);





}
