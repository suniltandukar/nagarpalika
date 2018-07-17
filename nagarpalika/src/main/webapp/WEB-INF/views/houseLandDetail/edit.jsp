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
			<spring:url value="/houseLand/update/${hd.house_and_land_detail_id }" var="formUrl"/>
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>HOUSE AND LAND DETAIL</h2>
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
							
							<a class="btn btn-danger confirm" href="<spring:url value="/houseLand/delete/${hd.house_and_land_detail_id }"/>">Delete</a>
							<input type="submit" class="btn btn-success" value="Update">
							
							<a class="btn btn-info" href="<spring:url value="/nav/houseLandDetail"/>"> Add New</a>
						</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Resident Id</strong>
										</h6>  <select class='form-control' name='houseOwnerDetailModel.house_owner_id' id="house_owner_id">
											<option value="">Select Resident Id</option>
											<c:forEach items="${houseOwner }" var="h">
												<option value="${h.house_owner_id }" <c:if test="${h.house_owner_id eq hd.houseOwnerDetailModel.house_owner_id }">selected</c:if>>${h.house_owner_id }/${h.house_owner_fname }
													${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach></select></td>
									<td><h6>
											<strong>Land and House ID</strong>
										</h6> <input type='text' class='form-control' name='land_house_id' value="${hd.land_house_id }"></td>
									<td><h6>
											<strong>Family Id</strong>
										</h6> <select  class='form-control' name='family_id' id="family_id">
										<option value="">Select Family Id</option>
										<c:forEach items="${familyDetail }" var="f">
										<option value="${f.family_detail_id}" <c:if test="${f.family_detail_id eq hd.family_id }">selected</c:if>>${f.family_detail_id }/${f.fname } ${f.lname }</option>
										</c:forEach>
										</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Ownership Type</strong>
										</h6> <select class='form-control' name='ownership_type'>
										<option value="">Select Ownership Type</option>
										<option value="Single" <c:if test="${hd.ownership_type eq 'Single' }">selected</c:if>>Single</option>
										<option value="Multiple" <c:if test="${hd.ownership_type eq 'Multiple' }">selected</c:if>>Multiple</option>
										</select>
										</td>
									<td><h6>
											<strong>House Number</strong>
										</h6> <input type='text' class='form-control house_number' name='house_number' value="${hd.house_number }"></td>
									<td><h6>
											<strong>Land Unit</strong>
										</h6> <select class='form-control' name='land_unit'>
										<option value="">Select Land Unit</option>
										<option value="Ropani" <c:if test="${hd.land_unit eq 'Ropani' }">selected</c:if>>Ropani</option>
										<option value="Bigha" <c:if test="${hd.land_unit eq 'Bigha' }">selected</c:if>>Bigha</option>
										<option value="Sq. Meter" <c:if test="${hd.land_unit eq 'Sq. Meter' }">selected</c:if>>Sq. Meter</option>
										<option value="Sq. Feet" <c:if test="${hd.land_unit eq 'Sq. Feet' }">selected</c:if>>Sq. Feet</option>
										</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Land Size</strong>
										</h6> <input type='text' class='form-control' name='land_size' value="${hd.land_size }"></td>
									<td><h6>
											<strong>Plot Num</strong>
										</h6> <input type='text' class='form-control' name='plot_num' value="${hd.plot_num }"></td>
									<td><h6>
											<strong>Sheet Num</strong>
										</h6> <input type='text' class='form-control' name='sheet_num' value="${hd.sheet_num }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Land Legacy District</strong>
										</h6> <input type="text" value="${hd.district_uni }" class='form-control' name='district_uni'>
										</td>
									<td><h6>
											<strong>Land Legacy Municipality/ Village council</strong>
										</h6> <input type="text" value="${hd.mun_vc_uni }" class='form-control' name='mun_vc_uni'>
										</td>
									<td><h6>
											<strong>Land Legacy Ward Number</strong>
										</h6> <input type="text" value="${hd.ward_no_uni }"class='form-control' name='ward_no_uni'>
										</td>
								</tr>
								<tr>
									<td><h6>
											<strong>Moth Number</strong>
										</h6> <input type='text' class='form-control' name='moth_num_uni' value="${hd.moth_num_uni }"></td>
									<td><h6>
											<strong>Kitta Number</strong>
										</h6> <input type='text' class='form-control' name='kitta_num_uni' value="${hd.kitta_num_uni }"></td>
									<td><h6>
											<strong>Land Legacy Address</strong>
										</h6> <input type='text' class='form-control'
										name='land_legacy_address' value="${hd.land_legacy_address }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Land Current District</strong>
										</h6> <select class='form-control' name='land_current_district'>
											<option value="27">Bhaktapur</option>
									</select></td>
									<td><h6>
											<strong>Land Current Municipality/ Village Council</strong>
										</h6> <select class='form-control' name='land_current_mun_vc'>
											<option value="32703">Madhyepur Thimi</option>
									</select>
									</td>
									<td><h6>
											<strong>Ward No</strong>
										</h6> 
										<select class='form-control' name='ward_no'>
										<option value="${hd.ward_no }" selected>${hd.ward_no }</option>
											<%
												int n;
													for (n = 1; n < 10; n++) {
											%>
											<option value="<%=n%>"><%=n%></option>
											<%
												}
											%>
									</select>
								</tr>
								<tr>
									<td><h6>
											<strong>Tole</strong>
										</h6> <input type='text' class='form-control' name='tole' value="${hd.tole }"></td>
									<td><h6>
											<strong>House Construction Type</strong>
										</h6> <select class='form-control'
										name='house_construction_type'>
										
										<option value="">Select Construction Type</option>
										
										<c:forEach items="${constructionType }" var="ct">
										<option value="${ct.id }" <c:if test="${ct.id eq hd.house_construction_type }">selected</c:if>>${ct.type }</option>
										</c:forEach>
										</select></td>
									<td><h6>
											<strong>Used Status</strong>
										</h6> <select class='form-control' name='used_status'>
										<option value="">Select Used Status</option>
										<option value="${hd.used_status }" selected>${hd.used_status }</option>
										<option value="Self Used">Self Used</option>
											<option value="Rented">Rented</option>
										</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>House Floor Count</strong>
										</h6> <input type='text' class='form-control'
										name='house_floor_count' value="${hd.house_floor_count }"></td>
									<td><h6>
											<strong>Rentnted Floor Count</strong>
										</h6> <input type='text' class='form-control'
										name='rented_floor_count' value="${hd.rented_floor_count }"></td>
									<td><h6>
											<strong>House Area Unit</strong>
										</h6> <select class='form-control'
										name='house_area_unit'>
										<option value="">Select Area Unit</option>
										<option value="Sq. Feet" <c:if test="${hd.house_area_unit eq 'Sq. Feet'}">Selected</c:if>>Sq. Feet</option>
										<option value="Sq. Meter" <c:if test="${hd.house_area_unit eq 'Sq. Meter'}">Selected</c:if>>Sq. Meter</option>
										</select></td>
								</tr>
								<tr>
									<td><h6>
											<strong>House Area</strong>
										</h6> <input type='text' class='form-control' name='house_area' value="${hd.house_area }"></td>
									<td><h6>
											<strong>Map Application Date</strong>
										</h6> <input type='text' class='form-control'
										name='map_application_date' value="${hd.map_application_date }"></td>
									<td><h6>
											<strong>Map Approved Date</strong>
										</h6> <input type='text' class='form-control'
										name='map_approved_date' value="${hd.map_approved_date }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Construction Start Date</strong>
										</h6> <input type='text' class='form-control'
										name='construction_start_date' value="${hd.construction_start_date }"></td>
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
	$(".confirm").click(function(){
		return confirm("Confirm?");
	})
	$("form").submit(function(){
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
