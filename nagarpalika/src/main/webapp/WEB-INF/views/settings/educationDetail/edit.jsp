<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../include.jsp"></jsp:include>
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
				<spring:url value="/educationDetail/update/${ed.edu_id }" var="formUrl" />
				<form method="post" action="${formUrl }">

					<div class="x_title">
						<h2>EDUCATION DETAIL</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group">
							<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
								<button class="btn btn-info" type="button" id="validate">Validate</button>
								<button class="btn btn-primary" type="reset">Reset</button>
								<a class="btn btn-danger confirm" href="<spring:url value="/educationDetail/delete/${ed.edu_id }"/>">Delete</a>
								<input type="submit" class="btn btn-success" value="Update">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Education ID</strong>
										</h6> <input type='text' class='form-control' name='edu_id' value="${ed.edu_id }"></td>
									<td><h6>
											<strong>Education Type</strong>
										</h6> <input type='text' class='form-control' name='education_type' value="${ed.education_type }"></td>
									<td><h6>
											<strong>Record Status</strong>
										</h6> <input type='text' class='form-control' name='record_status' value="${ed.record_status }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Inputter</strong>
										</h6> <input type='text' class='form-control' name='inputter' value="${ed.inputter }"></td>
									<td><h6>
											<strong>Authorizer</strong>
										</h6> <input type='text' class='form-control' name='authorizer' value="${ed.authorizer }"></td>
									<td><h6>
											<strong>date and Time</strong>
										</h6> <input type='text' class='form-control' name='date_time' value="${ed.date_time }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Current Number</strong>
										</h6> <input type='text' class='form-control' name='curr_number' value="${ed.curr_number }"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
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
