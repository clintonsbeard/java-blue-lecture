<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<div id="main_content">
			<h1>You are this close to Awesome...</h1>
			<form action="notificationSignupInput" method="POST">
				<div class="formGroup">
					<label for="firstName">First Name: </label>
					<input type="text" name="firstName" id="firstName" />
				</div>
				<div class="formGroup">
					<label for="lastName">Last Name: </label>
					<input type="text" name="lastName" id="lastName" />
				</div>	
				<div class="formGroup">		
					<label for="age">Age: </label>
					<input type="text" name="age" id="age" />
				</div>	
				<div class="formGroup">		
					<label for="emailAddress">Email Address: </label>
					<input type="text" name="emailAddress" id="emailAddress" />
				</div>
				<div class="formGroup">
					<input type="submit" value="Sign Up" />
				</div>		
			</form>
		</div>
	</body>
</html>