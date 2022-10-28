import java.sql.*;
import java.util.Date;

public class Commons {
    public Statement getStatement() {
        String url = "jdbc:mysql//localhost:3306/toys_JavaWithDB";
        String user = "root";
        String password = "*khacademy!";
        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public String getGeneratorID() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        
        return null;
    }

}
