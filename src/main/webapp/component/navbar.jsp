<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i
			class="fa-solid fa-sack-dollar"></i> Expense Tracker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"><i
						class="fa-solid fa-house-user"></i> Home</a></li>
				<c:if test="${not empty loginUser }">
					<li class="nav-item"><a class="nav-link active"
						href="addExpense.jsp"><i class="fa-solid fa-plus"></i> Add
							Expense</a></li>

					<li class="nav-item"><a class="nav-link active"
						href="viewExpense.jsp" tabindex="-1"><i
							class="fa-solid fa-list"></i> View Expense</a></li>
				</c:if>
			</ul>

		</div>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<c:if test="${not empty loginUser}">
					<li class="nav-item"><a class="nav-link active" href="#">
							<i class="fa-solid fa-circle-user"></i> ${loginUser.name }
					</a></li>

					<li class="nav-item"><a class="nav-link active"
						href="../logout" tabindex="-1"><i
							class="fa-solid fa-right-to-bracket"></i> Logout</a></li>
				</c:if>
				<c:if test="${empty loginUser }">
					<li class="nav-item"><a class="nav-link active"
						href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i>
							Login</a></li>

					<li class="nav-item"><a class="nav-link active"
						href="register.jsp" tabindex="-1"><i
							class="fa-solid fa-user-plus"></i> Register</a></li>
				</c:if>
			</ul>

		</div>
	</div>
</nav>