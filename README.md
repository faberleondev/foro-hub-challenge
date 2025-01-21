# Foro Hub

**Foro Hub** es una API REST moderna diseñada para administrar foros virtuales, facilitando la interacción entre usuarios.  
Con Foro Hub, las comunidades pueden publicar, responder, editar y gestionar contenido de manera eficiente.

El sistema está diseñado para ser seguro y escalable, con características como autenticación robusta, gestión de roles, y búsquedas personalizadas.  
Además, su arquitectura basada en **Spring Boot** lo convierte en una solución modular y fácil de integrar con otras herramientas.

---

## Tecnologías utilizadas
- **Java 17**: Lenguaje base del proyecto.
- **Spring Boot**: Framework para construir aplicaciones web robustas.
- **MySQL**: Base de datos relacional para el almacenamiento de información.

---

## Enlaces de descarga

### Requisitos principales
- **Java 17**:  
  [Descargar Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)

- **MySQL**:  
  [Descargar MySQL](https://dev.mysql.com/downloads/installer/)

### Dependencias de Maven
Aquí tienes los enlaces directos a cada una de las dependencias utilizadas en el archivo `pom.xml`:

1. **Spring Boot Starter Test**:  
   [Maven Repository - spring-boot-starter-test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)

2. **Spring Boot Starter Web**:  
   [Maven Repository - spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)

3. **Spring Boot DevTools**:  
   [Maven Repository - spring-boot-devtools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)

4. **Lombok (v1.18.36)**:  
   [Maven Repository - lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.36)

5. **Spring Boot Starter Data JPA**:  
   [Maven Repository - spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)

6. **Flyway Core**:  
   [Maven Repository - flyway-core](https://mvnrepository.com/artifact/org.flywaydb/flyway-core)

7. **Flyway MySQL**:  
   [Maven Repository - flyway-mysql](https://mvnrepository.com/artifact/org.flywaydb/flyway-mysql)

8. **MySQL Connector J**:  
   [Maven Repository - mysql-connector-j](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)

9. **Spring Boot Starter Validation**:  
   [Maven Repository - spring-boot-starter-validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)

10. **Spring Boot Starter Security**:  
    [Maven Repository - spring-boot-starter-security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)

11. **Java JWT (v4.2.0)**:  
    [Maven Repository - java-jwt](https://mvnrepository.com/artifact/com.auth0/java-jwt/4.2.0)

12. **SpringDoc OpenAPI Starter WebMVC UI (v2.7.0)**:  
    [Maven Repository - springdoc-openapi-starter-webmvc-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui/2.7.0)

13. **Spring Security Test (v6.4.1)**:  
    [Maven Repository - spring-security-test](https://mvnrepository.com/artifact/org.springframework.security/spring-security-test/6.4.1)

Las dependencias del archivo pom.xml debería de quedarte asi:

```bash
</dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.36</version>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-mysql</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>4.2.0</version>
		</dependency>

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.7.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<version>6.4.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```


---

## Instrucciones de instalación

1. **Instalar Java y MySQL**:
    - Asegúrate de tener **Java 17** y **MySQL** instalados y configurados.
    - Configura un usuario y una base de datos para el proyecto.

2. **Configurar Maven**:
    - Descarga e incluye las dependencias mencionadas en tu archivo `pom.xml`.

3. **Configurar la base de datos**:
    - Edita el archivo `application.properties` para configurar la conexión con tu base de datos:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```

4. **Ejecutar la aplicación**:
    - Desde la línea de comandos:
      ```bash
      mvn spring-boot:run
      ```
    - O desde tu IDE favorito.

5. **Acceso a la API**:
    - Documentación interactiva disponible en Swagger.

---

## Licencia
Este proyecto está licenciado bajo la licencia **MIT**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## Contribuciones
¡Las contribuciones son bienvenidas! Si tienes sugerencias o mejoras, abre un `issue` o envía un `pull request`. 😊

---

## Autor

Desarrollado por faberleondev
