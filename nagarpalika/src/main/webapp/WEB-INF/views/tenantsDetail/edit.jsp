<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include.jsp"></jsp:include>
<html>
<head>
<style>
h5 {
	font-size: 80%;
	font-weight: bold;
}
.alert{
 position: absolute;
    left: 0px;
    top: 0px;
    z-index: 1;
    }
    .commercial{
display:none;
}
</style>
</head>
<body class="background">

	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
			<spring:url value="/tenants/update" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }/${t.tenants_id }">

					<div class="x_title">
						<h2>UPDATE TENANTS DETAIL</h2>
					<c:if test="${not empty msg }">
							<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
						<div class="alert alert-danger"><strong>${msg }</strong></div>
						</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					<div class="form-group">
						<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
							<button class="btn btn-info" type="button" id="validate">Validate</button>
							<button class="btn btn-primary" type="reset">Reset</button>
							
							<a class="btn btn-danger confirm" href="<spring:url value="/tenants/delete/${t.tenants_id }"/>">Delete</a>
							<input type="submit" class="btn btn-success" value="Update">
							
							<a class="btn btn-info" href="<spring:url value="/nav/tenantsDetail"/>"> Add New</a>
						</div>
					</div>
						<br />
						<table class="table">
							<tr>
								<td><h6>
										<strong>Resident Id</strong>
									</h6> <select class='form-control'
										name='houseOwnerDetailModel.house_owner_id' id="house_owner_id">
											<option value="">Select Resident Id</option>
											<c:forEach items="${houseOwner }" var="h">
											<option value="${h.house_owner_id }" <c:if test="${h.house_owner_id eq t.houseOwnerDetailModel.house_owner_id}">selected</c:if>>${h.house_owner_id }/${h.house_owner_fname } ${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select></td>
								<td><h6>
										<strong>Land House ID</strong>
									</h6> <input type='text' class='form-control' name='land_house_id' value="${t.land_house_id }"></td>
								<td><h6>
										<strong>Tenant's Name</strong>
									</h6> <input type='text' class='form-control' name='tenant_name' value="${t.tenant_name }"></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Tenant's Address</strong>
									</h6> <input type='text' class='form-control' name='tenant_address' value="${t.tenant_address }"></td>
								<td><h6>
										<strong>Occupation</strong>
									</h6> <select class='form-control' name='occupationModel.occu_id' value="${t.occupationModel.occu_id }">
									<option value="">Select Occupation</option>
								<c:forEach items="${occupation }" var="o">
									<option value="${o.occu_id }" <c:if test="${o.occu_id eq t.occupationModel.occu_id }">selected</c:if>>${o.occupation_type }</option>
									</c:forEach>
									</select></td>
								<td><h6>
										<strong>Phone/ Mobile Number</strong>
									</h6> <input type='text' class='form-control' name='phone_number' value="${t.phone_number }"></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Id Type</strong>
									</h6> <input type='text' class='form-control' name='identity' value="${t.identity }"></td>
								<td><h6>
										<strong>Identity Number</strong>
									</h6> <input type='text' class='form-control' name='identity_number' value="${t.identity_number }"></td>
								<td><h6>
										<strong>Number of Tenants</strong>
									</h6> <input type='text' class='form-control' name='tenant_nos' value="${t.tenant_nos }"></td>
							</tr>
							
								<tr>
								<td><h6>
										<strong>Rented Purpose</strong>
									</h6> <select class='form-control comm_on' name='rented_purpose'>

										<option value="">Select Rented Purpose</option>
										
										<option value="Commercial" <c:if test="${t.rented_purpose  eq 'Commercial'}">selected</c:if>>Commercial</option>
										<option value="Residential" <c:if test="${t.rented_purpose  eq 'Residential'}">selected</c:if>>Residential</option>
								</select></td>
								</tr>
								
								<tr class="commercial">
							<td><h6>
									<strong>Name of Company</strong>
								</h6> <input type='text' class='form-control com' name='company_name' value="${t.company_name }"></td>

							<td><h6>
									<strong>Manager/Owner/Proprietor</strong>
								</h6> <input type='text' class='form-control com' name='owner' value="${t.owner }"></td>
							<td><h6>
									<strong>Register Number</strong>
								</h6> <input type='text' class='form-control com' name='register_number' value="${t.register_number }"></td>
								
								</tr>
					
						<tr class="commercial">
							<td><h6>
									<strong>Register Date</strong>
								</h6> <input type='text' class='form-control com' name='register_date' value="${t.register_date}"></td>
							<td><h6>
									<strong>License Providing Office</strong>
								</h6> <input type='text' class='form-control com' name='license_provider' value="${t.license_provider }"></td>
							<td><h6>
									<strong>Telephone Number</strong>
								</h6> <input type='text' class='form-control com' name='phone' value="${t.phone }"></td>
								
								</tr>
								
								<tr class="commercial">
								<td><h6>
									<strong>Types Of Business </strong>
								</h6> <input type='text' class='form-control com' name='business_type' value="${t.business_type }"></td>
								</tr>
						</table>

					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script>
	$(".confirm").click(function(){
		return confirm("Confirm?");
	})
	$("form").submit(function(){
		return confirm("Confirm Submit?");
	});
	
	$(".alert").delay(2000).slideUp(200, function() {
		$(this).alert('close');
	});
	 $(document).ready(function () {
	var rented_purpose=$(".comm_on option:selected").val();
	  if (rented_purpose == "Commercial") {
          //show the tr if value is others
          $('.commercial').show();
      } else {
          //Hide the tr if value is others
          $('.commercial').hide();
      }
	  $('.comm_on').change(function () {
		  if(confirm('Are you sure?')){
          //Grab the value from dropdownlist
          if (this.value == "Commercial") {
              //show the tr if value is others
              $('.commercial').show();
          } else {
              //Hide the tr if value is others
              $('.commercial').hide();
              $('.com').val('');
          }
		  }
		  else{return false;}

      });
	  });
</script>
</body>
</html>
