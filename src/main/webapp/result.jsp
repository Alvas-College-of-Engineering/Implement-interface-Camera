<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>

<body style="text-align:center; background-color:lightgreen;">

<h2>Result</h2>

<%
String res = (String) request.getAttribute("result");
if(res == null){
    res = "No Result Found";
}
%>

<h3><%= res %></h3>

<br>

<a href="index.jsp">Go Back</a>

</body>
</html>