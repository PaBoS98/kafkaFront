<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>kafka_send</title>
</head>
<body>
<h1>Send a Message</h1>
<form action="onsend" method="post">
    Specify age:<textarea name="age">0</textarea>
    Specify name:<textarea name="name">Name</textarea>
    <br>
    <input type="submit" value="Submit">
</form>

<h2><a href="${pageContext.request.contextPath}/welcome">RETURN HOME</a></h2>

</body>
</html>