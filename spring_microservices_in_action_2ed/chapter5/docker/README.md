### Start the Docker

prerequisite: need to build `configserver` & `licensing-service`

```shell
$ docker-compose up 
```

### Stop the Docker

```shell
$ docker-compose down
```

### Check the `Postgres` DB

```shell
$ docker exec -it {CONTAINER_ID} bash # enter container
$ psql -U postgres # enter DB
$ \l # list db
$ \c ostock_dev # go to ostock_dev db
$ select * from licenses; # or any other SQL query
```