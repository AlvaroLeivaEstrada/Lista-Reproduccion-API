package com.leiva.ListaReproducion.service;

import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import com.leiva.ListaReproducion.model.DTO.RequestDTO;
import com.leiva.ListaReproducion.repository.PlayListRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class PlayListResource {
    private PlayListRepository playListRepository;

    public PlayListResource(PlayListRepository playListRepository){
        this.playListRepository = playListRepository;
    }

    public PlayListResponseDTO addList(RequestDTO requestDTO){
        PlayListResponseDTO playListResponseDTO = new PlayListResponseDTO();
        playListResponseDTO.setPlayListDTO(requestDTO.getPlayListDTO());
        playListResponseDTO.setMessage("201 Created");
        playListRepository.save(requestDTO.getPlayListDTO());
        return playListResponseDTO;

    }
    public List<String> getNameLists(){
        List<String> playList = playListRepository.getNameLists();
        return playList;
    }

    public String getDescriptionByName(String nameList){
        return playListRepository.getDescriptionByName(nameList);
    }

    public PlayListResponseDTO putNewContentOnList(RequestDTO requestDTO,String nameList){
       return playListRepository.putNewContentOnTheList(requestDTO.getPlayListDTO(),nameList);
    }
    public String deleteFromRow(String nameList){
        return playListRepository.deleteRow(nameList);
    }

}
