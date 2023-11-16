package alejandro.utilities;

import alejandro.entities.Piloto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaccions {

    public boolean transaccion(Piloto piloto1, Piloto piloto2, Connection connection){
        PreparedStatement insert = null;
        String sql;

        if (piloto1.getConstructor().getConstructorid() == piloto2.getConstructor().getConstructorid()) {

            return false;

        }else {

            sql = "INSERT INTO constructors (constructorid, constructorref, name, nationality, url) VALUES (?, ?, ?, ?, ?)";

            try {

                insert = connection.prepareStatement(sql);
                insert.setInt(1, piloto1.getConstructor().getConstructorid());
                insert.setString(2, piloto1.getConstructor().getConstructorref());
                insert.setString(3, piloto1.getConstructor().getName());
                insert.setString(4, piloto1.getConstructor().getNationality());
                insert.setURL(5, piloto1.getConstructor().getUrl());
                insert.executeUpdate();

            }catch (SQLException e){

                System.err.println("Error creating the query.\n Error: " + e.getMessage());
                assert insert != null;

                try {

                    connection.rollback();

                } catch (SQLException ex) {

                    System.err.println("Error rolling back the transaction.\n Error: " + ex.getMessage());

                }
            }

            sql = "INSERT INTO drivers (code, forename, surname, dob, nationality, teamid, url) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {

                insert = connection.prepareStatement(sql);
                insert.setString(1, piloto1.getCode());
                insert.setString(2, piloto1.getForename());
                insert.setString(3, piloto1.getSurname());
                insert.setDate(4, piloto1.getDob());
                insert.setString(5, piloto1.getNationality());
                insert.setInt(6, piloto1.getConstructor().getConstructorid());
                insert.setURL(7, piloto1.getUrl());
                insert.executeUpdate();

            } catch (SQLException e) {

                System.err.println("Error creating the query.\n Error: " + e.getMessage());

                try {

                    connection.rollback();

                } catch (SQLException ex) {

                    System.err.println("Error rolling back the transaction.\n Error: " + ex.getMessage());
                }
            }
        }
        return true;
    }
}
