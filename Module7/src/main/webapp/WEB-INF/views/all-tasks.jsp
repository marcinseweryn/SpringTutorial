<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<h3>Zadania</h3>

<table>
<c:forEach items="${allTasks}" var="t">
	<tr>
		<td>${t.subject}</td>
	</tr>
</c:forEach>
</table>


</body>
</html>
