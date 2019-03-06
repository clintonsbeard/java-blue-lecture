<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Address</h3>
<form method="POST" action="addressInput">
	<div class="formInputGroup">
		<label for="streetAddress">Street Address:</label> 
		<input type="text" name="streetAddress" id="streetAddress" />
	</div>
	<div class="formInputGroup">
		<label for="apartmentNumber">Apartment / Suite Number:</label> 
		<input type="text" name="apartmentNumber" id="apartmentNumber" />
	</div>
	<div class="formInputGroup">
		<label for="city">City:</label> 
		<input type="text" name="city" id="city" />
	</div>
	<div class="formInputGroup">
		<label for="state">State:</label> 
		<select name="state" id="state">
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
		<label for="zipCode">ZIP:</label> 
		<input type="text" name="zipCode" id="zipCode" />
	</div>
	<input class="formSubmitButton" type="submit" value="Next >>>" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />