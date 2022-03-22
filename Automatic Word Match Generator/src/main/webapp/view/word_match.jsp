<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>Word Match Generator</title>
    <style>
    *:focus {outline: 2px solid blue; outline-offset: 2px;}
    details {padding:3px;}
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/boxes.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/event1.js"></script>
  
<!-- Global Site Tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-89940905-27"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments)};
  gtag('js', new Date());
  gtag('config', 'UA-89940905-27');
</script>

<!-- <script type="text/javascript" src="../logging.js"></script> -->
</head>


  <body>
    <div id="maincontentstyle">
        <div id="boxstyle">
          <h3 id= "title">Word Match Generator</h3>
          <div>
            <div id="inputs">
                  <div id="inputBoxes">
                      <title>Input:</title>
                      <div>
                        Title: <input id= "title_input" type="text">
                      </div>  
                      
                      <div>
                        Key Term 1: <input id="el1" type="text" value="">
                      </div>
                      <div>
                        Description 1: <input id="dl1" type="text" value=""> 
                      </div>
                      <div>
                        Key Term 2: <input id="el2" type="text" value=""> 
                      </div>
                      <div>
                        Description 2: <input id="dl2" type="text" value=""> 
                      </div>
                  </div>
                  <span style="padding: 3px">
                    <button id ="add_more" class="button" type="button" onClick="add_more()">Add More</button>
                  </span>
                  <span style="padding: 3px">
                    <button id ="one" class="button" type="button" onClick="generate_html()">Generate HTML</button>
                  </span>
              </div>
              </div>
            </div>
          <div id="results" class="row">
          </div>
          <div id="renderedHTML" class="row">
          </div>
        </div>


    
<script src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.ui.touch-punch.min.js"></script><script src="${pageContext.request.contextPath}/static/js/jquery.alerts.js"></script><link href="${pageContext.request.contextPath}/static/js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />  

<script type="text/javascript">
$(init);
$( window ).unload(function() {
  removeStorage.removeItem("someVarKey1");
});
function init() {
      document.getElementById('resetButton').style.display = 'none';
document.getElementById("resetButton").style.visibility = "hidden";
if (false && sessionStorage.getItem("someVarKey1")) // No focus for the first time
  $("#one").focus();
  var numbers = [3, 4, 5, 1, 2];
  initialize(numbers);
  

}
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/word_match.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/GetElementPosition3.js"></script>
<script> 
  

audioOn = false;
$(function() {
  $('.menulink').click(function(){
    if (audioOn) {
      $("#bg").attr('src',"${pageContext.request.contextPath}/static/images/audioOff.png");  
      audioOn = false;
    }
    else {
      $("#bg").attr('src',"${pageContext.request.contextPath}/static/images/audioOn.png");
      audioOn = true; speak(" ");
    }
    return false;
  });
});
   </script>   

   </body>
</html>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/highlight.min.js"></script>