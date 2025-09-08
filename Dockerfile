# Stage 1: Build the application with Maven
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom.xml do diretório raiz do contexto de build
COPY pom.xml .

# Copia o diretório 'src' que está junto com o Dockerfile
# Assumindo que o Dockerfile está em um subdiretório, ex: 'app/Dockerfile'
# O caminho 'app/src' é relativo à raiz do projeto (o contexto de build)
COPY app/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final, smaller image
FROM openjdk:21-jdk-bullseye
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]