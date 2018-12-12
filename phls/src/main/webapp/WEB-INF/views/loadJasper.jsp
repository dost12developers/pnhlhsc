<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<html>
<head>
<style>
.error {
	color: #ff0000;
}
 

</style>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>
</head>
 
<body>
	<h2>Spring MVC Jasper Report example</h2>
	
	<h3>Generate Report for Employees Working More than or equal to given year</h3>
 
	<form:form method="POST" action="${contextRoot}/laboratory/generateReport" commandName="jasperInputForm">
		
		<table id="reptbl" width="350px" border="1">
		<tr>
		<td colspan="2"><form:errors path="noofYears" cssClass="error"/></td> </tr>
  		<tr>
  			<td>
  			    Enter Number of Years <form:input path="noofYears" id="noofYears"/>
    			<input type="submit"  value="Generate Employee List"  />
 			</td> 
 			<td>
 				<form:radiobuttons path="rptFmt" items="${jasperRptFormats}"/>
 			</td>
 
		</tr>
		
		
 
         </table>  
		
	
	</form:form>
 
</body>
</html>