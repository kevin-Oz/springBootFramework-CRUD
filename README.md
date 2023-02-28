# Instrucciones:
Descargar el proyecto del repositorio.
```sh
git clone origin <url>
```
una vez descargado vamos instalar todas las dependencias, ubicandonos en la raiz del proyecto ejecutar:
```sh
./mvnw install
```


Hay que modificar el archivo de application.properties para que se adecue a la base de datos local.

luego de eso podemos generar el jar y ejecutar la aplicacion en el puerto 8082, si ese puerto esta ocupado cambiarlo en el application.properties

Esto generara el jar y lo ejecutamos
```sh
./mvnw clean package 
java -jar target/test-0.0.1-SNAPSHOT.jar
```




# Endpoints:
CREATE empresa http://localhost:8082/api/v1/empresa
method: POST
RequestBody: {
"nombre": "CC-company 222",
"numero_de_nit": "88888-2",
"fecha_de_fundacion": "2022-04-01"
}

READ List<Empresas> http://localhost:8082/api/v1/empresas
method GET

UPDATE Empresa/id http://localhost:8082/api/v1/empresa/{id}
method PUT
RequestBody:
{
"nombre": "CC-company ",
"numero_de_nit": "55555-2",
"fecha_de_fundacion": "2022-01-01"
}

DELETE http://localhost:8082/api/v1/empresa
method DELETE