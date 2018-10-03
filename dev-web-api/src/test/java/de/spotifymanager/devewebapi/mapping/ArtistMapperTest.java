package de.spotifymanager.devewebapi.mapping;

import de.spotifymanager.devewebapi.endpoint.to.ArtistTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ArtistMapperTest {

    private static ArtistTO artistTO;

    @BeforeAll
    static void setUp() throws Exception {
        final var unitToTest = new ArtistMapper();
        final var url = ArtistMapperTest.class.getResource("/ArtistJson.json");
        final var inputJson = Files.readAllLines(Paths.get(url.toURI()))
                        .stream()
                        .collect(Collectors.joining());
        artistTO = unitToTest.mapToArtist(inputJson);
    }

    @Test
    void mapToArtist() {
            assertAll(
                    () -> assertEquals("Kendrick Lamar",artistTO.getName()),
                    () -> assertEquals("artist",artistTO.getType()),
                    () -> assertEquals(89,artistTO.getPopularity()),
                    () -> assertEquals("spotify:artist:2YZyLoL8N0Wb9xBt1NhZWg",artistTO.getUri()),
                    () -> assertEquals("2YZyLoL8N0Wb9xBt1NhZWg",artistTO.getId()),
                    () -> assertEquals("https://api.spotify.com/v1/artists/2YZyLoL8N0Wb9xBt1NhZWg",artistTO.getHref())
            );

    }

    @Test
    void mapToArtist_externalUrl() {
         assertEquals("https://open.spotify.com/artist/2YZyLoL8N0Wb9xBt1NhZWg",artistTO.getExternalUrlTO().getSpotify());
    }

    @Test
    void mapToArtist_artists() {
         assertAll(
                 () -> assertEquals("conscious hip hop",artistTO.getGenres().get(0)),
                 () -> assertEquals("hip hop",artistTO.getGenres().get(1)),
                 () -> assertEquals("pop rap",artistTO.getGenres().get(2)),
                 () -> assertEquals("rap",artistTO.getGenres().get(3)),
                 () -> assertEquals("west coast rap",artistTO.getGenres().get(4))
         );
    }

    @Test
    void mapToArtist_images() {
        final var imageTO = artistTO.getImages().get(0);
        final var imageTO_01 = artistTO.getImages().get(1);
        final var imageTO_02 = artistTO.getImages().get(2);
        assertAll(
                () -> assertEquals(640,imageTO.getHeight()),
                () -> assertEquals("https://i.scdn.co/image/3a836196bfb341f736c7fe2704fb75de53f8dfbb",imageTO.getUrl()),
                () -> assertEquals(640,imageTO.getWidth()),
                () -> assertEquals(320,imageTO_01.getHeight()),
                () -> assertEquals("https://i.scdn.co/image/5259c0496329b3f608a1ae0edb799cd2f8451acc",imageTO_01.getUrl()),
                () -> assertEquals(320,imageTO_01.getWidth()),
                () -> assertEquals(160,imageTO_02.getHeight()),
                () -> assertEquals("https://i.scdn.co/image/b772a78d4cb192268d6f601a78f21044c17d6dda",imageTO_02.getUrl()),
                () -> assertEquals(160,imageTO_02.getWidth())
         );
    }

    @Test
    void mapToArtist_followers() {
        final var followersTO = artistTO.getFollowers();
        assertAll(
                () -> assertEquals("",followersTO.getHref()),
                () -> assertEquals(10396548,followersTO.getTotal())
         );
    }
}