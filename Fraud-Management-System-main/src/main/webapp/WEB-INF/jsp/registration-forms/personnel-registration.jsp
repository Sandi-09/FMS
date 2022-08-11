<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<li class="nav-item"><a class="nav-link active" href="#">Personnel Registration Page</a></li>
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
<h1 class="text-center">Register as Fraud Analysis Personnel</h1>
<div class="container">
	<form:form method="post" modelAttribute="personnel">
		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input class="form-control" type="text" path="firstName"
				placeholder="Your First Name" autofocus="true" required="true" />
			<form:errors path="firstName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input class="form-control" type="text" path="lastName"
				placeholder="Your Last Name" required="true" />
			<form:errors path="lastName" cssClass="text-warning" />
		</fieldset>

    <fieldset class="form-group">
			<form:label path="dob">Date of Birth</form:label>
			<form:input path="dob" type="text" class="form-control"
				placeholder="Your Date of Birth" required="required" />
			<form:errors path="dob" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="gender">Gender</form:label>
			<form:select path="gender" cssClass="form-select">
				<option value="">Select Your Gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</form:select>
			<form:errors path="gender" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="contactNo">Contact Number</form:label>
			<form:input class="form-control" type="text" path="contactNo"
				placeholder="Your Contact Number" required="true" />
			<form:errors path="contactNo" cssClass="text-warning" />
		</fieldset>
    <fieldset class="form-group">
			<form:label path="userId">User ID</form:label>
			<form:input class="form-control" type="text" path="userId"
				placeholder="Create Your User-ID" required="true" />
			<form:errors path="userId" cssClass="text-warning" />
		</fieldset>
    <fieldset class="form-group">
			<form:label path="email">Email-Id</form:label>
			<form:input class="form-control" type="email" path="email"
				placeholder="Create Your Password" required="true" />
			<form:errors path="email" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="password">Password</form:label>
			<form:input class="form-control" type="password" path="password"
				placeholder="Create Your Password" required="true" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<button class="btn btn-success mt-3" type="submit">Submit</button>
	</form:form>
	<div>
		Already have an account? <a href="/personnel-login">Click here</a> to
		Login
	</div>
</div>