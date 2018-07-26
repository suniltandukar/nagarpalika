<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body class="background">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-12 col-xs-12">
			<div class="x_panel">
				
					<div class="x_title">
						<h2>HOUSE AND LAND DETAIL</h2>
						<div class="col-md-4 col-sm-4 col-xs-12 pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					<table id="datatable" class="table jambo_table table-striped table-bordered dt-responsive nowrap display dataTable dtr-inline" style="font-size: 95%; width: 100%;">
					<thead>
						<tr>
							<th>Resident ID</th>
							<th>House Number</th>
							<th>Land and House ID</th>
							<th>Ownership Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${houseLandDetail}" var="h">
						<tr>
						<td>${h.houseOwnerDetailModel.house_owner_id }</td>
							<td>${h.house_number }</td>
							<td>${h.land_house_id }</td>
							<td>${h.ownership_type }</td>
							<td><a href="<spring:url value="/houseLand/edit/${h.house_and_land_detail_id }"/>">Edit</a></td>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					</div>
			</div>
		</div>
	</div>
</body>
</html>