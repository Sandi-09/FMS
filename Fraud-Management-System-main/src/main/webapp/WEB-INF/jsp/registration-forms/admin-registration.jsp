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
				<li class="nav-item"><a class="nav-link" href="/admin-login">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="/personnel-login">Fraud Analysis Personnel</a></li>
			</ul>
		</div>
	</div>
</nav>
<h1 class="text-center">Register as Admin</h1>
<div class="container">
	<form:form method="post" modelAttribute="claimOfficer">
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
			<form:label path="dOB">Date of Birth</form:label>
			<form:input path="dOB" type="text" class="form-control"
				placeholder="Your Date of Birth" required="true" />
			<form:errors path="dOB" cssClass="text-warning" />
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
			<form:label path="contact">Contact Number</form:label>
			<form:input class="form-control" type="text" path="contact"
				placeholder="Your Contact Number" required="true" />
			<form:errors path="contact" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="bankName">Email ID</form:label>
			<form:input class="form-control" type="email" path="bankName"
				placeholder="Enter Bank Name" required="true" />
			<form:errors path="bankName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="bankBranch">User ID</form:label>
			<form:input class="form-control" type="text" path="bankBranch"
				placeholder="Enter Bank's Branch Name" required="true" />
			<form:errors path="bankBranch" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine1">Password</form:label>
			<form:input class="form-control" type="password" path="addLine1"
				placeholder="Enter Your Address line 1" required="true" />
			<form:errors path="addLine1" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine2">Confirm Password</form:label>
			<form:input class="form-control" type="password" path="addLine2"
				placeholder="Enter Your Address line 2 (Optional)" />
		</fieldset>
		<button class="btn btn-success" type="submit">Submit</button>
	</form:form>
	<div>
		Already have an account? <a href="/admin-login">Click here</a> to
		Login
	</div>