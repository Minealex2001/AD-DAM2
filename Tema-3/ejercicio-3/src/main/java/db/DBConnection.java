package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.Drivers;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBConnection {
    public MongoCollection<Drivers> dbConnection(String username, String password, String ip){
        MongoClient dbClient = MongoClients.create("mongodb://" + username + ":" + password + "@" + ip + ":27017");
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoDatabase db = dbClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
        return db.getCollection("drivers", Drivers.class);
    }
}
