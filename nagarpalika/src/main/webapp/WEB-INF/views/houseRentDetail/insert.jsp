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
						<h2>HOUSE RENT DETAIL</h2>
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
										<strong>Rented Storied</strong>
									</h6> <input type='text' class='form-control' name='rented_storied'></td>
							</tr>
							<tr>
								<td><h6>
										<strong>Rented Room</strong>
									</h6> <input type='text' class='form-control' name='rented_room'></td>
								<td><h6>
										<strong>Rented from</strong>
									</h6> <input type='text' class='form-control' name='rented_from'></td>
								<td><h6>
										<strong>Rented Purpose</strong>
									</h6> <input type='text' class='form-control' name='rented_purpose'></td>
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
