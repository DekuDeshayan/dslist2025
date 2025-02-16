package mz.co.nanotech.dslist.services.Impl;

import mz.co.nanotech.dslist.dto.GameMinDTO;
import mz.co.nanotech.dslist.entities.Game;
import mz.co.nanotech.dslist.repositories.GameRepository;
import mz.co.nanotech.dslist.services.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;

    public GameServiceImpl(GameRepository repository){
        this.repository = repository;
    }

    @Transactional
    @Override
    public List<GameMinDTO> findAll() {
        var result = repository.findAll();

       return result.stream().map(GameMinDTO::new).collect(Collectors.toList());
      }



}
