package com.leiva.ListaReproducion.controller;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import com.leiva.ListaReproducion.model.DTO.RequestDTO;
import com.leiva.ListaReproducion.service.PlayListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lists")
public class PlayListController {

    @Autowired
    PlayListResource playListResource;

    @PostMapping
    public ResponseEntity<PlayListResponseDTO>addList(@RequestBody RequestDTO requestDTO){
        PlayListResponseDTO playListResponseDTO = playListResource.addList(requestDTO);
        return ResponseEntity.ok(playListResponseDTO);
    }

}
