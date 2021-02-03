package ir.amin.redisson;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class Bootstrap {

	public static void main(String[] args) {
		//Let's connect to a single node instance of Redis.
		Config config = new Config();
		config.useSingleServer()
		  .setAddress("redis://127.0.0.1:6379");

		RedissonClient client = Redisson.create(config);
		
		
//		try {
//			String jsonFormat = config.toJSON();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
//		get all the keys
		RKeys keys = client.getKeys();
		System.out.println(keys.count());
		
//		get the keys conforming to a pattern
		Iterable<String> keysByPattern = keys.getKeysByPattern("*key*");
		Iterator<String> iterator = keysByPattern.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next);
			RBucket<String> bucket = client.getBucket(next ,StringCodec.INSTANCE);
			System.out.println(bucket.get());
		}
/*		
		Distributed objects provided by Redisson include:

			ObjectHolder
			BinaryStreamHolder
			GeospatialHolder
			BitSet
			AtomicLong
			AtomicDouble
			Topic
			BloomFilter
			HyperLogLog
		
*/		
		
//		RsBucket class, this object can hold any type of object
		RBucket<SampleObject> bucket = client.getBucket("sample12");
		SampleObject sampleObject = new SampleObject();
		sampleObject.setName("today : " + new Date());
		bucket.set(sampleObject);
		
		
		SampleObject sample = bucket.get();
		System.out.println(new Date() + "\n\t\t" + sample.getName());
	}
	
}
