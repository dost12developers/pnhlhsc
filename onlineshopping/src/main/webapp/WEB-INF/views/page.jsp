<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Online Shopping Website">
<meta name="author" content="DOST XII">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>${title} - Onlineshopping</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'

	window.image = '${images}';

	window.categoryId = '';
</script>
<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
     
<!-- Custom CSS -->
<!-- Bootstrap Readable Theme -->

<%--   <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">   --%>
  <link href="${css}/myapp.css" rel="stylesheet"> 
 


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- <div class="se-pre-con"></div> -->
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickServicesLaboratory == true }">
				<%@include file="servicesLaboratory.jsp"%>
			</c:if>
	
			<c:if test="${userClickServicesLabTesting == true }">
				<%@include file="serviceLabTesting.jsp"%>
			</c:if>
			
			<c:if test="${userClickServicesLabOnSite == true }">
				<%@include file="serviceLabOnSite.jsp"%>
			</c:if>
			
			<c:if test="${userClickServicesFoodDev == true }">
				<%@include file="servicesFoodDevelopment.jsp"%>
			</c:if>

			<c:if test="${userClickServicesPackageLabel == true }">
				<%@include file="servicesPackageLabel.jsp"%>
			</c:if>
			
			<c:if test="${userClickServicesResearch == true }">
				<%@include file="servicesResearch.jsp"%>
			</c:if>
						
			<c:if test="${userClickMultimedia == true }">
				<%@include file="multimedia.jsp"%>
			</c:if>
	
			<c:if test="${userClickAllProducts == true }">
				<%@include file="viewProducts.jsp"%>
			</c:if>		
			
			<c:if test="${userClickCategoryProducts == true }">
				<%@include file="viewProducts.jsp"%>
			</c:if>					

			<c:if test="${userClickShowProduct == true }">
				<%@include file="viewProduct.jsp"%>
			</c:if>	
			
			<c:if test="${userClickEnterprise == true }">
				<%@include file="enterprise.jsp"%>
			</c:if>	
			
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>					

			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>	
			
			<c:if test="${userClickShowCart == true }">
				<%@include file="cart.jsp"%>
			</c:if>	
						
		</div>

		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>
		
 		<script src="${js}/jquery.min.js"></script>	
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/bootbox.min.js"></script>
		
		<script src="${js}/myapp.js"></script>
			
		<script src="${js}/list.min.js"></script>
		<!-- Self coded javascript -->	
	

</body>

</html>