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
				
				<li class="nav-item"><a class="nav-link" href="/Userlogin">User</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Claim Dashboard</a></li>
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
</nav>

<div class="container">
	<h1 class="text-center">Welcome ${user.userId}</h1>

	<table class="table caption-top table-striped">
		<caption>User Claims are</caption>
		<thead>
			<tr>
				<td>User ID</td>
				<td>Name</td>
				<td>Ac/No</td>
				<td>Card No</td>
				<td>Risk level</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${claim}" var="c">
				<tr>
					<td>${c.userId}</td>
					<td>${c.cardHolderName}</td>
					<td>${c.accNo}</td>
					<td>${c.cardNo}</td>
					<td>${c.fraudLevel}</td>
					<td><a href="/claim-updateForm?userId=${c.userId}" type="button"
						class="btn btn-success">Update</a></td>
					<td><a href="/claim-delete?userId=${c.userId}" type="button"
						class="btn btn-warning">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>