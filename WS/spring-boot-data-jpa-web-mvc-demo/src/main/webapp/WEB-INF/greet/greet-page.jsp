<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
	<title>Greet Page</title>
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<form>
			<label>UserName: <input type="text" name="unm" required /></label>
			<button>GO</button>
		</form>
		
		<c:if test="${msg ne null }">
			<p><strong>${msg }</strong></p>
		</c:if>
	</section>

</body>
</html>