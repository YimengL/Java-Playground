## HOW to Run

### 1. Build `configserver`
```shell
$ cd configserver
$ mvn package dockerfile:build
```

### 2. Build `licensing-service`

```shell
$ cd licensing-service
$ mvn package dockerfile:build
```

### 3. Run Docker

```shell
$ cd docker
$ # Set up 2 env variable: ENCRYPT_KEY & POSTGRES_PASSWORD
$ docker-compose up 
```

### Check the `Postgres` DB

```shell
$ docker exec -it {CONTAINER_ID} bash # enter container
$ psql -U postgres # enter DB
$ \l # list db
$ \c ostock_dev # go to ostock_dev db
$ select * from licenses; # or any other SQL query
```

### Stop the Docker

```shell
$ docker-compose down
```
