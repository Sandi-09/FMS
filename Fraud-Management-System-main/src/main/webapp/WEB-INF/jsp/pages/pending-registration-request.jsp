<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Fraud Management System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/admin-login">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="/personnel-login">Fraud Analysis Personnel</a></li>
				<li class="nav-item"><a class="nav-link" href="/Userlogin">User</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Pending Request</a></li>
			</ul>
		</div>
		<form class="d-flex mt-3">
			<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-light btn-sm" type="submit">Search</button>
			&nbsp;&nbsp; 
			<a class="btn btn-light btn-sm" href="/log-out">Logout</a>
		</form>
	</div>
		</div>
	</div>
</nav>

<div class="container">
	<h1 class="text-center">Welcome ${admin.userId}</h1>

	<table class="table caption-top table-striped">
		<caption>Pending Requests of User For Approval are</caption>
		<thead>
			<tr>
				<td>User ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${unApprovedUser}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td><a href="/approve-user?id=${user.id}" type="button"
						class="btn btn-success">Approve</a></td>
					<td><a href="/reject-user?id=${user.id}" type="button"
						class="btn btn-warning">Reject</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    <h1 class="text-center">${emptyList1}</h1>

	<div class="container">
	
		<table class="table caption-top table-striped">
			<caption>Pending Requests of Personnel For Approval are</caption>
			<thead>
				<tr>
					<td>Personnel ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${unApprovedPersonnel}" var="personnel">
					<tr>
						<td>${personnel.userId}</td>
						<td>${personnel.firstName}</td>
						<td>${personnel.lastName}</td>
						<td><a href="/approve-personnel?id=${personnel.id}" type="button"
							class="btn btn-success">Approve</a></td>
						<td><a href="/reject-personnel?id=${personnel.id}" type="button"
							class="btn btn-warning">Reject</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1 class="text-center">${emptyList2}</h1>