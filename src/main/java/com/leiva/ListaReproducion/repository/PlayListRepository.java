package com.leiva.ListaReproducion.repository;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;

import java.util.List;

public interface PlayListRepository {

    public String save(PlayListDTO playListDTO);
    public List<PlayListDTO> getList();
    public String modList(String listName);
    public String deleteList(String listName);
}
