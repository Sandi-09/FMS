<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                                <li class="nav-item"><a class="nav-link active" href="#">User Transaction Page</a></li>
                            </ul>
                        </div>
                        <form class="d-flex">
                            &nbsp;&nbsp; <a class="btn btn-light btn-sm mt-3" href="/log-out">Log-out</a>
                        </form>
                    </div>
                    </div>
                </nav>

                <h1 class="text-center">Update Transaction Fraud Complaint</h1>
                <div class="container">
                    <form:form method="post" modelAttribute="transaction">
                        <fieldset class="form-group">
                            <form:label path="cardNo">Enter Card Number</form:label>
                            <form:input class="form-control" type="Number" path="cardNo" placeholder="Card Number" autofocus="true" required="true" />
                            <form:errors path="cardNo" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="userId">Enter User Id</form:label>
                            <form:input class="form-control" type="text" path="userId" placeholder="User Id" autofocus="true" required="true" />
                            <form:errors path="userId" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="cardHolderName">Enter Card Holder Name</form:label>
                            <form:input class="form-control" type="text" path="cardHolderName" placeholder="Card Holder Name" autofocus="true" required="true" />
                            <form:errors path="cardHolderName" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="accNo">Enter Account Number</form:label>
                            <form:input path="accNo" type="Number" class="form-control" placeholder="Account Number" required="required" />
                            <form:errors path="accNo" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group ">
                            <form:label path="expiryDate">Enter Expiry Date</form:label>
                            <form:input class="form-control " type="text" path="expiryDate" placeholder="Expiry Date" required="true " />
                            <form:errors path="expiryDate" cssClass="text-warning " />
                        </fieldset>

                        <fieldset class=" form-group ">
                            <form:label path="cardType">Card Type</form:label>
                            <form:select path="cardType" cssClass="form-select ">
                                <option value="">Select Your Card Type</option>
                                <option value="Credit">Credit Card</option>
                                <option value="Debit">Debit Card</option>
                            </form:select>
                            <form:errors path="cardType" cssClass="text-warning " />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="transDate">Select Transaction Date</form:label>
                            <form:input path="transDate" type="text" class="form-control" placeholder="Transaction Date" required="required" />
                            <form:errors path="transDate" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="transDetails">Enter Transaction Details</form:label>
                            <form:input class="form-control" type="text " path="transDetails" placeholder="Transaction Details" required="true" />
                            <form:errors path="transDetails" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="remarks">Enter Remarks</form:label>
                            <form:input class="form-control" type="text " path="remarks" placeholder="Remarks" required="true" />
                            <form:errors path="remarks" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class=" form-group ">

                            <form:select path="fraudLevel" cssClass="form-select" hidden="hidden">
                                <option value=" ">Select Level</option>
                                <option value="Low">Low</option>
                                <option value="Medium">Medium</option>
                                <option value="High">High</option>
                            </form:select>
                            <form:errors path="cardType" cssClass="text-warning " />
                        </fieldset>

                        <fieldset class=" form-group ">
                            <form:label path="blocked">Card Status</form:label>
                            <form:select path="blocked" cssClass="form-select ">
                                <option value="">Select Card Status</option>
                                <option value="">UnBlocked</option>
                                <option value="">Blocked</option>
                            </form:select>
                            <form:errors path="cardType" cssClass="text-warning" />
                        </fieldset>
                        <button class="btn btn-success " type="submit">Submit</button>
                    </form:form>