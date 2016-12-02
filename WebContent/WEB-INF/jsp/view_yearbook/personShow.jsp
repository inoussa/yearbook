<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<c:url var="deleteUrl" value="/actions/person/delete" />
<c:url var="updateUrl" value="/actions/person/edit" />

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Show Person</title>
	</head>

	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		<jsp:include page="../view_fragments/navigation.jsp" />
		
		<div id="body_">
			<h3><c:out value="${person.firstName} ${person.lastName}" /></h3>
	 		
	 		<ul>
	 			<c:if test="${person.homePage != null}">
		 			<li><b>Site web : </b><c:out value="${person.homePage}" /></li>
	 			</c:if>
	 			<li><b>Est rattaché(e) au groupe :</b> 
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
			
			<table>
				<tr>		
					<td>
						<button class="btn update" onclick="location.href='${updateUrl}/${person.id}'">Modifier</button>
						<button class="btn delete" onclick="location.href='${deleteUrl}/${person.id}'">Supprimer</button>
					</td>
				</tr>
			</table>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	 </body>
</html>