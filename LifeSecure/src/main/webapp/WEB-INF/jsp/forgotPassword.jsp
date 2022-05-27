<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forget password web</title>
<!-- CSS only -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<style>
  form{
     width:250px;
  }
</style>
</head>
<body style="background-color: gray;">

<button type="button" data-toggle="modal" data-target="#modalPopup1" >modal</button>

<!--  	<form action="verifyusername" class="container text-center m-5 ">
		<h3 style="color: red">${msg }</h3>
		<h1 class="text-center $red-500">Forgot Password Page</h1>

		<input class="mt-5 rounded" type="email" placeholder="Enter The Email"
			name="email"><br>
		<br> <input class="btn btn-primary rounded " type="submit"
			value="Send the otp">
	</form>                             -->
	
	<div class="modal fade" tabindex="-1" role="dialog" id="modalPopup1">
        <div class="modal-dialog">
        <div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title">Forgot Password Page</h2>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

				</div>
				<div class="modal-body ">
					<form action="verifyusername" class="text-center">
						<h3 style="color: red">${msg }</h3>
						

						<input class="mt-5 rounded" type="email"
							placeholder="Enter The Email" name="email"><br> <br>
						<input class="btn btn-primary rounded " type="submit"
							value="Send the otp">
					</form>
				</div>
				<div class="modal-footer">
         
          <button type="button" class="btn btn-primary" data-dismiss="modal"> close</button>
          </div>
          </div>
        </div>
      </div>

</body>
</html>