package utils;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class DataSource {

    private final String SERVER_NAME = "localhost";
    private final int DEFAULT_PORT = 3306;
    private final String DB_NAME = "webuy-db";
    private final String USERNAME = "matt";
    private final String PASSWORD = "9b7-RcJ-rTf-dQ9";

    private static DataSource instance;
    private MysqlDataSource dataSource;

    public static DataSource getInstance() {
        if(instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public DataSource() {
        // TODO Auto-generated constructor stub

        dataSource = new MysqlDataSource();

        dataSource.setServerName(SERVER_NAME);
        dataSource.setPortNumber(DEFAULT_PORT);
        dataSource.setDatabaseName(DB_NAME);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() throws SQLException {
        getConnection().close();
    }

    public Optional<ResultSet> execute(String query) throws SQLException {
        Statement statement = getConnection().createStatement();
        Optional<ResultSet> result = Optional.of(statement.executeQuery(query));
        return result;
    }
}
