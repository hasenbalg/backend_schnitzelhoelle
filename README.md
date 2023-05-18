# backend_schnitzelhoelle

# run
```
mvn spring-boot:run
```

# testing 

## schnitzel
```
echo "get all"
curl http://localhost:8080/api/schnitzels | json_pp

echo "get 0"
curl http://localhost:8080/api/schnitzels/0 | json_pp


echo "create 3"
curl --header "Content-Type: application/json" \
--request POST \
--data '{"name":"XXL Schnitzel"}' \
http://localhost:8080/api/schnitzels

echo "get 3"
curl http://localhost:8080/api/schnitzels/3 | json_pp

echo "update 3"
curl --header "Content-Type: application/json" \
--request PUT \
--data '{"id":3, "name":"XxxxXL Schnitzel"}' \
http://localhost:8080/api/schnitzels

echo "get 3"
curl http://localhost:8080/api/schnitzels/3 | json_pp


echo "delete 3"
curl http://localhost:8080/api/schnitzels/3 --request DELETE 

echo "get all"
curl http://localhost:8080/api/schnitzels | json_pp

```


## Restaurant
```
echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

echo "get 0"
curl http://localhost:8080/api/restaurants/0 | json_pp


echo "create 3"
curl --header "Content-Type: application/json" --request POST --data '{"name":"XXL Restaurant", "country": "DE", "houseNum": "333", "street": "Huehnerstr", "zipCode": "99999", "city":"Schweinfurt"}' http://localhost:8080/api/restaurants


echo "get 3"
curl http://localhost:8080/api/restaurants/3 | json_pp

echo "update 3"
curl --header "Content-Type: application/json" \
--request PUT \
--data '{"id":3, "name":"XxxxXL Restaurant" }' \
http://localhost:8080/api/restaurants

echo "get 3"
curl http://localhost:8080/api/restaurants/3 | json_pp


echo "delete 3"
curl http://localhost:8080/api/restaurants/3 --request DELETE 

echo "get all"
curl http://localhost:8080/api/restaurants | json_pp

```