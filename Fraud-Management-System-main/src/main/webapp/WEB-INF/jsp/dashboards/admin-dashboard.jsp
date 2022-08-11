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
				<li class="nav-item"><a class="nav-link active"
					href="/admin-login">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="/personnel-login">Fraud Analysis Personnel</a></li>
				<li class="nav-item"><a class="nav-link" href="/Userlogin">User</a></li>
                <li class="nav-item"><a class="nav-link"
					href="/pending-requests">Pending Requests</a></li>
			</ul>
		</div>
		       <form class="d-flex mt-3">
              &nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
            </form>
	</div>
</nav>

<div class="container">
        <h1 class="text-center">Welcome ${admin.userId}</h1>
        ${errorMessage}
        <a href="/all-card-fraud"><input class="btn btn-success mt-3" type="submit" value="Credit/Debit Frauds"></a>
        <a href="/all-transaction-fraud"><input class="btn btn-success mt-3" type="submit" value="Transaction Frauds"></a>
        <a href="/all-claim-fraud"><input class="btn btn-success mt-3" type="submit" value="Claims Frauds"></a>
        <a href="manage-fraud"><input class="btn btn-success mt-3" type="submit" value="Manage Frauds"></a>
</div>

