<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>User ID</th>
					<th>Company Name</th>
					<th>Person Name</th>
					<th>Details</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users }" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.company.name }</td>
						<td>${user.name }</td>
						<td>
							<table>
								<tr>
									<td>name:</td>
									<td>${user.name }</td>
								</tr>
								<tr>
									<td>username:</td>
									<td>${user.username }</td>
								</tr>
								<tr>
									<td>email:</td>
									<td>${user.email }</td>
								</tr>
								<tr>
									<td>street:</td>
									<td>${user.address.street }</td>
								</tr>
								<tr>
									<td>suite:</td>
									<td>${user.address.suite }</td>
								</tr>
								<tr>
									<td>city:</td>
									<td>${user.address.city }</td> 
								</tr>
								<tr>
									<td>zipcode:</td>
									<td>${user.address.zipcode }</td>
								</tr>
								<tr>
									<td>latitude:</td>
									<td>${user.address.geo.lat }</td>
								</tr>
								<tr>
									<td>longitude:</td>
									<td>${user.address.geo.lng }</td>
								</tr>
								<tr>
									<td>phone:</td>
									<td>${user.phone }</td>
								</tr>
								<tr>
									<td>website:</td>
									<td>${user.website }</td>
								</tr>
								<tr>
									<td>catchePhrase:</td>
									<td>${user.company.catchPhrase }</td>
								</tr>
								<tr>
									<td>bs:</td>
									<td>${user.company.bs}</td>
								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr>
									<td>
										<a href="userposts/${user.id }" target="_blank">Posts(${user.postCount })</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="usercomments/${user.id }" target="_blank">Comments(${user.commentCount })</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userstodos/${user.id }" target="_blank">Todos(${user.todosCount })</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userspendingtodos/${user.id }" target="_blank">PendingTodos(${user.pendingTodosCount })</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userscompletedtodos/${user.id }" target="_blank">CompltedTodos(${user.completedCount})</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="usersalbums/${user.id }" target="_blank">Albums(${user.albumsCount })</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>