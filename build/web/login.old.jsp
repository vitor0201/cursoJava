<%@page import="livraria.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<h3>LOGIN</h3>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String erro = (String) session.getAttribute("erro");
    String email = (String) request.getAttribute("email");
    if (usuario != null) {%>
<h4>Vc está logado <%= usuario.getNome() %> </h4>
<a href="logout">Clique para deslogar </a>

<%
} else {
    if (erro != null) {%>
<span class="erro" > <%= erro %></span>  
<%    }
    }
%>
<%
    if (erro != null) {
%>
<span class="erro"><%= erro%></span>
<%   }
%>
<table>
    <form method="post" action="login"> 
        <tr>
            <td>E-Mail:</td>
            <td><input type="text" name="email" value="<%= email != null ? email : ""%>" /></td>
                       </tr>
                       <tr>
                       <td>E-Mail:</td>
                       <td><input type="password" name="senha" /></td>
        </tr>
        <tr><input type="submit" value="login" class="button"/></tr>
</table>
</form>
<jsp:include page="footer.jsp" />