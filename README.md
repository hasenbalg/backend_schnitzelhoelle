# backend_schnitzelhoelle

# run
```
mvn spring-boot:run
```

# testing
```
echo "get all"
curl http://localhost:8080/schnitzel | json_pp

echo "get 0"
curl http://localhost:8080/schnitzel/0 | json_pp


echo "create 3"
curl --header "Content-Type: application/json" \
--request POST \
--data '{"name":"XXL Schnitzel"}' \
http://localhost:8080/schnitzel

echo "get 3"
curl http://localhost:8080/schnitzel/3 | json_pp

echo "update 3"
curl --header "Content-Type: application/json" \
--request PUT \
--data '{"id":3, "name":"XxxxXL Schnitzel"}' \
http://localhost:8080/schnitzel

echo "get 3"
curl http://localhost:8080/schnitzel/3 | json_pp


echo "delete 3"
curl http://localhost:8080/schnitzel/3 --request DELETE 

echo "get all"
curl http://localhost:8080/schnitzel | json_pp

```