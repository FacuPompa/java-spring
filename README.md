# Cine Java API

<<<<<<< HEAD
API REST de películas creada con **Java y Spring Boot** como proyecto de práctica del curso de Spring.
=======
API REST de películas creada con **Java y Spring Boot** como práctica de Spring.
>>>>>>> 08ea4d2ee99402e90b5a04434a9962ba56dba1b6

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
- Gradle

## Qué hace actualmente

- Expone un endpoint para listar películas.
- Guarda las películas en PostgreSQL.
- Carga películas de prueba al iniciar la aplicación.
- Separa el código en capas: web, dominio y persistencia.
- Incluye un endpoint de saludo generado mediante LangChain4j como práctica adicional.

## Endpoint disponible

Con el perfil de desarrollo activo, la aplicación se ejecuta en el puerto `8090` y usa el prefijo `/cine-java/api`.

| Método | Ruta | Descripción |
| --- | --- | --- |
| `GET` | `/cine-java/api/movies` | Devuelve todas las películas disponibles en la base de datos. |

Ejemplo de URL:

```text
http://localhost:8090/cine-java/api/movies
```

La respuesta es una lista JSON con el título, duración, género, fecha de estreno y calificación de cada película.

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

## Próximos pasos

- [ ] Consultar una película por id.
- [ ] Crear películas con `POST`.
- [ ] Actualizar películas con `PUT` o `PATCH`.
- [ ] Eliminar películas con `DELETE`.
- [ ] Agregar validaciones y manejo de errores.
- [ ] Desplegar la API en Render.
<<<<<<< HEAD

## Nota de aprendizaje

Este repositorio registra mi avance con Spring Boot. La idea no es solo que los endpoints funcionen, sino entender gradualmente para qué sirve cada capa y cada herramienta.
=======
>>>>>>> 08ea4d2ee99402e90b5a04434a9962ba56dba1b6
