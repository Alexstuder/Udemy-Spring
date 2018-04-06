<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Confirmation - Customer</title>
</head>

<body>

	The Customer is confirmed: ${customer.firstName} ${customer.lastName}

	<br>
	<br> Free passes : ${customer.freePasses}

	<br>
	<br> Postal code : ${customer.postalCode}

	<br>
	<br> Course code : ${customer.courseCode}


<br>
<br>
<a href="/spring-mvc-demo/">"...back"</a>
</body>
</html>
