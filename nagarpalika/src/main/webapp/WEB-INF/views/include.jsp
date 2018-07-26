<html>
<head>
<!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/scroller.bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/resources/css/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/css/custom.min.css" rel="stylesheet">
    <style>
    	.background{
    	background-color:#F7F7F7;}
    	#myImg {
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
    display: block;
    margin-left: auto;
    margin-right: auto
}

#myImg:hover {opacity: 0.7;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
    margin: auto;
    display: block;
    width: 75%;
    //max-width: 75%;
}

/* Caption of Modal Image */
#caption {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
}

/* Add Animation */
.modal-content, #caption {
    -webkit-animation-name: zoom;
    -webkit-animation-duration: 0.6s;
    animation-name: zoom;
    animation-duration: 0.6s;
}

.out {
  animation-name: zoom-out;
  animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
    from {-webkit-transform:scale(1)}
    to {-webkit-transform:scale(2)}
}

@keyframes zoom {
    from {transform:scale(0.4)}
    to {transform:scale(1)}
}

@keyframes zoom-out {
    from {transform:scale(1)}
    to {transform:scale(0)}
}

/* The Close Button */
.close {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}

.close:hover,
.close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
    .modal-content {
        width: 100%;
    }
}
    </style>
</head>
<body>
 <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
     <!-- Datatables -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.buttons.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/buttons.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/buttons.flash.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/buttons.html5.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/buttons.print.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.fixedHeader.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.keyTable.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/responsive.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.scroller.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jszip.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pdfmake.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/vfs_fonts.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath}/resources/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${pageContext.request.contextPath}/resources/js/nprogress.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/resources/js/custom.min.js"></script>
    
    <!-- Form Required Scripts -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/nepaliDatePicker/nepali.datepicker.v2.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dynamicselect.js"></script> 
	 
</body>
</html>