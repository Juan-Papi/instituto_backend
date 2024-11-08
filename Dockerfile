# Usa una imagen base con Maven y Java 17
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto de la aplicación y compila
COPY src ./src
RUN mvn clean package -DskipTests

# Imagen ligera para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY --from=build /app/target/instituto_backend-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando de inicio de la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
