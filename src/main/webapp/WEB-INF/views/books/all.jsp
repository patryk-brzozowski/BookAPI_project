<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 09.07.2021
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Book List</title>
</head>
<body>

<table border="1">
  <thead>
  <th>isbn</th>
  <th>title</th>
  <th>author</th>
  <th>publisher</th>
  <th>actions</th>
  </thead>
  <tbody>
  <c:forEach items="${books}" var="book">
    <tr>
      <td><c:out value="${book.isbn}"/></td>
      <td><c:out value="${book.title}"/></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.publisher}"/></td>
      <td>
        <a href="/admin/books/${book.id}">show</a>
        <a href="/admin/books/edit/${book.id}">edit</a>
        <a href="/admin/books/delete/${book.id}">delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="/admin/books/add">Add new book</a> <br/>
<a href="/admin/books/all">Show all books</a>
</body>
</html>