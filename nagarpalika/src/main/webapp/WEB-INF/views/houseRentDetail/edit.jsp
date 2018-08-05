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
			<spring:url value="/houseRent/update" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }/${hd.house_rent_id }">

					<div class="x_title">
						<h2>UPDATE HOUSE RENT DETAIL</h2>
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
							
							<a class="btn btn-danger confirm" href="<spring:url value="/houseRent/delete/${hd.house_rent_id }"/>">Delete</a>
							<input type="submit" class="btn btn-success" value="Update">
							
							<a class="btn btn-info" href="<spring:url value="/nav/houseRentDetail"/>"> Add New</a>
						</div>
					</div>
						<br />
						<table class="table">
							<tr>
								<td><h6>
										<strong>Resident Id</strong>
									</h6> <select class='form-control'
										name='houseOwnerDetailModel.house_owner_id' id="house_owner_id" required>
											<option value="">Select Resident Id</option>
											<c:forEach items="${houseOwner }" var="h">
											<option value="${h.house_owner_id }" <c:if test="${h.house_owner_id eq hd.houseOwnerDetailModel.house_owner_id}">selected</c:if>>${h.house_owner_id }/${h.house_owner_fname } ${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select></td>
								<td><h6>
										<strong>Land House ID</strong>
									</h6> <input type='text' class='form-control' name='land_house_id' value="${hd.land_house_id }"></td>
								<td><h6>
										<strong>Rented Storied</strong>
									</h6> <input type='text' class='form-control' name='rented_storied' value="${hd.rented_storied }"></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Rented Room</strong>
									</h6> <input type='text' class='form-control' name='rented_room' value="${hd.rented_room }"></td>
								<td><h6>
										<strong>Rented from</strong>
									</h6> <input type='text' class='form-control' name='rented_from' value="${hd.rented_from }"></td>
								<td><h6>
										<strong>Rented Purpose</strong>
									</h6> <select class='form-control' name='rented_purpose'>
									
									<option value="">Select Rented Purpose</option>
									<option value="Commercial" <c:if test="${hd.rented_purpose eq 'Commercial'}">selected</c:if>>Commercial</option>
									<option value="Residential" <c:if test="${hd.rented_purpose eq 'Residential'}">selected</c:if>>Residential</option>
									</select>
									</td>
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
