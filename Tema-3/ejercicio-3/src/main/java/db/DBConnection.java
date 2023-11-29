package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.Drivers;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.logging.Logger;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBConnection {
    MongoClient dbClient;
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    public MongoCollection<Drivers> dbConnection(String username, String password, String ip , String database){
        try{
            dbClient = MongoClients.create("mongodb://" + username + ":" + password + "@" + ip + ":27017/" + database + "?authSource=" + database);
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase db = dbClient.getDatabase(database).withCodecRegistry(pojoCodecRegistry);
            return db.getCollection("drivers", Drivers.class);
        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos");
            return null;
        }
    }
    public void closeConnection(){
        dbClient.close();
    }
}
