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
			<c:if test="${empty bmedit }">
				<spring:url value="/branch/save" var="formUrl" />
			</c:if>
			
			<c:if test="${not empty bmedit }">
				<spring:url value="/branch/update/${bmedit.branch_id}" var="formUrl" />
			</c:if>
				
				<form method="post" action="${formUrl }">

					<div class="x_title">
						<h2>NEW BRANCH</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group">
							<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
								<c:if test="${empty bmedit.name }">
								<button class="btn btn-info" type="button" id="validate">Validate</button>
								<button class="btn btn-primary" type="reset">Reset</button>
								<input type="submit" class="btn btn-success" value="Submit">
								</c:if>
								<c:if test="${not empty bmedit.name }">
								<button class="btn btn-info" type="submit" id="validate">Update</button>
								</c:if>
							</div>
						</div>
						<br />
						<table class="table">
							<tbody>
								<tr>
									<td><h6>
											<strong>Company Id</strong>
										</h6> <input type='text' class='form-control' name='company_id' value="${bmedit.company_id }"></td>

									<td><h6>
											<strong>Name</strong>
										</h6> <input type='text' class='form-control' name='name' value="${bmedit.name }"></td>
										
									<td><h6>
											<strong>Address</strong>
										</h6> <input type='text' class='form-control' name='address' value="${bmedit.address }"></td>
								</tr>
								<tr>
									
									<td><h6>
											<strong>Phone No.</strong>
										</h6> <input type='text' class='form-control' name='phone' value="${bmedit.phone }"></td>
									<td><h6>
											<strong>Email</strong>
										</h6> <input type='text' class='form-control' name='email' value="${bmedit.email }"></td>
										<td><h6>
											<strong>Fax</strong>
										</h6> <input type='text' class='form-control' name='fax' value="${bmedit.fax }"></td>
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
					<table
						class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline"
						style="font-size: 95%; width: 100%;">
						<thead>
							<tr>
								<th>Branch Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Fax</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							 <c:forEach items="${bm }" var="b">
					<tr>
							<td>${b.branch_id}</td>
							<td>${b.name }</td>
							<td>${b.address }</td>
							<td>${b.phone }</td>
							<td>${b.fax }</td>
							<td><a href="<spring:url value="/branch/edit/${b.branch_id}"/>">Edit</a></td>
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
