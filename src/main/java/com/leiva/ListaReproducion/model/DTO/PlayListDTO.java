package com.leiva.ListaReproducion.model.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PlayListDTO implements Serializable{
    private String name;
    private String description;
    @ JsonProperty("Songs")
    private List<SongDTO> songDTO;
}
