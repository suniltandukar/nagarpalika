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
		<div class="col-md-8 col-xs-12">
			<div class="x_panel">
				<spring:url value="/familyDetail/update/${fd.family_detail_id }"
					var="formUrl" />
				<form:form class="form-horizontal form-label-left input_mask"
					method="post" action="${formUrl }">

					<div class="x_title">
						<h2>UPDATE FAMILY DETAIL</h2>
						<c:if test="${not empty msg }">
							<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
								<div class="alert alert-danger">
									<strong>${msg }<br>${msga }</strong>
								</div>
							</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group">
							<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
								<button class="btn btn-info" type="button" id="validate">Validate</button>
								<button class="btn btn-primary" type="reset">Reset</button>

								<a class="btn btn-danger confirm"
									href="<spring:url value="/familyDetail/delete/${fd.family_detail_id }"/>">Delete</a>
								<input type="submit" class="btn btn-success" value="Update">

								<a class="btn btn-info"
									href="<spring:url value="/nav/familyDetail"/>"> Add New</a>
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
							<tr>
									<td></td>
										<td><img id="myImg"
										src="//124.41.193.91/images/thimi/${fd.houseOwnerDetailModel.house_owner_id }FAM${fd.relationModel.relation }.jpg"
										style="height: 100px; width: 100px;" /></td>
										<td></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Resident Id</strong>
										</h6> <select class='form-control'
										name='houseOwnerDetailModel.house_owner_id' required>
											<option value="">Select Resident Id</option>
											<c:forEach items="${houseOwner }" var="h">
												<option value="${h.house_owner_id }"
													<c:if test="${h.house_owner_id eq fd.houseOwnerDetailModel.house_owner_id}">selected</c:if>>${h.house_owner_id }/${h.house_owner_fname }
													${h.house_owner_mname } ${h.house_owner_lname }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Relation</strong>
										</h6> <select class='form-control' name='relationModel.relation' required>
											<c:forEach items="${relation }" var="r">
												<option value="${r.relation_id }"
													<c:if test="${r.name eq fd.relationModel.relation}">selected</c:if>>${r.name }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Gender</strong>
										</h6> <select class='form-control' name='gender'>
											<option value="">Select Gender</option>
											<option value="m"
												<c:if test="${fd.gender eq 'm' }">selected</c:if>>Male</option>
											<option value="f"
												<c:if test="${fd.gender eq 'f' }">selected</c:if>>Female</option>
											<option value="o"
												<c:if test="${fd.gender eq 'o' }">selected</c:if>>Other</option>
									</select></td>

								</tr>
								<tr>
									<td><h6>
											<strong>First Name</strong>
										</h6> <input type='text' class='form-control' name='fname'
										value="${fd.fname }"></td>
									<td><h6>
											<strong>Middle Name</strong>
										</h6> <input type='text' class='form-control' name='mname'
										value="${fd.mname }"></td>
									<td><h6>
											<strong>Last Name</strong>
										</h6> <input type='text' class='form-control' name='lname'
										value="${fd.lname }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Marital Status</strong>
										</h6> <select class='form-control' name='marital_status'>
											<option value="">Select Marital Status</option>
											<option value="y"
												<c:if test="${fd.marital_status eq 'y' }">selected</c:if>>Yes</option>
											<option value="n"
												<c:if test="${fd.marital_status eq 'n' }">selected</c:if>>No</option>
									</select></td>
									<td><h6>
											<strong>Date of birth (Nepali YYYYMMDD)</strong>
										</h6> <input type='text' class='form-control' name='dob_nep'
										value="${fd.dob_nep }"></td>
								</tr>
								<tr>
									<td><h6>
											<strong>Occupation</strong>
										</h6> <select class='form-control'
										name='occupationModel.occupation_id'>
											<option value="">Select Occupation</option>
											<c:forEach items="${occupation }" var="o">
												<option value="${o.occu_id }"
													<c:if test="${o.occu_id eq fd.occupation_id }">selected</c:if>>${o.occupation_type }</option>
											</c:forEach>
									</select></td>
									<td><h6>
											<strong>Disability if any</strong>
										</h6> <select class='form-control'
										name='disableTypeModel.disable_type'>
											<option value="">Select Disability</option>
											<c:forEach items="${disablity }" var="d">
												<option value="${d.id }"
													<c:if test="${d.id eq fd.disableTypeModel.disable_type }">selected</c:if>>${d.typehead }</option>
											</c:forEach>
									</select></td>

								</tr>
								
							</tbody>
						</table>
					</div>


				</form:form>
			</div>
		</div>
	</div>
	<div id="myModal" class="modal">
		<img class="modal-content" id="img01">
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/zoomimage.js"></script>
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
