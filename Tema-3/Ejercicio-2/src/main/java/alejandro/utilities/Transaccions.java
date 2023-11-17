package alejandro.utilities;

import alejandro.entities.Piloto;

import java.sql.*;

public class Transaccions {
    static Boolean existsConstructor = false;
    static int constructorid;
    static int test = 0;

    private static void constructorInsert(Piloto piloto1, Connection connection) {
        String sql;
        PreparedStatement insert = null;
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Error setting the autocommit to false. 01 \n Error: " + e.getMessage());
        }

        sql = "INSERT INTO constructors (constructorref, name, nationality, url) VALUES ( ?, ?, ?, ?)";

        try {

            insert = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setString(1, piloto1.getConstructor().getConstructorref());
            insert.setString(2, piloto1.getConstructor().getName());
            insert.setString(3, piloto1.getConstructor().getNationality());
            insert.setString(4, piloto1.getConstructor().getUrl());
            insert.executeUpdate();
            connection.commit();
            existsConstructor = true;
            ResultSet rs = insert.getGeneratedKeys();
            rs.next();
            constructorid = rs.getInt(1);

        } catch (SQLException e) {

            System.err.println("Error creating the query 02.\n Error: " + e.getMessage());

            try {

                connection.rollback();

            } catch (SQLException ex) {

                System.err.println("Error rolling back the transaction. 03 \n Error: " + ex.getMessage());

            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Error setting the autocommit to true. 04 \n Error: " + e.getMessage());
            }

        }
    }

    private static boolean pilotoInsert(Piloto piloto, Connection connection) {
        PreparedStatement insert;
        String sql;
        System.out.println(piloto + " " + test++);

        sql = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorid, url) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Error setting the autocommit to false. 06 \n Error: " + e.getMessage());
        }

        try {

            insert = connection.prepareStatement(sql);
            insert.setString(1, piloto.getCode());
            insert.setString(2, piloto.getForename());
            insert.setString(3, piloto.getSurname());
            insert.setDate(4, Date.valueOf(piloto.getDob()));
            insert.setString(5, piloto.getNationality());
            insert.setInt(6, constructorid);
            insert.setString(7, piloto.getUrl());
            insert.executeUpdate();

            connection.commit();
            return true;

        } catch (SQLException e) {

            Boolean rollback = true;
            if (e.getClass().getName().equals("org.postgresql.util.PSQLException") &&
                    e.getMessage().contains("duplicate key value violates unique constraint \"drivers_code_key\"")) {
                rollback = solveDuplicateKey(piloto, connection);
            } else if (!rollback){

                try {
                    System.err.println("Rollback...");
                    connection.rollback();

                } catch (SQLException ex) {

                    System.err.println("Error rolling back the transaction. 08 \n Error: " + ex.getMessage());

                }
            }

            try {

                connection.setAutoCommit(true);

            } catch (SQLException exx) {

                System.err.println("Error setting the autocommit to true. 09 \n Error: " + exx.getMessage());

            }
        }
        return false;
    }

    private static boolean solveDuplicateKey(Piloto piloto, Connection connection) {
        piloto.setCode(piloto.getSurname().substring(0, 2) + piloto.getForename().charAt(0));
        System.out.println("Solve" + piloto);
        if (pilotoInsert(piloto, connection)){
            return true;
        }
        return false;
    }


    public void transaccion(Piloto piloto1, Piloto piloto2, Connection connection) {
        if (!existsConstructor) {
            constructorInsert(piloto1, connection);
        }
        pilotoInsert(piloto1, connection);
        pilotoInsert(piloto2, connection);
    }

    /**
     * Deletes the rows that were inserted in the database.
     *
     * @param connection Connection to the database.
     */
    public void deleteIfExists(Connection connection) {
        PreparedStatement delete;
        String sql;

        sql = "DELETE FROM drivers WHERE code = ?";

        try {

            delete = connection.prepareStatement(sql);
            delete.setString(1, "nor");
            delete.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error creating the query. 10 \n Error: " + e.getMessage());

        }

        try {

            delete = connection.prepareStatement(sql);
            delete.setString(1, "sai");
            delete.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error creating the query. 11 \n Error: " + e.getMessage());

        }

        sql = "DELETE FROM constructors WHERE constructorref = ?";
        try {

            delete = connection.prepareStatement(sql);
            delete.setString(1, "mclaren");
            delete.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error creating the query. 12 \n Error: " + e.getMessage());

        }
    }
}

