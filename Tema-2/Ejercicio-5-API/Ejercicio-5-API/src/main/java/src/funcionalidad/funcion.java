package src.funcionalidad;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.objetos.Drivers;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;

public class funcion {
    URL season = new URL("https://ergast.com/api/F1/2023.json");
    URL drivers = new URL("https://ergast.com/api/f1/2023/drivers.json");
    HttpsURLConnection seasonConnection = (HttpsURLConnection) season.openConnection();
    HttpsURLConnection driversConnection = (HttpsURLConnection) drivers.openConnection();


    public JsonNode leerDrivers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(driversConnection.getInputStream());
        return node.get("Drivers");

    }


    public funcion() throws IOException {
    }
}
