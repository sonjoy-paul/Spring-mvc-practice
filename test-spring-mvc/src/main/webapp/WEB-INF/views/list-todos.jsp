
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">

		Hi ${name} <br />

		<table class="table table-striped">
			<caption>Your Todos are</caption>
			<thead>
				<th>Id no</th>
				<th>User Name</th>
				<th>Description</th>
				<th>Date</th>
				<th>Is completed?</th>
			</thead>


			<tbody>

				<c:forEach items="${todos }" var="todo">
					<br />

					<tr>
						<td>${todo.id}</td>
						<td>${todo.user}</td>
						<td>${todo.desc }</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
						<td>NO</td>
						<td><a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
						<td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>


		</table>





		<di>
			 <a class="btn btn-success" href=/add-todo>ADD</a>
		</di>
	</div>

	
	<%@ include file="common/footer.jspf" %>