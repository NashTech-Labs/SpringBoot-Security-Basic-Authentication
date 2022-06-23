## spring-boot-security-basic-authentication
Simple Spring-Security basic authentication using method level security.

### Public access
Test the `public` endpoint without any authentication:

```sh
curl http://localhost:8081/public
```
Response:
```sh
Hello Knoldus!
```

### Private access

Test the `private` endpoint without authentication:

```sh
curl http://localhost:8081/private
```
You receive the following response, which indicates you are not authorized to access the resource:
```sh
HTTP Status 401 - Full authentication is required to access this resource
```


Test the `private` endpoint with `ROLE_USER` account authentication:

```sh
curl -u user:password http://localhost:8081/private
```
Response:
```sh
Hello Java!
```

Test the `private` endpoint with `ROLE_ADMIN` account authentication:

```sh
curl -u admin:password http://localhost:8081/private
```
Response:
```sh
Hello Java!
```


Test the `private` endpoint with wrong user authentication:

```sh
curl -u user:wrongpassword http://localhost:8081/private
```
You receive the following response, which indicates you are not authorized to access the resource:
```sh
HTTP Status 401 - Bad credentials
```

### Admin access

Test the `admin` endpoint with `ROLE_USER` account authentication:

```sh
curl -u user:password http://localhost:8081/admin
```
Response:
```sh
{  
   "timestamp":1515542457567,
   "status":403,
   "error":"Forbidden",
   "exception":"org.springframework.security.access.AccessDeniedException",
   "message":"Hello knoldus",
   "path":"/admin"
}
```

Test the `admin` endpoint with `ROLE_ADMIN` account authentication:

```sh
curl -u admin:password http://localhost:8081/admin
```
Response:
```sh
Hello Admin!
```