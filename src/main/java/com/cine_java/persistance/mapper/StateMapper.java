package com.cine_java.persistance.mapper;

import dev.langchain4j.agent.tool.P;
import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        if (estado == null) return null;

        return switch (estado) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("stateToString")
    public static String stateToString(Boolean state) {
        if (state == null) {
            return null;
        } else if (state == true) {
            return "D";
        } else {
            return "N";
        }
    }
}
