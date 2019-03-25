<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="livraria.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<fmt:setLocale value="pt_BR" />
<h3>Pesquisar Livros</h3>

<table>
    <form method="get" action="PesquisarLivros"> 
        <tr>
            <td>Titulo:</td>
            <td><input type="text" name="titulo"/></td>
        </tr>
        <tr>
            <td>Autor:</td>
            <td><input type="text" name="autor" /></td>
        </tr>
        <tr><input type="submit" value="Pesquisa ai!" class="button"/></tr>
</table>
</form>

<c:forEach var="livro" items="${livros}">
    <span class="livro_titulo">${livro.titulo}</span><br/><br/>
    <span class="livro_autor">${livro.autor}</span><br/><br/>
    <span class="livro_info">${livro.editora}, ${livro.ano}</span><br/><br/>
    <span class="livro_preco"><fmt:formatNumber value="${livro.preco}" type="currency" /></span><br/><br/>
    <a href="Carrinho?op=inserir&id=${livro.id}">Adicoinar este livro carrinho</a>
</c:forEach>

<jsp:include page="footer.jsp" />