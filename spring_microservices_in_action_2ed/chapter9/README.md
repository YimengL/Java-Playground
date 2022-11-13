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

### 3. Create users via `keycloak`

1. Visit localhost:8080/auth
2. Manage -> Users -> Add User
3. `yimeng.li`, Enable "Email Verified"
4. Credentials Tab: `passwerd1`, disable Temporary
5. Role Mappings, add `offline_access`, `ostkc-admin`, `uma_authorization`


### 4. Generate new Client Secret

1. Visit localhost:8080/auth
2. Clients -> `ostock` -> Credentials
3. Regenerate Secret


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
