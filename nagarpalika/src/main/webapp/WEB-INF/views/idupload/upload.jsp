<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="../include.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
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
		<div class="col-md-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>IMAGE UPLOAD FORM</h2>
					<c:if test="${not empty msg }">
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
							<div class="alert alert-success">
								<strong>${msg }</strong>
							</div>
						</div>
					</c:if>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<spring:url value="/upload/idupload" var="uploadUrl" />
					<form method="post" enctype="multipart/form-data"
						action="${uploadUrl }">
						<div class="form-group">
							<div class="col-md-12">
								<div class="col-md-4">

									<select class="form-control" name="house_owner_id">
										<option value="">Select Resident Id</option>
											<c:forEach items="${houseOwner }" var="h">
												<option value="${h.house_owner_id }">${h.house_owner_id }/${h.house_owner_fname }
													${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select>
								</div>
								<div class="col-md-4">
									<select class="form-control" name="document_type">
										<option value="">Select Doc. Type</option>
										<option value="101">Photo</option>
										<option value="102">Citizenship No</option>
										<option value="103">Character Certificate</option>
										<option value="104">Marksheet</option>
										<option value="105">Bank Voucher</option>
																			
									</select>
								</div>
								<div class="col-md-4">
									<input class="form-control" type="file" name="files"
										accept="image/*" required>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-4">
								<br>
									<input type="submit" class="btn btn-success" value="Upload">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(".alert").delay(2000).slideUp(200, function() {
		$(this).alert('close');
	});
	</script>
</body>
</html>