<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
		<title>Animais - Desisto!</title>
		
		<script>

			function complete() {
				var node = JSON.parse('${sessionScope.node}')
				document.getElementById('complete').innerHTML = "Complete, um " + 
				document.getElementById('name').value + 
				"<input type=\"text\" name=\"type\" id=\"type\" autofocus=\"autofocus\"> mas um " + 
				node.description + " não.</br><button onclick=\"save()\">Ok</button>" 
			}	
			
			function save() {
				document.getElementById('nameAnimal').value = document.getElementById('name').value
				document.getElementById('typeAnimal').value = document.getElementById('type').value
				document.forms[0].submit()
			}
			
		</script>
	</head>
	<body>
		<div id="content" style="border: 0px solid black; width: 800px; height: 160px; left: 500px; top: 270px; position: absolute;">
			Desisto! Que animal você pensou?</br>
			<input type="text" name="name" id="name" autofocus="autofocus" ></br>
			<button onclick="complete()">Ok</button></br>
			<div id="complete"></div>
		</div>
		<form method="post" action="register">
			<input type="hidden" name="typeAnimal" id="typeAnimal">
			<input type="hidden" name="nameAnimal" id="nameAnimal">
		</form>
	</body>
</html>