open module web.endpoint {

    requires spring.boot.starter.web;
    requires spring.boot.starter.tomcat;

    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;

    requires spring.beans;
    requires dev.web.api;
    requires release.notification;
}