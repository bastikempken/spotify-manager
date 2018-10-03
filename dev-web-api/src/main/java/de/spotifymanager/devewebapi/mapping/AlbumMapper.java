package de.spotifymanager.devewebapi.mapping;

import de.spotifymanager.devewebapi.endpoint.to.enums.ReleaseDatePrecision;
import de.spotifymanager.devewebapi.endpoint.to.enums.Type;
import de.spotifymanager.devewebapi.endpoint.to.enums.AlbumType;
import de.spotifymanager.devewebapi.endpoint.to.AlbumTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.AlbumArtistTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ExternalUrlTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.ImageTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlbumMapper {

    public List<AlbumTO> mapToAlbums(String rawResponse){
        final var response = new JSONObject(rawResponse);
        JSONArray items =
                response.getJSONArray("items");
        return IntStream.range(0,items.length())
                .mapToObj(index -> mapToAlbumArtists((JSONObject) items.get(index)))
                .collect(Collectors.toList());
    }

    public AlbumTO mapToAlbumArtists(JSONObject album) {
        final var albumTO = new AlbumTO();
        albumTO.setGroup(album.getString("album_group"));
        albumTO.setAlbumType(AlbumType.parseValue(album.getString("album_type")));

        final var artists =  album.getJSONArray("artists");
        List<AlbumArtistTO> albumArtistTOs = IntStream.range(0, artists.length())
                .mapToObj(index -> mapToAlbumArtist(((JSONObject) artists.get(index))))
                .collect(Collectors.toList());
        albumTO.setArtists(albumArtistTOs);

        final var markets = album.getJSONArray("available_markets");
        albumTO.setAvailableMarkets(IntStream.range(0, markets.length())
                .mapToObj(i -> (String) markets.get(i))
                .collect(Collectors.toList()));

        albumTO.setExternalUrlTO(mappeExternalUrlTO(album.getJSONObject("external_urls")));
        albumTO.setHref(album.getString("href"));
        albumTO.setId(album.getString("id"));

        final var images = album.getJSONArray("images");
        albumTO.setImages(IntStream.range(0, images.length())
                .mapToObj(i -> mapToImages((JSONObject) images.get(i)))
                .collect(Collectors.toList()));

        albumTO.setName(album.getString("name"));
        albumTO.setReleaseDatePrecision(ReleaseDatePrecision.parseValue(album.getString("release_date_precision")));
        albumTO.setReleaseDate(album.getString("release_date"));
        albumTO.setTotalTracks(album.getInt("total_tracks"));
        albumTO.setType(Type.parseValue(album.getString("type")));
        albumTO.setUri(album.getString("uri"));

        return albumTO;
    }

    private ImageTO mapToImages(JSONObject image) {
        final var imageTO = new ImageTO();
        imageTO.setHeight(image.getInt("height"));
        imageTO.setUrl(image.getString("url"));
        imageTO.setWidth(image.getInt("width"));
        return imageTO;
    }

    private AlbumArtistTO mapToAlbumArtist(JSONObject artist) {
        final var albumArtistTO = new AlbumArtistTO();
        albumArtistTO.setHref(artist.getString("href"));
        albumArtistTO.setId(artist.getString("id"));
        albumArtistTO.setName(artist.getString("name"));
        albumArtistTO.setType(artist.getString("type"));
        albumArtistTO.setUri(artist.getString("uri"));
        albumArtistTO.setExternalUrlTO(mappeExternalUrlTO(artist.getJSONObject("external_urls")));
        return albumArtistTO;
    }

    private ExternalUrlTO mappeExternalUrlTO(JSONObject jsonObject){
        final var externalUrlTO = new ExternalUrlTO();
        externalUrlTO.setSpotify(jsonObject.getString("spotify"));
        return externalUrlTO;
    }


}
