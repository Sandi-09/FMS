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
                <li class="nav-item"><a class="nav-link active"
					href="/pending-requests">Personnel Dashboard</a></li>
			</ul>
		</div>
		       <form class="d-flex mt-3">
              &nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
            </form>
	</div>
</nav>
<h1>Fraud Personnel Dashboard</h1>
 ${errorMessage}
 <a href="/claim-registration"><input class="btn btn-success mt-3" type="submit" value="Add Claim Fraud"></a>
 <a href="/all-card-fraud"><input class="btn btn-warning mt-3" type="submit" value="View Cards"></a>
  <a href="/all-transaction-fraud"><input class="btn btn-warning mt-3" type="submit" value="View transactions"></a>
 <a href="/claim-show"><input class="btn btn-warning mt-3" type="submit" value="View Claims"></a>
 
 <!-- <a href="/card-update"><input class="btn btn-success mt-3" type="submit" value="Update Card Fraud"></a>
 <a href="/card-delete?id=${user.userId}"><input class="btn btn-warning mt-3" type="submit" value="Delete Card Fraud"></a> -->