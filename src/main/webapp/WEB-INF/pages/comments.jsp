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
					<th>PostId</th>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Body</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments }" var="comment">
					<tr>
						<td>${comment.postId }</td>
						<td>${comment.id }</td>
						<td>${comment.name }</td>
						<td>${comment.email }</td>
						<td>${comment.body }</td>
						<td>
							<a href="${pageContext.request.contextPath}/viewcomment/${comment.id}" target="_blank">comment</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>