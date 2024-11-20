package activeRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Properties;

public class DBConnection {
    // variables de connection
    String userName = "root";
    String password = "";
    String serverName = "127.0.0.1";
    String portNumber = "3306";

    // il faut une base nommee testPersonne !
    String dbName = "testpersonne";

    Connection connect ;

    public DBConnection() {
        try {
            // chargement du driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creation de la connection
            Properties connectionProps = new Properties();
            connectionProps.put("user", userName);
            connectionProps.put("password", password);
            String urlDB = "jdbc:mysql://" + serverName + ":";
            urlDB += portNumber + "/" + dbName;
            System.out.println(urlDB);
            connect = DriverManager.getConnection(urlDB, connectionProps);
            //Connection connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testpersonne","scruzlara", "root2014");
        } catch (SQLException e) {
            System.out.println("*** ERREUR SQL ***");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("*** ERREUR lors du chargement du driver ***");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connect ;
    }
}
