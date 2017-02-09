<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Test</title>
</head>
<body>
<h1>Data: ${data}</h1>
<center style="margin-top: 150px">
	<form enctype='application/json' action="test" method="post">
	<table>
		<tr>
			<td>Name: </td>
			<td><input type="text" name="name" /> </td>
		</tr>
	</table>
	<input value="Insert" type="submit"/>
	</form>
	<br><p>Data</p>
	<table>
	<c:forEach var="testEntity" items="${testEntities}">
		<tr>
			<td>${testEntity.id}</td>
			<td>${testEntity.name}</td>
			<td><a href="${pageContext.request.contextPath}/delete/${testEntity.id}">  < X >  Delete</a></td>
			<td><a href="${pageContext.request.contextPath}/update/${testEntity.id}">  < ~ >  Update</a></td>
		</tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>