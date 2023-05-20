# backend_schnitzelhoelle

# run
```
mvn spring-boot:run
```


## create users
```
mysql --host=localhost --port 3306 --user=schnitzelhoelle --password=schnitzelhoelle schnitzelhoelle 
```

```sql
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled TINYINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO users VALUES 
("peter", "{noop}tiger", 1),
("paul", "{noop}tiger", 1),
("mary", "{noop}tiger", 1);

CREATE TABLE authorities(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,

    UNIQUE KEY authorities_idx_1 (username, authority),

    CONSTRAINT authorities_idx_1
    FOREIGN KEY (username) REFERENCES users (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO authorities VALUES 
("peter", "ROLE_USER"),
("paul", "ROLE_USER"),
("paul", "ROLE_MANAGER"),
("mary", "ROLE_ADMIN");

```

# testing 

## login
```
curl -i -X POST http://localhost:8080/login --data 'username=paul&password=tiger'
```

## schnitzel
```
echo "create 1"
curl --header "Content-Type: application/json" \
--user "john:tiger" \
--request POST \
--data '{"name":"XXL Schnitzel"}' \
http://localhost:8080/api/schnitzels

echo "get all"
curl \
--user "john:tiger" \
 http://localhost:8080/api/schnitzels | json_pp

echo "get 1"
curl http://localhost:8080/api/schnitzels/1 | json_pp


echo "update 1"
curl \
--user "john:tiger" \
--header "Content-Type: application/json" \
--request PUT \
--data '{"name":"XxxxXL Schnitzel"}' \
http://localhost:8080/api/schnitzels/1

echo "get 1"
curl http://localhost:8080/api/schnitzels/1 | json_pp


echo "delete 1"
curl \
--user "john:tiger" \
http://localhost:8080/api/schnitzels/1 --request DELETE 

echo "get all"
curl http://localhost:8080/api/schnitzels | json_pp

```


## Restaurant
```
echo "create 1"
curl \
--header "Content-Type: application/json" \
--user "john:tiger" \
--request POST --data '{"name":"XXL Restaurant", "country": "DE", "houseNum": "333", "street": "Huehnerstr", "zipCode": "99999", "city":"Schweinfurt"}' http://localhost:8080/api/restaurants

echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

echo "get 1"
curl http://localhost:8080/api/restaurants/1 | json_pp

echo "update 1"
curl \
--user "john:tiger" \
--header "Content-Type: application/json" \
--request PUT \
--data '{"name":"XXXXXXXL Restaurant", "country": "DK", "houseNum": "444", "street": "Hahnenstr", "zipCode": "88888", "city":"Faxe"}' \
http://localhost:8080/api/restaurants/1

echo "get 1"
curl http://localhost:8080/api/restaurants/1 | json_pp

echo "delete 1"
curl \
--user "john:tiger" \
 http://localhost:8080/api/restaurants/1 --request DELETE 

echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

```