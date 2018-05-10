<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>

<title>luv2code Company Home Page</title>
</head>
<body>

	<h2>Luv2cod company Home Page -- Yooooohoo</h2>

	<hr>
	<p>
	Welcome to the luv2code company home page !
	</p>
	<hr>
     <!--  display username and role -->	
     <p>
       User    : <security:authentication property="principal.username"/>
       <br><br>
       Role(s) : <security:authentication property="principal.authorities"/>
     </p>
	<hr>
     	
     	<security:authorize access="hasRole('MANAGER')">
   	<!--  Only for Manager ; note , een the html comment is not visibel  -->
   	<hr>
     <p>     	
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for Manager peeps)
 
     </p>     	
     	
   	<hr>
   	</security:authorize>
    <security:authorize access="hasRole('ADMIN')" >
   	<hr>
     <p>     	
        <a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
            (Only for Admins peeps)
 
     </p>     	
     	
   	<hr>
   	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
	  <input type="submit" value="Logout">
	
	
	</form:form>
	
	
</body>
</html>