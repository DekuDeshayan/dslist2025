package mz.co.nanotech.dslist.controllers;


import mz.co.nanotech.dslist.dto.GameListDTO;
import mz.co.nanotech.dslist.dto.GameMinDTO;
import mz.co.nanotech.dslist.services.GameListService;
import mz.co.nanotech.dslist.services.GameService;
import mz.co.nanotech.dslist.services.Impl.GameListServiceImpl;
import mz.co.nanotech.dslist.services.Impl.GameServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService service;
    private final GameService gameService;

    public GameListController(GameListServiceImpl service, GameServiceImpl gameService){
        this.service = service;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
     return service.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }


}
