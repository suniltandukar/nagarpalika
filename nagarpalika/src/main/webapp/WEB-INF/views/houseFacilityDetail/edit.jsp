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

.alert {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 1;
}
</style>
</head>
<body class="background">

	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-12 col-xs-12">
			<div class="x_panel">
				<spring:url value="/houseFacility/update/${hd.house_facility_id }"
					var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>UPDATE HOUSE FACILITY DETAIL</h2>
						<c:if test="${not empty msg }">
							<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
								<div class="alert alert-danger">
									<strong>${msg }</strong>
								</div>
							</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group">
							<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
								<button class="btn btn-info" type="button" id="validate">Validate</button>
								<button class="btn btn-primary" type="reset">Reset</button>

								<a class="btn btn-danger confirm"
									href="<spring:url value="/houseFacility/delete/${hd.house_facility_id }"/>">Delete</a>
								<input type="submit" class="btn btn-success" value="Update">

								<a class="btn btn-info"
									href="<spring:url value="/nav/houseFacilityDetail"/>"> Add
									New</a>
							</div>
						</div>
						<br />
						<table class="table">
						<tr>
									<td></td>
										<td><img id="myImg"
										src="//124.41.193.91/images/thimi/${hd.houseOwnerDetailModel.house_owner_id }HF${hd.land_house_id }.jpg"
										style="height: 100px; width: 100px;" /></td>
										<td></td>
								</tr>
							<tr>
								<td><h6>
										<strong>Resident Id</strong>
									</h6> <select class='form-control'
									name='houseOwnerDetailModel.house_owner_id' id="house_owner_id" required>
										<option value="">Select Resident Id</option>
										<c:forEach items="${houseOwner }" var="h">
											<option value="${h.house_owner_id }"
												<c:if test="${h.house_owner_id eq hd.houseOwnerDetailModel.house_owner_id}">selected</c:if>>${h.house_owner_id }/${h.house_owner_fname }
												${h.house_owner_mname } ${h.house_owner_lname }</option>
										</c:forEach>
								</select></td>
								<td><h6>
										<strong>Land House ID</strong>
									</h6> <input type='text' class='form-control' name='land_house_id'
									value="${hd.land_house_id }"></td>
								<td><h6>
										<strong>Drinking Water Type</strong>
									</h6> <select class='form-control'
									name='drinkingWaterTypeModel.drinking_water_type_id'>
										<option value="">Select Type</option>
										<c:forEach items="${drinkingWater }" var="d">
											<option value="${d.drinking_water_type_id }"
												<c:if test="${d.drinking_water_type_id eq hd.drinkingWaterTypeModel.drinking_water_type_id }">selected</c:if>>${d.drinking_water_type}</option>
										</c:forEach>
								</select></td>
								<td><h6>
										<strong>Drinking Water Sufficiency</strong>
									</h6> <select class='form-control' name='drinking_water_sufficiency'>
										<option value="">Select Facility</option>

										<option value="y"
											<c:if test="${hd.drinking_water_sufficiency eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.drinking_water_sufficiency eq 'n' }">selected</c:if>>No</option>
								</select></td>
							</tr>
							<tr>

								<td><h6>
										<strong>Drainage Management</strong>
									</h6> <select class='form-control' name='drainage_management'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.drainage_management eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.drainage_management eq 'n' }">selected</c:if>>No</option>
								</select></td>
								<td><h6>
										<strong>Electricity</strong>
									</h6> <select class='form-control' name='electricity_facility'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.electricity_facility eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.electricity_facility eq 'n' }">selected</c:if>>No</option>
								</select></td>
								<td><h6>
										<strong>Street Light</strong>
									</h6> <select class='form-control' name='street_light_facility'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.street_light_facility eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.street_light_facility eq 'n' }">selected</c:if>>No</option>
								</select></td>
								<td><h6>
										<strong>Telephone facility</strong>
									</h6> <select class='form-control' name='telephone_facility'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.telephone_facility eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.telephone_facility eq 'n' }">selected</c:if>>No</option>
								</select></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Internet facility</strong>
									</h6> <select class='form-control' name='internet_facility'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.internet_facility eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.internet_facility eq 'n' }">selected</c:if>>No</option>
								</select></td>
								<td><h6>
										<strong>TV Cable facility</strong>
									</h6> <select class='form-control' name='tv_facility'>
										<option value="">Select Facility</option>
										<option value="y"
											<c:if test="${hd.tv_facility eq 'y' }">selected</c:if>>Yes</option>
										<option value="n"
											<c:if test="${hd.tv_facility eq 'n' }">selected</c:if>>No</option>
								</select></td>
								<td><h6>
										<strong>Road type</strong>
									</h6> <select class='form-control' name='road_type_id'>
										<option value="">Select Road Type</option>
										<c:forEach items="${roadType }" var="r">
											<option value="${r.road_type_id }"
												<c:if test="${hd.road_type_id eq hd.road_type_id }">selected</c:if>>${r.road_type }</option>
										</c:forEach>
								</select></td>
								<td><h6>
										<strong>Road size (feet)</strong>
									</h6> <select class="form-control" name="road_width">
										<option value="">Select Road Size</option>
										<option value="${hd.road_width }" selected>${hd.road_width }</option>
										<%
											int sn;
												for (sn = 1; sn <= 10; sn++) {
										%>
										<option value="<%=sn%>"><%=sn%></option>
										<%
											}
										%>
										<option value="Other">Other</option>
								</select></td>
							</tr>
						</table>

					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div id="myModal" class="modal">
		<img class="modal-content" id="img01">
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/zoomimage.js"></script>
	<script>
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