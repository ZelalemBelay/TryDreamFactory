<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script
			src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
<title>Test</title>
</head>
<body>
<h1>Data: ${data}</h1>
<center style="margin-top: 150px">
	<form enctype='application/json' action="test" method="post">
	<table>
		<tr>
			<td>Name: </td>
			<td><input id="name_id" type="text" name="name" /> </td>
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
			<td id="tdd${testEntity.id}">
					<script>
                        a = document.createElement('Button');

                        a.onclick = function(){
                            window.location = "${pageContext.request.contextPath}/update/${testEntity.id}?newValenc="+$("#name_id").val();
                        };
                        a.innerHTML = " ~ Update";
                        document.getElementById('tdd${testEntity.id}').appendChild(a);
					</script>
			</td>
		</tr>
	</c:forEach>
	</table>
	</center>

</body>
</html>