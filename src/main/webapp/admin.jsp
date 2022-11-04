<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin</title>
</head>
<body>

<%
  String txtInicial = "Pagina ADM";
%>
<h1><%=txtInicial%></h1>


<h2>Protegida</h2>

<a href="index.jsp">Ir para index</a><br />
<a href="home.jsp">Ir para home</a><br />
<a href="servlet.do">Ir para Servlet</a><br />

<a href="j_spring_security_logout">Logout</a>

</body>
</html>
