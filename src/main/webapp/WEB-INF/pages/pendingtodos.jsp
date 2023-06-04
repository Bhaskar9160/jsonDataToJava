<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<table>
			<tr>
				<th>Id</th>
				<td>${user.id }</td>
			</tr>
			<tr>
				<th></th>
			</tr>
		</table>
		<table>
			<thead>
				<tr>
					<th>UserId</th>
					<th>Id</th>
					<th>Title</th>
					<th>Completed</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.userId }</td>
						<td>${todo.id }</td>
						<td>${todo.title }</td>
						<td>${todo.completed }</td>
						
						<td>
							<a href="${pageContext.request.contextPath}/viewpendingtodo/${todo.id}" target="_blank">pendingtodo"></a>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>