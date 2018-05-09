<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" commandName="flashcard">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="word">Word</form:label>
			<form:input path="word" type="text" class="form-control"
				required="required" />
			<form:errors path="word" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="definition">Definition</form:label>
			<form:input path="definition" type="text" class="form-control"
				required="required" />
			<form:errors path="definition" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="type">Type</form:label>
			<form:input path="type" type="text" class="form-control"
				required="required" />
			<form:errors path="type" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="order">Order</form:label>
			<form:input path="order" type="text" class="form-control"
				required="required" />
			<form:errors path="order" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>