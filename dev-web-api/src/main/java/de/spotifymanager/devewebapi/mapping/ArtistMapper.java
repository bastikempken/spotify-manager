package de.spotifymanager.devewebapi.mapping;

import de.spotifymanager.devewebapi.endpoint.to.ArtistTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ExternalUrlTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.FollowersTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ImageTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArtistMapper {
    public ArtistTO mapToArtist(String rawResponse) {
        final var artistTO = new ArtistTO();
        final var artist = new JSONObject(rawResponse);
        mapExternalUrl(artist.getJSONObject("external_urls"),artistTO.getExternalUrlTO());


        artistTO.setName(artist.getString("name"));
        artistTO.setPopularity(artist.getInt("popularity"));
        artistTO.setType(artist.getString("type"));
        artistTO.setUri(artist.getString("uri"));
        artistTO.setId(artist.getString("id"));
        artistTO.setHref(artist.getString("href"));

        final var genres = artist.getJSONArray("genres");
        final var collect = IntStream.range(0, genres.length())
                .mapToObj(i -> (String) genres.get(i))
                .collect(Collectors.toList());
        artistTO.setGenres(collect);

        artistTO.setFollowers(mapFollowers(artist.getJSONObject("followers")));

        artistTO.setImages(mapListImages(artist.getJSONArray("images")));


        return artistTO;
    }

    private static FollowersTO mapFollowers(JSONObject followers){
        var followersTO = new FollowersTO();
        var href = followers.get("href");
        followersTO.setHref("href" != null ? href.toString() : "");
        followersTO.setTotal(followers.getBigDecimal("total"));
        return followersTO;
    }

    private static void mapExternalUrl(JSONObject externalUrls, ExternalUrlTO externalUrlTO) {
        externalUrlTO.setSpotify(externalUrls.getString("spotify"));
    }

    private static List<ImageTO> mapListImages(JSONArray images) {
        return IntStream.range(0,images.length())
                .mapToObj(i -> mapImages((JSONObject) images.get(i)))
                .collect(Collectors.toList());
    }

    private static ImageTO mapImages(JSONObject image) {
        final var imageTO = new ImageTO();
        imageTO.setHeight(image.getInt("height"));
        imageTO.setWidth(image.getInt("width"));
        imageTO.setUrl(image.getString("url"));
        return imageTO;
    }
}
