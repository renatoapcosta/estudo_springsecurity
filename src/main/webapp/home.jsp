<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<%
    String txtInicial = "Pagina Home";
%>
<h1><%=txtInicial%></h1>


<h2>Protegida</h2>

<a href="index.jsp">Ir para index</a><br />
<a href="admin.jsp">Ir para admin</a><br />
<a href="servlet.do">Ir para Servlet</a><br />


<a href="j_spring_security_logout">Logout</a>

</body>
</html>
