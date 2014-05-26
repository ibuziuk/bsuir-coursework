<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
</head>

<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<body>

<nav role="navigation" class="navbar navbar-default">
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/bsuir-coursework/">Projects</a></li>
            <li class="active"><a href="/bsuir-coursework/customer">Customers</a></li>
            <li><a href="#">Employees</a></li>
            <li><a href="#">Teams</a></li>
            <li><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
    </div>
</nav>
  
<form:form method="post" action="addCustomer" commandName="customer">
 	<form:errors path="*" cssClass="errorblock" element="div" />
    <table class="table table-striped table-bordered table-condensed">
    	<tr>
		     <td><form:label path="name"><spring:message code="label.customerName"/></form:label></td>
		     <td><form:input path="name" /></td> 
		     <td><form:errors path="name" cssClass="error" /></td>
    	</tr>
	</table>  
    <input type="submit" class="btn btn-success btn-large" value="<spring:message code="label.addCustomer"/>"/>
</form:form>

<c:choose>
  <c:when test="${!empty customerList}">   
		<h3>Our Customers</h3>
		<table class="table table-striped table-bordered table-condensed" > 
		<tr>
		    <th>Name</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
		   <tr>
		       <td>${customer.name}</td>
		       <td><a href="deleteCustomer/${customer.id}">Delete</a></td>
		   </tr>
		</c:forEach>
		</table>
</c:when>
  <c:otherwise>
  		<h3>We have no customers yet</h3>	
  </c:otherwise>
</c:choose>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>