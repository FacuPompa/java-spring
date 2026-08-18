package com.cine_java.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface CineJavaAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de peliculas {{platform}}. Usá menos de 120 caracteres y NO USES EMOJIS.
            """)
    String generateGreeting(@V("platform") String platform);

    @SystemMessage("""
            Sos un experto en cine que recomienda películas personalizadas según los gustos del usuario.
            Tenés que recomendar máximo 3 películas.
            No incluyas películas que estén por fuera de la plataforma CineJava
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}
