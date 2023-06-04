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
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${albums }" var="album">
					<tr>
						<td>${album.userId }</td>
						<td>${album.id }</td>
						<td>${album.title }</td>
						<td>
							<a href="${pageContext.request.contextPath}/viewalbum/${album.id}" target="_blank">album</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>