package livraria.servlet;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import livraria.entity.Livro;
import livraria.service.LivroService;
import livraria.service.Service;
import livraria.service.ServiceFactory;

@WebServlet("/PesquisarLivros")
public class PesquisarLivrosServlet extends BaseServlet {

    @Override
    protected void processGet() throws Exception {

        String titulo = getRequest().getParameter("titulo");
        String autor = getRequest().getParameter("autor");

        if (autor == null && titulo == null) {
            forward("pesquisarLivros.jsp");
            return;
        }

        LivroService livroService = ServiceFactory.getInstance().getLivroService();

        List<Livro> livros = livroService.pesquisarLivros(titulo, autor);

        getRequest().setAttribute("livros", livros);

        forward("pesquisarLivros.jsp");
    }
}
