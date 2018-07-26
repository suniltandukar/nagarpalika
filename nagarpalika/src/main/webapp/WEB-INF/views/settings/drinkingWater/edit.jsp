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
				<spring:url value="/drinkingWater/update/${drinkingwater.drinking_water_type }" var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>UPDATE DRINKING WATER TYPE</h2>
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
								<a class="btn btn-danger confirm" href="<spring:url value="/drinkingWater/delete/${drinkingwater.drinking_water_type_id }"/>">Delete</a>
								<input type="submit" class="btn btn-success" value="Update">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Description</strong>
										</h6> <input type='text' class='form-control' name='drinking_water_type' value="${drinkingwater.drinking_water_type }"></td>
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
						<h2>AVAILABLE DRINKING WATER TYPE</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline" style="font-size: 95%; width: 100%;">
							<thead>
								<tr>
								<th>Document Type</th>
								<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${drinkingWaterType }" var="d">
								<tr>
									<td>${d.drinking_water_type }</td>
									<td><a href="<spring:url value="/drinkingWater/edit/${d.drinking_water_type_id }"/>">Edit</a></td>
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
		$(".alert").delay(2000).slideUp(200, function() {
			$(this).alert('close');
		});
	</script>
</body>
</html>
