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
			<spring:url value="/houseLand/save" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2> Update HOUSE AND LAND DETAIL</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Owner Id</strong>
										</h6> <input type='text' class='form-control' name='house_owner_id'></td>
									<td><h6>
											<strong>Land and House ID</strong>
										</h6> <input type='text' class='form-control' name='land_house_id'></td>
									<td><h6>
											<strong>Family Id</strong>
										</h6> <input type='text' class='form-control' name='family_id'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Ownership Type</strong>
										</h6> <input type='text' class='form-control' name='ownership_type'></td>
									<td><h6>
											<strong>House Number</strong>
										</h6> <input type='text' class='form-control' name='house_number'></td>
									<td><h6>
											<strong>Land Unit</strong>
										</h6> <input type='text' class='form-control' name='land_unit'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Land Size</strong>
										</h6> <input type='text' class='form-control' name='land_size'></td>
									<td><h6>
											<strong>Plot Num</strong>
										</h6> <input type='text' class='form-control' name='plot_num'></td>
									<td><h6>
											<strong>Sheet Num</strong>
										</h6> <input type='text' class='form-control' name='sheet_num'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>District</strong>
										</h6> <input type='text' class='form-control' name='district_uni'></td>
									<td><h6>
											<strong>Municipality/ Village council</strong>
										</h6> <input type='text' class='form-control' name='mun_vc_uni'></td>
									<td><h6>
											<strong>Ward Number</strong>
										</h6> <input type='text' class='form-control' name='ward_no_uni'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Moth Number</strong>
										</h6> <input type='text' class='form-control' name='moth_num_uni'></td>
									<td><h6>
											<strong>Kitta Number</strong>
										</h6> <input type='text' class='form-control' name='kitta_num_uni'></td>
									<td><h6>
											<strong>Land Legacy Address</strong>
										</h6> <input type='text' class='form-control'
										name='land_legacy_address'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Land Current District</strong>
										</h6> <input type='text' class='form-control'
										name='land_current_district'></td>
									<td><h6>
											<strong>Land Current Municipality/ Village Council</strong>
										</h6> <input type='text' class='form-control'
										name='land_current_mun_vc'></td>
									<td><h6>
											<strong>Ward No</strong>
										</h6> <input type='text' class='form-control' name='ward_no'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Tole</strong>
										</h6> <input type='text' class='form-control' name='tole'></td>
									<td><h6>
											<strong>House Construction Type</strong>
										</h6> <input type='text' class='form-control'
										name='house_construction_type'></td>
									<td><h6>
											<strong>Used Status</strong>
										</h6> <input type='text' class='form-control' name='used_status'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>House Floor Count</strong>
										</h6> <input type='text' class='form-control'
										name='house_floor_count'></td>
									<td><h6>
											<strong>Rentnted Floor Count</strong>
										</h6> <input type='text' class='form-control'
										name='rented_floor_count'></td>
									<td><h6>
											<strong>House Area Unit</strong>
										</h6> <input type='text' class='form-control'
										name='house_area_unit'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>House Area</strong>
										</h6> <input type='text' class='form-control' name='house_area'></td>
									<td><h6>
											<strong>Map Application Date</strong>
										</h6> <input type='text' class='form-control'
										name='map_application_date'></td>
									<td><h6>
											<strong>Map Approved Date</strong>
										</h6> <input type='text' class='form-control'
										name='map_approved_date'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Construction Start Date</strong>
										</h6> <input type='text' class='form-control'
										name='construction_start_date'></td>
									<td><h6>
											<strong>Construction Completion Date</strong>
										</h6> <input type='text' class='form-control'
										name='construction_completion_date'></td>
									<td><h6>
											<strong>Construction Completion Municipality/
												Village Council</strong>
										</h6> <input type='text' class='form-control'
										name='construction_completion_approval_date'></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Completion Approved By</strong>
										</h6> <input type='text' class='form-control'
										name='completion_approved_by'></td>
									<td><h6>
											<strong>House Map Municipality/ Village Council</strong>
										</h6> <input type='text' class='form-control'
										name='house_map_prepared_by'></td>
									<td><h6>
											<strong>Current Number</strong>
										</h6> <input type='text' class='form-control' name='curr_number'></td>
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
