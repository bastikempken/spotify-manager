package de.spotifymanager.webendpoint;

import de.spotifymanager.releasenotification.ReleaseNotificationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ReleaseNotificationConfig.class)
public class SpotifyManager {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyManager.class, args);
    }
}
