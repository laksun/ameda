<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	

<body>
	Hi ${name}: Your Todos are
	<div class="container">
		<table class="table table striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${todos }" var="todo">

					<tr>
						<td>${todo.desc }</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
						<td>${todo.done }</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}"> Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}"> Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div>
		<a type="button" href="/add-todos" class="btn btn-success">Add
			Todos</a>
	</div>
<%@ include file="common/footer.jspf" %>