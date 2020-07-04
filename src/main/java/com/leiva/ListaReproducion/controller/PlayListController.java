package com.leiva.ListaReproducion.controller;

import com.leiva.ListaReproducion.Configuration.PlayListConfiguration;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import com.leiva.ListaReproducion.model.DTO.RequestDTO;
import com.leiva.ListaReproducion.service.PlayListResource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/lists")
public class PlayListController {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PlayListConfiguration.class);
    PlayListResource playListResource = context.getBean("playListResourceFile", PlayListResource.class);

    @PostMapping
    public ResponseEntity<PlayListResponseDTO> addList(@RequestBody RequestDTO requestDTO) {
        PlayListResponseDTO playListResponseDTO = playListResource.addList(requestDTO);
        return ResponseEntity.ok(playListResponseDTO);
    }
/*
    @GetMapping
    public ResponseEntity<List<String>> getPlayList() {
        List<String> playListsNames = playListResource.getNameLists();
        return ResponseEntity.ok(playListsNames);
    }

    @GetMapping(value = "/{listName}")
    public ResponseEntity<String> getDescriptionByName(@PathVariable("listName") String nameList) {
        return ResponseEntity.ok(playListResource.getDescriptionByName(nameList));
    }

    @PutMapping(value = "/{listName}")
    public ResponseEntity<PlayListResponseDTO> putNewContentToList(@RequestBody RequestDTO requestDTO, @PathVariable("listName") String nameList) {
        return ResponseEntity.ok(playListResource.putNewContentOnList(requestDTO, nameList));
    }

    @DeleteMapping(value = "/{listName}")
    public ResponseEntity<String> putNewContentToList(@PathVariable("listName") String nameList) {
        return ResponseEntity.ok(playListResource.deleteFromRow(nameList));
    }*/





}
