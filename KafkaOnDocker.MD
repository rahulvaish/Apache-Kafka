####  Steps to configure Lense.IO
```
[1] Execute: docker run --rm -d -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 \
       -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost \
       landoop/fast-data-dev:latest
```      

#### Steps to configure Confluent Paltform

```
[1] Execute: git clone https://github.com/confluentinc/examples
[2] Navigate: cd examples
[3] Execute: git checkout 5.3.1-post
[4] Navigate: cd cp-all-in-one/
[5] Execute: docker-compose up -d --build
[6] Execute: docker-compose ps
```
