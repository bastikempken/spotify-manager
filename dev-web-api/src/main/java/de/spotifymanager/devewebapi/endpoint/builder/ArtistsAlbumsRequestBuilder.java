package de.spotifymanager.devewebapi.endpoint.builder;

import de.spotifymanager.devewebapi.connect.ConnectionUrls;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistsAlbumsRequestBuilder {

    private ArtistsAlbumsRequestTO to;

    private ArtistsAlbumsRequestBuilder(String id) {
        this.to = new ArtistsAlbumsRequestTO(id);
    }

    public static ArtistsAlbumsRequestBuilder id(String id){
        return new ArtistsAlbumsRequestBuilder(id);

    }

    public ArtistsAlbumsRequestBuilder single(){
        to.getIncludeGroups().add("single");
        return this;
    }

    public ArtistsAlbumsRequestBuilder album(){
        to.getIncludeGroups().add("album");
        return this;
    }

    public ArtistsAlbumsRequestBuilder appearsOn(){
        to.getIncludeGroups().add("appears_on");
        return this;
    }

    public ArtistsAlbumsRequestBuilder compilation(){
        to.getIncludeGroups().add("compilation");
        return this;
    }


    public ArtistsAlbumsRequestBuilder forMarket(String market){
        to.setMarket(market);
        return this;
    }


    public ArtistsAlbumsRequestBuilder limit(String limit){
        to.setLimit(limit);
        return this;
    }

    public ArtistsAlbumsRequestBuilder offset(String offset){
        to.setOffset(offset);
        return this;
    }

    public String build(){
       List<String> params = new ArrayList<>();
        if(to.getIncludeGroups().size() > 0){
            var groups = to.getIncludeGroups()
                    .stream()
                    .collect(Collectors.joining(","));
            params.add("include_groups="+groups);
        }
        if(to.getMarket() != null){
            params.add("markte="+to.getMarket());

        }
        if(to.getLimit() != null){
            params.add("limit="+to.getLimit());
        }
        if(to.getOffset() != null){
            params.add("offset="+to.getOffset());
        }
        var baseUrl = String.format(ConnectionUrls.GET_AN_ARTIST_ALBUMS.getUrl(),to.getId());

        if(params.size() > 0){
            baseUrl+= "?" + params
                              .stream()
                              .collect(Collectors.joining("&"));
        }
        return baseUrl;
    }


    private class ArtistsAlbumsRequestTO {

        private final String id;

        private List<String> includeGroups;

        private String market;

        private String limit;

        private String offset;

        public ArtistsAlbumsRequestTO(String id) {
            this.id = id;
            includeGroups = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public List<String> getIncludeGroups() {
            return includeGroups;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getOffset() {
            return offset;
        }

        public void setOffset(String offset) {
            this.offset = offset;
        }
    }
}
