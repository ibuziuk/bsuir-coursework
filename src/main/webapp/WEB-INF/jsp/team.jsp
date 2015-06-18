<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="${controllerRequestMapping}" var="baseUrl"/>
<!DOCTYPE html>
<html>
<head>
    <title>Team</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet">
</head>
<body>

<nav role="navigation" class="navbar navbar-default">
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/bsuir-coursework/project">Projects</a></li>
            <li><a href="/bsuir-coursework/customer">Customers</a></li>
            <li><a href="/bsuir-coursework/employee">Employees</a></li>
            <li><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
    </div>
</nav>
      
<c:choose>
	<c:when test="${!empty team}">
		<hr class="divider">
		<h2>${project.name} Team</h2>
		<table class="table table-striped table-bordered table-condensed" >
		<tr>
		    <th>Name</th>
		    <th>Birthday</th>
		    <th>Email</th>
		    <th>Project</th>
		    <th>Role</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${team}" var="employee">
		    <tr>
		        <td>${employee.name}</td>
	 	        <td>${employee.birthday}</td> 	
	 	        <td>${employee.email}</td> 	
		        <td>${employee.project.name}</td>
		        <td>${employee.role.name}</td>
		       	<td><a href="${baseUrl}/bsuir-coursework/employee/remove/${employee.employeeId}" class="btn btn-danger btn-large"><i class="glyphicon glyphicon-remove"></i> Delete</a></td>
		    </tr>
		</c:forEach>
		</table>
	</c:when>
	  <c:otherwise>
	  		<h2>We have no employees assigned to ${project.name}</h2>	
	  </c:otherwise>
</c:choose>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>