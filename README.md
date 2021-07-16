## Easyclaim backend
Backend code for easycliam application. The backend code is written in java springboot (Java 8)

## Deployment
### Deploy mysql database as deployment in Kubernetes
```
kubectl apply -f deployment/mysql/deployment/configmap.yaml
kubectl apply -f deployment/mysql/deployment/secret.yaml
kubectl apply -f deployment/mysql/deployment/deployment.yaml
kubectl apply -f deployment/mysql/deployment/service.yaml
```

### Deploy easyclaim backend java application as deployment in kubernetes
```
kubectl apply -f deployment/configmap.yaml
kubectl apply -f deployment/deployment.yaml
kubectl apply -f deployment/service.yaml
```

### Create new User in mysql database using backend api
```
curl -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"test","firstName":"test","lastName":"test","age":23,"salary":12345}' http://10.5.0.7:8080/users
```

Info:
http://10.5.0.7 --> backend ClusterIP service IP-address. Worker node ip address, if the service type is NodePort. External Ip address, if the service type is LoadBalancer

8080 --> backend ClusterIP service port. Use Nodeport defined in service definition, if the service type is NodePort. Use 80 if the service type is LoadBalancer

### Generate load for tseting Horizontal Pod Autoscaler
```
kubectl run -i --tty load-generator --rm --image=busybox --restart=Never -- /bin/sh -c "while sleep 0.01; do wget -q -O- http://easyclaim-backend:8080/users; done"
```