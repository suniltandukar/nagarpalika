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
			<spring:url value="/familyDetail/update/${fd.house_owner_id }" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>UPDATE FAMILY DETAIL</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					<div class="form-group">
						<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
							<button class="btn btn-info" type="button" id="validate">Validate</button>
							<button class="btn btn-primary" type="reset">Reset</button>
							
							<a class="btn btn-danger" href="<spring:url value="/familyDetail/delete/${fd.house_owner_id }"/>">Delete</a>
							<input type="submit" class="btn btn-success" value="Update">
						</div>
					</div>
						<br />
						<table class="table">
								<tbody>
									<tr>
										<td><h6>
												<strong>Owner ID</strong>
											</h6> <input type='text' class='form-control'
											name='house_owner_id' value="${fd.house_owner_id }"></td>
										<td><h6>
												<strong>Father Name</strong>
											</h6> <input type='text' class='form-control' name='house_owner_fname' value="${fd.house_owner_fname }"></td>
										<td><h6>
												<strong>Relation</strong>
											</h6> <select class='form-control' name='relation'>
											<option value="">Select Relation</option>
											</select></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Name</strong>
											</h6> <input type='text' class='form-control' name='name' value="${fd.name }"></td>
										<td><h6>
												<strong>Marital Status</strong>
											</h6> <select class='form-control'
											name='marital_status'>
											
											<option value="Married" <c:if test="${fd.marital_status eq 'Married' }">selected</c:if>>Married</option>
											<option value="Unmarried" <c:if test="${fd.marital_status eq 'Unmarried' }">selected</c:if>>Unmarried</option>
											</select></td>
										<td><h6>
												<strong>Date of birth (Nepali YYYYMMDD)</strong>
											</h6> <input type='text' class='form-control' name='dob_nep' value="${fd.dob_nep }"></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Disability if any</strong>
											</h6> <select class='form-control' name='disable_type'>
											<option value="">Select Disability</option>
											</select></td>
										<td><h6>
												<strong>Occupation Id</strong>
											</h6> <select class='form-control' name='occupation_id'>
											<option value="">Select Occupation</option>
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
								</tbody>
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
</script>
</body>
</html>