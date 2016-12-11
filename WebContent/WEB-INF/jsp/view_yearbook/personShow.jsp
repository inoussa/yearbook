<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<c:url var="deletePerson" value="/actions/person/delete" />
<c:url var="updatePerson" value="/actions/person/edit" />

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
			<c:choose>
				<c:when test="${person.id != null}">
					<jsp:include page="../view_fragments/disconnect.jsp" />
					
					<h3><c:out value="${pShowPerson.firstName} ${pShowPerson.lastName}" /></h3>
			 		<ul>
			 			<c:if test="${pShowPerson.homePage != null}">
				 			<li><b>Site web : </b><c:out value="${pShowPerson.homePage}" /></li>
			 			</c:if>
			 			<li><b>Est rattaché(e) au groupe :</b> 
			 				<c:forEach items="${listGroups}" var="group">
						        <tr>
							        <td>
							        	<c:if test="${pShowPerson.idG == group.id}">
									   		<c:out value="${group.name}" />
										</c:if>
							        </td>
						        </tr>
						    </c:forEach>
			 		    </li>
					</ul>
					
					<!-- Une personne ne peux modifier que ces données -->
					<c:if test="${pShowPerson.id == person.id}">
				    	<table>
							<tr>		
								<td>
									<button class="btnUpdate" onclick="location.href='${updatePerson}/${pShowPerson.id}'">Modifier</button>
									<button class="btnDelete" onclick="location.href='${deletePerson}/${pShowPerson.id}'">Supprimer</button>
								</td>
							</tr>
						</table>
				    </c:if>
				</c:when>
				
				<c:otherwise>
					<jsp:include page="../view_fragments/redirectLogin.jsp" />
			    </c:otherwise>
			</c:choose>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	 </body>
</html>