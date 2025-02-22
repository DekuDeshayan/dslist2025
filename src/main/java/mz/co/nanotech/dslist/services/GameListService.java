package mz.co.nanotech.dslist.services;

import mz.co.nanotech.dslist.dto.GameDTO;
import mz.co.nanotech.dslist.dto.GameListDTO;
import mz.co.nanotech.dslist.dto.GameMinDTO;

import java.util.List;

public interface GameListService {

    List<GameListDTO>  findAll();


}
