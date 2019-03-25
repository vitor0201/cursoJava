package livraria.dao;

import java.sql.Connection;

public class DAOFactory {

    private Connection conn;

    private UsuarioDAO usuarioDAO;

    private LivroDAO livroDAO;

    public DAOFactory(Connection conn) {
        this.conn = conn;
    }

    public UsuarioDAO getUsuarioDAO() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO(conn);
        }
        return usuarioDAO;
    }

    public LivroDAO getLivroDAO() {
        if (livroDAO == null) {
            livroDAO = new LivroDAO(conn);
        }
        return livroDAO;
    }
}
