<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css/lab/css" />
<spring:url var="js" value="/resources/js/lab/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

  <head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="DOST XII">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<title>${title} - Philippine National Halal Laboratory and Halal Science
	Center</title>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>
    <!-- Bootstrap core CSS-->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="${css}/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${css}/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

   <%@include file="./shared/lab/navbar.jsp"%>

    <div id="wrapper">

      <!-- Sidebar -->
	 <%@include file="./shared/lab/sidebar.jsp"%>

      <div id="content-wrapper">

        <div class="container-fluid">

  			<%@include file="lab-home.jsp"%>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © DOST XII</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${js}/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="${js}/Chart.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${js}/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="${js}/demo/datatables-demo.js"></script>
    <script src="${js}/demo/chart-area-demo.js"></script>

  </body>

</html>
