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
				<spring:url value="/businesstype/update/${findById.business_type_id }" var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>UPDATE BUSINESS TYPE</h2>
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
								<a class="btn btn-danger confirm" href="<spring:url value="/businesstype/delete/${findById.business_type_id }"/>">Delete</a>
								<input type="submit" class="btn btn-success" value="Update">
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
								<td><h6>
											<strong>Business ID</strong>
										</h6> <input type='text' class='form-control' name='business_type_id' maxlength="2" value="${findById.business_type_id }" disabled></td>
									<td><h6>
											<strong>Business Type</strong>
										</h6> <input type='text' class='form-control' name='business_type' value="${findById.business_type}"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
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
