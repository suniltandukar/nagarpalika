<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
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
		<div class="col-md-12 col-xs-12">
			<div class="x_panel">
				
					<div class="x_title">
						<h2>House Owner Details</h2>
						<c:if test="${not empty msg }">
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right">
						<div class="alert alert-success"><strong>${msg }</strong></div>
						</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					<table class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline" style="font-size: 95%; width: 100%;">
					<thead>
						<tr>
							<th>House Owner Id</th>
							<th>Full Name</th>
							<th>House No.</th>
							<th>Marital Status</th>
							<th>DOB (Nep)</th>
							<th>Permanent Address</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="f">
						<tr>
							<td>${f.house_owner_id }</td>
							<td>${f.house_owner_fname } ${f.house_owner_mname } ${f.house_owner_lname }</td>
							<td>${f.house_number }</td>
							<td>${f.marital_status }</td>
							<td>${f.dob_nep }</td>
							<td>${f.permanent_address }</td>
							
							<td><a href="<spring:url value="/houseOwner/edit/${f.house_owner_id }"/>">Edit</a></td>
							
						</tr>
						</c:forEach>
					</tbody>
					</table>
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