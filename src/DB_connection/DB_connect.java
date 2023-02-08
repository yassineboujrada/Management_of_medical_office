package DB_connection;
import java.sql.*;

public class DB_connect {
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try{
                String db = "jdbc:oracle:thin:@localhost:1521:xe";
                connection = DriverManager.getConnection(db, "tp_java", "java");
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return connection;
    }
}
