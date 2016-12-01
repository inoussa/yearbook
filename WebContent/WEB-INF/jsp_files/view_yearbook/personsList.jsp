<%@ include file="/WEB-INF/jsp_files/jstlPrefix.jsp" %>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:url var="showPerson" value="/actions/person/show" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/WEB-INF/css_files/yearbook.css" />
		<title>List Person</title>
	</head>

	<body>
		<h1>Liste des personnes de l'annuaire.</h1>
	    <table>
		    <c:forEach items="${people}" var="person">
		        <tr>
			        <td>
			        	<a href="${showPerson}/${person.id}">
			        		<c:out value="${person.lastName} ${person.firstName}" />
			            </a>
			        </td>
		        </tr>
		    </c:forEach>
	    </table>
	</body>
</html>