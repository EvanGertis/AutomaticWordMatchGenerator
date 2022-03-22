window.onload = main();

function main(){
	var list = document.getElementById("books");
	addBooks(list,list.getAttribute("account-id"));
}

function addBooks(list,id){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "/account/books?accountId="+id, true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState == 4 && xhr.status == 200) {
	    	console.log(this.response);
	        var result = JSON.parse(this.response);
	        result.forEach(function(book){
	        	console.log(book);
        		var li 	= document.createElement("li");
        		var a 	= document.createElement("a");
        		a.setAttribute("href",window.location.origin+"/books/show/"+book.id);
        		a.innerHTML = book.title;
        		li.append(a)
	        	list.append(li);
	        })
	    }
	}
	xhr.send(null);
}