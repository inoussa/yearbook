<%@ include file="/WEB-INF/jsp_files/jstlPrefix.jsp" %>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/WEB-INF/css_files/yearbook.css" />
		<title>Show Person</title>
	</head>

	<body>
		<p class="personName"><c:out value="${person.firstName} ${person.lastName}" /></p>
 		
 		<ul class="personDetails">
 			<c:if test="${person.homePage != null}">
	 			<li>Site web : <c:out value="${person.homePage}" /></li>
 			</c:if>
 			<li>Est rattaché(e) au groupe : 
 				<c:forEach items="${groups}" var="group">
			        <tr>
				        <td>
				        	<c:if test="${person.idG == group.id}">
						   		<c:out value="${group.name}" />
							</c:if>
				        </td>
			        </tr>
			    </c:forEach>
 		    </li>
		</ul>
	 </body>
</html>