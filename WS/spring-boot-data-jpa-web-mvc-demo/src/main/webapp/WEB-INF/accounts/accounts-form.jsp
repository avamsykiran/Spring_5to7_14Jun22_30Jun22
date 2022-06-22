<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>New or Edit Accpunt</title>
</head>
<body>
	<jsp:include page="/header" />
	<section>

		<h4>Account</h4>
		
		<form:form method="POST" modelAttribute="ah" style="width:50%;margin:auto;border:1px solid black;padding:2px;">
			<div>
				<form:label path="ahId">Account Holder Id:</form:label>
				<form:input path="ahId" readonly="true"/>
			</div>
			<div>
				<form:label path="fullName">Full Name:</form:label>
				<form:input path="fullName"/>
				<form:errors path="fullName"></form:errors>
			</div>
			<div>
				<form:label path="emailId">EmailId:</form:label>
				<form:input path="emailId" />
				<form:errors path="emailId"></form:errors>
			</div>
			<div>
				<form:label path="currentBalance">Current Balance:</form:label>
				<form:input path="currentBalance" readonly="true"/>
			</div>
			<div style="text-align:right">
				<button>SAVE</button>
			</div>			
			
		</form:form>
		
	</section>

</body>
</html>