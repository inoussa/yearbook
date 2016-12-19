<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<c:url var="showPerson" value="/actions/person/show/" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Group details - yearbook</title>
	</head>

	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		<jsp:include page="../view_fragments/navigation.jsp" />
		
		<div id="body_">
			<jsp:include page="../view_fragments/disconnect.jsp" />
			
			<h3>Liste des personnes de l'annuaire.</h3>
			<p><c:out value="${group.name} - ${people.size()} personnes."/> </p>
			<c:if test="${people.isEmpty()}">
				<p>Aucune personne dans ce groupe</p>
			 </c:if>
			<table>
				<tbody>
					<c:forEach items="${people }" var="person">
						<tr>
						        <td>
						        	<a href="${showPerson}/${person.id}">
						        		<c:out value="${person.lastName} ${person.firstName}" />
						            </a>
						        </td>
				        		</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>