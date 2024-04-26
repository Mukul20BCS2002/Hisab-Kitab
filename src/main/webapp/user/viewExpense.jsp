<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ExpenseDao"%>
<%@page import="com.db.HibernateUtil"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expense</title>
<%@include file="../component/all_css_js.jsp"%>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3)
}
</style>
</head>
<body>
<c:if test="${empty loginUser }">
<c:redirect url="../login.jsp"></c:redirect>
</c:if>
	<%@include file="../component/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card card-sh">
					<div class="card-header text-center">
						<p class="text-center fs-3">All Expenses</p>
						<c:if test="${not empty msg }">
						<p class="text-center text-success fs-4">${msg }</p>
						<c:remove var="msg"/>
						</c:if>
					</div>
					<div class="card-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
								    <th scope="col">S. No.</th>
									<th scope="col">Title</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Price</th>
									<th scope="col">Description</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							<%
							User user = (User)session.getAttribute("loginUser");
							ExpenseDao expensedao = new ExpenseDao(HibernateUtil.getSessionFactory());
							List<Expense>list = expensedao.getAllEntry(user);
							int count = 0;
							for(Expense expense:list)
							{count++;%>
							<tr>
							        <th scope="row"><%=count %></th>
									<td><%=expense.getTitle() %></td>
									<td><%=expense.getDate() %></td>
									<td><%=expense.getTime() %></td>
									<td><%=expense.getPrice() %></td>
									<td><%=expense.getDescription() %></td>
									<td>
									<a href="editExpense.jsp?id=<%=expense.getId() %>" class="btn btn-sm btn-success me-1">Edit</a>
									<a href="../removeExpense?id=<%=expense.getId() %>" class="btn btn-sm btn-danger me-1">Remove</a>
									</td>
								</tr>
							<% }
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>