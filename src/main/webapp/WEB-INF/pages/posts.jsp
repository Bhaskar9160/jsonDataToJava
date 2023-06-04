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
				<th>Name</th>
				<td>${user.name }</td>
			</tr>
			<tr>
				<th>UserName</th>
				<td>${user.username }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${user.email}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${user.address}</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>${user.phone}</td>
			</tr>
			<tr>
				<th>Website</th>
				<td>${user.website }</td>
			</tr>
			<tr>
				<th>Company</th>
				<td>${user.company}</td>
			</tr>
		</table>
		<table>
			<thead>
				<tr>
					<th>UserId</th>
					<th>Id</th>
					<th>Title</th>
					<th>Body</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${posts }" var="post">
					<tr>
						<td>${post.userId }</td>
						<td>${post.id }</td>
						<td>${post.title }</td>
						<td>${post.body }</td>
						<td>
							<a href="${pageContext.request.contextPath}/viewpost/${post.id}" target="_blank">post</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>