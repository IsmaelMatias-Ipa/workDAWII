#usar la imagen oficoal de java 21
FROM eclipse-temurin:21-jdk-alpine

#Crear un directorio para la aplicación
WORKDIR /app

#Copiar el archibo JAR generado por Maven al Contenedor
COPY target/Rest-Employee-0.0.1-SNAPSHOT.jar app.jar

#Puerto
EXPOSE 9002

#Comando para ejecutar
ENTRYPOINT [ "java", "-jar", "app.jar" ]