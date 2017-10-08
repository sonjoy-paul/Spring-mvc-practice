
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Add a Todo</h1>


		<form:form method="post" commandName="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-worning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-worning" />
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>


	</div>

<%@ include file="common/footer.jspf"%>