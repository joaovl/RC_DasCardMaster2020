package GameAbstractFactory.gateways;

import java.sql.*;

/**
 * Created by Joao on 23/02/2016.
 */
public class ResultsGateway {

    public boolean insert(int id_player, int score, int score_other, String game) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            statement.executeUpdate("insert into results values(" + id_player + ", " + score + ", " + score_other + ", '" + game + "')");
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
