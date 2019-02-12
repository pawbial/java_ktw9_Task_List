<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-12
  Time: 00:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TasksList</title>
</head>
<body>

<h1> TASK LIST</h1>

<p> Please specify Your task content, status, and final date</p>

<form id="taskForm" method="post">
    <label for="date"><b>Date</b></label>
    <input type="date" id="date" name="date">
    <br>

    <label for="status"><b>Status</b></label>
        <select name="status" id="status">
            <option value="disabled selection">Select ...</option>
            <option><%= new Task().getStatusAsOption()%></option>
        </select>
    <br>
    <textarea rows="4" cols="50" name="comment" form="taskForm">
Task content here ...</textarea>
    <br>
    <input type="submit" value="submit">
</form>

</body>
</html>
