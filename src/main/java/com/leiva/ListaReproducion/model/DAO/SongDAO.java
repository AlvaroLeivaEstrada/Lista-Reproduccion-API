package com.leiva.ListaReproducion.model.DAO;

import com.leiva.ListaReproducion.model.DTO.SongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class SongDAO {


    private static int idPlayList=0;

    public void save(Connection conn, List<SongDTO> songList) throws SQLException {
        String SQL_InsertSONG = "INSERT INTO Song(PlayListId,Title,Artist,Album,Year) VALUES(?,?,?,?,?)";

        try (
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_InsertSONG);) {

            for (int i = 0; i < songList.size(); i++) {

                preparedStatement.setInt(1, idPlayList);
                preparedStatement.setString(2, songList.get(i).getTitle());
                preparedStatement.setString(3, songList.get(i).getArtist());
                preparedStatement.setString(4, songList.get(i).getAlbum());
                preparedStatement.setString(5, songList.get(i).getYear());

                preparedStatement.executeUpdate();
                idPlayList++;

            }


        }
    }


}
