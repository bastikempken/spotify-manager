package de.spotifymanager.devewebapi.endpoint.to;

import de.spotifymanager.devewebapi.endpoint.to.enums.ReleaseDatePrecision;
import de.spotifymanager.devewebapi.endpoint.to.enums.Type;
import de.spotifymanager.devewebapi.endpoint.to.enums.AlbumType;
import de.spotifymanager.devewebapi.endpoint.to.nested.ExternalUrlTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ImageTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.AlbumArtistTO;

import java.util.List;

public class AlbumTO {

    private String group;

    private AlbumType albumType;

    private List<AlbumArtistTO> artists;

    private List<String> availableMarkets;

    private ExternalUrlTO externalUrlTO;

    private String href;

    private String id;

    private List<ImageTO> images;

    private String name;

    private String releaseDate;

    private ReleaseDatePrecision releaseDatePrecision;

    private int totalTracks;

    private Type type;

    private String uri;


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }



    public List<AlbumArtistTO> getArtists() {
        return artists;
    }

    public void setArtists(List<AlbumArtistTO> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public ExternalUrlTO getExternalUrlTO() {
        return externalUrlTO;
    }

    public void setExternalUrlTO(ExternalUrlTO externalUrlTO) {
        this.externalUrlTO = externalUrlTO;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImageTO> getImages() {
        return images;
    }

    public void setImages(List<ImageTO> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ReleaseDatePrecision getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public void setReleaseDatePrecision(ReleaseDatePrecision releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public AlbumType getAlbumType() {
        return albumType;
    }

    public void setAlbumType(AlbumType albumType) {
        this.albumType = albumType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }
}
