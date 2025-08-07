# ForoHub

ForoHub es una API REST desarrollada con Spring Boot que permite la gestión de un foro de discusión, donde los usuarios pueden crear, consultar, actualizar y eliminar tópicos (posts). La aplicación utiliza una base de datos MySQL para el almacenamiento de la información y cuenta con autenticación basada en JWT para proteger los endpoints sensibles.

## Características principales

- **Gestión de Tópicos:**  
  - Crear nuevos tópicos en el foro.
  - Consultar todos los tópicos paginados.
  - Consultar un tópico específico por su ID.
  - Actualizar la información de un tópico existente.
  - Eliminar tópicos (eliminación fisica).

- **Autenticación y Seguridad:**  
  - Sistema de login mediante usuario y contraseña.
  - Generación de tokens JWT para sesiones autenticadas.
  - Solo los usuarios autenticados pueden acceder a la información sensible del foro.
  - Roles y permisos gestionados con Spring Security (por defecto, los usuarios tienen rol de administrador).

- **Persistencia y Migraciones:**  
  - Integración con MySQL mediante Spring Data JPA.
  - Migraciones automáticas de la base de datos usando Flyway.

## Endpoints principales

- `POST /login`  
  Autenticación de usuarios. Devuelve un token JWT necesario para acceder a los endpoints protegidos.

- `POST /foro`  
  Crear un nuevo tópico. Requiere autenticación.

- `GET /foro`  
  Listar todos los tópicos paginados. Requiere autenticación.

- `GET /foro/{id}`  
  Consultar un tópico específico por ID. Requiere autenticación.

- `PUT /foro/{id}`  
  Actualizar un tópico existente. Requiere autenticación.

- `DELETE /foro/{id}`  
  Eliminar un tópico. Solo accesible para usuarios con rol ADMIN.

## Requisitos

- Java 21
- MySQL
- Maven

## Configuración

Configura las variables de entorno para la conexión a la base de datos y el secreto JWT en [`src/main/resources/application.properties`](src/main/resources/application.properties):

```properties
spring.datasource.url=jdbc:mysql://${DB_HOST}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
api.security.token.secret=${JWT_SECRET : 123456}
```
## Seguridad

- Es obligatorio iniciar sesión para obtener un token JWT.
- Sin autenticación, no se puede acceder a la información sensible del foro.
