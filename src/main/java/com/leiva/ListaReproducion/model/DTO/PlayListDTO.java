package com.leiva.ListaReproducion.model.DTO;
import lombok.Data;
import java.util.List;

@Data
public class PlayListDTO {
    private String name;
    private String description;
    private List<SongDTO> songDTO;
}
