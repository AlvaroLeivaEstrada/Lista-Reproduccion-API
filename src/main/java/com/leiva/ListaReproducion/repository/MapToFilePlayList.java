package com.leiva.ListaReproducion.repository;

import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;


public class MapToFilePlayList implements PlayListRepository {

    private String playListFile = "PlayListFile.dat";
    private ObjectOutputStream objectOutputStream=null;
    private final File file = new File(playListFile);
    @Override
    public void save(PlayListDTO playListDTO) {

        try{
            if (file.exists()){
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file,true)){
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }else {
                objectOutputStream= new ObjectOutputStream(new FileOutputStream(file));
            }
            objectOutputStream.writeObject(playListDTO);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<String> getNameLists() {
        return null;
    }

    @Override
    public String getDescriptionByName(String nameList) {
        return null;
    }

    @Override
    public PlayListResponseDTO putNewContentOnTheList(PlayListDTO playListDTO,String nameList) {
        return null;
    }

    @Override
    public String deleteRow(String nameList) {
    return null;
    }
}
