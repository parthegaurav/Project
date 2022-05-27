<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset the password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<style>
form {
	margin-top: 30px
}

.red {
	color: red;
}
</style>
</head>
<body style="background-color: gray;">

	<form action="verifyotp" class="container text-center" method="post">

		<h2>Enter The OTP</h2>

		<input type="number" name="otp" placeholder="Enter the OTP"
			class="rounded"><br>
		<br>
		<button class="btn btn-success rounded">validate otp</button>
		<br>
		<br> <span class="red">${msg}</span>


	</form>


</body>
</html>