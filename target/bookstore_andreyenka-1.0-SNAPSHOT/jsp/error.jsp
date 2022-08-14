<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <h1 align="center" style="color:#ff0000">Ops...</h1>
    <c:if test="${requestScope.message!=null}">
        <h3 align="center" style="color:#0000ff"><em> ${requestScope.message}</em></h3>
    </c:if>
</head>
<body>
</body>
</html>
