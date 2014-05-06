<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customers</title>
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
 
<h2><spring:message code="label.customerName"/></h2>
 
<form:form method="post" action="addCustomer" commandName="customer">
 	<form:errors path="*" cssClass="errorblock" element="div" />
    <table>
    <tr>
        <td><form:label path="name"><spring:message code="label.customerName"/></form:label></td>
        <td><form:input path="name" /></td> 
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="3">
            <input type="submit" value="<spring:message code="label.addCustomer"/>"/>
        </td>
    </tr>
</table>  
</form:form>
 
     
<h3>Customers</h3>
<c:if  test="${!empty customerList}">
<table class="data">
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
</c:if>
</body>
</html>