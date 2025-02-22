package mz.co.nanotech.dslist.services.Impl;

import mz.co.nanotech.dslist.dto.GameListDTO;
import mz.co.nanotech.dslist.repositories.GameListRepository;
import mz.co.nanotech.dslist.services.GameListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListServiceImpl implements GameListService {

    private final GameListRepository repository;

    public GameListServiceImpl(GameListRepository repository){
        this.repository = repository;
    }

      @Transactional(readOnly = true)
      @Override
      public List<GameListDTO> findAll() {
       var result = repository.findAll();

       return result.stream().map(GameListDTO::new).collect(Collectors.toList());
      }



}
