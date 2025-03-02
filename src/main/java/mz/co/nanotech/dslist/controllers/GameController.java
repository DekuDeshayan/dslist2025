package mz.co.nanotech.dslist.controllers;


import mz.co.nanotech.dslist.dto.GameDTO;
import mz.co.nanotech.dslist.dto.GameMinDTO;
import mz.co.nanotech.dslist.entities.Game;
import mz.co.nanotech.dslist.services.Impl.GameServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameServiceImpl service;

    public GameController(GameServiceImpl service){
        this.service = service;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
     return service.findAll();
    }

    @GetMapping("/{id}")
    public GameDTO getGame(@PathVariable Long id){
        return service.getGame(id);
    }


}
