package com.leiva.ListaReproducion.service;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import com.leiva.ListaReproducion.model.DTO.RequestDTO;
import com.leiva.ListaReproducion.repository.MapPlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListResource {

    @Autowired
    MapPlayListRepository  mapPlayListRepository;


    public PlayListResponseDTO addList(RequestDTO requestDTO){
        PlayListResponseDTO playListResponseDTO = new PlayListResponseDTO();
        PlayListDTO playListDTO = requestDTO.getPlayListDTO();
        playListResponseDTO.setPlayListDTO(playListDTO);
        playListResponseDTO.setMessage("201 Created");
        mapPlayListRepository.save(playListDTO);
        return playListResponseDTO;

    }
    public List<PlayListDTO> getLists(){
        return mapPlayListRepository.getList();
    }

    public PlayListDTO getListByName(RequestDTO requestDTO){

        List<PlayListDTO> playListDTOS = mapPlayListRepository.getList();

        for (PlayListDTO playListDTO : playListDTOS) {
            if (playListDTO.getName().equalsIgnoreCase(requestDTO.getPlayListDTO().getName())){
                return playListDTO;
            }
        }
        return null;
    }
    public String modList(RequestDTO requestDTO){
        List<PlayListDTO> playListDTOS = mapPlayListRepository.getList();
        for (PlayListDTO playListDTO:playListDTOS) {
           if (playListDTO.getName().equalsIgnoreCase(requestDTO.getPlayListDTO().getName())){
               return "204 No Content";
           }
        }
        return "404 NoT Found";
    }
}
