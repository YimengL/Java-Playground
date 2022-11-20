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
   1. "Username": `yimeng.li`
   2. "Email Verified": `ON`
   3. Click "Save"
3. Credentials Tab
   1. "Password" & "Password Confirmation": `passwerd1`
   2. Temporary: `OFF`
   3. Click "Set Password"
4. Role Mappings Tab
   1. Select `offline_access`, `ostock-admin`, `uma_authorization` in "Available Roles"
   2. Click "Add selected"

### 4. Generate new Client Secret

1. Visit localhost:8080/auth
2. Configure -> Clients -> `ostock` -> Credentials Tab
3. Regenerate Secret
4. Copy the secret, paste on Token(http://localhost:8080/auth/realms/spmia-realm/protocol/openid-connect/token) endpoint


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
