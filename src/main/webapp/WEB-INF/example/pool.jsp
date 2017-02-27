<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<body>
	<h2>Hello Pool!</h2>
	<button onclick="borrow()">借个对象玩玩</button>
	<button onclick="returnObject()">有借有还</button>
	<button onclick="clearPool()">清空池子</button>
	<button onclick="getIdel()">看看有几个对象闲着呢</button>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		function borrow(){
			$.get("borrowObject",function(data){
				alert(data);
			})
		}
		function returnObject(){
			$.get("returnObject",function(data){
				alert(data);
			})
		}
		
		function clearPool(){
			$.get("clearPool",function(data){
				alert(data);
			})
		}
		
		function getIdel(){
			$.get("getIdel",function(data){
				alert(data);
			})
		}
	</script>
</body>
</html>
