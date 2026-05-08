<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile System</title>
</head>

<body style="text-align:center; background-color:lightblue;">

<h2>Mobile Camera System</h2>

<form action="MobileServlet" method="post">

    Brand:
    <input type="text" name="brand" required>

    <br><br>

    <input type="radio" name="action" value="photo" required> Photo
    <input type="radio" name="action" value="video"> Video

    <br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>