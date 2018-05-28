<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/jsp/common/header.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Words</caption>
		<thead>
			<tr>
				<th>Word</th>
				<th>Definition</th>
				<th>Part Of Speech</th>

				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${words}" var="word">
				<tr>
					<td>${word.word}</td>

					<td>${word.definition}</td>
					<td>${word.pos}</td>
					<td><a type="button" class="btn btn-success"
						href="/word/update?id=${word.id}">Update</a></td>
					<td><a type="button" class="btn btn-warning"
						href="/word/delete?id=${word.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="button" href="/word/create">Add a Word</a>
	</div>
</div>
<%@ include file="/WEB-INF/jsp/common/footer.jspf"%>