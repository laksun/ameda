<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Words</caption>
			<thead>
				<tr>
					<th>Word</th>
					<th>Definition</th>
					<th>Type</th>
					<th>Order</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${flashcards}" var="flashcard">
					<tr>
						<td>${flashcard.word}</td>
						<td><fmt:formatDate value="${flashcard.definition}" /></td>
						<td>${flashcard.type}</td>
						<td>${flashcard.order}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-flashcard?id=${flashcard.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-flashcard?id=${flashcard.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-flashcard">Add a Flashcard</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>