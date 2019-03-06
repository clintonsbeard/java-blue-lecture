<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Personal Information</h3>

<form method="POST" action="personalInformationInput">

	<div class="formInputGroup">
		<label for="firstName">First Name:</label> 
		<input type="text" name="firstName" id="firstName" />
	</div>
	
	<div class="formInputGroup">
		<label for="lastName">Last Name:</label> 
		<input type="text" name="lastName" id="lastName" />
	</div>
	
	<div class="formInputGroup">
		<label for="dateOfBirth">Date of Birth:</label> 
		<input type="text" name="dateOfBirth" id="dateOfBirth" />
	</div>
	
	<div class="formInputGroup">
		<label for="stateOfBirth">State of Birth:</label> <select
			name="stateOfBirth" id="stateOfBirth">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="emailAddress">Email Address:</label> 
		<input type="text" name="emailAddress" id="emailAddress" />
	</div>
	<div class="formInputGroup">
		<label for="phoneNumber">Phone Number:</label> 
		<input type="text" name="phoneNumber" id="phoneNumber" />
	</div>
	<input class="formSubmitButton" type="submit" value="Next >>>" />
</form>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />