
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copia todos os arquivos do projeto
COPY . .

# Dá permissão de execução ao Maven Wrapper
RUN chmod +x ./mvnw

# Compila o projeto
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
