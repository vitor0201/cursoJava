package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import livraria.entity.Usuario;

public class UsuarioDAO extends DAO {

    public UsuarioDAO(Connection conn) {
        super(conn);
    }

    public Usuario getUsuarioByEmail(String email) {
        try (PreparedStatement stmt = stmt("SELECT id, nome, email, senha FROM usuario WHERE email = ?")) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                
                return usuario;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }
}
