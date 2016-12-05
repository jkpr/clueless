<!DOCTYPE html>
<html lang="en">
<head>
    <title>Clue-Less Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:4567/">Boddy Builder</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:4567/">Home</a></li>
            <li><a href="game.html">Game</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="http://localhost:4567/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="http://localhost:4567/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                     alt="">
                <form class="form-signin" role="form" action="" method="post">
                    <input type="text" class="form-control" name="username" placeholder="username or email" required autofocus>
                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
                        Sign in</button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                    <a href="forgotpassword.html" class="pull-right need-help">Forgot Password? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="http://localhost:4567/signup" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</body>
</html>
