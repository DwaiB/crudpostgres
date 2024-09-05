FROM openjdk:17
EXPOSE 8080
ADD target/crudpostgres.jar crudpostgres.jar
ENTRYPOINT [ "java","-jar","/crudpostgres.jar" ]