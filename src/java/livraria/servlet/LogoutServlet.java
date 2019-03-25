package livraria.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/logout")
public class LogoutServlet extends BaseServlet {

    @Override
    protected void processGet() throws Exception {
        session().invalidate();
        forward("/login.jsp");
    }
}
