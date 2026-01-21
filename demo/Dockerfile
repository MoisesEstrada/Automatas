# Etapa 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copiamos archivos de configuración de Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .
# Permisos para el ejecutable
RUN chmod +x mvnw
# Copiamos el código y compilamos
COPY src src
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]