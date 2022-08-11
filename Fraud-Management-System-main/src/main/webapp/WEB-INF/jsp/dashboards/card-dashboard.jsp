<%@ include file="../common/header.jspf"%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Fraud Management System</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/admin-login">Admin</a></li>
					<li class="nav-item"><a class="nav-link " href="/personnel-login">Fraud Analysis Personnel</a></li>
					<li class="nav-item"><a class="nav-link" href="/Userlogin">User</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#"> Card Dashboard</a></li>
                </ul>
            </div>
            <form class="d-flex mt-3">
                &nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
            </form>
        </div>
        </div>
    </nav>

    <div class="container">

        <h1 class="text-center">Welcome ${user.userId}</h1>

        <table class="table caption-top table-striped">
            <caption>User Transactions are</caption>
            <thead>
                <tr>
                    <td>User ID</td>
                    <td>First Name</td>
                    <td>Account Number</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${card}" var="c">
                    <tr>
                        <td>${c.userId}</td>
                        <td>${c.cardHolderName}</td>
                        <td>${c.accNo}</td>
                        <td>${c.cardNo}</td>
                        <td><a href="/card-updateForm?id=${c.userId}" type="button" class="btn btn-success">Update</a></td>
                        <td><a href="/card-delete?id=${c.userId}" type="button" class="btn btn-warning">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>