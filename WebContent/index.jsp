<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teste Inicial</title>
</head>
<body>
Bem vindo ao nosso gerenciador de Empresas! <br/>
<c:if test= "${not empty usuarioLogado }">
	Logado como ${usuarioLogado.email } <br/>
</c:if>
<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="NovaEmpresa"/>
	Nome: <input type="text" name="nome"/>
	<input type="submit" value="Enviar"/>
</form>
<br/>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Login"/>
	Email:  <input type="email" name="email"/>
	Senha: <input type="password" name="senha"/>
	<input type="submit" value="Enviar"/>
</form>
<br/>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout"/>
	<input type = "submit" value="Deslogar"/>

</form>
</body>
</html>