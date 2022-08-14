<%@ page contentType="text/html;UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <style>
            table {
                width: 100%;
                margin-bottom: 20px;
                border-collapse: collapse;
                outline: 3px solid #ffd300;
                font-size: 15px;
            }
            table th {
                font-weight: bold;
                padding: 7px;
                background: #ffd300;
                border: none;
                text-align: left;
                font-size: 15px;
                border-bottom: 3px solid #ffd300;
            }
            table td {
                padding: 7px;
                border: none;
            }
        </style>
        <body>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Year Publishing</th>
        </tr>
            <tr>
                <td>${requestScope.book.book_name}</td>
                <td>${requestScope.book.author}</td>
                <td>${requestScope.book.year_publishing}</td>
            </tr>
    </table>
        </body>
    </head>
</html>
