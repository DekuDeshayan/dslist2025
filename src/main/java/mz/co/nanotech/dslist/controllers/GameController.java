package mz.co.nanotech.dslist.controllers;


import mz.co.nanotech.dslist.dto.GameMinDTO;
import mz.co.nanotech.dslist.entities.Game;
import mz.co.nanotech.dslist.services.Impl.GameServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
