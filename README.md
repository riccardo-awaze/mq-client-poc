`docker-compose up`

`./gradlew bootRun --args='--spring.profiles.active=dev'


https://localhost:9443/ibmmq/console

put a message in the queue or use the rest endpoing

```
curl -X POST http://localhost:8080/messages -d '{ "eventDatetime": "2023-02-11T18:34:36Z", "eventId": 1, "eventType": "1", "booking": { "bookingId": "8031386", "bookingDatetime": "2023-02-11T18:34:36Z" }}' -H "Content-Type: application/json"
```


and watch the logs