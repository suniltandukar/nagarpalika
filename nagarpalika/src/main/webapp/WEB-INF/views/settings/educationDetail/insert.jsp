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
				<spring:url value="/educationDetail/save" var="formUrl" />
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
								<input type="submit" class="btn btn-success" value="Submit">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Education ID</strong>
										</h6> <input type='text' class='form-control' name='edu_id'></td>
									<td><h6>
											<strong>Education Type</strong>
										</h6> <input type='text' class='form-control' name='education_type'></td>
								</tr>
								
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>AVAILABLE EDUCATION DETAIL</h2>
					<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<table class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline" style="font-size: 95%; width: 100%;">
					<thead>
						<tr>
							<th>Education Id</th>
							<th>Education Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${educationDetail }" var="e">
					<tr>
							<td>${e.edu_id }</td>
							<td>${e.education_type }</td>
							<td><a href="<spring:url value="/educationDetail/edit/${e.edu_id}"/>">Edit</a></td>
						</tr>
					</c:forEach>
						
					
					</tbody>
					
					</table>
				</div>
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
