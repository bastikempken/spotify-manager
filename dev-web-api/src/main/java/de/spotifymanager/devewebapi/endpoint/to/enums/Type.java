package de.spotifymanager.devewebapi.endpoint.to.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Type {

    ALBUM("album");

    private final String value;

    private Type(String value) {
        this.value = value;
    }

    private static final Map<String, Type> MAPPING;
    static {
        MAPPING = Stream.of(Type.values())
                .collect(Collectors.toMap(Type::getValue, Function.identity()));
    }

    public String getValue() {
        return value;
    }

    public static final Type parseValue(String value){
        return MAPPING.get(value);
    }
}
