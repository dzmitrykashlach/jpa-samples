run postgres
```
docker run --name use-the-index --env POSTGRES_PASSWORD=root \
           --volume   postgres:/var/lib/postgresql/data \
           --publish 5432:5432 \
           --detach postgres
```

ssh to kafka container  
```
docker exec -it docker_kafka-test_1 bash
```
