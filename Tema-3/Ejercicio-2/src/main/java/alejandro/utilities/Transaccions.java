package alejandro.utilities;

import alejandro.entities.Piloto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaccions {

    public void transaccion(Piloto piloto1, Piloto piloto2, Connection connection){

            constructorInsert(piloto1, connection);
            pilotoInsert(piloto1, connection);
            pilotoInsert(piloto2, connection);

    }

    public void transaccion2(Piloto piloto1, Piloto piloto3, Connection connection){
        pilotoInsert(piloto1, connection);
        pilotoInsert(piloto3, connection);
    }

    private static void constructorInsert(Piloto piloto1, Connection connection) {
        String sql;
        PreparedStatement insert = null;
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Error setting the autocommit to false. L26\n Error: " + e.getMessage());
        }

        sql = "INSERT INTO constructors (constructorref, name, nationality, url) VALUES ( ?, ?, ?, ?)";

        try {

            insert = connection.prepareStatement(sql);
            insert.setString(1, piloto1.getConstructor().getConstructorref());
            insert.setString(2, piloto1.getConstructor().getName());
            insert.setString(3, piloto1.getConstructor().getNationality());
            insert.setString(4, piloto1.getConstructor().getUrl());
            insert.executeUpdate();
            connection.commit();

        }catch (SQLException e){

            System.err.println("Error creating the query L38.\n Error: " + e.getMessage());
            assert insert != null;

            try {

                connection.rollback();

            } catch (SQLException ex) {

                System.err.println("Error rolling back the transaction. L47 \n Error: " + ex.getMessage());

            }
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Error setting the autocommit to true. L60\n Error: " + e.getMessage());
            }
        }
    }

    private static void pilotoInsert(Piloto piloto1, Connection connection) {
        PreparedStatement insert;
        String sql;

        sql = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorid, url) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Error setting the autocommit to false. L74\n Error: " + e.getMessage());
        }

        try {

            insert = connection.prepareStatement(sql);
            insert.setString(1, piloto1.getCode());
            insert.setString(2, piloto1.getForename());
            insert.setString(3, piloto1.getSurname());
            insert.setString(4, piloto1.getDob().toString());
            insert.setString(5, piloto1.getNationality());
            insert.setInt(6, piloto1.getConstructor().getConstructorid());
            insert.setString(7, piloto1.getUrl());
            insert.executeUpdate();
            connection.commit();

        } catch (SQLException e) {

            System.err.println("Error creating the query. L72 \n Error: " + e.getMessage());

            try {

                connection.rollback();

            } catch (SQLException ex) {

                System.err.println("Error rolling back the transaction. L80\n Error: " + ex.getMessage());
            }finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException exx) {
                    System.err.println("Error setting the autocommit to true. L60\n Error: " + exx.getMessage());
                }
            }
        }
    }
}
