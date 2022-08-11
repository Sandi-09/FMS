<%@ include file="common/header.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
					href="/pending-requests">Critical Claim Frauds</a></li>
			</ul>
		</div>
		       <form class="d-flex mt-3">
              &nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
            </form>
	</div>
</nav>




<div>

<h3 align="center">Showing critical claims</h3>
 			
	
	<table class="table caption-top table-striped">
		<caption>Critical Claims</caption>
		<thead >
			<tr>
				<td>User ID</td>
				<td>Name</td>
				<td>ACC.No</td>
				<td>Transaction Date</td>
				<td>Risk Level</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${claimList}" var="c">
				<tr>
					<td>${c.userId}</td>
					<td>${c.cardHolderName}</td>
					<td>${c.accNo}</td>
					<td>${c.transDate}</td>
					<td>${c.fraudLevel}</td>
					<td><div class="btn-group" role="group" aria-label="Action">
					 <a  href="#" class="btn btn-success">Approve</a>
					 &nbsp;&nbsp;
					 <a  href="#" class="btn btn-danger">Disapprove</a>
					</div>
					</td>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>



	
