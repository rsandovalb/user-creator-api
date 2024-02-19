# user-creator-api
API para la creación de usuarios

# Como construir el project usando Docker

docker build -t ${project_name} .
docker run -it -p 8080:8080 ${project_name}

*********************************************************************
# Detalles de la implementacion
********************************************************************* 
Springboot 3.2.2
Swagger UI
H2 2.2.224
Java-11
Arquitectura Hexagonal

Validacion Contraseña
Se agrega validación de clave mediante expresión regular, debe contener 1 digito una mayuscula y una misucula y puede ser de 4 a 16 caracteres

*********************************************************************
# Instalación y ejecución
********************************************************************* 

1. clonar proyecto

   git clone https://github.com/rsandovalb/user-creator-api.git

   cd user-creator-api

2. ejecutar la siguiente línea de comando:

   mvn spring-boot:run

3. Para validar la creación de usuarios, abra un navegador visite el siguiente link

   http://localhost:8080/swagger-ui/index.html#/user-controller/createUser

4.- Tras operaciones de inserción puede verificar los registros en el panel de administración de H2 en el siguiente link:

http://localhost:8080/h2-console

    las siguientes opciones deben coincidir en el panel:
      
      Saved Settings:	Generic H2 (Embeded)
      Setting Name: Generic H2 (Embeded)
      Driver Class: org.h2.Driver
      JDBC URL: jdbc:h2:mem:users
      User Name: neoris
      Password: sa
