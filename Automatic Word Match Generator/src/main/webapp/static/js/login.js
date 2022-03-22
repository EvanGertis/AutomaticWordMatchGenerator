window.onload = main();

function main(){
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var submit = document.getElementById("submit");
	submit.addEventListener("click",function(){login(username,password)})
}

function login(){
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/user/login", true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState == 4 && xhr.status == 200) {
	        location.reload();
	    }
	}
	xhr.send('{"userName":"'+username.value+'","password":"'+password.value+'"}');
}