package mz.co.nanotech.dslist.controllers;


import mz.co.nanotech.dslist.dto.GameListDTO;
import mz.co.nanotech.dslist.services.GameListService;
import mz.co.nanotech.dslist.services.Impl.GameListServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService service;

    public GameListController(GameListServiceImpl service){
        this.service = service;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
     return service.findAll();
    }


}
