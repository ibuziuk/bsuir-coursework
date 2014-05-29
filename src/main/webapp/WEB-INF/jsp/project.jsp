<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BSUIR coursework</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/error.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
</head>
<body>

<nav role="navigation" class="navbar navbar-default">
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/bsuir-coursework/">Projects</a></li>
            <li><a href="/bsuir-coursework/customer">Customers</a></li>
            <li><a href="/bsuir-coursework/employee">Employees</a></li>
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
        <td><form:label path="budget"><spring:message code="label.budget"/></form:label></td>
        <td><form:input path="budget" type="number"/></td>
        <td><form:errors path="budget" cssClass="error" /></td>
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
     <input type="submit" class="btn btn-success btn-large fixed-width" value="<spring:message code="label.addProject"/>"/>
</form:form>
      
<c:choose>
	<c:when test="${!empty projectList}">
		<hr class="divider">
		<h3>Our Projects</h3>
		<table class="table table-striped table-bordered table-condensed" >
		<tr>
		    <th>Name</th>
		    <th><spring:message code="label.budget"/></th>
		    <th>Customer</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${projectList}" var="project">
		    <tr>
		        <td>${project.name}</td>
		        <td>${project.budget}</td>
		        <td>${project.customer.name}</td>
		        <td>
		        	<div class="center">
			        	<a href="delete/${project.id}" class="btn btn-danger btn-large fixed-width"><i class="glyphicon glyphicon-trash"></i> Delete</a>
				        <a href="editProject/${project.id}" class="btn btn-warning btn-large fixed-width"><i class="glyphicon glyphicon-edit"></i> Edit</a>
				        <a href="getTeam/${project.id}" class="btn btn-primary btn-large fixed-width"><i class="glyphicon glyphicon-user"></i> View Team</a>
		        	</div>
		        </td>
		    </tr>
		</c:forEach>
		</table>
	</c:when>
	  <c:otherwise>
	  		<h3>We have no projects yet</h3>	
	  </c:otherwise>
</c:choose>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>