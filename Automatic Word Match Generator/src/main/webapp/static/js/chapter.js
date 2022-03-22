window.onload = main();

function main(){
	var list = document.getElementById("exercises");
	addChapters(list,list.getAttribute("chapter-id"));
}

function addChapters(list,id){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "/exercises/chapter?chapterId="+id, true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState == 4 && xhr.status == 200) {
	        var result = JSON.parse(this.response);
	        result.forEach(function(exercise){
	        	console.log(exercise);
	        	var li = document.createElement("li");
        		var a 	= document.createElement("a");
        		a.setAttribute("href",window.location.origin+"/exercises/show/"+exercise.id);
        		a.innerHTML = exercise.question;
        		li.append(a)
	        	list.append(li);
	        })
	    }
	}
	xhr.send(null);
}