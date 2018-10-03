package de.spotifymanager.devewebapi.endpoint.to;

import de.spotifymanager.devewebapi.endpoint.to.nested.TrackAlbumTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.TrackArtistTO;

import java.util.List;

public class TrackTO {

    private List<TrackAlbumTO> trackAlbumTOs;

    private List<TrackArtistTO> trackArtistTOs;

    private int discNumber;

    private String durationInMs;

    private boolean explicit;

    private String href;

    private String id;

    private String name;

    private int popularity;

    private String previewUrl;

    private int trackNumber;

    //TODO
    private String type;

    private String uri;
}
