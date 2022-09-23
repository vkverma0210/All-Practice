<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Demo</title>
</head>
<body>
	<form action="submit.jsp" method="post">
		Full name: <input type="text" name="name" /><br /> 
		Gender: <input type="radio" name="gender" value="Male"> Male 
				<input type="radio" name="gender" value="Female"> Female <br />
		Language know: <input type="checkbox" name="language" value="English"> English 
					   <input type="checkbox" name="language" value="Hindi"> Hindi 
					   <input type="checkbox" name="language" value="French"> French <br /> 
		Country: <select name="country">
			<option value="India">India</option>
			<option value="USA">USA</option>
			<option value="UK">UK</option>
			<option value="Finland">Finland</option>
			<option value="Fiji">Fiji</option>
		</select><br />
		<input type="submit" value="Submit">
	</form>
</body>
</html>