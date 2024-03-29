## HOW to Run

### 1. Build all (configserver, licensing-service, organization-service)
```shell
$ mvn package dockerfile:build # in root directory
```

### 2. Run Docker

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
$ \q # leave db
```

### Stop the Docker

```shell
$ docker-compose down
```
