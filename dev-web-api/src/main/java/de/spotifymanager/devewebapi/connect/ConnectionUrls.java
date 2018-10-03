package de.spotifymanager.devewebapi.connect;

public enum ConnectionUrls {

    BASE_URL("https://api.spotify.com/v1/"),

    GET_AN_ARTIST("artists/%s"),

    GET_AN_ARTIST_ALBUMS("artists/%s/albums"),

    GET_AN_ARTIST_TOP_TRACKS("artists/%s/top-tracks"),

    GET_AN_RELEATED_ARTIST("artists/%s/related-artists"),

    GET_SEVERAL_ARTIST("artists");

    private final String url;

    ConnectionUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return BASE_URL.url + url;
    }
}
