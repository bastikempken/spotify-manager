package de.spotifymanager.devewebapi.configuration;

import de.spotifymanager.devewebapi.connect.Connector;
import de.spotifymanager.devewebapi.endpoint.ArtistEndpoint;
import de.spotifymanager.devewebapi.mapping.AlbumMapper;
import de.spotifymanager.devewebapi.mapping.ArtistMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevWebApiConfiguration {

    @Bean
    public Connector connector(){
        return new Connector();
    }

    @Bean
    public ArtistEndpoint artistEndpoint(){
        ArtistEndpoint artistEndpoint = new ArtistEndpoint(connector());
        artistEndpoint.setAlbumMapper(albumMapper());
        artistEndpoint.setArtistMapper(artistMapper());
        return artistEndpoint;
    }

    @Bean
    public AlbumMapper albumMapper(){
        return new AlbumMapper();
    }

    @Bean
    public ArtistMapper artistMapper(){
        return new ArtistMapper();
    }
}
