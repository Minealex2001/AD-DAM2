package utils;

import com.mongodb.client.MongoCollection;
import entities.Cliente;
import db.dbConection;
import entities.Cuenta;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.mongodb.client.model.Filters.eq;
import static jdk.internal.org.jline.utils.AttributedStringBuilder.append;

public class CRUDOperation {

    MongoCollection<Cliente> clientes = dbConection.mongoConnection();
    Connection connection = dbConection.postgresConnection();


    public void crearCliente(Cliente cliente) {
        clientes.insertOne(cliente);
    }

    public void leerTodo() {
        try {
            for (Cliente cliente : clientes.find()) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al leer los clientes");
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");

            while (resultSet.next()) {
                String iban = resultSet.getString("iban");
                double balance = resultSet.getDouble("balance");
                int clientid = resultSet.getInt("clientid");

                System.out.println("IBAN: " + iban + ", Balance: " + balance + ", Client ID: " + clientid);
            }
        } catch (Exception e) {
            System.out.println("Error al leer las cuentas");
        }
}

    public void modificarCliente( Cliente cliente) {
        org.bson.Document document = new org.bson.Document("$set", new Document()
                .append("apellido", cliente.getApellido())
                .append("clientid", cliente.getClientid())
                .append("dni", cliente.getDni())
                .append("nombre", cliente.getNombre())
                .append("nacionalidad", cliente.getNacionalidad())
                .append("telefono", cliente.getTelefono())
                .append("email", cliente.getEmail())
                .append("usuario", cliente.getUsuario())
                .append("contrasenya", cliente.getContrasenya()));
        clientes.updateOne(new Document("clientid", cliente.getClientid()), document);
    }

    public void borrarCliente(int clienteid) {
        try{
            clientes.deleteMany(eq("clientid", clienteid));
            borrarCuenta(clienteid);
        }catch (Exception e) {
            System.out.println("Error al borrar el cliente");
        }
    }

    public void insertarCuenta(Cuenta cuenta, Cliente cliente){
        if (true) {
            try {
                String sql = "INSERT INTO accounts (iban, balance, clientid) VALUES ('" + cuenta.getIban() + "', " + cuenta.getBalance() + ", " + cuenta.getClientid() + ");";
                PreparedStatement consulta = connection.prepareStatement(sql);
                consulta.executeUpdate();
            }catch (Exception e) {
                System.out.println("Error al insertar la cuenta");
            }
        } else {
            System.out.println("El cliente no existe");
        }
    }

    public void borrarCuenta(Cuenta cuenta){
        try {
            String sql = "DELETE FROM accounts WHERE iban = '" + cuenta.getIban() + "';";
            PreparedStatement consulta = connection.prepareStatement(sql);
            consulta.executeUpdate();
        }catch (Exception e) {
            System.out.println("Error al borrar la cuenta");
        }
    }

    public void borrarCuenta(int id){
        try {
            String sql = "DELETE FROM accounts WHERE clientid = '" + id + "';";
            PreparedStatement consulta = connection.prepareStatement(sql);
            consulta.executeUpdate();
        }catch (Exception e) {
            System.out.println("Error al borrar la cuenta");
        }
    }

    public void modificarCuenta(Cuenta cuenta1, Cuenta cuenta2){
        try {
            String sql = "UPDATE accounts SET iban = '" + cuenta2.getIban() + "', balance = " + cuenta2.getBalance() + ", clientid = " + cuenta2.getClientid() + " WHERE iban = '" + cuenta1.getIban() + "';";
            PreparedStatement consulta = connection.prepareStatement(sql);
            consulta.executeUpdate();
        }catch (Exception e) {
            System.out.println("Error al modificar la cuenta");
        }
    }

    public boolean clienteExiste(int clienteId) {
        Cliente cliente = clientes.find(eq("clientid", clienteId)).first();
        return cliente != null;
    }
}
