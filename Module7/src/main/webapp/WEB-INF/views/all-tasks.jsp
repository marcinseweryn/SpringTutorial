<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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


<form:form commandName="task">
<table>
	<tr>
		<td>Temat zadania</td>
		<td><form:input path="subject"/></td>
	</tr>
	<tr>
		<td>Data rozpoczecia</td>
		<td><form:input path="startDate"/></td>
	</tr>
	<tr>
		<td>Data zakonczenia</td>
		<td><form:input path="closeDate"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="Zatwierdz">
		</td>
	</tr>	

</table>
</form:form>



</body>
</html>
