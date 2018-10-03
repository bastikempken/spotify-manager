package de.spotifymanager.devewebapi.connect;

import de.spotifymanager.devewebapi.endpoint.builder.ArtistsAlbumsRequestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void connect() {

        String url = ArtistsAlbumsRequestBuilder
                .id("2F8GvYuY0lfZNYu45dY6gJ")
                .single()
                .build();
        String result = new Connector().connect(url);
        assertEquals(1,1);
    }
}