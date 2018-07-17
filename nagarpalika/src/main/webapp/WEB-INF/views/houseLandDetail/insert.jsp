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
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
				<spring:url value="/houseLand/save" var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>HOUSE AND LAND DETAIL</h2>
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
								<input type="submit" class="btn btn-success" value="Submit">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
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
											<strong>Land and House ID</strong>
										</h6> <input type='text' class='form-control' name='land_house_id'></td>
									<td><h6>
											<strong>Family Id</strong>
										</h6> <select class='form-control' id="family_id" name='family_id'>
										<option value="">Select Family Id</option>
										</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Ownership Type</strong>
										</h6> <select class='form-control' name='ownership_type'>
											<option value="">Select Ownership Type</option>
											<option value="Single">Single</option>
											<option value="Multiple">Multiple</option>
									</select></td>
									<td><h6>
											<strong>House Number</strong>
										</h6> <input type='text' class='form-control house_number'
										name='house_number'></td>
									<td><h6>
											<strong>Land Unit</strong>
										</h6> <select class='form-control' name='land_unit'>
											<option value="">Select Land Unit</option>
											<option value="Ropani">Ropani</option>
											<option value="Bigha">Bigha</option>
											<option value="Sq. Meter">Sq. Meter</option>
											<option value="Sq. Feet">Sq. Feet</option>
									</select></td>
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
											<strong>Land Legacy District</strong>
										</h6> <input type="text" class='form-control' name='district_uni'>
											</td>
									<td><h6>
											<strong>Municipality/ Village council</strong>
										</h6> <input type="type" class='form-control' name='mun_vc_uni'>
											</td>
									<td><h6>
											<strong>Ward Number</strong>
										</h6> <input type="text" class='form-control' name='ward_no_uni'>
											</td>
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
										</h6> 
										<select class='form-control' name='land_current_district'>
											<option value="27">Bhaktapur</option>
									</select></td>
									<td><h6>
											<strong>Land Current Municipality/ Village Council</strong>
										</h6> 
										<select class='form-control' name='land_current_mun_vc'>
											<option value="32703">Madhyepur Thimi</option>
									</select></td>
									<td><h6>
											<strong>Ward No</strong>
										</h6> 
										<select class='form-control' name='ward_no'>
											<%
												int n;
													for (n = 1; n < 10; n++) {
											%>
											<option value="<%=n%>"><%=n%></option>
											<%
												}
											%>
									</select>
										</td>
								</tr>
								<tr>
									<td><h6>
											<strong>Tole</strong>
										</h6> <input type='text' class='form-control' name='tole'></td>
									<td><h6>
											<strong>House Construction Type</strong>
										</h6> <select class='form-control' name='house_construction_type'>

											<option value="">Select Construction Type</option>
											<c:forEach items="${constructionType }" var="ct">
												<option value="${ct.id }">${ct.type }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Used Status</strong>
										</h6> <select class='form-control' name='used_status'>
											<option value="">Select Used Status</option>
											<option value="Self Used">Self Used</option>
											<option value="Rented">Rented</option>
									</select></td>
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
										</h6> <select class='form-control' name='house_area_unit'>
											<option value="">Select Area Unit</option>
											<option value="Sq. Feet">Sq. Feet</option>
											<option value="Sq. Meter">Sq. Meter</option>
									</select></td>
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
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>
		</div>
		
	</div>
	
	<input type="hidden" id="url" value="<spring:url value="/houseLand/findFamilyId"/>">
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
		$('#house_owner_id').change(function(){
		    $.ajax({
		        url: $("#url").val(),
		        data: { "houseOwnerDetailModel.house_owner_id": $("#house_owner_id").val() },
		        dataType:"html",
		        type: "post",
		        success: function(data){
		           $('#family_id').append(data);
		        }
		    });
		});
	</script>
</body>
</html>
