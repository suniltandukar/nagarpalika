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
				<spring:url value="/documentType/save" var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>DOCUMENT TYPE</h2>
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
											<strong>Id Type</strong>
										</h6> <input type='text' class='form-control' name='id_type'></td>
									<td><h6>
											<strong>Description</strong>
										</h6> <input type='text' class='form-control' name='description'></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
					<div class="x_title">
						<h2>AVAILABLE DOCUMENT TYPE</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline" style="font-size: 95%; width: 100%;">
							<thead>
								<tr>
								<th>Document Type</th>
								<th>Description</th>
								<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${documentType }" var="d">
								<tr>
									<td>${d.id_type }</td>
									<td>${d.description }</td>
									
									<td><a href="<spring:url value="/documentType/edit/${d.id_type }"/>">Edit</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
		</div>
	</div>

	<script>
		$(".confirm").click(function() {
			return confirm("Confirm?");
		})
		$("form").submit(function() {
			return confirm("Confirm Submit?");
		});
	</script>
</body>
</html>
