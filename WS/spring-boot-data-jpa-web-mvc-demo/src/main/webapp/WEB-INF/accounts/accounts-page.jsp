<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
	<title>Accpunt Holders</title>
</head>
<body>
	<jsp:include page="/header" />
	<section>

		<h4>Accounts</h4>
		
		<c:choose>
			<c:when test="${ahs==null || ahs.isEmpty()}">
				<p><strong>No Data available yet!</strong></p>
			</c:when>
			<c:otherwise>
				<table style="width:70%;margin:auto;border:1px solid black">
					<thead>
						<tr>
							<th>AccountHolder#</th>
							<th>Full Name</th>
							<th>Email Id</th>
							<th>Balance</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ah" items="${ahs }">
							<tr>
								<td>${ah.ahId }</td>
								<td>${ah.fullName }</td>
								<td>${ah.emailId }</td>
								<td>${ah.currentBalance }</td>
								<td>
									<a href="/accounts/edit?ahId=${ah.ahId}" > EDIT </a> <span> | </span>
									<a href="/accounts/delete?ahId=${ah.ahId}" > DELETE </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>

	</section>

</body>
</html>