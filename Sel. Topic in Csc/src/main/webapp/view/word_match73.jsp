<!DOCTYPE HTML>
<html lang="en">
	<head>
		<title>Word Matching Exercise</title>
		<style>
*:focus {outline: 2px solid blue; outline-offset: 2px;}
		details {padding:3px;}
		</style>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/boxes.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/event1.js"><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" /></script>
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-89940905-27"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/event1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.alerts.js"></script>
<link href="${pageContext.request.contextPath}/static/js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen"><script type="text/javascript" src="${pageContext.request.contextPath}/static/js/logging.js"></script>
</head>
		<body><div id='maincontentstyle'>
	<center>
		<div id='boxstyle'>
			<h3 id='title'>HTML typography QUIZ</h3>
				<center>
					<div class='source'>
						<div id='s1' class='draggyBox-small ui-draggable'>
							b
						</div>
						<div id='s2' class='draggyBox-small ui-draggable'>
							strong
						</div>
						<div id='s3' class='draggyBox-small ui-draggable'>
							i
						</div>
						<div id='s4' class='draggyBox-small ui-draggable'>
							em
						</div>
						<div id='s5' class='draggyBox-small ui-draggable'>
							mark
						</div>
						<div id='s6' class='draggyBox-small ui-draggable'>
							small
						</div>
						<div id='s7' class='draggyBox-small ui-draggable'>
							del
						</div>
						<div id='s8' class='draggyBox-small ui-draggable'>
							ins
						</div>
						<div id='s9' class='draggyBox-small ui-draggable'>
							sub
						</div>
						<div id='s10' class='draggyBox-small ui-draggable'>
							sup
						</div>
					</div>
					</center>
					<table id='tablestyle'>
						<tr>
						<td id='row1'>
							<div id='t1' class='ltarget ui-droppable'></div>
						</td >
						<td id='d1'>
															<pre>Important text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row2'>
							<div id='t2' class='ltarget ui-droppable'></div>
						</td >
						<td id='d2'>
															<pre>italic text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row3'>
							<div id='t3' class='ltarget ui-droppable'></div>
						</td >
						<td id='d3'>
															<pre>emphasized text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row4'>
							<div id='t4' class='ltarget ui-droppable'></div>
						</td >
						<td id='d4'>
															<pre>marked text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row5'>
							<div id='t5' class='ltarget ui-droppable'></div>
						</td >
						<td id='d5'>
															<pre>smaller text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row6'>
							<div id='t6' class='ltarget ui-droppable'></div>
						</td >
						<td id='d6'>
															<pre>deleted text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row7'>
							<div id='t7' class='ltarget ui-droppable'></div>
						</td >
						<td id='d7'>
															<pre>inserted text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row8'>
							<div id='t8' class='ltarget ui-droppable'></div>
						</td >
						<td id='d8'>
															<pre>subscript text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row9'>
							<div id='t9' class='ltarget ui-droppable'></div>
						</td >
						<td id='d9'>
															<pre>superscript text
								</pre>
							</td >
						</tr>
						<tr>
						<td id='row10'>
							<div id='t10' class='ltarget ui-droppable'></div>
						</td >
						<td id='d10'>
															<pre>Bold text element
								</pre>
							</td >
						</tr>
					</table>
				</center>
		</div>
	</center>
</div><span style="padding: 3px"> <button id ="one" class="button" type="button" onClick="show_answer()">Show Answer</button> <button id = "resetButton" class="button" type="button" onClick="reset()">Reset</button></span><span id="audio" style=""><a href="" title="Turns Text-to-Speech Output On or Off" class="menulink" style="text-decoration: none;"><img id="bg" src="${pageContext.request.contextPath}/static/images/audioOff.png" height="30" width="30" style="margin-bottom:-10px; padding-bottom:-20px;"></a></span>
		</body>
</html>
<script type="text/javascript">$(init);$( window ).unload(function() {removeStorage.removeItem("someVarKey1");});function reset() {  var someVarName = true;sessionStorage.setItem("someVarKey1", someVarName);window.location.reload();}function init() {	document.getElementById('resetButton').style.display = 'none';document.getElementById("resetButton").style.visibility = "hidden";if (false && sessionStorage.getItem("someVarKey1"))$("#one").focus();var numbers = [2,3,4,5,6,7,8,9,10,1,];initialize(numbers);}</script>  <script>  answer = "strong:Important text i:italic text em:emphasized text mark:marked text small:smaller text del:deleted text ins:inserted text sub:subscript text sup:superscript text b:Bold text element ";  function show_answer() {	  jAlert(answer, 'Correct Match');  }</script> <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/GetElementPosition3.js"></script> <script>    $(function(){  if ('speechSynthesis' in window) {    speechSynthesis.onvoiceschanged = function() {      var $voicelist = $('#voices');      if($voicelist.find('option').length == 0) {        speechSynthesis.getVoices().forEach(function(voice, index) {          var $option = $('<option>')          .val(index)          .html(voice.name + (voice.default ? ' (default)' :''));          $voicelist.append($option);        });        $voicelist.form_select();      }    }  } });     audioOn = false;$(function() {$('.menulink').click(function(){  if (audioOn) {	$("#bg").attr('src',"${pageContext.request.contextPath}/static/images/audioOff.png");  	audioOn = false;  }  else {	$("#bg").attr('src',"${pageContext.request.contextPath}/static/images/audioOn.png");	audioOn = true; speak(" ");  }  return false;});}); </script>   