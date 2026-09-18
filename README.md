# Carrera Académica - Spring Boot MVC

Aplicación web desarrollada con **Spring Boot**, **Spring MVC**, **Spring Data JPA** y **Thymeleaf**

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Spring Security
- MySQL
- Maven

---

## Estructura del proyecto

- `entity` → Entidades (Usuario y CarreraAcademica)
- `repository` → Interfaces de acceso a datos (Spring Data JPA)
- `service` → Lógica de negocio
- `controller` → Controladores MVC
- `config` → Configuraciones (SecurityConfig)
- `templates` → Vistas HTML con Thymeleaf

---

## Base de datos

La aplicación utiliza MySQL.  

### Datos de prueba

**Usuario Admin
- Usuario: admin
- Clave: admin123

---

## Configuración

Archivo principal de configuración:  
`src/main/resources/application.properties`

---

Cómo ejecutar la aplicación localmente:

1. Clonar el repositorio:
   git clone https://github.com/Mapeflo/Carrera-Academica-spring-mvc.git
2. Importar el proyecto en IntelliJ IDEA como proyecto Maven.
3. Configurar la base de datos en application.properties.
4. Ejecutar la clase principal: CarreraAcademicaApplication.java
5. Abrir en el navegador: http://localhost:8080

---

Funcionalidades implementadas:
-Autenticación de usuarios (Login / Logout) con Spring Security
-Recuperación de clave por correo electrónico
-CRUD completo de Usuario
-CRUD completo de Carrera Académica
-Reportes parametrizados:Usuarios por Rol
-Usuarios por Nombre (parcial)
-Carreras por Universidad + Nivel de Formación
-Carreras Acreditadas por rango de valor de semestre

-Arquitectura por capas: Controller → Service → Repository → Entity
-Vistas renderizadas del lado del servidor con Thymeleaf

Autor
Mapeflo








