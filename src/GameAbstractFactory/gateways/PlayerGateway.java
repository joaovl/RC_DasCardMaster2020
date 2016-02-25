package GameAbstractFactory.gateways;

import java.sql.*;

/**
 * Created by Joao on 23/02/2016.
 */
public class PlayerGateway {
    public Player find(String user_name) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from player where name = '" + user_name + "'");

            if (rs.next()) {
                Player p = new Player();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));

                return p;
            } else {
                return null;
            }
        }catch (Exception ex) {
            System.err.println(ex);
            return null;
        }finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    public boolean insert(int id, String user_name, String pass_word) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            statement.executeUpdate("insert into player values(" + id + ", '" + user_name + "', '" + pass_word + "')");
            return true;
        }catch (Exception ex) {
            System.err.println(ex);
            return false;
        }finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
