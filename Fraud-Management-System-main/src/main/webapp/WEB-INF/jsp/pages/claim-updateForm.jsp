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
                             <li class="nav-item"><a class="nav-link" href="/admin-login">Admin</a></li>
                             <li class="nav-item"><a class="nav-link " href="/personnel-login">Fraud Analysis Personnel</a></li>
                             <li class="nav-item"><a class="nav-link" href="/Userlogin">User</a></li>
                             <li class="nav-item"><a class="nav-link active" href="#">Claim Registration Page</a></li>
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
				  
				   <h1 class="text-center">Update Claim Details</h1>
                <div class="container">
                    <form:form method="post" modelAttribute="claim">
                    
                    <fieldset class="form-group">
                       <form:label path="userId">Enter Claim User Id</form:label>
                       <form:input path="userId" type="text" class="form-control" placeholder="Claim User Id" required="true"  />
                       <form:errors path="userId" cssClass="text-warning" />
                   </fieldset>
                        
                        <fieldset class="form-group">
                            <form:label path="cardNo">Enter Card Number</form:label>
                            <form:input class="form-control" type="Number" path="cardNo" placeholder="Card Number" autofocus="true" required="true" />
                            <form:errors path="cardNo" cssClass="text-warning" />
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <form:label path="cardHolderName">Enter Card Holder Name</form:label>
                            <form:input class="form-control" type="text" path="cardHolderName" placeholder="Card Holder Name" autofocus="true" required="true"  />
                            <form:errors path="cardHolderName" cssClass="text-warning" />
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <form:label path="accNo">Enter Account Number</form:label>
                            <form:input path="accNo" type="Number" class="form-control" placeholder="Account Number" required="required" />
                            <form:errors path="accNo" cssClass="text-warning" />
                        </fieldset>

                 
                        <fieldset class="form-group ">
                            <form:label path="expiryDate">Enter Expiry Date</form:label>
                            <form:input class="form-control " type="text"  path="expiryDate" placeholder="dd/MM/yyyy" required="true " />
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
                            <form:input path="transDate" type="text"   class="form-control" placeholder="dd/MM/yyyy" required="required" />
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
                            <form:label path="fraudLevel">Fraud Level</form:label>
                            <form:select path="fraudLevel" cssClass="form-select ">
                                <option value=" ">Select Level</option>
                                <option value="Low">Low</option>
                                <option value="Medium">Medium</option>
                                <option value="High">High</option>
                            </form:select>
                            <form:errors path="fraudLevel" cssClass="text-warning " />                             
                        </fieldset>     
                                      
                        <fieldset class=" form-group ">
                            <form:label path="validId">Id Proof Status</form:label>
                            <form:select path="validId" cssClass="form-select">
                                <option value=" ">Select valid Id or not</option>
                                <option value="${1}">Valid ID</option>
                                <option value="${0}">Not Valid ID</option>
                            </form:select>
                            <form:errors path="validId" cssClass="text-warning " /> 
                        </fieldset>
                        <button class="btn btn-success mt-3 " type="submit ">Submit</button>
                    </form:form>
                   