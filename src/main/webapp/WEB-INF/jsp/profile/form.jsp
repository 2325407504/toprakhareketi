<%@ include file="/WEB-INF/jsp/header.jsp" %>

<spring:url var="saveUrl" value="/profile/save" />

<div class="bs-docs-example" data-content="<spring:message code="Profile"></spring:message>">
	<form:form modelAttribute="profileAttribute" action="${saveUrl}" method="post">
		<form:errors path="*" cssClass="error-block" element="div" />
		<fieldset>
			<div class="form-row">
				<form:label path="customer.firstName"><spring:message code="FirstName"></spring:message></form:label>
				<span><form:input path="customer.firstName" /></span>
			</div>       
			<div class="form-row">
				<form:label path="customer.lastName"><spring:message code="LastName"></spring:message></form:label>
				<span><form:input path="customer.lastName" /></span>
			</div>
			<div class="form-row">
				<form:label path="email"><spring:message code="E-mail Address"></spring:message></form:label>
				<span><form:input path="email" /></span>
				<form:errors cssClass="error-field" path="email" />
			</div>
			<div class="form-row">
				<form:label path="username"><spring:message code="Username"></spring:message></form:label>
				<span><form:input path="username" /></span>
				<form:errors cssClass="error-field" path="username" />
			</div>
			<div class="form-row">
				<form:label path="password"><spring:message code="Password"></spring:message></form:label>
				<span><form:password path="password" /></span>
				<form:errors cssClass="error-field" path="password" />
			</div>
			<div class="form-actions">
				<button class="btn btn-primary" type="submit"><spring:message code="Save"></spring:message></button>
			</div>
		</fieldset>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>