package livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {

    private static final ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();
    private static final ThreadLocal<DAOFactory> threadLocalFactory = new ThreadLocal<>();
    private static final String URL = "jdbc:postgresql://192.168.200.83:5432/treinamento?currentSchema=treinamentovitor";
    private static final String USER = "treinamentovitor";
    private static final String PSWD = "123";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void newTransactionScope() {
        try {
            Connection conn = openConnection();
            conn.setAutoCommit(false);
            threadLocalConn.set(conn);
            threadLocalFactory.set(new DAOFactory(conn));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void endTransactionScope(boolean commit) {
        try (Connection conn = threadLocalConn.get()) {
            if (commit) {
                conn.commit();
            } else {
                conn.rollback();
            }

            threadLocalConn.set(null);
            threadLocalFactory.set(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    public static DAOFactory dAOFactory(){
        return threadLocalFactory.get();
    }
    private static synchronized Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PSWD);
    }
}
