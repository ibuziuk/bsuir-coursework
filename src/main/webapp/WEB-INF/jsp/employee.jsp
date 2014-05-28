<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="${controllerRequestMapping}" var="baseUrl"/>
<!DOCTYPE html>
<html>
<head>
    <title>Employees</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/error.css"/>" rel="stylesheet">
</head>
<body>

<nav role="navigation" class="navbar navbar-default">
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/bsuir-coursework/">Projects</a></li>
            <li><a href="/bsuir-coursework/customer">Customers</a></li>
            <li class="active"><a href="/bsuir-coursework/employee">Employees</a></li>
            <li><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
    </div>
</nav>

<h2>Employee</h2>
 
<form:form method="post" action="${baseUrl}/bsuir-coursework/employee/addEmployee" commandName="employee">
 	<form:errors path="*" cssClass="errorblock" element="div" />
    <table class="table table-striped table-bordered table-condensed">
    <tr>
        <td><form:label path="name"><spring:message code="label.employee.name"/></form:label></td>
        <td><form:input path="name" /></td> 
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.employee.email"/></form:label></td>
        <td><form:input path="email" type="email"/></td>
        <td><form:errors path="email" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="birthday"><spring:message code="label.employee.birthday"/></form:label></td>
        <td><form:input path="birthday" type="date"/></td>
        <td><form:errors path="birthday" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="project"><spring:message code="label.project"/></form:label></td>
        <td>
        	<form:select path="project.id" commandName="projectId">
   				<form:option value="" label="--- Select ---" />
   				<form:options items="${projectList}" required="true" itemLabel="name" itemValue="id" />
			</form:select>
		</td>
		<td><form:errors path="project" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="role"><spring:message code="label.employee.role"/></form:label></td>
        <td>
        	<form:select path="role.id" commandName="roleId">
   				<form:option value="" label="--- Select ---" />
   				<form:options items="${roleList}" required="true" itemLabel="name" itemValue="id" />
			</form:select>
		</td>
		<td><form:errors path="role" cssClass="error" /></td>
    </tr>   
</table>  
     <input type="submit" class="btn btn-success btn-large" value="<spring:message code="label.addEmployee"/>"/>
     <a href="${baseUrl}/bsuir-coursework/employee/listUnassignedEmployees" class="btn btn-primary btn-large"><i class="glyphicon glyphicon-user"></i> Show Unassigned Employees</a>
</form:form>
	
	
      
<c:choose>
	<c:when test="${!empty employeeList}">
		<hr class="divider">
		<h3>Our Employees</h3>
		<table class="table table-striped table-bordered table-condensed" >
		<tr>
		    <th>Name</th>
		    <th>Birthday</th>
		    <th>Email</th>
		    <th>Project</th>
		    <th>Role</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
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
	  		<h3>We have no employees yet</h3>	
	  </c:otherwise>
</c:choose>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>