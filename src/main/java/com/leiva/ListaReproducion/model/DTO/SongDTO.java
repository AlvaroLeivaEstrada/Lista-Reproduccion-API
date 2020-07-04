package com.leiva.ListaReproducion.model.DTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class SongDTO implements Serializable {
    private String title;
    private String artist;
    private String album;
    private String year;
}
