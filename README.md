# redisson-sample
Sample of work with Redis (Docker) image by redisson based on 
	https://www.baeldung.com/redis-redisson

docker pull redis
docker run --name my-first-redis -d -p 6379:6379 redis

<h1>for access to bash</h1><br/>
docker exec -it my-first-redis sh

for access to redis cli
redis-cli[Enter]

for test redis running is ok 
https://redis.io/topics/quickstart

for see all keys
KEYS *

for test redisson-sample
get sample12

at end
exit [from redis-cli]
exit [from redis container]
docker stop my-first-redis
docker rm my-first-redis



