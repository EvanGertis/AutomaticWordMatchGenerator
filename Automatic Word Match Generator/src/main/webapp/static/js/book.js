window.onload = main();

function main(){
	var list = document.getElementById("chapters");
	addBooks(list,list.getAttribute("book-id"));
}

function addBooks(list,id){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "/books/chapters?bookId="+id, true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState == 4 && xhr.status == 200) {
	        var result = JSON.parse(this.response);
	        result.forEach(function(chapter){
	        	console.log(chapter);
        		var li = document.createElement("li");
        		var a 	= document.createElement("a");
        		a.setAttribute("href",window.location.origin+"/chapter/show/"+chapter.id);
        		a.innerHTML = chapter.title;
        		li.append(a)
	        	list.append(li);
	        })
	    }
	}
	xhr.send(null);
}