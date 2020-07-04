package com.leiva.ListaReproducion.Configuration;

import com.leiva.ListaReproducion.model.DAO.PlayListDAO;
import com.leiva.ListaReproducion.repository.MapToFilePlayList;
import com.leiva.ListaReproducion.repository.PlayListRepository;
import com.leiva.ListaReproducion.service.PlayListResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayListConfiguration {

    @Bean
    public PlayListRepository mapToMysqlPlayList(){
        return new PlayListDAO();
    }
    @Bean
    public PlayListRepository mapToFilePlayList(){
        return new MapToFilePlayList();
    }
    @Bean
    public PlayListResource playListResourceSql(){
        return new PlayListResource(mapToMysqlPlayList());
    }
    @Bean
    public PlayListResource playListResourceFile(){
        return new PlayListResource(mapToFilePlayList());
    }


}
