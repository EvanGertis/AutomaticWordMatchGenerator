window.onload = main();

function main(){
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var billing_address = document.getElementById("billing_address");
	var billing_province = document.getElementById("billing_province");
	var billing_country = document.getElementById("billing_country");
	var phone_number = document.getElementById("phone_number");
	var zip = document.getElementById("zip");
	var submit = document.getElementById("submit");
	submit.addEventListener("click",function(){login(username,password)})
}

function login(){
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/user/registration", true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState == 4 && xhr.status == 201) {
	    	var registrationNotification = document.getElementById("registration-notification");
	    	registrationNotification.style.display = "block";
	    	var UnsuccessfulRegistrationNotification = document.getElementById("unsuccessful-registration-notification");
	    	UnsuccessfulRegistrationNotification.style.display = "none";
	    }
	    else{
	    	var registrationNotification = document.getElementById("registration-notification");
	    	registrationNotification.style.display = "none";
	    	var UnsuccessfulRegistrationNotification = document.getElementById("unsuccessful-registration-notification");
	    	UnsuccessfulRegistrationNotification.style.display = "block";
	    }
	}
	xhr.send('{"userName":"'
			+username.value
			+'","password":"'
			+password.value
			+'","billingAddress":"'
			+billing_address.value
			+'","billingCountry":"'
			+billing_country.value
			+'","billingProvince":"'
			+billing_province.value
			+'","phoneNumber":"'
			+phone_number.value
			+'","zip":"'
			+zip.value
			+'"}');
}