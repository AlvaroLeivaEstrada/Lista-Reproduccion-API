package com.leiva.ListaReproducion.model.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import lombok.Data;

@Data
public class RequestDTO {
    @JsonProperty("list")
    private PlayListDTO playListDTO;
}
