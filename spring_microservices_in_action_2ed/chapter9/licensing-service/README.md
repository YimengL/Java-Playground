### Build
```shell
$ mvn clean package
```

### Run

Prerequisite: need to up & run postgres
```shell
$ brew services restart postgresql
```

```shell
$ mvn spring-boot:run
```

### Build docker image
```shell
$ mvn package dockerfile:build
```

### Run docker
```shell
$ docker run -d rocklee1108/licensing-service:0.0.1-SNAPSHOT
```

### Buildpacks run docker image
```shell
$ ./mvnw spring-boot:build-image
$ docker run -it -p 8080:8080 docker.io/library/licensing-service:0.0.1-SNAPSHOT
```

### Run docker-compose
```shell
$ docker-compose up
```

