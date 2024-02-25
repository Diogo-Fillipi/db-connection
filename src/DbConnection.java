import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection{

    private static final String url = "jdbc:mysql://localhost:3306/[yourDataBaseName]";

    private static final String user = "[yourUser]";

    private static final String password = "[yourPassword]";

    private static Connection conn;

    public static Connection getConnection(){

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }



    }



}