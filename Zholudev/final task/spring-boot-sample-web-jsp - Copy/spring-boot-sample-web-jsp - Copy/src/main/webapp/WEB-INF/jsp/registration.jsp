<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Register a new user</title>

    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="signin.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>


    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>


      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

  </head>

<body>
<div class="container">
${loginError}
<h3>Please enter following information</h3>
<div class="form-group form">
	<form action='registration' method="post">
		<div>
			<label>Your Name</label>
			<input type="text" id="userName" name="userName" placeholder="user name" class="form-control"/>
		</div>
		<div>
        	<label>Your Email</label>
        	<input type="text" id="userEmail" name="userEmail" placeholder="user email" class="form-control"/>
        </div>
		<div>
			<label>Password</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control"/>
		</div>
		<br>
		<br>
		<button class="btn btn-lg btn-primary btn-block" id="loginButton" class="form-control">Register</button>
	</form>
</div>
</div>
</body>
</html>

