package de.spotifymanager.devewebapi.endpoint.to.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AlbumType {

    ALBUM("album");

    private final String value;

    private AlbumType(String value) {
        this.value = value;
    }

    private static final Map<String,AlbumType> MAPPING;
    static {
        MAPPING = Stream.of(AlbumType.values())
                .collect(Collectors.toMap(AlbumType::getValue, Function.identity()));
    }

    public String getValue() {
        return value;
    }

    public static final AlbumType parseValue(String value){
        return MAPPING.get(value);
    }
}
