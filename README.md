# Easyclaim backend
Backend code for easycliam application
The backend code is written in java

# Database
### Connect to a mysql pod
```
kubectl exec -it pod_name -n easyclaim -- bash
```

### Login to mysql from inside a pod
```
mysql -u root -p test
```

### List database and use specific database
```
show databses;
```

### Create database
```
create database test;
```

### Select a database
``` 
use test;
```

### List tables
```
show tables;
```

### Create new User using backend api
```
curl -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"test","firstName":"test","lastName":"test","age":23,"salary":12345}' http://10.5.0.7:8080/users
```