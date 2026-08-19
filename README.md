# Cine Java API

API REST para administrar un catálogo de películas, desarrollada con Java y Spring Boot.

El proyecto aplica una arquitectura por capas, persiste los datos en PostgreSQL y documenta sus endpoints con OpenAPI/Swagger. Está desplegado en Render.

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

## Funcionalidades

- Consultar el catálogo completo de películas.
- Consultar una película por su identificador.
- Crear, actualizar y eliminar películas.
- Validar datos recibidos por la API.
- Informar errores de película inexistente, duplicada o datos inválidos.
- Persistir información en PostgreSQL.
- Cargar un catálogo inicial al iniciar la aplicación.
- Generar saludos y sugerencias de películas mediante IA.

## Endpoints

La URL base es `http://localhost:8090/cine-java/api`.

| Método | Ruta | Descripción |
| --- | --- | --- |
| `GET` | `/movies` | Lista todas las películas. |
| `GET` | `/movies/{id}` | Busca una película por su ID. |
| `POST` | `/movies` | Crea una película. |
| `PUT` | `/movies/{id}` | Actualiza título, fecha de estreno y calificación. |
| `DELETE` | `/movies/{id}` | Elimina una película. |
| `POST` | `/movies/suggest` | Genera una sugerencia según preferencias del usuario. |
| `GET` | `/hello` | Genera un saludo para la plataforma. |

### Ejemplo: crear una película

```json
{
  "title": "Blade Runner 2049",
  "duration": 164,
  "genre": "SCI_FI",
  "releaseDate": "2017-10-06",
  "rating": 8.0
}
```

Los campos `id` y `state` los administra la API.

### Ejemplo: actualizar una película

```json
{
  "title": "Blade Runner 2049",
  "releaseDate": "2017-10-06",
  "rating": 8.2
}
```

Géneros disponibles: `ACTION`, `EPIC`, `ADVENTURE`, `DRAMA` y `SCI_FI`.

## Documentación interactiva

Con la aplicación iniciada, Swagger UI está disponible en:

```text
http://localhost:8090/cine-java/api/swagger-ui/index.html
```

La especificación OpenAPI en JSON está disponible en:

```text
http://localhost:8090/cine-java/api/v3/api-docs
```

## Arquitectura

```text
Cliente
  -> MovieController
  -> MovieService
  -> MovieRepository
  -> MovieEntityRepository
  -> PostgreSQL
```

```text
src/main/java/com/cine_java/
├── web/                 # Controladores HTTP y manejo de errores
├── domain/              # DTOs, servicios, reglas y contratos
└── persistance/         # Entidades, repositorios CRUD y mapeadores
```

## Ejecutar localmente

### Requisitos

- Java 21
- Docker Desktop en ejecución

### Pasos

1. Clonar el repositorio.
2. Abrir Docker Desktop.
3. Ejecutar la aplicación desde IntelliJ o con:

```powershell
.\gradlew.bat bootRun
```

Spring Boot utiliza el perfil `dev`, detecta `docker-compose.yaml` y levanta PostgreSQL para el entorno local.

Podés verificar la API en:

```text
http://localhost:8090/cine-java/api/movies
```

## Despliegue

La aplicación se empaqueta en un contenedor Docker y se ejecuta con el perfil `prod` en Render. La conexión a PostgreSQL se configura mediante estas variables de entorno:

```text
DATABASE_HOST
DATABASE_PORT
DATABASE_NAME
DATABASE_USERNAME
DATABASE_PASSWORD
```

Para usar los endpoints de IA en un entorno real, configurá una clave válida del proveedor de IA en lugar del valor de demostración.

## Empaquetar la aplicación

Para generar el JAR de producción:

```powershell
.\gradlew.bat bootJar
```

El archivo generado queda en `build/libs/`.
