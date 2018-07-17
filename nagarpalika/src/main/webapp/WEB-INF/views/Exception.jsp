<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="include.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body class="background">
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">&times;</a>

        <strong>Warning!</strong> Exception Occured! Please Contact to administrator.
        - Digi Nepal.
        
        Exception Found:
        ${exception }
    </div>
</body>
</html>