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
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>HOUSE FACILITY DETAIL</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<table class="table">
							<tr>
								<td><h6>
										<strong>House Owner ID</strong>
									</h6> <input type='text' class='form-control' name='house_owener_id'></td>
								<td><h6>
										<strong>Land House ID</strong>
									</h6> <input type='text' class='form-control' name='land_house_id'></td>
								<td><h6>
										<strong>Drinking Water Type</strong>
									</h6> <input type='text' class='form-control'
									name='drinking_water_type'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Drinking Water Sufficiency</strong>
									</h6> <input type='text' class='form-control'
									name='drinking_water_sufficiency'></td>
								<td><h6>
										<strong>Drainage Management</strong>
									</h6> <input type='text' class='form-control'
									name='drainage_manegement'></td>
								<td><h6>
										<strong>Electricity</strong>
									</h6> <input type='text' class='form-control'
									name='electricity_facility'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Street Light</strong>
									</h6> <input type='text' class='form-control'
									name='street_light_facility'></td>
								<td><h6>
										<strong>Telephone facility</strong>
									</h6> <input type='text' class='form-control'
									name='telephone_facility'></td>
								<td><h6>
										<strong>Internet facility</strong>
									</h6> <input type='text' class='form-control'
									name='internet_facility'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>TV Calbe facility</strong>
									</h6> <input type='text' class='form-control' name='tv_facility'></td>
								<td><h6>
										<strong>road type</strong>
									</h6> <input type='text' class='form-control' name='road_type'></td>
								<td><h6>
										<strong>Road size (feet)</strong>
									</h6> <input type='text' class='form-control' name='road_width'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Record Status</strong>
									</h6> <input type='text' class='form-control' name='record_status'></td>
								<td><h6>
										<strong>Company ID</strong>
									</h6> <input type='text' class='form-control' name='company_id'></td>
								<td><h6>
										<strong>Branch ID</strong>
									</h6> <input type='text' class='form-control' name='branch_id'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Inputter</strong>
									</h6> <input type='text' class='form-control' name='inputter'></td>
								<td><h6>
										<strong>Authorizer</strong>
									</h6> <input type='text' class='form-control' name='authorizer'></td>
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
</script>
</body>
</html>