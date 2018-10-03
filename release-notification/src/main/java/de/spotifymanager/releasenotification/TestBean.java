package de.spotifymanager.releasenotification;

import de.spotifymanager.devewebapi.endpoint.ArtistEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class TestBean {

    @Autowired
    private ArtistEndpoint artistEndpoint;

    @Autowired
    private JavaMailSender javaMailSender;


    public void send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("sebastiankempken@mail.de");
        message.setSubject("Test");
        message.setText("Hallo");
        javaMailSender.send(message);
    }
}
