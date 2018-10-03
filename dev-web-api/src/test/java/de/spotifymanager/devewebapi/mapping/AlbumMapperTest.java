package de.spotifymanager.devewebapi.mapping;

import de.spotifymanager.devewebapi.endpoint.to.enums.AlbumType;
import de.spotifymanager.devewebapi.endpoint.to.enums.ReleaseDatePrecision;
import de.spotifymanager.devewebapi.endpoint.to.enums.Type;
import de.spotifymanager.devewebapi.endpoint.to.AlbumTO;
import de.spotifymanager.devewebapi.endpoint.to.nested.AlbumArtistTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class AlbumMapperTest {

    private static List<AlbumTO> albumTOs;

    @BeforeAll
    static void setUp() throws Exception {
        final var unitToTest = new AlbumMapper();
        final var url = AlbumMapperTest.class.getResource("/AlbumsOfArtistJson.json");
        final var inputJson = Files.readAllLines(Paths.get(url.toURI()))
                        .stream()
                        .collect(Collectors.joining());
        albumTOs = unitToTest.mapToAlbums(inputJson);
    }

    @ParameterizedTest
    @MethodSource("paramsMapToAlbum")
    void mapToAlbum(int index,String group,String externalUrl,AlbumType albumType,String href
            ,String id,String name,String releaseDate,ReleaseDatePrecision releaseDatePrecision,
    Type type, int totalTrack,String uri) {
            final var albumTO = albumTOs.get(index);
            assertAll(
                    () -> assertEquals(group, albumTO.getGroup()),
                    () -> assertEquals(externalUrl,albumTO.getExternalUrlTO().getSpotify()),
                    () -> assertEquals(albumType, albumTO.getAlbumType()),
                    () -> assertEquals(href,albumTO.getHref()),
                    () -> assertEquals(id,albumTO.getId()),
                    () -> assertEquals(name,albumTO.getName()),
                    () -> assertEquals(releaseDate,albumTO.getReleaseDate()),
                    () -> assertEquals(releaseDatePrecision,albumTO.getReleaseDatePrecision()),
                    () -> assertEquals(type,albumTO.getType()),
                    () -> assertEquals(totalTrack,albumTO.getTotalTracks()),
                    () -> assertEquals(uri,albumTO.getUri())
            );
    }

    private static Stream<Arguments> paramsMapToAlbum(){
        return Stream.of(
                Arguments.of(0
                        ,"album"
                        ,"https://open.spotify.com/album/3pLdWdkj83EYfDN6H2N8MR"
                        , AlbumType.ALBUM
                        ,"https://api.spotify.com/v1/albums/3pLdWdkj83EYfDN6H2N8MR"
                        ,"3pLdWdkj83EYfDN6H2N8MR"
                        ,"Black Panther The Album Music From And Inspired By"
                        ,"2018-02-09"
                        ,ReleaseDatePrecision.DAY
                        ,Type.ALBUM
                        ,14
                        ,"spotify:album:3pLdWdkj83EYfDN6H2N8MR"
                )
        );
    }


    @ParameterizedTest
    @MethodSource("paramsMapToArtist")
    void mapToArtist(int index,int artistIndex, String externalUrl,String href,String id,String name,String type,String uri) {
        List<AlbumArtistTO> artistsTOs = albumTOs.get(index).getArtists();
        assertAll(
                () -> assertEquals(externalUrl, artistsTOs.get(artistIndex).getExternalUrlTO().getSpotify()),
                () -> assertEquals(href, artistsTOs.get(artistIndex).getHref()),
                () -> assertEquals(id, artistsTOs.get(artistIndex).getId()),
                () -> assertEquals(name, artistsTOs.get(artistIndex).getName()),
                () -> assertEquals(type, artistsTOs.get(artistIndex).getType()),
                () -> assertEquals(uri, artistsTOs.get(artistIndex).getUri())

        );
    }

    private static Stream<Arguments> paramsMapToArtist(){
        return Stream.of(
                Arguments.of(
                        0,0
                        ,"https://open.spotify.com/artist/2YZyLoL8N0Wb9xBt1NhZWg"
                        ,"https://api.spotify.com/v1/artists/2YZyLoL8N0Wb9xBt1NhZWg"
                        ,"2YZyLoL8N0Wb9xBt1NhZWg"
                        ,"Kendrick Lamar"
                        ,"artist"
                        ,"spotify:artist:2YZyLoL8N0Wb9xBt1NhZWg"),
                Arguments.of(
                        0,1
                        ,"https://open.spotify.com/artist/1Xyo4u8uXC1ZmMpatF05PJ"
                        ,"https://api.spotify.com/v1/artists/1Xyo4u8uXC1ZmMpatF05PJ"
                        ,"1Xyo4u8uXC1ZmMpatF05PJ"
                        ,"The Weeknd"
                        ,"artist"
                        ,"spotify:artist:1Xyo4u8uXC1ZmMpatF05PJ"),
                Arguments.of(
                        0,2
                        ,"https://open.spotify.com/artist/7tYKF4w9nC0nq9CsPZTHyP"
                        ,"https://api.spotify.com/v1/artists/7tYKF4w9nC0nq9CsPZTHyP"
                        ,"7tYKF4w9nC0nq9CsPZTHyP"
                        ,"SZA"
                        ,"artist"
                        ,"spotify:artist:7tYKF4w9nC0nq9CsPZTHyP")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsMapToAvailableMarkets")
    void mapToAvailableMarkets(int index,List<String> markets) {
        final var albumTO = albumTOs.get(index);
        assertIterableEquals(markets,albumTO.getAvailableMarkets());
    }

    private static Stream<Arguments> paramsMapToAvailableMarkets(){
        return Stream.of(
                Arguments.of(0,
                        Arrays.asList(
                                "AD","AR","AT", "AU", "BE",
                                "BG", "BO", "BR", "CA", "CH",
                                "CL", "CO", "CR", "CY", "CZ",
                                "DE", "DK", "DO", "EC", "EE",
                                "ES", "FI", "FR", "GB", "GR",
                                "GT", "HK", "HN", "HU", "ID",
                                "IE", "IL", "IS", "IT", "JP",
                                "LI", "LT", "LU", "LV", "MC",
                                "MT", "MX", "MY", "NI", "NL",
                                "NO", "NZ", "PA", "PE", "PH",
                                "PL", "PT", "PY", "RO", "SE",
                                "SG", "SK", "SV", "TH", "TR",
                                "TW", "US", "UY", "VN", "ZA")
                ));
    }


    @ParameterizedTest
    @MethodSource("paramsMapToImageTO")
    void mapToImageTO(int index,int imageIndex,int laengeBreite,String url) {
        final var albumTO = albumTOs.get(index);
        final var imageTO = albumTO.getImages().get(imageIndex);
        assertAll(
                () -> assertEquals(laengeBreite,imageTO.getHeight()),
                () -> assertEquals(laengeBreite,imageTO.getWidth()),
                () -> assertEquals(url,imageTO.getUrl())
        );
    }


    private static Stream<Arguments> paramsMapToImageTO(){
        return Stream.of(
                Arguments.of(0,0,640
                        ,"https://i.scdn.co/image/2bd50294b0b2874d3182fa31a6fb825784e6e395"),
                Arguments.of(0,1,300
                        ,"https://i.scdn.co/image/844da52d9871ec8fe044eba0746be7717bba838c"),
                Arguments.of(0,2,64
                        ,"https://i.scdn.co/image/133d420e24b7236301a968a0011c5fbc3d2365e3")
        );
    }

    @Test
    void mapAllAlbums(){
        assertEquals(20,albumTOs.size());
    }
}