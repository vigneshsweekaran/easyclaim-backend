# capstone-easyclaim-backend
Backend code for easycliam application
The backend code is written in java

# Database
### List database and use specific database
```
show databses;
use database_name;
```

### List tables
```
show tables;
```

### Create database
```
create database test;
```

### Create new User
```
curl -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"test","firstName":"test","lastName":"test","age":23,"salary":12345}' http://10.5.0.7:8080/users
```