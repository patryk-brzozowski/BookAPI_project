<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 09.07.2021
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
<form:form method="post" modelAttribute="book">

    <label for="title">Title:</label>
    <form:input path="title"/>  <form:errors path="title"/>
    <label for="isbn">Isbn:</label>
    <form:input path="isbn"/>  <form:errors path="isbn"/>
    <label for="author">Author:</label>
    <form:input path="author"/>  <form:errors path="author"/>
    <label for="type">Category:</label>
    <form:select path="type" items="${categories}" />  <form:errors path="type"/>
    <label for="publisher">Publisher:</label>
    <form:select path="publisher" items="${publishers}"/>  <form:errors path="publisher"/>
    <input type="submit" value="Save">

</form:form>
</body>
</html>
