`docker-compose up`

`./gradlew bootRun --args='--spring.profiles.active=dev'


https://localhost:9443/ibmmq/console

put a message in the queue or use the rest endpoing

```
curl -X POST http://localhost:8080/messages -d '{ "eventDatetime": "2023-02-11T18:34:36Z", "eventId": 1, "eventType": "1", "booking": { "bookingId": "8031386", "bookingDatetime": "2023-02-11T18:34:36Z" }}' -H "Content-Type: application/json"
```


and watch the logs

CURL
```
curl -k --location --request POST 'https://localhost:9443/ibmmq/console/internal/ibmmq/qmgr/QM1/queue/DEV.QUEUE.1/messages' \
--header 'Content-Type: application/json' \
--header 'ibm-mq-csrf-token: value' \
--header 'Authorization: Basic YWRtaW46cGFzc3cwcmQ=' \
--0 'Cookie: WASPostParam=L2libW1xL2NvbnNvbGUvaW50ZXJuYWwvaWJtbXEvcW1nci9RTTEvcXVldWUvREVWLlFVRVVFLjEvbWVzc2FnZXM=.AAAAAAAAABo=.AAAAEA==.YXBwbGljYXRpb24vanNvbg==.ewogICAgIm1lc3NhZ2UiIDogIkJMQUgiCn0=; LtpaToken2_1678894721851907315=f1xfNsJWEXYC/d4pSh7x7oWLZNZxDxuB6soOmzZ1ZQvQ+w2wmVh2cUJtKYY8uPJ2gLoT6J35P0/bLMlttzYPNlXqUoGWSiFWXAIXCbpPlhxVjefzLVDPOq8I7WDoT4vjjrdFYLqC1S3DQpRO7qFbbMljhFxays1CUrkTceIf5v2PIrueTDlLwxc2pdBx7hKveVLOcuVqZMwicYzTYDzQ4NXkFCaKXSZYPrZ2sZ2pRd2RJbYZGLkylJqF0XUfVIDDyBshetuDaY6hojSoJqS+QVVYRL8maT0go7e7pval3QjiOlIeQOwvOfrJZxWXJyDc; WASReqURL=https://:9443/ibmmq/console/internal/ibmmq/qmgr/QM1/queue/DEV.QUEUE.1/messages' \
--data-raw '{
    "message" : "asdasdasda"
}'
```

WGET alternative
```
wget --no-check-certificate --quiet \
  --method POST \
  --timeout=0 \
  --header 'Content-Type: application/json' \
  --header 'ibm-mq-csrf-token: value' \
  --header 'Authorization: Basic YWRtaW46cGFzc3cwcmQ=' \
  --header 'Cookie: WASPostParam=L2libW1xL2NvbnNvbGUvaW50ZXJuYWwvaWJtbXEvcW1nci9RTTEvcXVldWUvREVWLlFVRVVFLjEvbWVzc2FnZXM=.AAAAAAAAABo=.AAAAEA==.YXBwbGljYXRpb24vanNvbg==.ewogICAgIm1lc3NhZ2UiIDogIkJMQUgiCn0=; LtpaToken2_1678894721851907315=f1xfNsJWEXYC/d4pSh7x7oWLZNZxDxuB6soOmzZ1ZQvQ+w2wmVh2cUJtKYY8uPJ2gLoT6J35P0/bLMlttzYPNlXqUoGWSiFWXAIXCbpPlhxVjefzLVDPOq8I7WDoT4vjjrdFYLqC1S3DQpRO7qFbbMljhFxays1CUrkTceIf5v2PIrueTDlLwxc2pdBx7hKveVLOcuVqZMwicYzTYDzQ4NXkFCaKXSZYPrZ2sZ2pRd2RJbYZGLkylJqF0XUfVIDDyBshetuDaY6hojSoJqS+QVVYRL8maT0go7e7pval3QjiOlIeQOwvOfrJZxWXJyDc; WASReqURL=https://:9443/ibmmq/console/internal/ibmmq/qmgr/QM1/queue/DEV.QUEUE.1/messages' \
  --body-data '{
    "message" : "asdasdasda"
}' \
   'https://localhost:9443/ibmmq/console/internal/ibmmq/qmgr/QM1/queue/DEV.QUEUE.1/messages'
```