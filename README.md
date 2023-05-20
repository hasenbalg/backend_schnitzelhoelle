# backend_schnitzelhoelle

# run
```
mvn spring-boot:run
```

# testing 

## schnitzel
```
echo "create 1"
curl --header "Content-Type: application/json" \
--request POST \
--data '{"name":"XXL Schnitzel"}' \
http://localhost:8080/api/schnitzels

echo "get all"
curl http://localhost:8080/api/schnitzels | json_pp

echo "get 1"
curl http://localhost:8080/api/schnitzels/1 | json_pp


echo "update 1"
curl --header "Content-Type: application/json" \
--request PUT \
--data '{"name":"XxxxXL Schnitzel"}' \
http://localhost:8080/api/schnitzels/1

echo "get 1"
curl http://localhost:8080/api/schnitzels/1 | json_pp


echo "delete 1"
curl http://localhost:8080/api/schnitzels/1 --request DELETE 

echo "get all"
curl http://localhost:8080/api/schnitzels | json_pp

```


## Restaurant
```
echo "create 1"
curl --header "Content-Type: application/json" --request POST --data '{"name":"XXL Restaurant", "country": "DE", "houseNum": "333", "street": "Huehnerstr", "zipCode": "99999", "city":"Schweinfurt"}' http://localhost:8080/api/restaurants

echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

echo "get 1"
curl http://localhost:8080/api/restaurants/1 | json_pp

echo "update 1"
curl --header "Content-Type: application/json" \
--request PUT \
--data '{"name":"XXXXXXXL Restaurant", "country": "DK", "houseNum": "444", "street": "Hahnenstr", "zipCode": "88888", "city":"Faxe"}' \
http://localhost:8080/api/restaurants/1

echo "get 1"
curl http://localhost:8080/api/restaurants/1 | json_pp

echo "delete 1"
curl http://localhost:8080/api/restaurants/1 --request DELETE 

echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

```