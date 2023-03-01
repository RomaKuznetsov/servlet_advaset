package connection;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class PoolConnectionMySQL implements CloseConnectionMySQL {
    MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
    private Connection connection;
    private DriverManager driverManager;
    private BlockingQueue<Connection> queConnection = new ArrayBlockingQueue<>(5000);

    private BlockingQueue<Connection> getNewConnections() {
        try {
            if (queConnection.size() < 2500) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = driverManager.getConnection(PropertyMySQL.setMyURL(), PropertyMySQL.createProperty());
                queConnection.put(connection);
            }
        } catch (SQLException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return queConnection;
    }

    public Connection takeConnection() {
        try {
            connection = getNewConnections().take();
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deregisterDriver() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                driverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}