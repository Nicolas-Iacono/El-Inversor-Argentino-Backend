# Usa una imagen base de Maven y Java JDK con la versión que necesitas
FROM maven:3.8.4-openjdk-17 AS build

# Establece el directorio de trabajo en /home/app
WORKDIR /home/app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias necesarias antes de copiar el código fuente
RUN mvn dependency:go-offline

# Copia todo el código fuente al contenedor
COPY src src

# Empaqueta la aplicación
RUN mvn package -DskipTests

# Inicia una nueva etapa de construcción para el contenedor de la aplicación
FROM openjdk:17.0.1-jdk

# Establece el directorio de trabajo en /usr/src/app
WORKDIR /usr/src/app

# Copia el archivo JAR de la aplicación al contenedor y renómbralo
COPY --from=build /home/app/target/inv-arg-0.0.1-SNAPSHOT.jar inv-arg-0.0.1.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "inv-arg-0.0.1.jar"]