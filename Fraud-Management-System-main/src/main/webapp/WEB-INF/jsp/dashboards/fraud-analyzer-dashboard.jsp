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
				<li class="nav-item"><a class="nav-link active" href="#">Fraud Analyzer Dashboard</a></li>
			</ul>
		</div>
			<form class="d-flex">
				&nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
			</form>
		</div>
	</div>
</nav>

<div class="container">
	<div class="container mt-3">
		<div class="row justify-content-center">
		<h3 class="text-center">Fraud Analyzer Dashboard</h3>
		</div>
	</div>

	
	<nav class="nav nav-pills nav-justified">
		<a class="nav-link active link bg-dark" aria-current="page" href="/card-fraud" style="margin: 20px; padding: 20px;">Credit/Debit Frauds</a>
		<a class="nav-link active link bg-dark" href="/transaction-fraud" style="margin: 20px; padding: 20px;">Transaction Frauds</a>
		<a class="nav-link active link bg-dark" href="/personnel-login" style="margin: 20px; padding: 20px;">Claims Fraud</a>
	</nav>
		
	
</div>
	

