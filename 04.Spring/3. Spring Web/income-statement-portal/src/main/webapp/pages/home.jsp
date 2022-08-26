<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<jsp:include page="/header" />
 	<h3>Home Page</h3>
 	<p> Hai All! welcome to my new web application.</p>
 	
 	<form>
 		<label>UserName: <input type="text" name="unm" required/></label>
 		<button>send</button>
 	</form>
 	
 	<c:if test="${msg!=null }">
 		<p><strong>${msg }</strong></p>
 	</c:if>
</body>
</html>