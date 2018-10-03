open module dev.web.api {

    exports de.spotifymanager.devewebapi.endpoint;
    exports de.spotifymanager.devewebapi.configuration;

    requires org.apache.commons.codec;
    requires json;
    requires commons.lang3;
    requires spring.context;

}