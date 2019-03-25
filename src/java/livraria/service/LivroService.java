package livraria.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import livraria.dao.ConnectionManager;
import livraria.dao.LivroDAO;
import livraria.entity.Livro;

public class LivroService extends Service {

    public List<Livro> pesquisarLivros(String titulo, String autor) {

        ConnectionManager.newTransactionScope();

        LivroDAO livroDAO = ConnectionManager.dAOFactory().getLivroDAO();
        Set<Livro> livros = new LinkedHashSet<>();

        if (titulo != null && !titulo.isEmpty()) {
            livros.addAll(livroDAO.getLivroByAutor(autor));
        }

        if (autor != null && !autor.isEmpty()) {
            livros.addAll(livroDAO.getLivroByTitulo(titulo));
        }

        ConnectionManager.endTransactionScope(true);

        return new ArrayList<>(livros);
    }
}
