<%@ page contentType="text/html;UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        table {
            width: 100%;
            border: none;
            margin-bottom: 20px;
        }

        table thead th {
            font-weight: bold;
            text-align: left;
            border: none;
            padding: 10px 15px;
            background: #d8d8d8;
            font-size: 14px;
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
        }

        table tbody td {
            text-align: left;
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
            padding: 10px 15px;
            font-size: 14px;
            vertical-align: top;
        }

        table thead tr th:first-child, .table tbody tr td:first-child {
            border-left: none;
        }

        table thead tr th:last-child, .table tbody tr td:last-child {
            border-right: none;
        }

        table tbody tr:nth-child(even) {
            background: #f3f3f3;
        }
    </style>
<body>
<h1 align="center" style="color:#ff0000">Users</h1>
<c:if test="${requestScope.message!=null}">
    <h3 align="center" style="color:#0000ff"><em> ${requestScope.message}</em></h3>
</c:if>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${requestScope.all_user}" var="user" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${user.firstName}</td>
            <td><a href="controller?command=user&id=${user.id}">${user.lastName}<a/></td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
</body>
</head>
</html>