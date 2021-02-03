# redisson-sample
Sample of work with Redis (Docker) image by redisson based on 
	https://www.baeldung.com/redis-redisson

docker pull redis<br/>
docker run --name my-first-redis -d -p 6379:6379 redis

<h3>Access to bash</h3><br/>
docker exec -it my-first-redis sh

<h3>Access to redis cli</h3><br/>
redis-cli[Enter]

<h3>Test redis running is ok</h3><br/>
https://redis.io/topics/quickstart

<h3>See all keys</h3><br/>
KEYS *

<h3>Test redisson-sample</h3><br/>
get sample12

<h3>Shutdown Redis</h3><br/>
exit [from redis-cli]<br/>
exit [from redis container]<br/>
docker stop my-first-redis<br/>
docker rm my-first-redis<br/>



