<%@ include file="/WEB-INF/jsp/header.jsp" %>

<spring:url var="editUrl" value="/profile/edit" />

<div class="bs-docs-example" data-content="<spring:message code="Profile"></spring:message>">
	<ul class="nav nav-pills pull-right">
		<li><a href="${editUrl}"><spring:message code="Edit"></spring:message></a></li>
		<li><a href="${editUrl}"><spring:message code="Change Password"></spring:message></a></li>
	</ul>
	<dl class="dl-horizontal">
		<dt><spring:message code="Username"></spring:message></dt>
		<dd><c:out value="${profileAttribute.username}" /></dd>
		<dt><spring:message code="FirstName"></spring:message></dt>
		<dd><c:out value="${profileAttribute.customer.firstName}" /></dd>
		<dt><spring:message code="LastName"></spring:message></dt>
		<dd><c:out value="${profileAttribute.customer.lastName}" /></dd>
		<dt><spring:message code="E-mail Address"></spring:message></dt>
		<dd><c:out value="${profileAttribute.email}" /></dd>
	</dl>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>