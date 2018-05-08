<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" commandName="addFlashCard">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="wordName">Description</form:label>
			<form:input path="wordName" type="text" class="form-control"
				required="required" />
			<form:errors path="wordName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="wordDefinition">Word Definition</form:label>
			<form:input path="wordDefinition" type="text" class="form-control"
				required="required" />
			<form:errors path="wordDefinition" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>