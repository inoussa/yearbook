<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<c:url var="personList" value="/actions/person/list" />
<c:url var="groupList" value="/actions/group/list" />

<div id="menu_">
	<ul>
		<li><a href="${personList}">Les personnes</a></li>
		<li><a href="${groupList}">Les groupes</a></li>
	</ul>
</div>