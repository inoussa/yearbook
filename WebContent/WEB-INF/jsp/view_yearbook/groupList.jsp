<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Groups - yearbook</title>
	</head>
	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		<jsp:include page="../view_fragments/navigation.jsp" />
		
		<div id="body_">
			<jsp:include page="../view_fragments/disconnect.jsp" />
			
			<h3>Liste des groupes de l'annuaire.</h3>
			<table>
				<thead>
					<tr>
						<td>Nom du groupe</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${groups }" var="group">
						<tr>
							<td><c:out value="${group.name}"/></td>
							
							<c:url var="detailLink" value="/actions/group/${group.id }" />
							<td>
								<a href="${detailLink}">Details</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>