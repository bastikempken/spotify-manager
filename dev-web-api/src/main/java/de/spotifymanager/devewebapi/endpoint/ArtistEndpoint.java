package de.spotifymanager.devewebapi.endpoint;

import de.spotifymanager.devewebapi.connect.Connector;
import de.spotifymanager.devewebapi.endpoint.to.AlbumTO;
import de.spotifymanager.devewebapi.endpoint.to.ArtistTO;
import de.spotifymanager.devewebapi.endpoint.to.TrackTO;
import de.spotifymanager.devewebapi.mapping.AlbumMapper;
import de.spotifymanager.devewebapi.mapping.ArtistMapper;

import java.util.List;

public class ArtistEndpoint {

    private Connector connector;

    private ArtistMapper artistMapper;

    private AlbumMapper albumMapper;

    public ArtistEndpoint(Connector connector) {
        this.connector = connector;
    }

    public ArtistTO getAnArtist(final String url){
        final var respone = connector.connect(url);
        return artistMapper.mapToArtist(respone);
    }

    public List<AlbumTO> getAnArtistsAlbums(final String url){
        final var respone = connector.connect(url);
        return albumMapper.mapToAlbums(respone);
    }

    public List<TrackTO> getAnArtistsTopTracks(){
        throw new UnsupportedOperationException();
    }


    public List<AlbumTO> getAnArtistsRelatedArtist(){
        throw new UnsupportedOperationException();
    }

    public List<AlbumTO> getASeveralArtists(){
        throw new UnsupportedOperationException();
    }

    public void setArtistMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }

    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }
}
