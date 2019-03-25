package livraria.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david
 */
public abstract class BaseServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req, resp);
        try {
            processGet();
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    protected void processGet() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req, resp);

        try {
            processPost();
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    protected void processPost() throws Exception {
        throw new UnsupportedOperationException();

    }

    private void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected HttpSession session() {
        return request.getSession();
    }

    protected void forward(String path) throws Exception {
        request.getRequestDispatcher(path).forward(request, response);
    }

    protected void redirect(String path) throws Exception {
        String contextRoot = request.getContextPath();
        response.sendRedirect(contextRoot + "/" + path);
    }
}
