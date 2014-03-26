<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>BSUIR coursework</title>
</head>
<body>
 
<h2><spring:message code="label.title"/></h2>
 
<form:form method="post" action="add.html" commandName="project">
 
    <table>
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name" /></td> 
    </tr>
    <tr>
        <td><form:label path="details"><spring:message code="label.details"/></form:label></td>
        <td><form:input path="details" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addProject"/>"/>
        </td>
    </tr>
</table>  
</form:form>
 
     
<h3>Projects</h3>
<c:if  test="${!empty projectList}">
<table class="data">
<tr>
    <th>Name</th>
    <th>Details</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${projectList}" var="project">
    <tr>
        <td>${project.name}</td>
        <td>${project.details}</td>
        <td><a href="delete/${project.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>