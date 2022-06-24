<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.cts.sbdjwd.entity.TxnType" %>

<html>
<head>
	<title>Statement</title>
</head>
<body>
	<jsp:include page="/header" />
	<section style="text-align:center">

		<h4>${ah.fullName }`s Statement</h4>
		
		<form:form method="POST" action="/txns/add" modelAttribute="txn">
			<table style="width:70%;margin:auto;border:1px solid black">
					<thead>
						<tr>
							<th>Txn#</th>
							<th>Date</th>
							<th>Description</th>
							<th>Amount</th>
							<th>Type</th>
							<th></th>
						</tr>
						<tr>
							<th colspan="6">
								<form:errors path="*"></form:errors>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td><form:input path="txnDate" type="date"/></td>
							<td><form:input path="desp"/></td>
							<td><form:input path="amount" type="number"/></td>							
							<td><form:select path="type" items="${TxnType.values() }" ></form:select></td>
							<td><button>ADD</button></td>
						</tr>
					</tbody>
				</table>
			
		</form:form>
		
		<c:choose>
			<c:when test="${txns==null || txns.isEmpty()}">
				<p><strong>No Data available yet!</strong></p>
			</c:when>
			<c:otherwise>
				<table style="width:70%;margin:auto;border:1px solid black">
					<thead>
						<tr>
							<th>Txn#</th>
							<th>Date</th>
							<th>Description</th>
							<th>Credit</th>
							<th>Debit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="t" items="${txns }">
							<tr>
								<td>${t.txnId }</td>
								<td>${t.txnDate }</td>
								<td>${t.desp }</td>
								<td style="text-align:right">${t.type==TxnType.CREDIT?t.amount+"":"" }</td>
								<td style="text-align:right">${t.type!=TxnType.CREDIT?t.amount+"":"" }</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="4" style="text-align:right">
							 Current Balance
							</th>
							<th style="text-align:right">
								${ah.currentBalance }
							</th>
						</tr>
					</tfoot>
				</table>
			</c:otherwise>
		</c:choose>

	</section>

</body>
</html>