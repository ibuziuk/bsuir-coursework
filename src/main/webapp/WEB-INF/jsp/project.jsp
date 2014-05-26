<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BSUIR coursework</title>
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
            <li class="active"><a href="/bsuir-coursework/">Projects</a></li>
            <li><a href="/bsuir-coursework/customer">Customers</a></li>
            <li><a href="#">Employees</a></li>
            <li><a href="#">Teams</a></li>
            <li><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
    </div>
</nav>
 
<h2><spring:message code="label.title"/></h2>
 
<form:form method="post" action="add" commandName="project">
 	<form:errors path="*" cssClass="errorblock" element="div" />
    <table class="table table-striped table-bordered table-condensed">
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name" /></td> 
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="details"><spring:message code="label.details"/></form:label></td>
        <td><form:input path="details" /></td>
    </tr>
    <tr>
        <td><form:label path="customer"><spring:message code="label.customer"/></form:label></td>
        <td>
        	<form:select path="customer.id" commandName="customerId">
   				<form:option value="" label="--- Select ---" />
   				<form:options items="${customerList}" required="true" itemLabel="name" itemValue="id" />
			</form:select>
		</td>
		<td><form:errors path="customer" cssClass="error" /></td>
    </tr>   
</table>  
     <input type="submit" class="btn btn-success btn-large" value="<spring:message code="label.addProject"/>"/>
</form:form>
 
     
<h3>Projects</h3>
<c:if  test="${!empty projectList}">
<table class="data" class="table table-striped table-bordered table-condensed">
<tr>
    <th>Name</th>
    <th>Details</th>
    <th>Customer</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${projectList}" var="project">
    <tr>
        <td>${project.name}</td>
        <td>${project.details}</td>
        <td>${project.customer.name}</td>
        <td><a href="delete/${project.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>