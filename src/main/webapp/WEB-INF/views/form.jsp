<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<%@ include file="nav.jsp" %>
<h2>Add book</h2>
<form:form action="/books/save" modelAttribute="book" method="post">
    <form:hidden path="id" id="id"/>

    <label for="author">Author:</label>
    <form:input path="author" id="author" required="true"/><br><br>

    <label for="title">Title:</label>
    <form:input path="title" id="title" required="true"/><br><br>

    <label for="isbn">ISBN:</label>
    <form:input path="isbn" id="isbn" required="true"/><br><br>

    <label for="publisher">Publisher:</label>
    <form:input path="publisher" id="publisher" required="true"/><br><br>

    <label for="type">Type:</label>
    <form:input path="type" id="type" required="true"/><br><br>

    <button type="submit">Submit</button>
</form:form>
</body>
</html>
