package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import livraria.entity.Livro;

public class LivroDAO extends DAO {

    public LivroDAO(Connection conn) {
        super(conn);
    }

    public List<Livro> getLivroByTitulo(String titulo) {
        try (PreparedStatement stmt = stmt("SELECT id, titulo, autor, editora, ano, preco FROM livro "
                + "WHERE upper(titulo) LIKE ?")) {
            stmt.setString(1, "%" + titulo.toUpperCase() + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                List<Livro> livros = new ArrayList<>();

                while (rs.next()) {
                    Livro livro = fromResultSet(rs);
                    livros.add(livro);
                }
                return livros;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Livro fromResultSet(final ResultSet rs) throws SQLException {
        Livro livro = new Livro();
        livro.setId(rs.getInt("id"));
        livro.setAutor(rs.getString("autor"));
        livro.setEditora(rs.getString("editora"));
        livro.setPreco(rs.getDouble("preco"));
        livro.setTitulo(rs.getString("titulo"));
        return livro;
    }

    public List<Livro> getLivroByAutor(String autor) {
        try (PreparedStatement stmt = stmt("SELECT id, titulo, autor, editora, ano, preco FROM livro "
                + "WHERE upper(autor) LIKE ?")) {
            stmt.setString(1, "%" + autor.toUpperCase() + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                List<Livro> livros = new ArrayList<>();

                while (rs.next()) {
                    Livro livro = fromResultSet(rs);
                    livros.add(livro);
                }
                return livros;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
