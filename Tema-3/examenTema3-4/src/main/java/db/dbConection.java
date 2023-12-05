package db;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.Cliente;
import org.bson.codecs.pojo.PojoCodecProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Logger;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
public class dbConection {
    /**
     * Connects to MongoDB
     * @return MongoCollection<Cliente>
     */
public static MongoCollection<Cliente> mongoConnection(){
    Logger logger = Logger.getLogger(dbConection.class.getName());
    MongoClient mongoClient;
    try {
        String username = "sanpin";
        String password = "qwerty1234";
        String ip = "ec2-54-146-188-92.compute-1.amazonaws.com";
        String database = "sanpin";
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        mongoClient = MongoClients.create("mongodb://" + username + ":" + password + "@" + ip + ":27017");
        MongoDatabase db = mongoClient.getDatabase(database).withCodecRegistry(pojoCodecRegistry);
        logger.info("Connected to MongoDB");
        return db.getCollection("clients", Cliente.class);
    } catch (Exception e) {
        logger.severe("Error connecting to MongoDB");
        e.printStackTrace();
    }
    return null;
}

/**
 * Connects to PostgreSQL
 * @return Connection
 */
public static Connection postgresConnection()  {
    try {
        return DriverManager.getConnection("jdbc:postgresql://examenad.ci66saah1axn.us-east-1.rds.amazonaws.com:5432/sanpin", "postgres", "qwerty1234");
    } catch (SQLException e) {
        return null;
    }
}
}
