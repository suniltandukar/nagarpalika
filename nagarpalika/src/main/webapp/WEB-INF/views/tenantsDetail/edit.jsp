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
</script>
</body>
</html>
