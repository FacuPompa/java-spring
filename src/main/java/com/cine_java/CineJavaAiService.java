package com.cine_java;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface CineJavaAiService {

    @UserMessage("""
            Genera un saludo de bienvenida al usuario de gestión de películas. Usá menos de 120 caracteres y hacelo de manera amigable. No uses emojis.
            """)
    String generateGreeting();
}
