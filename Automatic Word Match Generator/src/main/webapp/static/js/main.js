window.onload = main();

//editor to show code samples
var editor;

//initial entry point
function main(){
	var a = document.getElementById("a");
	var b = document.getElementById("b");
	var c = document.getElementById("c");
    a.addEventListener("click",checkAnswer);
    b.addEventListener("click",checkAnswer);
    c.addEventListener("click",checkAnswer);
}

function checkAnswer(e){
	var answer = e.target.value;
	var exerciseId = e.target.parentNode.getAttribute("exercise-id");
	var xhr = new XMLHttpRequest();
    xhr.open("POST", '/exercises/check/', true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function() { // Call a function when the state changes.
		if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
			if(this.response=="true")
				showCorrectAnswer();
			else
				showIncorrectAnswer();
		}
	}
    xhr.send('{"exerciseId":'+exerciseId+',"answer":'+answer+'}');
}

function showCorrectAnswer(){
	alert("Good job that is the correct Answer.");
}

function showIncorrectAnswer(){
	alert("I'm sorry that answer is incorrect");
}


