<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
	.totals input {
		display: block;
		margin: auto;
	}
	.totals {
		text-align: center;
	}
	.totals > .row {
		margin-bottom: 25px;
	}
</style>

<div class="totals">

<h2>Patronages totales por Status</h2>
	<c:forEach items="${Status.values()}" var="status">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<label>
							<acme:message code="Patron.dashboard.form.label.totalpatronages${status}" />
							<input type="text" value="${totalNumberPatronage[status]}" readonly />
						</label>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>	
	

