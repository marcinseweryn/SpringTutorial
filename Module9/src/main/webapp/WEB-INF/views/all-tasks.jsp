<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<spring:message code="welcome"/> 
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
		<td><spring:message code="task.subject"/> </td>
		<td>
			<form:input path="subject"/>
			<form:errors path="subject"/>
		</td>
	</tr>
	<tr>
		<td><spring:message code="task.startDate"/> </td>
		<td>
			<form:input path="startDate"/>
			<form:errors path="startDate"/>
		</td>
	</tr>
	<tr>
		<td><spring:message code="task.closeDate"/> </td>
		<td>
			<form:input path="closeDate"/>
			<form:errors path="closeDate"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="<spring:message code="submit"/>"/>
		</td>
	</tr>	

</table>
</form:form>



</body>
</html>
