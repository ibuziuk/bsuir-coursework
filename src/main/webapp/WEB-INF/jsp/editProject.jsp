<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="${controllerRequestMapping}" var="baseUrl"/>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Project</title>
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
            <li><a href="/bsuir-coursework/employee">Employees</a></li>
            <li><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
    </div>
</nav>

<h2>${project.name} is ready for editing</h2>

<form:form method="post" action="${baseUrl}/bsuir-coursework/editProject/${project.id}" commandName="project">
	<form:input path="id" type="hidden"/>
 	<form:errors path="*" cssClass="errorblock" element="div" />	 
    <table class="table table-striped table-bordered table-condensed">
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name"/></td> 
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
     <input type="submit" class="btn btn-success btn-large" value="<spring:message code="label.updateProject"/>"/>
</form:form>
      

<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>