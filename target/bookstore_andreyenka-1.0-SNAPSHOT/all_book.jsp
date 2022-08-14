<%@ page contentType="text/html;UTF-8" language="java" %>
<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <style>.table {
            width: 300 px;
            border: 2px solid;
               }
              td {
              text-align: center;
              }
    </style>
        <body>
            <table align=center class="table">
            <tr>
            <th>#</th>
            <th>Title</th>
            <th>Author</th>
            <th>Year Publishing</th>$
            </tr>
            <c:forEach items="${books}" var="book" varStatus="counter">
            <tr>
            <td>${counter.count}</td>
            <td>${book.book_name}</td>
            <td>${book.author}</td>
            <td>${book.year_publishing}</td>
            </tr>
            </c:forEach>
            </table>
        </body>
    </head>
</html>