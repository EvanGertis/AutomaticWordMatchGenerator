function main(){
    var a = document.getElementById("a");
    var b = document.getElementById("b");
    var c = document.getElementById("c");
    a.addEventListener("click",checkAnswer);
    b.addEventListener("click",checkAnswer);
    c.addEventListener("click",checkAnswer);
}

function checkAnswer(e){
    var xhr = new XMLHttpRequest();
}


window.onload = main();

