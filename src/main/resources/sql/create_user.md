```
mysql -h localhost -P 3306 -u root -pexample
```
```
CREATE USER 'schnitzelhoelle'@'%' IDENTIFIED BY 'schnitzelhoelle';
CREATE DATABASE schnitzelhoelle;
```
```
USE schnitzelhoellel
GRANT ALL PRIVILEGES ON schnitzelhoelle.* TO 'schnitzelhoelle'@'%';
FLUSH PRIVILEGES;
```

```
mysql -h localhost -P 3306 -u schnitzelhoelle -pschnitzelhoelle schnitzelhoelle
```