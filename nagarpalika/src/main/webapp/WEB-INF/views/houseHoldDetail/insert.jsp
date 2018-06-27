<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include.jsp"></jsp:include>

<html>
<head>
</head>
<body class="background">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>HOUSE HOLD DETAIL</h2>

				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
				</ul>

				<form method="post"
					action="<spring:url value="/student/studentRegistration"></spring:url>"
					id="form"></form>
				<button type="submit" class="btn btn-success " form="form">
					<i class="fa fa-check"></i> SUBMIT
				</button>
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
											name='house_owener_id'></td>
										<td><h6>
												<strong>First Name</strong>
											</h6> <input type='text' class='form-control'
											name='house_owner_first_name'></td>
										<td><h6>
												<strong>Middle Name</strong>
											</h6> <input type='text' class='form-control'
											name='house_owner_middle_name'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Last Name</strong>
											</h6> <input type='text' class='form-control'
											name='house_owner_last_name'></td>
										<td><h6>
												<strong>Marital Status (Y/N)</strong>
											</h6> <input type='text' class='form-control'
											name='marital_status'></td>
										<td><h6>
												<strong>Grand Father's Name</strong>
											</h6> <input type='text' class='form-control'
											name='grand_father_name'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Father's Name</strong>
											</h6> <input type='text' class='form-control' name='father_name'></td>
										<td><h6>
												<strong>Spouse Name</strong>
											</h6> <input type='text' class='form-control' name='spouse_name'></td>
										<td><h6>
												<strong>House Number</strong>
											</h6> <input type='text' class='form-control' name='house_number'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Permanent Address (Now)</strong>
											</h6> <input type='text' class='form-control'
											name='permanent_address'></td>
										<td><h6>
												<strong>District</strong>
											</h6> <select class='form-control'
											name='permanent_address_district'>
											<option value="">Select District</option>
											</select></td>
										<td><h6>
												<strong>Municipality/ Vilage Council</strong>
											</h6> <select class='form-control'
											name='permanent_address_mun_vc'>
											<option value="">Select Muncipality</option>
											</select></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Ward No</strong>
											</h6> <select class='form-control'
											name='permanent_address_ward_no'>
											<option value="">Select Ward No</option>
											</select>
											</td>
										<td><h6>
												<strong>Temporary Address</strong>
											</h6> <input type='text' class='form-control'
											name='temporary_address'></td>
										<td><h6>
												<strong>Gender</strong>
											</h6> <input type='text' class='form-control' name='gender'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Date Of Birth (Nepali YYYYMMDD)</strong>
											</h6> <input type='text' class='form-control' name='DOB_nep'></td>
										<td><h6>
												<strong>Phone Number</strong>
											</h6> <input type='text' class='form-control' name='Phone_number '></td>
										<td><h6>
												<strong>Mobile Number</strong>
											</h6> <input type='text' class='form-control' name='Mobile_no'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>E_mail Address</strong>
											</h6> <input type='text' class='form-control' name='email'></td>
										<td><h6>
												<strong>Education Status</strong>
											</h6> <select class='form-control'
											name='education_status'>
											<option>Select Education Status</option>
											</select></td>
										<td><h6>
												<strong>Occupation</strong>
											</h6> <select class='form-control' name='occupation_id'>
											<option value="">Select Occupation</option>
											</select></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Disablilty if any</strong>
											</h6> <input type='text' class='form-control' name='disable_type'></td>
										<td><h6>
												<strong>PAN Number</strong>
											</h6> <input type='text' class='form-control' name='pan_Number'></td>
										<td><h6>
												<strong>Record Status</strong>
											</h6> <input type='text' class='form-control' name='record_status'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Company ID</strong>
											</h6> <input type='text' class='form-control' name='company_id'></td>
										<td><h6>
												<strong>Branch ID</strong>
											</h6> <input type='text' class='form-control' name='branch_id'></td>
										<td><h6>
												<strong>Inputter</strong>
											</h6> <input type='text' class='form-control' name='inputter'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Authorizer</strong>
											</h6> <input type='text' class='form-control' name='authorizer'></td>
										<td><h6>
												<strong>date and Time</strong>
											</h6> <input type='text' class='form-control' name='date_time'></td>
										<td><h6>
												<strong>Current Number</strong>
											</h6> <input type='text' class='form-control' name='curr_number'></td>
									</tr>


								</tbody>
							</table>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab_content2"
							aria-labelledby="profile-tab">
							<table class="table">
								<tbody>
									<tr>
										<td><h6>
												<strong>House Owner ID</strong>
											</h6> <input type='text' class='form-control'
											name='house_owener_id'></td>
										<td><h6>
												<strong>Identity Type</strong>
											</h6> <input type='text' class='form-control' name='id_type'></td>
										<td><h6>
												<strong>Identity Number</strong>
											</h6> <input type='text' class='form-control' name='id_number'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Issue Date</strong>
											</h6> <input type='text' class='form-control' name='issue_date'></td>
										<td><h6>
												<strong>Expiry Date</strong>
											</h6> <input type='text' class='form-control' name='expiry_date'></td>
										<td><h6>
												<strong>Issued By</strong>
											</h6> <input type='text' class='form-control' name='issued_by'></td>
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
										<td><h6>
												<strong>date and Time</strong>
											</h6> <input type='text' class='form-control' name='date_time'></td>
									</tr>
									<tr>
										<td><h6>
												<strong>Current Number</strong>
											</h6> <input type='text' class='form-control' name='curr_number'></td>
									</tr>
								</tbody>
							</table>
						</div>


					</div>
				</div>

			</div>
		</div>
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
	</script>
</body>
</html>

