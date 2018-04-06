<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Confirmation - Student</title>
</head>

<body>

The Student is confirmed: ${student.firstName}	${student.lastName} 

<br>
<br>

Country: ${student.country}
<br>
<br>

Favorite Language  : ${student.favoriteLanguage}

<br>
<br>
Favorite Junk Food : ${student.favoriteJunkFood }

<br>
<br>

<ul>
<c:forEach var="temp" items = "${student.operatingSystems}">

<li> ${temp}</li>

</c:forEach>

</ul>


</body>
</html>
