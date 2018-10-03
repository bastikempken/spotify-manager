package de.spotifymanager.devewebapi.endpoint.to;

import de.spotifymanager.devewebapi.endpoint.to.nested.ExternalUrlTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.FollowersTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ImageTO;

import java.util.ArrayList;
import java.util.List;

public class ArtistTO {

    private ExternalUrlTO externalUrlTO;

    private FollowersTO followers;

    private List<String> genres;

    private String href;

    private String id;

    private List<ImageTO> images;

    private String name;

    private int popularity;

    private String type;

    private String uri;


    public ArtistTO() {
        externalUrlTO = new ExternalUrlTO();
        followers = new FollowersTO();
        genres = new ArrayList<>();
        images = new ArrayList<>();
    }

    public ExternalUrlTO getExternalUrlTO() {
        return externalUrlTO;
    }

    public void setExternalUrlTO(ExternalUrlTO externalUrlTO) {
        this.externalUrlTO = externalUrlTO;
    }

    public FollowersTO getFollowers() {
        return followers;
    }

    public void setFollowers(FollowersTO followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
