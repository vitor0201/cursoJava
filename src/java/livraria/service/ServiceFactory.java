package livraria.service;

public class ServiceFactory {

    private static ServiceFactory instance;

    private UsuarioService usuarioService;

    private LivroService livroService;

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public UsuarioService getUsuarioService() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }
        return usuarioService;
    }

    public LivroService getLivroService() {
        if (livroService == null) {
            livroService = new LivroService();
        }
        return livroService;
    }
}
