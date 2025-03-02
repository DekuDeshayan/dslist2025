package mz.co.nanotech.dslist.services.Impl;

import mz.co.nanotech.dslist.dto.GameListDTO;
import mz.co.nanotech.dslist.projections.GameMinProjection;
import mz.co.nanotech.dslist.repositories.GameListRepository;
import mz.co.nanotech.dslist.repositories.GameRepository;
import mz.co.nanotech.dslist.services.GameListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListServiceImpl implements GameListService {

    private final GameListRepository repository;
    private final GameRepository gameRepository;

    public GameListServiceImpl(GameListRepository repository,
                               GameRepository gameRepository){
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

      @Transactional(readOnly = true)
      @Override
      public List<GameListDTO> findAll() {
       var result = repository.findAll();

       return result.stream().map(GameListDTO::new).collect(Collectors.toList());
      }

    @Transactional
    @Override
    public void move(Long listId, int sourceIndex, int destinationIndex){

        var result = gameRepository.searchByList(listId);

        GameMinProjection obj = result.remove(sourceIndex);
        result.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <=max; i++){

            repository.updateBelongingPosition(
                    listId,
                    result.get(i).getId(),
                    i);
        }



    }




}
