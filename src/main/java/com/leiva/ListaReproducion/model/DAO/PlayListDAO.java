package com.leiva.ListaReproducion.model.DAO;

import com.leiva.ListaReproducion.model.DAO.Convert;
import com.leiva.ListaReproducion.model.DAO.SongDAO;
import com.leiva.ListaReproducion.model.DTO.PlayListDTO;
import com.leiva.ListaReproducion.model.DTO.PlayListResponseDTO;
import com.leiva.ListaReproducion.model.DTO.RequestDTO;
import com.leiva.ListaReproducion.repository.ConnectionToBBDD;
import com.leiva.ListaReproducion.repository.PlayListRepository;

import java.sql.*;
import java.util.*;


public class PlayListDAO implements PlayListRepository {
    private static Connection conn= conn= ConnectionToBBDD.ConnectionToMysql();;
    private HashMap<String,String> descriptionByListMap = new HashMap<String, String>();
    private SongDAO songDAO = new SongDAO();



    @Override
    public void save(PlayListDTO playListDTO) {
        this.InsertRow(playListDTO);
    }

    @Override
    public List<String> getNameLists() {

        List<String> result = new ArrayList<String>();


        String sql = "select * from PlayLists";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resulSet = preparedStatement.executeQuery();

            while (resulSet.next()) {
               String name = resulSet.getString("Name");
               String description = resulSet.getString("Description");
               int nrOfSongs = resulSet.getInt("Songs");

               if(!descriptionByListMap.containsKey(name)) descriptionByListMap.put(name,description);
               result.add(name);
            }

        } catch (SQLException e) {
            System.err.format("SQL state %s\n", e.getSQLState());

        } catch (Exception e) {
            System.out.println("Table alredy exist");
        }
        return result;
    }

    @Override
    public String getDescriptionByName(String nameList) {

        String description="404 NOT FOUND";
        if(!descriptionByListMap.containsKey(nameList))return description;
        return descriptionByListMap.get(nameList);
    }

    @Override
    public PlayListResponseDTO putNewContentOnTheList(PlayListDTO playListDTO,String nameList) {

        String SQL_UPDATE = "UPDATE PlayLists SET Description=?,Songs=? Where Name=? ";
        PlayListResponseDTO playListResponseDTO=new PlayListResponseDTO();
        //String SQL_UPDATE = "UPDATE EMPLEADOS SET SALARIO=? WHERE NOMBRE=?";


        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

            preparedStatement.setString(1,playListDTO.getDescription() );
            preparedStatement.setInt(2,playListDTO.getSongDTO().size());
            preparedStatement.setString(3, nameList);


            int row = preparedStatement.executeUpdate();
            playListResponseDTO.setPlayListDTO(playListDTO);
            playListResponseDTO.setMessage("204 No Content");
            return  playListResponseDTO;


        } catch (SQLException e) {
            //System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            playListResponseDTO.setMessage("404 NOT FOUND");
            return playListResponseDTO;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playListResponseDTO;

    }
    public String deleteRow(String nameList) {

        String SQL_DELETE = "DELETE FROM PlayLists WHERE Name=?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

            preparedStatement.setString(1, nameList);
            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Row deleted!!";
    }


    private void InsertRow(PlayListDTO playListDTO)  {
        String SQL_INSERT = "INSERT INTO PlayLists(Name,Description,Songs) VALUES(?,?,?)";


        int playListSize= playListDTO.getSongDTO().size();

        try ( PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);){

            preparedStatement.setString(1, playListDTO.getName());
            preparedStatement.setString(2, playListDTO.getDescription());
            preparedStatement.setInt(3, playListSize);
            int row = preparedStatement.executeUpdate();

            songDAO.save(conn,playListDTO.getSongDTO());

            conn.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
