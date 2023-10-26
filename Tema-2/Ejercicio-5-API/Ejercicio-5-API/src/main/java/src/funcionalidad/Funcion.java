package src.funcionalidad;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import src.objetos.Drivers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public class Funcion  {
    static List<Drivers> driversList;

    public Funcion() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        JsonNode root = objectMapper.readTree(new URL("https://ergast.com/api/f1/2023/drivers.json"));
        driversList = objectMapper.readValue(root.get("MRData").get("DriverTable").get("Drivers").traverse(), new TypeReference<>(){});
        for (Drivers drivers : driversList) {
            System.out.println(drivers);

        }
    }


    public static void escribirJSON(Path ficheroJSON) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ficheroJSON.toFile(), driversList);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


