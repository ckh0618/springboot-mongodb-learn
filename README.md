
# Skeleton for studying Spring boot
This project aims the developer who wants to learn Spring Boot with 'Spring Data for MongoDB'.
You need to install MongoDB on your local machine.
Modify resource/application.properties to connect your MongoDB.

This project is awful and not optimized. It is intended. 

# Basic usage 
1. After run this project, you can generate data.
```commandline
curl -X POST http://localhost:8080/generate/100
```

2. Get the product with sku id 
```commandline
curl -X GET http://localhost:8080/product/1 | jq 
```
3. Tune and run more effectively. 

Have fun. 