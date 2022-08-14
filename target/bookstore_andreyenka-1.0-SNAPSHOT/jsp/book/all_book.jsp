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
            table tbody tr:nth-child(even){
                background: #f3f3f3;
            }
        </style>
        <body>
            <table>
            <tr>
            <th>#</th>
            <th>Title</th>
            <th>Author</th>
            <th>Year Publishing</th>
            </tr>
            <c:forEach items="${requestScope.all_book}" var="book" varStatus="counter">
            <tr>
            <td>${counter.count}</td>
            <td><a href="controller?command=book&id=${book.id}">${book.book_name}<a/></td>
            <td>${book.author}</td>
            <td>${book.year_publishing}</td>
            </tr>
            </c:forEach>
            </table>
        </body>
    </head>
</html>