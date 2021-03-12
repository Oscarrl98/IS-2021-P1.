# IS-2021-P1
Repositorio que almacena codigo fuente de examen parcial 1 ingenieria de software

## Datos del alumno:

- Oscar Raul Lopez Perez
- Carnet:1290-17-4138

### Funcionamiento 
# Imagen docker
https://hub.docker.com/repository/docker/oscarrl98/parcial1is

- Ejecucion de el servicio con el docker descargado de docker hub

docker pull oscarrl98/parcial1is

- Iniciar la ejecucion del docker

docker run -p 8080:8080 -v /tmp:/tmp --name p1app oscarrl98/parcial1is

- Direccion del servicio

http:localhost:8080/

redirigira al index donde podra cargar el archivo

- Ejecucion de conversion

por ejemplo:

http://localhost:8080/download?from=archive.csv&as=json (si el archivo no esta cargado no funcionara)
