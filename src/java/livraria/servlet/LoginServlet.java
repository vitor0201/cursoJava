package livraria.servlet;

import javax.servlet.annotation.WebServlet;
import livraria.entity.Usuario;
import livraria.service.ServiceFactory;
import livraria.service.UsuarioService;
import livraria.servlet.BaseServlet;

@WebServlet("/Login")
public class LoginServlet extends BaseServlet {

    @Override
    protected void processGet() throws Exception {
        forward("/login.jsp");
    }

    @Override
    protected void processPost() throws Exception{
        String email = getRequest().getParameter("email");
        String senha = getRequest().getParameter("senha");

        UsuarioService usuarioService = ServiceFactory.getInstance().getUsuarioService();
        Usuario usuario = usuarioService.login(email, senha);

        if (usuario == null) {
            session().setAttribute("erro", "Usuário/Senha incorretos");
            session().setAttribute("email", email);
            session().setAttribute("senha", senha);
            forward("/login.jsp");
            return;
        }

        session().setAttribute("usuario", usuario);
        redirect("usuarioLogado.jsp");
    }

}
