<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="in.tp.is.entity.TxnType" %>

<html>
<head>
	<title>Txn Form Page</title>
	<style>
		section{
			width:40%;
			border:1px solid #000000;
			border-radius: 15px;
			margin:auto;
			margin-top:10px;
			padding:10px;
		}
		
		label,input{
			display: inline-block;
			width:45%;
		}
		
		div{
			margin:4px;
		}
	</style>
</head>
<body>
	<jsp:include page="/header" />
	<section>
	
	 	<h3>Transaction</h3>
	 	<form:form method="POST" modelAttribute="txn">
	 		<div>
	 			<form:errors path="*"></form:errors>
	 		</div>
	 		<div>
	 			<form:label path="txnId">Id</form:label>
	 			<form:input path="txnId" readonly="true" />
	 		</div>
	 		<div>
	 			<form:label path="desp">Description</form:label>
	 			<form:input path="desp" />
	 		</div>
	 		<div>
	 			<form:label path="txnDate">Date</form:label>
	 			<form:input path="txnDate" type="date" />
	 		</div>
	 		<div>
	 			<form:label path="amount">Amount</form:label>
	 			<form:input path="amount" type="number"/>
	 		</div>
	 		<div>
	 			<form:label path="type">Transaction Type</form:label>
	 			<form:select path="type" items="${TxnType.values() }" />
	 		</div>
	 		<div style="text-align:right">
	 			<button>SAVE</button>
	 		</div>
	 	</form:form>
	 	
 	</section>
</body>
</html>