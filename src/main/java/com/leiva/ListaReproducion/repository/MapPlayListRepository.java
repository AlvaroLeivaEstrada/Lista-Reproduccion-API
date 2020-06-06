package com.leiva.ListaReproducion.repository;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapPlayListRepository implements PlayListRepository {


    @Override
    public String save(PlayListDTO playListDTO) {
        return null;
    }

    @Override
    public List<PlayListDTO> getList() {
        return null;
    }

    @Override
    public String modList(String listName) {
        return null;
    }

    @Override
    public String deleteList(String listName) {
        return null;
    }

}
