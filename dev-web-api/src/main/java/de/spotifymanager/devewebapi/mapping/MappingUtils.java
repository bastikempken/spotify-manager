package de.spotifymanager.devewebapi.mapping;

import de.spotifymanager.devewebapi.endpoint.to.enums.ReleaseDatePrecision;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MappingUtils {

    public static Map<ReleaseDatePrecision, Function<String,LocalDate>> PARSER;
     static {
         PARSER = new HashMap<>();
         PARSER.put(ReleaseDatePrecision.DAY,MappingUtils::yyyyddmm);
         PARSER.put(ReleaseDatePrecision.YEAR,MappingUtils::yyyy);
     }

     public static LocalDate parse(ReleaseDatePrecision releaseDatePrecision,String input){
         return PARSER.get(releaseDatePrecision).apply(input);
     }


    private static LocalDate yyyyddmm(String input){
        return LocalDate.parse(input,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    private static LocalDate yyyy(String input){
        return LocalDate.parse(input,DateTimeFormatter.ofPattern("yyyy"));
    }

}
