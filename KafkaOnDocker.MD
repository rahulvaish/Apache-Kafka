####  Steps to configure Lense.IO
<pre>
[1] <b>Execute:</b> docker run --rm -d -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest
</pre>     

#### Steps to configure Confluent Paltform

<pre>
[1] <b>Execute:</b> git clone https://github.com/confluentinc/examples
[2] <b>Navigate:</b> cd examples
[3] <b>Execute:</b> git checkout 5.3.1-post
[4] <b>Navigate:</b> cd cp-all-in-one/
[5] <b>Execute:</b> docker-compose up -d --build
[6] <b>Execute:</b> docker-compose ps
</pre>
