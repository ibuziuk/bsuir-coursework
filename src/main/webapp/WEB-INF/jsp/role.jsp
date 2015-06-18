<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="${controllerRequestMapping}" var="baseUrl"/>
<!DOCTYPE html>
<html>
<head>
    <title>Roles</title>
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
            <li class="active"><a href="/bsuir-coursework/role">Roles</a></li>
        </ul>
        
       <form action = "logout" method = "post">
        	<input type="submit" name="upvote" value="Logout" />
   	   </form>
    </div>
</nav>
 
<h2><spring:message code="label.role"/></h2>
 
<form:form method="post" action="${baseUrl}/bsuir-coursework/role/addRole" commandName="role">
 	<form:errors path="*" cssClass="errorblock" element="div" />
    <table class="table table-striped table-bordered table-condensed">
    <tr>
        <td><form:label path="name"><spring:message code="label.roleName"/></form:label></td>
        <td><form:input path="name" /></td> 
        <td><form:errors path="name" cssClass="error"/></td>
    </tr>    
</table>  
    <input type="submit" class="btn btn-success btn-large" value="<spring:message code="label.addRole"/>"/>
</form:form>

<c:choose>
  <c:when test="${!empty roleList}">
  		<hr class="divider">
  		<h3>Our Roles</h3>
		<table class="table table-striped table-bordered table-condensed">
		<tr>
		    <th>Role</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${roleList}" var="role">
		    <tr>
		        <td>${role.name}</td>
		        <td><a href="${baseUrl}/bsuir-coursework/role/remove/${role.id}" class="btn btn-danger btn-large"><i class="glyphicon glyphicon-remove"></i> Delete</a></td>
		    </tr>
		</c:forEach>
		</table>
	</c:when>
	  <c:otherwise>
	  		<h3>We have no roles yet</h3>	
	  </c:otherwise>
</c:choose>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>