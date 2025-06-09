FROM maven:3.9.6-eclipse-temurin-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de configuração do Maven e o código-fonte
COPY pom.xml .
COPY src ./src

# Executa o build do Maven para gerar o arquivo .jar
RUN mvn clean package -DskipTests


# Estágio 2: Criação da imagem final
FROM eclipse-temurin:17-jre

# Define o diretório de trabalho
WORKDIR /app

# Declara que /app/data é um ponto de montagem para dados persistentes
VOLUME /app/data

# MUDANÇA: Copia a pasta 'data' local para dentro da imagem
COPY data ./data

# Copia o arquivo JAR gerado no estágio de build
COPY --from=build /app/target/bloco-de-notas-app.jar .

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "bloco-de-notas-app.jar"]