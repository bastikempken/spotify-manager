open module release.notification {

    requires dev.web.api;


    requires spring.context;

    exports de.spotifymanager.releasenotification;

    requires spring.beans;
    requires spring.context.support;
}