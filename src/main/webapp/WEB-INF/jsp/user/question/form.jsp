<%@ include file="/WEB-INF/jsp/header.jsp" %>

<spring:url var="saveUrl" value="/user/question/save" />

<div class="bs-docs-example" data-content="<spring:message code="Questions"></spring:message>">
	<form:form modelAttribute="questionAttribute" action="${saveUrl}" method="post">
		<form:errors path="*" cssClass="error-block" element="div" />
		<form:hidden path="id" />
		<fieldset>
			<div class="control-group">
				<form:label path="urgency" class="control-label"><spring:message code="Urgency"></spring:message></form:label>
				<div class="controls">
					<form:select path="urgency">
						<form:option value="1" label="Low"/>
						<form:option value="2" label="Medium"/>
						<form:option value="3" label="High"/>
					</form:select>
				</div>
				<form:errors cssClass="error-field" path="urgency" />
			</div>
			<div class="control-group">
				<form:label path="subject" class="control-label"><spring:message code="Subject"></spring:message></form:label>
				<div class="controls"><form:input path="subject" /></div>
				<form:errors cssClass="error-field" path="subject" />
			</div>
			<div class="control-group">
				<form:label path="content" class="control-label"><spring:message code="Content"></spring:message></form:label>
				<div class="controls"><form:textarea path="content" /></div>
				<form:errors cssClass="error-field" path="content" />
			</div>
			<div class="form-actions">
				<button class="btn btn-primary" type="submit"><spring:message code="Save"></spring:message></button>
			</div>
		</fieldset>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>