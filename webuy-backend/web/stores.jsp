<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 5/7/20
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stores</title>
</head>
<body>
<form method="post" action="AddStoreServlet">
    <input type="text" placeholder="Name" name="storeName">
    <input type="file" name="storeLogo">
    <input type="submit" value="Add store">
</form>
</body>
</html>
