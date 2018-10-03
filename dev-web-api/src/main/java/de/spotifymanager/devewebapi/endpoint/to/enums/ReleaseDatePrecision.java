package de.spotifymanager.devewebapi.endpoint.to.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ReleaseDatePrecision {

    DAY("day"),

    YEAR("year");

    private final String value;

    private ReleaseDatePrecision(String value) {
        this.value = value;
    }

    private static final Map<String, ReleaseDatePrecision> MAPPING;
    static {
        MAPPING = Stream.of(ReleaseDatePrecision.values())
                .collect(Collectors.toMap(ReleaseDatePrecision::getValue, Function.identity()));
    }

    public String getValue() {
        return value;
    }

    public static final ReleaseDatePrecision parseValue(String value){
        return MAPPING.get(value);
    }
}
