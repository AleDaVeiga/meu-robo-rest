# README

## Necessário

Deve estar instalado [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [Maven](https://maven.apache.org/download.cgi) e [Wildfly](http://wildfly.org/downloads/).

## Compilar

Abra o prompt de comando na pasta raiz do projeto e execute:

```
mvn clean
mvn package
```

## Iniciar

Copiar o arquivo "target/rest.war" para a pasta de deploy do Wildfly.

Acessar http://localhost:8080/rest/mars/MML para ver o resultado.