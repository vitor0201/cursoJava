package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    protected PreparedStatement stmt(String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    protected String nextValString() {
        return "nextval('generator_sequence')";
    }
}
