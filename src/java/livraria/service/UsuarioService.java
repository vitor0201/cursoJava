package livraria.service;

import livraria.dao.ConnectionManager;
import livraria.dao.UsuarioDAO;
import livraria.entity.Usuario;

public class UsuarioService extends Service {

    public Usuario login(String email, String senha) {
        ConnectionManager.newTransactionScope();

        UsuarioDAO usuarioDAO = ConnectionManager.dAOFactory().getUsuarioDAO();
        Usuario usuario = usuarioDAO.getUsuarioByEmail(email);

        if (usuario != null && !usuario.getSenha().equals(senha)) {
            usuario = null;
        }
        ConnectionManager.endTransactionScope(true);
        return usuario;
    }
}
