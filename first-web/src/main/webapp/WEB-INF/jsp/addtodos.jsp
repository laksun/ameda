<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<body>
	Hi ${name}: Add Todos here
	<div class="container">
		<form:form method="post" modelAttribute="todo">
		    <form:hidden path="id"/>
		    
			<fieldset class="form-group">
				<form:label path="desc"> Description </form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="targetDate"> Target Date </form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	
<%@ include file="common/footer.jspf" %>