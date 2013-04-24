			<hr>

			<div class="footer">
				<p>
					<c:set var="value1" value="2012" />
					<c:set var="value2" value="2013" />
					<c:set var="value3" value="aripd.com" />
					<spring:message code="Copyright"
						arguments="${value1};${value2};${value3}" htmlEscape="false"
						argumentSeparator=";" />
				</p>
			</div>

		</div> <!-- /container -->

		<aripd:flashattribute body="${message}"></aripd:flashattribute>

	</body>
</html>