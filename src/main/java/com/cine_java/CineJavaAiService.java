package com.cine_java;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface CineJavaAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de peliculas {{platform}}. Usá menos de 120 caracteres y NO USES EMOJIS.
            """)
    String generateGreeting(@V("platform") String platform);
}
