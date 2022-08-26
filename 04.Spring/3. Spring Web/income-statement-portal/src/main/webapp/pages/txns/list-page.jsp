<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="in.tp.is.entity.TxnType" %>

<html>
<head>
	<title>Txns List Page</title>
</head>
<body>
	<jsp:include page="/header" />
 	<h3>Txns List Page</h3>
 	
 	<c:choose>
 		<c:when test="${txns==null || txns.isEmpty() }">
 			<p><strong>No Txns Yet To Display</strong>
 		</c:when>
 		<c:otherwise>
 			<table style="width:80%;margin:auto;border:1px solid #000000">
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
 							<td>${t.type==TxnType.CREDIT?String.valueOf(t.amount):"" }</td>
 							<td>${t.type==TxnType.DEBIT?String.valueOf(t.amount):"" }</td>
 						</tr>
 					</c:forEach>
 				</tbody>
 			</table>
 		</c:otherwise>
 	</c:choose>
</body>
</html>