<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="livraria.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<h3>LOGIN</h3>

<c:if test="${usuario != null}">
    <h4>Vc está logado ${usuario.nome} </h4>
    <a href="logout">Clique para deslogar </a>
</c:if>
<c:if test="${usuario == null}">
    <c:if test="${erro != null}">
        <span class="erro" > ${erro}</span>  
    </c:if>
</c:if>

<table>
    <form method="post" action="Login"> 
        <tr>
            <td>E-Mail:</td>
            <td><input type="text" name="email" value="${email}" /></td>
        </tr>
        <tr>
            <td>E-Mail:</td>
            <td><input type="password" name="senha" /></td>
        </tr>
        <tr><input type="submit" value="login" class="button"/></tr>
</table>
</form>
<jsp:include page="footer.jsp" />