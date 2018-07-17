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
			<spring:url value="/houseFacility/save" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>HOUSE FACILITY DETAIL</h2>
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
								<input type="submit" class="btn btn-success" value="Submit">
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
												<option value="${h.house_owner_id }">${h.house_owner_id }/${h.house_owner_fname }
													${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select></td>
								<td><h6>
										<strong>Land House ID</strong>
									</h6> <input type='text' class='form-control' name='land_house_id'></td>
								<td><h6>
										<strong>Drinking Water Type</strong>
									</h6> <select class='form-control'
									name='drinkingWaterTypeModel.drinking_water_type_id'>
									<option value="">Select Type</option>
									<c:forEach items="${drinkingWater }" var="d">
									<option value="${d.drinking_water_type_id }">${d.drinking_water_type}</option>
									</c:forEach>
									</select>
									</td>
							</tr>
							<tr>
								<td><h6>
										<strong>Drinking Water Sufficiency</strong>
									</h6> <select class='form-control'
									name='drinking_water_sufficiency'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
								<td><h6>
										<strong>Drainage Management</strong>
									</h6> <select class='form-control'
									name='drainage_management'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select>
									</td>
								<td><h6>
										<strong>Electricity</strong>
									</h6> <select class='form-control'
									name='electricity_facility'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Street Light</strong>
									</h6> <select class='form-control'
									name='street_light_facility'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
								<td><h6>
										<strong>Telephone facility</strong>
									</h6> <select class='form-control'
									name='telephone_facility'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
								<td><h6>
										<strong>Internet facility</strong>
									</h6> <select class='form-control'
									name='internet_facility'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
							</tr>
							<tr>
								<td><h6>
										<strong>TV Calbe facility</strong>
									</h6> <select class='form-control' name='tv_facility'>
									<option value="">Select Facility</option>
									<option value="y">Yes</option>
									<option value="n">No</option>
									</select></td>
								<td><h6>
										<strong>Road type</strong>
									</h6> <select class='form-control' name='road_type_id'>
									<option value="">Select Road Type</option>
									<c:forEach items="${roadType }" var="r">
									<option value="${r.road_type_id }">${r.road_type }</option>
									</c:forEach>
									</select>
									</td>
								<td><h6>
										<strong>Road size (meter)</strong>
									</h6> 
									<select class="form-control" name="road_width">
									<option value="">Select Road Size</option>
									<%int sn;
									for(sn=1;sn<=10;sn++){%>
									<option value="<%=sn%>"><%=sn%></option>
									<%} %>
									<option value="Other">Other</option>
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