<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
		<link rel="stylesheet" href="site.css"></link>
	</head>
	<body>
		<div id="main_content">
			<h1>Tell us what you think is Awesome</h1>
			<form action="surveyInput" method="POST">
				<div class="formGroup">
					<label for="color">What is your favorite color?</label>
					<input type="text" name="color" id="color" />
				</div>
				<div class="formGroup">
					<label for="natureOfQuest">What is your quest?: </label>
					<input type="text" name="natureOfQuest" id="natureOfQuest" />
				</div>	
				<div class="formGroup">		
					<label for="petPreference">Do you prefer cats or dogs?: </label>
					<input type="text" name="petPreference" id="petPreference" />
				</div>	
				<div class="formGroup">		
					<label for="emailAddress">Email Address: </label>
					<input type="text" name="emailAddress" id="emailAddress" />
				</div>
				<div class="formGroup">		
					<label for="language">Do you prefer C# or Java?</label>
					<input type="text" name="language" id="language" />
				</div>
				<div class="formGroup">
					<input type="submit" value="Speak Your Mind" />
				</div>		
			</form>
		</div>
	</body>
</html>