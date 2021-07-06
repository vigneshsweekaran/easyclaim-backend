# Easyclaim backend
Backend code for easycliam application
The backend code is written in java

# Deployment
### Deploy mysql database
```
kubectl apply -f database-deployment.yaml
```

### Deploy configmap and deployment for backend java application
```
kubectl apply -f backend-configmap.yaml
kubectl apply -f backend-deployment.yaml
```

# Create new User using backend api
```
curl -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"test","firstName":"test","lastName":"test","age":23,"salary":12345}' http://10.5.0.7:8080/users
```

Info:
http://10.5.0.7 --> backend ClusterIP service IP-address
                    Worker node ip address, if the service type is NodePort
                    External Ip address, if the service type is LoadBalancer
8080 --> backend ClusterIP service port
         Use Nodeport defined in service definition, if the service type is NodePort
         Use 80 if the service type is LoadBalancer