<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Student-Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">

     First Name: <form:input path="firstName" />

		<br>
		<br>
     Last Name: <form:input path="lastName" />
		<br>
		<br>
     Country: 
     <form:select path="country">
     
     <form:options items="${student.countryOptions}"/>
     
     
     
    <%-- OLDVersion HTML Selection :  
    <form:option value ="Brazil" label="Brazil"/>
     <form:option value ="France" label="France"/>
     <form:option value ="Germany" label="Germany"/>
     <form:option value ="India" label="India"/> --%>
     </form:select>

		<br>
		<br>
		
		
		<form:radiobuttons path="favoriteJunkFood" items="${student.favoriteJunkFoodOptions}"/>
		
		<br>
		<br>
		
		
		Java <form:radiobutton path="favoriteLanguage" value = "Java"/>
		Perl <form:radiobutton path="favoriteLanguage" value = "Perl"/>
		C## <form:radiobutton path="favoriteLanguage" value = "C##"/>
		JS <form:radiobutton path="favoriteLanguage" value = "JS"/>
		<br>
		<br>
		
		
		Operating System :
		Linux <form:checkbox path="operatingSystems" value = "Linux"/>
		Windows <form:checkbox path="operatingSystems" value = "Windows"/>
		iOS <form:checkbox path="operatingSystems" value = "iOS"/>
		
		<br>
		<br>
     <input type="submit" value="Submit"/> 


	</form:form>






</body>



</html>
