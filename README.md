# Cine Java API

API REST de películas creada con **Java y Spring Boot**.


El objetivo es aprender, paso a paso, cómo construir un backend: recibir peticiones HTTP, aplicar una estructura por capas y guardar datos en PostgreSQL.

> Estado actual: en desarrollo. Por ahora permite consultar el catálogo de películas.

## Tecnologías

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Docker Compose
- MapStruct
- LangChain4j
- OpenAPI / Swagger UI
- Gradle

## Qué hace actualmente

- Lista todas las películas.
- Busca una película por su ID.
- Crea películas nuevas.
- Actualiza título, fecha de lanzamiento y calificación.
- Elimina películas.
- Valida datos de entrada.
- Devuelve errores controlados para películas inexistentes, duplicadas o datos inválidos.
- Genera saludos y recomendaciones mediante IA.
- Guarda las películas en PostgreSQL.
- Carga películas de prueba al iniciar la aplicación.
- Separa el código en capas: web, dominio y persistencia.

## Endpoints disponibles

Con el perfil de desarrollo activo, la aplicación se ejecuta en el puerto `8090` y usa el prefijo `/cine-java/api`.

| Método | Ruta | Descripción |
| --- | --- | --- |
| `GET` | `/cine-java/api/movies` | Devuelve todas las películas. |
| `GET` | `/cine-java/api/movies/{id}` | Devuelve una película por su ID. |
| `POST` | `/cine-java/api/movies` | Crea una película. |
| `PUT` | `/cine-java/api/movies/{id}` | Actualiza una película. |
| `DELETE` | `/cine-java/api/movies/{id}` | Elimina una película. |
| `POST` | `/cine-java/api/movies/suggest` | Genera recomendaciones mediante IA. |
| `GET` | `/cine-java/api/hello` | Genera un saludo mediante IA. |

## Documentación interactiva

Con la aplicación iniciada, Swagger UI está disponible en:

```text
http://localhost:8090/cine-java/api/swagger-ui/index.html
```

La especificación OpenAPI en formato JSON está disponible en:

```text
http://localhost:8090/cine-java/api/v3/api-docs
```

## Estructura del proyecto

```text
src/main/java/com/cine_java/
├── web/controller/        # Recibe las peticiones HTTP
├── domain/
│   ├── dto/               # Datos que la API devuelve al cliente
│   ├── repository/        # Contratos que necesita el dominio
│   └── service/           # Lógica y coordinación de la aplicación
└── persistance/           # Conexión con PostgreSQL y mapeos de datos
    ├── crud/
    ├── entity/
    └── mapper/
```

Flujo de una consulta de películas:

```text
Cliente -> MovieController -> MovieService -> MovieRepository
        -> MovieEntityRepository -> PostgreSQL
```

## Ejecutar el proyecto localmente

### Requisitos

- Java 21
- Docker Desktop abierto

### Pasos

1. Clonar el repositorio.
2. Abrir Docker Desktop.
3. Ejecutar la aplicación desde IntelliJ o con:

```powershell
.\gradlew.bat bootRun
```

Spring Boot detecta `docker-compose.yaml` y utiliza PostgreSQL con la configuración del perfil `dev`.

Luego se puede probar el endpoint en el navegador, Postman o Insomnia:

```text
http://localhost:8090/cine-java/api/movies
```
