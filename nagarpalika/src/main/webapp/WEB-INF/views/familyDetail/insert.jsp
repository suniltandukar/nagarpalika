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
</style>
</head>
<body class="background">

	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
				<spring:url value="/familyDetail/save" var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					id="form" method="post" action="${formUrl }"
					commandName="familyDetailForm">

					<div class="x_title">
						<h2>FAMILY DETAIL</h2>
						
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
						
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						
						<div class="form-group">
							<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
								<button class="btn btn-info" type="button" id="validate">Validate</button>
								<button class="btn btn-primary" type="reset">Reset</button>
								<input type="submit" class="btn btn-success" value="Submit">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Owner</strong>
										</h6> <select class='form-control' name='house_owner_id'>
											<option value="">Select Owner</option>
											<c:forEach items="${houseOwner }" var="h">
												<option value="${h.house_owner_id }">${h.house_owner_id }/${h.house_owner_fname }
													${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select></td>

									<td><h6>
											<strong>Relation</strong>
										</h6> <select class='form-control' name='relation'>
											<option value="">Select Relation</option>
											<c:forEach items="${relation }" var="r">
												<option value="${r.name }">${r.name }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Gender</strong>
										</h6> <select class='form-control' name='gender'>
											<option value="">Select Gender</option>
											<option value="m">Male</option>
											<option value="f">Female</option>
											<option value="o">Other</option>
									</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>First Name</strong>
										</h6> <input type='text' class='form-control'
										name='house_owner_fname'></td>
									<td><h6>
											<strong>Middle Name</strong>
										</h6> <input type='text' class='form-control'
										name='house_owner_mname'></td>
									<td><h6>
											<strong>Last Name</strong>
										</h6> <input type='text' class='form-control'
										name='house_owner_lname'></td>
								</tr>
								<tr>

									<td><h6>
											<strong>Marital Status</strong>
										</h6> <select class='form-control' name='marital_status'>
											<option value="">Select Marital Status</option>
											<option value="Married">Married</option>
											<option value="Unmarried">Unmarried</option>
									</select></td>
									<td><h6>
											<strong>Date of birth (Nepali YYYYMMDD)</strong>
										</h6> <input type='text' class='form-control' name='dob_nep'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Occupation</strong>
										</h6> <select class='form-control' name='occupation_id'>
											<option value="1">Select Occupation</option>
											<c:forEach items="${occupation }" var="o">
												<option value="${o.occu_id }">${o.occupation_type }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Disability if any</strong>
										</h6> <select class='form-control' name='disable_type'>
											<option value="">Select Disability</option>
											<c:forEach items="${disablity }" var="d">
												<option value="${d.id }">${d.typehead }</option>
											</c:forEach>
									</select></td>


								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-md-4 col-xs-12">
		<div class="alert alert-success"><strong>${msg }</strong></div>
		</div>
	</div>
	
	<script>
		$(".confirm").click(function() {
			return confirm("Confirm?");
		})
		$("form").submit(function() {
			return confirm("Confirm Submit?");
		});
		$(".alert").delay(2000).slideUp(200, function() {
			$(this).alert('close');
		});
	</script>
</body>
</html>
