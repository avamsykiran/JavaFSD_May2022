package in.tp.incomestatement.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;

public class MongoDBProvider {
	
	private static MongoDBProvider INSTANCE;
	
	private String dbHost;
	private int dbPort;
	
	private MongoDBProvider() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileReader("application.properties"));
		dbHost = props.getProperty("mongo.host");
		dbPort = Integer.parseInt(props.getProperty("mongo.port"));
	}
	
	public static MongoDBProvider getInstance() throws IOException {
		if(INSTANCE==null) {
			INSTANCE=new MongoDBProvider();
		}
		return INSTANCE;
	}
	
	public MongoDatabase getDB() {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		return new MongoClient(dbHost,dbPort).getDatabase("isdb").withCodecRegistry(pojoCodecRegistry);
	}
}
