package com.leiva.ListaReproducion.repository;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;

import java.util.List;

public interface PlayListRepository {

    public void save(PlayListDTO playListDTO);
    public List<String> getNameLists();
    public String getDescriptionByName(String nameList);
    public PlayListResponseDTO putNewContentOnTheList(PlayListDTO playListDTO,String nameList);
    public String deleteRow(String nameList);

}
