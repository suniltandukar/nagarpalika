<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include.jsp"></jsp:include>

<html>
<head>
<style>
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
			<spring:url value="/houseOwner/update/${ho.house_owner_id }" var="formUrl" />
		<form method="post" action="${formUrl }">

			<div class="x_panel">
				<div class="x_title">
					<h2>UPDATE HOUSE HOLD DETAIL</h2>

					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="x_title">
						<c:if test="${not empty msg }">
							<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
								<div class="alert alert-success">
									<strong>${msg }</strong>
								</div>
							</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
					<button class="btn btn-info" type="button" id="validate">Validate</button>
					<button class="btn btn-primary" type="reset">Reset</button>
					
						<input type="submit" class="btn btn-primary" value="Update">
						
						<a class="btn btn-danger" href="<spring:url value="/houseOwner/delete/${ho.house_owner_id }"/>">Delete</a>
					<div class="clearfix"></div>

				</div>
				<div class="x_content">
					<div class="" role="tabpanel" data-example-id="togglable-tabs">
						<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
							<li role="presentation" class="active"><a
								href="#tab_content1" id="home-tab" role="tab" data-toggle="tab"
								aria-expanded="true">House Hold Details</a></li>
							<li role="presentation" class=""><a href="#tab_content2"
								role="tab" id="profile-tab" data-toggle="tab"
								aria-expanded="false">Owner Identity Details</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in"
								id="tab_content1" aria-labelledby="home-tab">
								<table class="table">
									<tbody>
										<tr>
											<td><h6>
													<strong>House Owner ID</strong>
												</h6> <input type='text' class='form-control'
												name='house_owner_id' value="${ho.house_owner_id }"></td>

											<td><h6>
													<strong>First Name</strong>
												</h6> <input type='text' class='form-control'
												name='house_owner_fname' value="${ho.house_owner_fname }"></td>
											<td><h6>
													<strong>Middle Name</strong>
												</h6> <input type='text' class='form-control'
												name='house_owner_mname' value="${ho.house_owner_mname }"></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Last Name</strong>
												</h6> <input type='text' class='form-control'
												name='house_owner_lname' value="${ho.house_owner_lname }"></td>

											<td><h6>
													<strong>Marital Status</strong>
												</h6> <select name="marital_class" class="form-control">
													<option value="">Marital Status</option>
													<option value="Y">Yes</option>
													<option value="N">No</option>

											</select>
											<td><h6>
													<strong>Grand Father's Name</strong>
												</h6> <input type='text' class='form-control'
												name='grand_father_name' value="${ho.grand_father_name}"></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Father's Name</strong>
												</h6> <input type='text' class='form-control' name='father_name'
												value="${ho.father_name }"></td>
											<td><h6>
													<strong>Spouse Name</strong>
												</h6> <input type='text' class='form-control' name='spouse_name'
												value="${ho.spouse_name }"></td>
											<td><h6>
													<strong>House Number</strong>
												</h6> <input type='text' class='form-control' name='house_number'
												value="${ho.house_number }"></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Permanent Address (Now)</strong>
												</h6> <input type='text' class='form-control'
												name='permanent_address' value="${ho.permanent_address }"></td>
											<td><h6>
													<strong>District</strong>
												</h6> <select class='form-control'
												name='permanent_address_district'>
													<option value="">Select District</option>
													<option value="27" selected>Bhaktapur</option>
											</select></td>
											<td><h6>
													<strong>Municipality/ Vilage Council</strong>
												</h6> <select class='form-control'
												name='permanent_address_mun_vc'>
													<option value="">Select Muncipality</option>
													<option value="32703" selected>Madhyepur Thimi</option>
											</select></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Ward No</strong>
												</h6> <select class='form-control'
												name='permanent_address_ward_no'>
													<option value="">Select Ward No</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
											</select></td>
											<td><h6>
													<strong>Temporary Address</strong>
												</h6> <input type='text' class='form-control'
												name='temporary_address' value="${ho.temporary_address }"></td>
											<td><h6>
													<strong>Gender</strong>
												</h6> <select class='form-control' name='gender'>
													<option value="m">Male</option>
													<option value="f">Female</option>
											</select></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Date Of Birth (Nepali YYYYMMDD)</strong>
												</h6> <input type='text' class='form-control' name='dob_nep'
												value="${ho.dob_nep}"></td>
											<td><h6>
													<strong>Phone Number</strong>
												</h6> <input type='text' class='form-control'
												name='phone_number ' value="${ho.phone_number }"></td>
											<td><h6>
													<strong>Mobile Number</strong>
												</h6> <input type='text' class='form-control' name='mobile_no'
												value="${ho.mobile_no }"></td>
										</tr>
										<tr>
											<td><h6>
													<strong>E_mail Address</strong>
												</h6> <input type='text' class='form-control' name='email'
												value="${ho.email }"></td>
											<td><h6>
													<strong>Education Status</strong>
												</h6> <select class='form-control' name='education_status'>
													<option value="">Select Education Status</option>
													<c:forEach var="edu" items="${edu}">

														<option value="${edu.edu_id }"
															<c:if test="${edu.edu_id eq ho.education_status}">selected</c:if>>${edu.education_type }</option>
													</c:forEach>
											</select></td>
											<td><h6>
													<strong>Occupation</strong>
												</h6> <select class='form-control' name='occupation_id'>
													<option value="1">Select Occupation</option>
													<c:forEach items="${occupation }" var="o">
														<option value="${o.occu_id }">${o.occupation_type }</option>
													</c:forEach>
											</select></td>

										</tr>
										<tr>
											<td><h6>
													<strong>Disablilty if any</strong>
												</h6> <select class='form-control' name='disable_type'>
													<option value="">Select Disability</option>
													<c:forEach items="${disablity }" var="d">
														<option value="${d.id }">${d.typehead }</option>
													</c:forEach>
													</select>
											<td><h6>
													<strong>PAN Number</strong>
												</h6> <input type='text' class='form-control' name='pan_Number'></td>
											<td><h6>
													<strong>Record Status</strong>
												</h6> <input type='text' class='form-control'
												name='record_status'></td>
										</tr>
									


									</tbody>
								</table>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="tab_content2"
								aria-labelledby="profile-tab">
								<table class="table">
									<tbody>
									<c:if test="${empty ownerList }">
									<tr>
											<!-- <td><h6>
													<strong>House Owner ID</strong>
												</h6> <input type='text' class='form-control'
												name='house_owener_id'></td> -->
												
											
											<td><h6>
													<strong>Identity Type</strong>
												</h6> <input type='text' class='form-control' name='id_type' value=""></td>
											<td><h6>
													<strong>Identity Number</strong>
												</h6> <input type='text' class='form-control' name='id_number' value=""></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Issue Date</strong>
												</h6> <input type='text' class='form-control' name='issue_date' value=""></td>
											
											<td><h6>
													<strong>Expiry Date</strong>
												</h6> <input type='text' class='form-control' name='expiry_date' value=""></td>
											<td><h6>
													<strong>Issued By</strong>
												</h6> <input type='text' class='form-control' name='issued_by' value=""></td>
										</tr>
									</c:if>
										 <c:forEach items="${ownerList }" var="o" varStatus="descIndex">
										<tr>
											<!-- <td><h6>
													<strong>House Owner ID</strong>
												</h6> <input type='text' class='form-control'
												name='house_owener_id'></td> -->
												
											
											<td><h6>
													<strong>Identity Type</strong>
												</h6> <input type='text' class='form-control' name='id_type' value="${o[descIndex.index].id_type }"></td>
											<td><h6>
													<strong>Identity Number</strong>
												</h6> <input type='text' class='form-control' name='id_number' value="${o[descIndex.index].id_number }"></td>
										</tr>
										<tr>
											<td><h6>
													<strong>Issue Date</strong>
												</h6> <input type='text' class='form-control' name='issue_date' value="${o[descIndex.index].issue_date }"></td>
											
											<td><h6>
													<strong>Expiry Date</strong>
												</h6> <input type='text' class='form-control' name='expiry_date' value="${o[descIndex.index].expiry_date }"></td>
											<td><h6>
													<strong>Issued By</strong>
												</h6> <input type='text' class='form-control' name='issued_by' value="${o[descIndex.index].issued_by }"></td>
										</tr>
										
										</c:forEach>
										
									</tbody>
								</table>
							</div>


						</div>
					</div>

				</div>

			</div>
		</form>
	</div>
	<script>
		function nepaliToEnglish(nepalidate, englishdate) {
			var date = $(nepalidate).val();
			var dataString = {
				'nepalidate' : date
			};
			$.ajax({
				type : "POST",
				url : "nepaliToEnglish",
				data : dataString,
				cache : false,
				success : function(html) {
					$(englishdate).val(html);
				},
				error : function() {
					alert("error occured");
				}

			});
		}
		function englishToNepali(nepalidate, englishdate) {
			var date = $(englishdate).val();
			var dataString = {
				'englishdate' : date
			};
			$.ajax({
				type : "POST",
				url : "englishToNepali",
				data : dataString,
				cache : false,
				success : function(html) {
					$(nepalidate).val(html);
				},
				error : function() {
					alert("error occured");
				}
			});
		}

		$(".alert").delay(2000).slideUp(200, function() {
			$(this).alert('close');
		});
	</script>
</body>
</html>

